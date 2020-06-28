package org.treblereel.gwt.three4g.demo.client.local.examples.interactive;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.JsArray;
import elemental2.core.Uint8Array;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.bufferattributes.Float32BufferAttribute;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extensions.utils.BufferGeometryUtils;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshLambertMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshLambertMaterialParameters;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/13/18.
 */
@InjectJavaScriptFor(elements = {TrackballControls.class, BufferGeometryUtils.class})
public class WebglInteractiveCubesGpu extends Attachable {

    public static final String name = "interactive / cubes / gpu";

    private Random rand = new Random();
    private Scene pickingScene;
    private WebGLRenderTarget pickingTexture;
    private Mesh highlightBox;
    private JsArray<JsPropertyMap> pickingData = new JsArray();
    private Vector2 mouse = new Vector2();
    private Vector3 offset = new Vector3(10, 10, 10);

    public WebglInteractiveCubesGpu() {

        camera = new PerspectiveCamera(70, aspect, 1, 5000);
        camera.position.z = 1000;

        trackballControls = new TrackballControls(camera);
        trackballControls.rotateSpeed = 1.0f;
        trackballControls.zoomSpeed = 1.2f;
        trackballControls.panSpeed = 0.8f;
        trackballControls.noZoom = false;
        trackballControls.noPan = false;
        trackballControls.staticMoving = true;
        trackballControls.dynamicDampingFactor = 0.3f;

        scene = new Scene();
        scene.background = new Color(0xffffff);
        pickingScene = new Scene();
        pickingTexture = new WebGLRenderTarget(getWidth(), getHeight());
        pickingTexture.texture.minFilter = THREE.LinearFilter;
        scene.add(new AmbientLight(0x555555));
        SpotLight light = new SpotLight(0xffffff, 1.5f);
        light.position.set(0, 500, 2000);
        scene.add(light);
        MeshBasicMaterial pickingMaterial = new MeshBasicMaterial();
        pickingMaterial.vertexColors = THREE.VertexColors;

        MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
        parameters.color = new Color(0xffffff);
        parameters.flatShading = true;
        parameters.vertexColors = THREE.VertexColors;
        parameters.shininess = 0;

        MeshPhongMaterial defaultMaterial = new MeshPhongMaterial(parameters);


        List<BoxBufferGeometry> geometriesDrawn = new ArrayList<>();
        List<BoxBufferGeometry> geometriesPicking = new ArrayList<>();

        Matrix4 matrix = new Matrix4();
        Quaternion quaternion = new Quaternion();
        Color color = new Color();
        for (int i = 0; i < 5000; i++) {
            BoxBufferGeometry geometry = new BoxBufferGeometry();
            Vector3 position = new Vector3();
            position.x = rand.nextFloat() * 10000 - 5000;
            position.y = rand.nextFloat() * 6000 - 3000;
            position.z = rand.nextFloat() * 8000 - 4000;
            Euler rotation = new Euler();
            rotation.x = rand.nextFloat() * 2 * (float) Math.PI;
            rotation.y = rand.nextFloat() * 2 * (float) Math.PI;
            rotation.z = rand.nextFloat() * 2 * (float) Math.PI;
            Vector3 scale = new Vector3();
            scale.x = rand.nextFloat() * 200 + 100;
            scale.y = rand.nextFloat() * 200 + 100;
            scale.z = rand.nextFloat() * 200 + 100;

            quaternion.setFromEuler(rotation, false);
            matrix.compose(position, quaternion, scale);
            geometry.applyMatrix(matrix);
            // give the geometry's vertices a random color, to be displayed
            applyVertexColors(geometry, color.setHex(rand.nextInt() * 0xffffff));
            geometriesDrawn.add(geometry);

            BufferGeometry bg = geometry.clone();
            geometry = Js.uncheckedCast(bg); //TODO

            // give the geometry's vertices a color corresponding to the "id"
            applyVertexColors(geometry, color.setHex(i));
            geometriesPicking.add(geometry);

            JsPropertyMap map = JsPropertyMap.of();
            map.set("position", position);
            map.set("rotation", rotation);
            map.set("scale", scale);
            pickingData.setAt(i, map);

        }
        Mesh objects = new Mesh(BufferGeometryUtils.mergeBufferGeometries(geometriesDrawn.toArray(new BufferGeometry[geometriesDrawn.size()])), defaultMaterial);
        scene.add(objects);
        pickingScene.add(new Mesh(BufferGeometryUtils.mergeBufferGeometries(geometriesPicking.toArray(new BufferGeometry[geometriesDrawn.size()])), pickingMaterial));
        MeshLambertMaterialParameters parameters1 = new MeshLambertMaterialParameters();
        parameters1.color = new Color(0xffff00);
        highlightBox = new Mesh(
                new BoxBufferGeometry(),
                new MeshLambertMaterial(parameters1));
        scene.add(highlightBox);

        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.antialias = true;

        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.shadowMap.enabled = true;
        renderer.shadowMap.type = THREE.PCFShadowMap;
        container.appendChild(renderer.domElement);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };

    }

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float) (event.clientX - panel.offsetWidth);
        mouse.y = (float) event.clientY;
    }

    public void applyVertexColors(BoxBufferGeometry geometry, Color color) {
        BufferAttribute position = geometry.attributes.position;
        JsArray colors = new JsArray();
        for (int i = 0; i < position.count; i++) {
            colors.push(color.r, color.g, color.b);
        }
        geometry.addAttribute("color", new Float32BufferAttribute(colors, 3));
    }

    public void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("webgl - draggable cubes' ");
    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void pick() {
        //render the picking scene off-screen
        camera.setViewOffset( renderer.domElement.clientWidth, renderer.domElement.clientHeight, (float)(mouse.x * devicePixelRatio), (float)(mouse.y * devicePixelRatio), 1, 1 );
        renderer.setRenderTarget( pickingTexture );
        renderer.render(pickingScene, camera);
        //create buffer for reading single pixel
        Uint8Array pixelBuffer = new Uint8Array(4);
        //read the pixel under the mouse from the texture
        renderer.readRenderTargetPixels(pickingTexture, mouse.x, (float) pickingTexture.height - mouse.y, 1, 1, pixelBuffer);
        //interpret the pixel as an ID
        int id = (pixelBuffer.getAt(0).intValue() << 16) | (pixelBuffer.getAt(1).intValue() << 8) | (pixelBuffer.getAt(2).intValue());
        JsPropertyMap<Object3D> data = pickingData.getAt(id);
        if (data != null) {
            //move our highlightBox so that it surrounds the picked object
            if (data.get("position") != null && data.get("rotation") != null && data.get("scale") != null) {
                highlightBox.position.copy(Js.uncheckedCast(data.get("position")));
                highlightBox.rotation.copy(Js.uncheckedCast(data.get("rotation")));
                highlightBox.scale.copy(Js.uncheckedCast(data.get("scale"))).add(offset);
                highlightBox.visible = true;
            }
        } else {
            highlightBox.visible = false;
        }
    }

    private void render() {
        trackballControls.update();
        pick();
        renderer.setRenderTarget(null);
        renderer.render(scene, camera);
    }
}


