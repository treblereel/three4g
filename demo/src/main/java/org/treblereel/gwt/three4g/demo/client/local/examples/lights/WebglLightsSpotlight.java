package org.treblereel.gwt.three4g.demo.client.local.examples.lights;

import elemental2.dom.DomGlobal;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.helpers.AxesHelper;
import org.treblereel.gwt.three4g.helpers.CameraHelper;
import org.treblereel.gwt.three4g.helpers.SpotLightHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglLightsSpotlight extends Attachable {

    public static final String name = "lights / spotlight";

    private SpotLight spotLight;
    private SpotLightHelper lightHelper;
    private CameraHelper shadowCameraHelper;
    private Scene scene = new Scene();
    private PerspectiveCamera camera;

    public WebglLightsSpotlight() {
        camera = new PerspectiveCamera(35, aspect, 1, 1000);
        camera.position.set(65, 8, -10);

        OrbitControls orbitControls = new OrbitControls(camera, root);
        orbitControls.addEventListener("change", event -> render());
        orbitControls.minDistance = 20;
        orbitControls.maxDistance = 500;
        orbitControls.enablePan = false;

        AmbientLight ambient = new AmbientLight(0xffffff, 0.1f);
        scene.add(ambient);
        spotLight = new SpotLight(0xffffff, 1);
        spotLight.position.set(15, 40, 35);
        spotLight.angle = (float) Math.PI / 4;
        spotLight.penumbra = 0.05f;
        spotLight.decay = 2;
        spotLight.distance = 200;
        spotLight.castShadow = true;
        spotLight.shadow.mapSize.width = 1024;
        spotLight.shadow.mapSize.height = 1024;

        PerspectiveCamera cam = spotLight.shadow.camera.cast();
        cam.near = 10;
        cam.far = 200;
        scene.add(spotLight);

        lightHelper = new SpotLightHelper(spotLight);
        scene.add(lightHelper);
        shadowCameraHelper = new CameraHelper(spotLight.shadow.camera);
        scene.add(shadowCameraHelper);
        scene.add(new AxesHelper(10));
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0x808080);
        material.dithering = true;

        PlaneBufferGeometry geometry = new PlaneBufferGeometry(2000, 2000);
        Mesh mesh = new Mesh(geometry, material);
        mesh.position.set(0, -1, 0);
        mesh.rotation.x = (float) -Math.PI * 0.5f;
        mesh.receiveShadow = true;
        scene.add(mesh);

        MeshPhongMaterial meshPhongMaterial = new MeshPhongMaterial();
        meshPhongMaterial.color = new Color(0x4080ff);
        meshPhongMaterial.dithering = true;

        BoxBufferGeometry boxBufferGeometry = new BoxBufferGeometry(3, 1, 2);
        mesh = new Mesh(boxBufferGeometry, meshPhongMaterial);
        mesh.position.set(40, 2, 0);
        mesh.castShadow = true;
        scene.add(mesh);

        orbitControls.target.copy(mesh.position);
        orbitControls.update();

        buildGui();
    }

    private void render() {
        if (renderer.domElement != null) {
            lightHelper.update();
            shadowCameraHelper.update();
            renderer.render(scene, camera);
        }
    }

    private void buildGui() {
        float intensity = spotLight.intensity;
        float distance = spotLight.distance;
        float angle = spotLight.angle;
        float penumbra = spotLight.penumbra;
        float decay = spotLight.decay;

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        gui.addColor("light color", spotLight.color.getHex()).onChange(result -> {
            spotLight.color.setHex(Integer.valueOf(result.toString()));
            render();
        });

        gui.add("intensity", intensity, 0, 2).setStep(0.1).onChange(result -> {
            spotLight.intensity = result.floatValue();
            render();
        });

        gui.add("distance", distance, 50, 200).setStep(1).onChange(result -> {
            spotLight.distance = result.floatValue();
            render();
        });

        gui.add("angle", angle, 0, Math.PI / 3).setStep(0.1).onChange(result -> {
            spotLight.angle = result.floatValue();
            render();
        });
        gui.add("penumbra", penumbra, 0, 1).onChange(result -> {
            spotLight.penumbra = result.floatValue();
            render();
        });
        gui.add("decay", decay, 1, 2).setStep(0.1).onChange(result -> {
            spotLight.decay = result.floatValue();
            render();
        });
        gui.open();

        gui.finishAndBuild();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());
    }

    @Override
    public void doAttachScene() {
        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        renderer.shadowMap.enabled = true;
        renderer.shadowMap.type = THREE.PCFSoftShadowMap;

        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    public void doDetach() {
        AppSetup.infoDiv.hide();
        AppSetup.menuDiv.hide();
        detachControls();
        detachGui();
        window.removeEventListener("resize", onResize);
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - webgl - spotlight by <a style=' color: orange;'" +
                                                                                                                          " href=\"http://master-domain.com\" target=\"_blank\" rel=\"noopener\">Master James</a>");
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                render();
                animate();
            }
        });
    }
}

