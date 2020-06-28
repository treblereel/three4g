package org.treblereel.gwt.three4g.demo.client.local.examples.clipping;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.datgui4g.GUI;
import org.treblereel.gwt.datgui4g.GUIProperty;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusKnotBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/20/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglClipping extends Attachable {

    public static final String name = "clipping";
    private double startTime;
    private Mesh object;

    public WebglClipping() {

        camera = new PerspectiveCamera(36, aspect, 0.25f, 16);
        camera.position.set(0, 1.3f, 3);
        scene = new Scene();
        // Lights
        scene.add(new AmbientLight(0x505050));
        SpotLight spotLight = new SpotLight(0xffffff);
        spotLight.angle = (float) Math.PI / 5;
        spotLight.penumbra = 0.2f;
        spotLight.position.set(2, 3, 3);
        spotLight.castShadow = true;
        ((PerspectiveCamera) spotLight.shadow.camera).near = 3;
        ((PerspectiveCamera) spotLight.shadow.camera).far = 10;
        spotLight.shadow.mapSize.width = 1024;
        spotLight.shadow.mapSize.height = 1024;
        scene.add(spotLight);
        DirectionalLight dirLight = new DirectionalLight(0x55505a, 1);
        dirLight.position.set(0, 3, 0);
        dirLight.castShadow = true;

        OrthographicCamera orthographicCamera = (OrthographicCamera) dirLight.shadow.camera;
        orthographicCamera.near = 1;
        orthographicCamera.far = 10;
        orthographicCamera.right = 1;

        orthographicCamera.left = -1;
        orthographicCamera.top = 1;
        orthographicCamera.bottom = -1;
        dirLight.shadow.mapSize.width = 1024;
        dirLight.shadow.mapSize.height = 1024;
        scene.add(dirLight);
        // ***** Clipping planes: *****
        Plane localPlane = new Plane(new Vector3(0, -1, 0), 0.8f);
        Plane globalPlane = new Plane(new Vector3(-1, 0, 0), 0.1f);
        // Geometry
        MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
        parameters.color = new Color(0x80ee10);

        parameters.shininess = 100;
        parameters.side = THREE.DoubleSide;
        // ***** Clipping setup (material): *****
        parameters.clippingPlanes = new Plane[]{localPlane};
        parameters.clipShadows = true;

        MeshPhongMaterial material = new MeshPhongMaterial(parameters);

        TorusKnotBufferGeometry geometry = new TorusKnotBufferGeometry(0.4f, 0.08f, 95, 20);
        object = new Mesh(geometry, material);
        object.castShadow = true;
        scene.add(object);

        MeshPhongMaterialParameters paramMaterial1 = new MeshPhongMaterialParameters();
        paramMaterial1.color = new Color(0xa0adaf);
        paramMaterial1.shininess = 150;

        Mesh ground = new Mesh(
                new PlaneBufferGeometry(9, 9, 1, 1),
                new MeshPhongMaterial(paramMaterial1)
        );

        ground.rotation.x = (float) -Math.PI / 2; // rotates X/Y to X/Z
        ground.receiveShadow = true;
        scene.add(ground);

        // ***** Clipping setup (renderer): *****

        Plane[] globalPlanes = new Plane[]{globalPlane};

        renderer.clippingPlanes = new Plane[]{};
        renderer.localClippingEnabled = true;
        renderer.shadowMap.enabled = true;
        // Controls
        orbitControls = new OrbitControls(camera, renderer.domElement);
        orbitControls.target.set(0, 1, 0);
        orbitControls.update();

        GUIProperty guiProperty = new GUIProperty();
        guiProperty.autoPlace = false;

        gui = new GUI(guiProperty);

        GUI localClippingFolder = gui.addFolder("Local Clipping");
        localClippingFolder.add("enabled", true).onChange(result -> {
            renderer.localClippingEnabled = result;
        }).done();

        localClippingFolder.add("shadows", true).onChange(result -> {
            material.clipShadows = result;
        }).done();
        localClippingFolder.add("Plane", 0.8f, 0.3, 1.25).onChange(v -> {
            localPlane.constant = v.floatValue();
        }).done();


        GUI globalClippingFolder = gui.addFolder("Global Clipping");

        globalClippingFolder.add("enabled", false).onChange(result -> {
            if (result) {
                renderer.clippingPlanes = globalPlanes;
            } else {
                renderer.clippingPlanes = new Plane[]{};
            }
        }).done();

        globalClippingFolder.add("Plane", globalPlane.constant, -0.4, 3f).onChange(v -> {
            globalPlane.constant = v.floatValue();
        }).done();

        gui.finishAndBuild();
        localClippingFolder.open();
        globalClippingFolder.open();
        AppSetup.guiDiv.get().appendChild(gui.getDomElement());

        startTime = new Date().getTime();

        setupWebGLRenderer(renderer);
        container.appendChild(renderer.domElement);
    }


    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();

    }

    private void animate() {

        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                double currentTime = new Date().getTime();
                double time = (currentTime - startTime) / 1000;
                object.position.y = 0.8f;
                object.rotation.x = (float) (time * 0.5f);
                object.rotation.y = (float) (time * 0.2);
                object.scale.setScalar((float) (Math.cos(time) * 0.125 + 0.875));

                renderer.render(scene, camera);
                animate();
            }
        });
    }

}

