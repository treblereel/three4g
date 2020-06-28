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
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.api.ImprovedNoise;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.resources.JavascriptTextResource;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.FirstPersonControls;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CanvasTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/28/18.
 */
@InjectJavaScriptFor(elements = FirstPersonControls.class)
public class WebglGeometryTerrain extends Attachable {


    public static final String name = "geometry / terrain";
    private Clock clock = new Clock();
    private CanvasTexture texture;

    int worldWidth = 256, worldDepth = 256,
            worldHalfWidth = worldWidth / 2, worldHalfDepth = worldDepth / 2;

    public WebglGeometryTerrain() {
        loadJavaScript(JavascriptTextResource.IMPL.getImprovedNoise().getText());

        camera = new PerspectiveCamera(60, aspect, 1, 20000);
        scene = new Scene();
        scene.background = new Color(0xbfd1e5);

        firstPersonControls = new FirstPersonControls(camera, root);
        firstPersonControls.movementSpeed = 1000;
        firstPersonControls.lookSpeed = 0.1;

        Uint8Array data = generateHeight(worldWidth, worldDepth);
        camera.position.y = (float) (data.getAt(worldHalfWidth + worldHalfDepth * worldWidth) * 10 + 500);

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

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
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
        firstPersonControls.update(clock.getDelta());
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - dynamic geometry demo - webgl<br />(left click: forward, right click: backward)");
    }

}
