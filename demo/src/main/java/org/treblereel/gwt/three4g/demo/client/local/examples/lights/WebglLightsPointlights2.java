package org.treblereel.gwt.three4g.demo.client.local.examples.lights;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.geometries.TorusBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@InjectJavaScriptFor(elements = TrackballControls.class)
public class WebglLightsPointlights2 extends Attachable {

    public static final String name = "lights / pointlights2";

    public Clock clock = new Clock();
    private Random random = new Random();
    private PointLight light1, light2, light3, light4, light5, light6;


    public WebglLightsPointlights2() {

        camera = new PerspectiveCamera(50, aspect, 1, 300);
        camera.position.set(0, 15, 150);
        camera.lookAt(new Vector3());
        // SCENE
        scene = new Scene();
        scene.background = new Color(0x040306);
        scene.fog = new Fog(0x040306, 10, 300);
        // CONTROLS
        trackballControls = new TrackballControls(camera);
        trackballControls.rotateSpeed = 1.0f;
        trackballControls.zoomSpeed = 1.2f;
        trackballControls.panSpeed = 0.8f;
        trackballControls.noZoom = false;
        trackballControls.noPan = false;
        trackballControls.staticMoving = false;
        trackballControls.dynamicDampingFactor = 0.15f;

        // TEXTURES
        TextureLoader textureLoader = new TextureLoader();
        Texture texture = textureLoader.load("textures/disturb.jpg");
        texture.repeat.set(20, 10);
        texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
        texture.format = THREE.RGBFormat;
        // MATERIALS

        MeshPhongMaterial groundMaterial = new MeshPhongMaterial();
        groundMaterial.color = new Color(0xffffff);
        groundMaterial.map = texture;

        MeshStandardMaterial objectMaterial = new MeshStandardMaterial();
        objectMaterial.color = new Color(0xffffff);
        objectMaterial.roughness = 0.5f;
        objectMaterial.metalness = 1.0f;


        // GROUND
        Mesh mesh = new Mesh(new PlaneBufferGeometry(800, 400, 2, 2), groundMaterial);
        mesh.position.y = -5;
        mesh.rotation.x = (float) -Math.PI / 2;
        scene.add(mesh);
        // OBJECTS
        TorusBufferGeometry objectGeometry = new TorusBufferGeometry(1.5f, 0.4f, 8, 16);
        for (int i = 0; i < 5000; i++) {
            Mesh m = new Mesh(objectGeometry, objectMaterial);
            m.position.x = 400 * (0.5f - random.nextFloat());
            m.position.y = 50 * (0.5f - random.nextFloat()) + 25;
            m.position.z = 200 * (0.5f - random.nextFloat());
            m.rotation.y = 3.14f * (0.5f - random.nextFloat());
            m.rotation.x = 3.14f * (0.5f - random.nextFloat());
            m.matrixAutoUpdate = false;
            m.updateMatrix();
            scene.add(m);
        }
        // LIGHTS
        float intensity = 2.5f;
        float distance = 100;
        float decay = 2.0f;
        int c1 = 0xff0040, c2 = 0x0040ff, c3 = 0x80ff80, c4 = 0xffaa00, c5 = 0x00ffaa, c6 = 0xff1100;
        SphereBufferGeometry sphere = new SphereBufferGeometry(0.25f, 16, 8);

        light1 = new PointLight(c1, intensity, distance, decay);
        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(c1);
        light1.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light1);

        light2 = new PointLight(c2, intensity, distance, decay);
        meshBasicMaterialParameters.color = new Color(c2);
        light2.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light2);

        light3 = new PointLight(c3, intensity, distance, decay);
        meshBasicMaterialParameters.color = new Color(c3);
        light3.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light3);

        light4 = new PointLight(c4, intensity, distance, decay);
        meshBasicMaterialParameters.color = new Color(c4);
        light4.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light4);

        light5 = new PointLight(c5, intensity, distance, decay);
        meshBasicMaterialParameters.color = new Color(c5);
        light5.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light5);

        light6 = new PointLight(c6, intensity, distance, decay);
        meshBasicMaterialParameters.color = new Color(c6);
        light6.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light6);

        DirectionalLight dlight = new DirectionalLight(0xffffff, 0.05f);
        dlight.position.set(0.5f, 1, 0).normalize();
        scene.add(dlight);

        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);

        renderer.gammaInput = true;
        renderer.gammaOutput = true;

    }


    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - point lights WebGL demo");

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
        double time = new Date().getTime() * 0.00025;
        float d = 150;
        light1.position.x = (float) Math.sin(time * 0.7f) * d;
        light1.position.z = (float) Math.cos(time * 0.3f) * d;
        light2.position.x = (float) Math.cos(time * 0.3f) * d;
        light2.position.z = (float) Math.sin(time * 0.7f) * d;
        light3.position.x = (float) Math.sin(time * 0.7f) * d;
        light3.position.z = (float) Math.sin(time * 0.5f) * d;
        light4.position.x = (float) Math.sin(time * 0.3f) * d;
        light4.position.z = (float) Math.sin(time * 0.5f) * d;
        light5.position.x = (float) Math.cos(time * 0.3f) * d;
        light5.position.z = (float) Math.sin(time * 0.5f) * d;
        light6.position.x = (float) Math.cos(time * 0.7f) * d;
        light6.position.z = (float) Math.cos(time * 0.5f) * d;
        trackballControls.update(clock.getDelta());
        renderer.render(scene, camera);
    }

}





