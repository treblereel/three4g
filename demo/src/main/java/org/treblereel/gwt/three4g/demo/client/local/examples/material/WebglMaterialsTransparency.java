package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshStandardMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
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
public class WebglMaterialsTransparency extends Attachable {

    public static final String name = "materials / transparency";
    private MeshStandardMaterial material1, material2;

    public WebglMaterialsTransparency() {


        camera = new PerspectiveCamera(40, aspect, 1, 2000);
        camera.position.set(0.0f, 40f, 40 * 3.5f);
        scene = new Scene();
        //
        SphereBufferGeometry geometry = new SphereBufferGeometry(18, 30, 30);

        MeshStandardMaterialParameters meshStandardMaterialParameters = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters.opacity = 0.25f;
        meshStandardMaterialParameters.transparent = true;
        material1 = new MeshStandardMaterial(meshStandardMaterialParameters);

        MeshStandardMaterialParameters meshStandardMaterialParameters2 = new MeshStandardMaterialParameters();
        meshStandardMaterialParameters2.opacity = 0.25f;
        meshStandardMaterialParameters2.transparent = true;
        meshStandardMaterialParameters2.premultipliedAlpha = true;

        material2 = new MeshStandardMaterial(meshStandardMaterialParameters2);
        TextureLoader textureLoader = new TextureLoader();
        textureLoader.load("textures/hardwood2_diffuse.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.anisotropy = 8;
                material1.map = map;
                material1.needsUpdate = true;
                material2.map = map;
                material2.needsUpdate = true;
            }
        });

        textureLoader = new TextureLoader();
        textureLoader.load("textures/hardwood2_roughness.jpg", new OnLoadCallback<Texture>() {
            @Override
            public void onLoad(Texture map) {
                map.anisotropy = 8;
                material1.roughnessMap = map;
                material1.needsUpdate = true;
                material2.roughnessMap = map;
                material2.needsUpdate = true;
            }
        });

        Mesh mesh = new Mesh(geometry, material1);
        mesh.position.x = -25.0f;
        scene.add(mesh);
        mesh = new Mesh(geometry, material2);
        mesh.position.x = 25.0f;
        scene.add(mesh);
        //
        PlaneBufferGeometry planeBufferGeometry = new PlaneBufferGeometry(800, 800);
        MeshStandardMaterial material = new MeshStandardMaterial();
        material.color = new Color(0x333333);
        mesh = new Mesh(planeBufferGeometry, material);
        mesh.position.y = -50;
        mesh.rotation.x = (float) -Math.PI * 0.5f;
        scene.add(mesh);
        // Lights
        SpotLight spotLight = new SpotLight(0xff8888);
        spotLight.position.set(100, 200, 100);
        spotLight.angle = (float) Math.PI / 6;
        spotLight.penumbra = 0.9f;
        scene.add(spotLight);
        spotLight = new SpotLight(0x8888ff);
        spotLight.position.set(-100, -200, -100);
        spotLight.angle = (float) Math.PI / 6;
        spotLight.penumbra = 0.9f;
        scene.add(spotLight);


        WebGLRendererParameters webGLRendererParameters = new WebGLRendererParameters();
        webGLRendererParameters.antialias = true;
        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.shadowMap.enabled = true;

        setupWebGLRenderer(renderer);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;

        orbitControls = new OrbitControls(camera, renderer.domElement);

        container.appendChild(renderer.domElement);
        initGui();
    }

    private void initGui() {
        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        gui.add("opacity", 0.25, 0.0, 1.0).setStep(0.01).onChange(result -> {

            material1.opacity = result.floatValue();
            material2.opacity = result.floatValue();
        }).done();
        gui.open();
        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http=//threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - Transparency with Premultiplied Alpha (right) and without (left)<br /> using RGBA8 Buffers by <a style='color:orange;' href='http://clara.io/' target='_blank' rel='noopener'>Ben Houston</a>.");
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

    private void render() {
        for (int i = 0, l = scene.children.length; i < l; i++) {
            if (scene.children[i] instanceof Mesh) {
                Mesh object = scene.children[i].cast();
                double time = new Date().getTime() * 0.0002;
                if (object.geometry instanceof SphereBufferGeometry) {
                    object.rotation.x = (float) time;
                    object.rotation.y = -(float) time;
                }
            }
        }
        renderer.render(scene, camera);
    }

}
