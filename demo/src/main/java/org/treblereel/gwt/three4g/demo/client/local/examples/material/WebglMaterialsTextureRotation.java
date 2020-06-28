package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.events.Event;
import org.treblereel.gwt.three4g.core.events.EventListener;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 8/7/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglMaterialsTextureRotation extends Attachable {

    public static final String name = "materials / texture / rotation";

    private float offsetX, offsetY = 0;
    private float repeatX = 0.25f, repeatY = 0.25f;
    private float centerY = 0.5f, centerX = 0.5f;
    private float rotation = (float) Math.PI / 4;

    public WebglMaterialsTextureRotation() {


        scene = new Scene();
        camera = new PerspectiveCamera(40, aspect, 1, 1000);
        camera.position.set(10, 15, 25);
        scene.add(camera);

        orbitControls = new OrbitControls(camera, renderer.domElement);
        orbitControls.addEventListener("change", new EventListener() {
            @Override
            public void call(Event event) {
                render();
            }
        });
        orbitControls.minDistance = 20;
        orbitControls.maxDistance = 50;
        orbitControls.maxPolarAngle = (float) Math.PI / 2;

        BoxBufferGeometry geometry = new BoxBufferGeometry(10, 10, 10);
        TextureLoader loader = new TextureLoader();
        Texture texture = loader.load("textures/UV_Grid_Sm.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture object) {
                render();
            }
        });
        texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
        texture.matrixAutoUpdate = true;
        MeshBasicMaterial material = new MeshBasicMaterial();
        material.map = texture;
        mesh = new Mesh(geometry, material);
        scene.add(mesh);

        updateUvTransform();
        initGui();

        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }

    private void updateUvTransform() {
        Texture texture = ((MeshBasicMaterial) mesh.material).map;
        texture.offset.set(offsetX, offsetY);
        texture.repeat.set(repeatX, repeatY);
        texture.center.set(centerX, centerY);
        texture.rotation = rotation;
        render();
    }

    private void initGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        gui.add("offsetX", offsetX, 0.0, 1.0).setStep(0.01).onChange(result -> {
            offsetX = result.floatValue();
            updateUvTransform();
        }).done();

        gui.add("offsetY", offsetY, 0.0, 1.0).setStep(0.01).onChange(result -> {
            offsetY = result.floatValue();
            updateUvTransform();
        }).done();

        gui.add("repeatX", repeatX, 0.25, 2.0).onChange(result -> {
            repeatX = result.floatValue();
            updateUvTransform();
        }).done();
        gui.add("repeatY", repeatY, 0.25, 2.0).onChange(result -> {
            repeatY = result.floatValue();
            updateUvTransform();
        }).done();
        gui.add("rotation", rotation, -2.0, 2.0).onChange(result -> {
            rotation = result.floatValue();
            updateUvTransform();
        }).done();
        gui.add("centerX", centerX, 0.0, 1.0).onChange(result -> {
            centerX = result.floatValue();
            updateUvTransform();
        }).done();
        gui.add("centerY", centerY, 0.0, 1.0).onChange(result -> {
            centerY = result.floatValue();
            updateUvTransform();
        }).done();

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - webgl - texture rotation");
    }

    private void render() {
        renderer.render(scene, camera);
    }

}
