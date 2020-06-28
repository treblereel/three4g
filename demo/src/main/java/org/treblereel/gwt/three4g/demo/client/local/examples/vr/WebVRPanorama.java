package org.treblereel.gwt.three4g.demo.client.local.examples.vr;

import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.Image;
import java.util.LinkedList;
import java.util.List;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.vr.WebVR;
import org.treblereel.gwt.three4g.geometries.BoxGeometry;
import org.treblereel.gwt.three4g.loaders.ImageLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.OnAnimate;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/14/18.
 */
@InjectJavaScriptFor(elements = WebVR.class)
public class WebVRPanorama extends Attachable {

    public static final String name = "panorama";
    public List<Texture> textures = new LinkedList<>();
    private boolean isMouseDown;


    private WebVRPanorama() {
        getTexturesFromAtlasFile("textures/cube/sun_temple_stripe_stereo.jpg", 12);
    }

    public void getTexturesFromAtlasFile(String atlasImgUrl, int tilesNum) {


        for (int i = 0; i < tilesNum; i++) {
            textures.add(new Texture());
        }
        ImageLoader loader = new ImageLoader();
        loader.load(atlasImgUrl, new OnLoadCallback<Image>() {
            @Override
            public void onLoad(Image object) {
                int tileWidth = object.height;

                HTMLCanvasElement canvas;
                CanvasRenderingContext2D context;
                for (int i = 0; i < tilesNum; i++) {

                    canvas = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
                    context = Js.uncheckedCast(canvas.getContext("2d"));
                    canvas.height = tileWidth;
                    canvas.width = tileWidth;

                    context.drawImage(object, tileWidth * i, 0, tileWidth, tileWidth, 0, 0, tileWidth, tileWidth);
                    textures.get(i).image = Js.uncheckedCast(canvas);
                    textures.get(i).needsUpdate = true;
                }
                init();
            }
        });

    }

    private void init() {

        scene = new Scene();
        camera = new PerspectiveCamera(90, aspect, 1, 1000);
        camera.layers.enable(1);
        BoxGeometry geometry = new BoxGeometry(100, 100, 100);
        geometry.scale(1, 1, -1);

        MeshBasicMaterial[] materials = new MeshBasicMaterial[6];

        for (int i = 0; i < 6; i++) {
            MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
            parameters.map = textures.get(i);
            materials[i] = new MeshBasicMaterial(parameters);
        }

        Mesh skyBox = new Mesh(geometry, materials);
        skyBox.layers.set(1);
        scene.add(skyBox);

        MeshBasicMaterial[] materialsR = new MeshBasicMaterial[6];

        for (int i = 6; i < 12; i++) {
            MeshBasicMaterialParameters parameters = new MeshBasicMaterialParameters();
            parameters.map = textures.get(i);
            materialsR[i] = new MeshBasicMaterial(parameters);
        }

        Mesh skyBoxR = new Mesh(geometry, materialsR);
        skyBoxR.layers.set(2);
        scene.add(skyBoxR);

        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.alpha = true;

        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.vr.enabled = true;
        renderer.vr.userHeight = 0;

        container.appendChild(renderer.domElement);
        container.appendChild(WebVR.createButton(renderer));

        window.addEventListener("vrdisplaypointerrestricted", (e) -> onPointerRestricted(), false);
        window.addEventListener("vrdisplaypointerunrestricted", (e) -> onPointerUnrestricted(), false);

        container.addEventListener("mousedown", (e) -> onMouseDown(), false);
        container.addEventListener("mouseup", (e) -> onMouseUp(), false);
        container.addEventListener("touchstart", (e) -> onMouseDown(), false);
        container.addEventListener("touchend", (e) -> onMouseUp(), false);

    }

    private void onMouseDown() {
        isMouseDown = true;
    }

    private void onMouseUp() {
        isMouseDown = false;
    }

    private void onPointerUnrestricted() {
        org.treblereel.gwt.three4g.demo.client.api.dom.Document currentPointerLockElement = Js.uncheckedCast(DomGlobal.document);
        org.treblereel.gwt.three4g.demo.client.api.dom.Document expectedPointerLockElement = Js.uncheckedCast(renderer.domElement);

        if (currentPointerLockElement.pointerLockElement != null && currentPointerLockElement.pointerLockElement.equals(expectedPointerLockElement)) {
            currentPointerLockElement.exitPointerLock();
        }

    }


    private void onPointerRestricted() {
        org.treblereel.gwt.three4g.demo.client.api.dom.HTMLElement pointerLockElement = (org.treblereel.gwt.three4g.demo.client.api.dom.HTMLElement) renderer.domElement;
        if (pointerLockElement != null)
            pointerLockElement.requestPointerLock();
    }


    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }

    private void animate() {
        renderer.setAnimationLoop(new OnAnimate() {
            @Override
            public void animate() {
                if (container.parentNode != null && container.parentNode.parentNode != null) {
                    render();
                }
            }
        });
    }

    private void render() {
        renderer.render(scene, camera);
    }
}
