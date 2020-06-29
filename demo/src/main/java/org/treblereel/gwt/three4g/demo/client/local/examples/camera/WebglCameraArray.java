package org.treblereel.gwt.three4g.demo.client.local.examples.camera;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.cameras.ArrayCamera;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.CylinderBufferGeometry;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/21/18.
 */
public class WebglCameraArray extends Attachable {

    public static final String name = "camera / array";
    private Mesh mesh;
    private float AMOUNT = 6;

    private double WIDTH = (window.innerWidth / AMOUNT) * window.devicePixelRatio;
    private double HEIGHT = (window.innerHeight / AMOUNT) * window.devicePixelRatio;

    public WebglCameraArray() {
        scene = new Scene();

        float SIZE = 1 / AMOUNT;
        List<PerspectiveCamera> cameras = new ArrayList<>();
        for (int y = 0; y < AMOUNT; y++) {
            for (int x = 0; x < AMOUNT; x++) {
                PerspectiveCamera subcamera = new PerspectiveCamera(40f, aspect, 0.1f, 10f);
                subcamera.viewport = new Vector4((float) Math.floor(x * WIDTH), (float) Math.floor(y * HEIGHT), (float) Math.ceil(WIDTH), (float) Math.ceil(HEIGHT));
                subcamera.position.x = (x / AMOUNT) - 0.5f;
                subcamera.position.y = 0.5f - (y / AMOUNT);
                subcamera.position.z = 1.5f;
                subcamera.position.multiplyScalar(2f);
                subcamera.lookAt(new Vector3());
                subcamera.updateMatrixWorld(true);
                cameras.add(subcamera);
            }
        }
        camera = new ArrayCamera(cameras.toArray(new PerspectiveCamera[cameras.size()]));
        camera.position.z = 3f;
        scene = new Scene();
        scene.add(new AmbientLight(0x222244));

        DirectionalLight light = new DirectionalLight();
        light.position.set(0.5f, 0.5f, 1f);
        light.castShadow = true;
        ((OrthographicCamera) light.shadow.camera).zoom = 4f; // tighter shadow map
        scene.add(light);

        PlaneBufferGeometry geometry = new PlaneBufferGeometry(100f, 100f);
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0x000066);
        Mesh background = new Mesh(geometry, material);
        background.receiveShadow = true;
        background.position.set(0f, 0f, -1f);
        scene.add(background);

        CylinderBufferGeometry cylinderBufferGeometry = new CylinderBufferGeometry(0.5f, 0.5f, 1f, 32);
        material = new MeshPhongMaterial();
        material.color = new Color(0xff0000);
        mesh = new Mesh(cylinderBufferGeometry, material);
        mesh.castShadow = true;
        mesh.receiveShadow = true;
        scene.add(mesh);

        setupWebGLRenderer(renderer);
        renderer.shadowMap.enabled = true;
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

    private void render() {
        mesh.rotation.x += 0.005f;
        mesh.rotation.z += 0.01f;
        renderer.render(scene, camera);
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.hide();
    }
}
