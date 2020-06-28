package org.treblereel.gwt.three4g.demo.client.local.examples.geometry;

import com.google.gwt.animation.client.AnimationScheduler;
import elemental2.core.ArrayBuffer;
import elemental2.core.TypedArray;
import elemental2.core.Uint8Array;
import elemental2.core.Uint8ClampedArray;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.ImageData;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.core.extra.Intersect;
import org.treblereel.gwt.three4g.demo.client.api.ImprovedNoise;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.ConeBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshNormalMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/28/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglGeometryTerrainRaycast extends Attachable {


    public static final String name = "geometry / terrain / raycasting";
    private Clock clock = new Clock();
    private CanvasTexture texture;
    private Vector2 mouse = new Vector2();
    private Raycaster raycaster = new Raycaster();
    private Intersect[] intersects;
    private Mesh helper;

    private int worldWidth = 256, worldDepth = 256,
            worldHalfWidth = worldWidth / 2, worldHalfDepth = worldDepth / 2;

    public WebglGeometryTerrainRaycast() {
        loadJavaScript(JavascriptTextResource.IMPL.getImprovedNoise().getText());

        camera = new PerspectiveCamera(60, aspect, 1, 20000);
        scene = new Scene();
        scene.background = new Color(0xbfd1e5);

        orbitControls = new OrbitControls(camera, root);
        orbitControls.target.set(0.0f, 100.0f, 0.0f);
        orbitControls.panSpeed = 100f;


        Uint8Array data = generateHeight(worldWidth, worldDepth);

        camera.position.y = (float) (data.getAt(worldHalfWidth + worldHalfDepth * worldWidth) + 500);
        camera.position.y = orbitControls.target.y + 2000;
        camera.position.x = 2000;


        PlaneBufferGeometry geometry = new PlaneBufferGeometry(7500, 7500, worldWidth - 1, worldDepth - 1);
        geometry.rotateX((float) -Math.PI / 2);

        TypedArray vertices = geometry.attributes.position.array;

        for (int i = 0, j = 0, l = vertices.length; i < data.length; i++, j += 3) {
            vertices.setAt(j + 1, data.getAt(i) * 10);
        }
        texture = new CanvasTexture(generateTexture(data, worldWidth, worldDepth));
        texture.wrapS = THREE.ClampToEdgeWrapping;
        texture.wrapT = THREE.ClampToEdgeWrapping;

        MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
        parameters.map = texture;
        mesh = new Mesh(geometry, new MeshBasicMaterial(parameters));
        scene.add(mesh);


        ConeBufferGeometry coneBufferGeometry = new ConeBufferGeometry(20, 100, 3);
        coneBufferGeometry.translate(0, 50, 0);
        coneBufferGeometry.rotateX((float) (Math.PI / 2));

        helper = new Mesh(coneBufferGeometry, new MeshNormalMaterial());
        scene.add(helper);

        renderer.domElement.onmousemove = p0 -> {
            MouseEvent event = Js.uncheckedCast(p0);
            onDocumentMouseMove(event);
            return null;
        };
        setupWebGLRenderer(renderer);
    }

    private void onDocumentMouseMove(MouseEvent event) {
        event.preventDefault();

        mouse.x = (float) (((event.clientX - panel.offsetWidth) / (window.innerWidth - panel.offsetWidth)) * 2 - 1);
        mouse.y = (float) (-(event.clientY / window.innerHeight) * 2 + 1);

        raycaster.setFromCamera(mouse, camera);
        // See if the ray from the camera into the world hits one of our meshes
        intersects = raycaster.intersectObject(mesh);
        // Toggle rotation bool for meshes that we clicked

        if (intersects.length > 0) {

            helper.position.set(0, 0, 0);
            helper.lookAt(intersects[0].face.normal);
            helper.position.copy(intersects[0].point);
        }
    }

    private HTMLElement generateTexture(Uint8Array data, int width, int height) {
        float shade;

        Vector3 vector3 = new Vector3(0, 0, 0);
        Vector3 sun = new Vector3(1, 1, 1);
        sun.normalize();

        HTMLCanvasElement canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        canvas.width = width;
        canvas.height = height;

        CanvasRenderingContext2D context = Js.uncheckedCast(canvas.getContext("2d"));
        context.fillStyle = Js.cast("#000");
        context.fillRect(0, 0, width, height);

        ImageData image = context.getImageData(0, 0, canvas.width, canvas.height);
        Uint8ClampedArray imageData = image.data;


        for (int i = 0, j = 0, l = imageData.length; i < l; i += 4, j++) {

            //TODO, change to condition
            try {
                vector3.x = (float) (data.getAt(j - 2) - data.getAt(j + 2));
            } catch (NullPointerException e) {

            }
            vector3.y = 2;
            try {
                vector3.z = (float) (data.getAt(j - width * 2) - data.getAt(j + width * 2));
            } catch (NullPointerException e) {
                vector3.z = 0;

            }

            vector3.normalize();
            shade = vector3.dot(sun);

            imageData.setAt(i, (96 + shade * 128) * (0.5 + data.getAt(j) * 0.007));
            imageData.setAt(i + 1, (32 + shade * 96) * (0.5 + data.getAt(j) * 0.007));
            imageData.setAt(i + 2, (shade * 96) * (0.5 + data.getAt(j) * 0.007));
        }
        context.putImageData(image, 0, 0);

        // Scaled 4x

        HTMLCanvasElement canvasScaled = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
        canvasScaled.width = width * 4;
        canvasScaled.height = height * 4;
        CanvasRenderingContext2D canvasScaledContext = Js.uncheckedCast(canvasScaled.getContext("2d"));


        canvasScaledContext.scale(4, 4);
        canvasScaledContext.drawImage(canvas, 0, 0);

        ImageData canvasScaledImage = canvasScaledContext.getImageData(0, 0, canvasScaled.width, canvasScaled.height);
        Uint8ClampedArray canvasScaledImageData = canvasScaledImage.data;

        for (int i = 0, l = canvasScaledImageData.length; i < l; i += 4) {
            double v = Math.floor(Math.random() * 5);
            canvasScaledImageData.setAt(i, canvasScaledImageData.getAt(i) + v);
            canvasScaledImageData.setAt(i + 1, canvasScaledImageData.getAt(i) + v);
            canvasScaledImageData.setAt(i + 2, canvasScaledImageData.getAt(i) + v);
        }
        canvasScaledContext.putImageData(image, 0, 0);
        return canvasScaled;
    }

    private Uint8Array generateHeight(int width, int height) {
        int size = width * height;

        Uint8Array data = new Uint8Array(new ArrayBuffer(size));
        ImprovedNoise perlin = new ImprovedNoise();

        int quality = 1;
        double z = Math.random() * 100;

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < size; i++) {
                double x = i % width, y = ~~(i / width);
                data.setAt(i, data.getAt(i) + Math.abs(perlin.noise(x / quality, y / quality, z) * quality * 1.75));
            }
            quality *= 5;
        }
        return data;

    }

    private void render() {
        orbitControls.update();
        renderer.render(scene, camera);
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                render();
                animate();
            }
        });
    }

    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - webgl terrain raycasting demo<br />(left click: forward, right click: backward)");
    }

}
