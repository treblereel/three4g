package org.treblereel.gwt.three4g.demo.client.local.examples.lensflares;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.FlyControls;
import org.treblereel.gwt.three4g.extensions.objects.Lensflare;
import org.treblereel.gwt.three4g.extensions.objects.LensflareElement;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/14/18.
 */
@InjectJavaScriptFor(elements = {FlyControls.class, Lensflare.class, LensflareElement.class})
public class WebglLensflares extends Attachable {

    public static final String name = "lensflares";

    private Clock clock = new Clock();
    private Random rand = new Random();
    private Texture textureFlare0, textureFlare3;


    public WebglLensflares() {

        camera = new PerspectiveCamera(40, aspect, 1, 15000);
        camera.position.z = 250;

        flyControls = new FlyControls(camera);
        flyControls.movementSpeed = 2500f;
        flyControls.rollSpeed = (float) Math.PI / 6;
        flyControls.autoForward = false;
        flyControls.dragToLook = false;
        // scene
        scene = new Scene();
        scene.background = new Color().setHSL(0.51f, 0.4f, 0.01f);
        scene.fog = new Fog(((Color) scene.background).getHex(), 3500, 15000);
        // world
        float s = 250f;
        BoxBufferGeometry geometry = new BoxBufferGeometry(s, s, s);
        MeshPhongMaterial material = new MeshPhongMaterial();
        material.color = new Color(0xffffff);
        material.specular = new Color(0xffffff);
        material.shininess = 50;

        for (int i = 0; i < 3000; i++) {
            Mesh mesh = new Mesh(geometry, material);
            mesh.position.x = (float) (8000 * (2.0 * rand.nextDouble() - 1.0));
            mesh.position.y = (float) (8000 * (2.0 * rand.nextDouble() - 1.0));
            mesh.position.z = (float) (8000 * (2.0 * rand.nextDouble() - 1.0));
            mesh.rotation.x = (float) (rand.nextDouble() * Math.PI);
            mesh.rotation.y = (float) (rand.nextDouble() * Math.PI);
            mesh.rotation.z = (float) (rand.nextDouble() * Math.PI);
            mesh.matrixAutoUpdate = false;
            mesh.updateMatrix();
            scene.add(mesh);
        }
        // lights
        DirectionalLight dirLight = new DirectionalLight(0xffffff, 0.05f);
        dirLight.position.set(0, -1, 0).normalize();
        dirLight.color.setHSL(0.1f, 0.7f, 0.5f);
        scene.add(dirLight);
        // lensflares
        TextureLoader textureLoader = new TextureLoader();
        textureFlare0 = textureLoader.load("textures/lensflare/lensflare0.png");
        textureFlare3 = textureLoader.load("textures/lensflare/lensflare3.png");

        addLight(0.55f, 0.9f, 0.5f, 5000, 0, -1000);
        addLight(0.08f, 0.8f, 0.5f, 0, 0, -1000);
        addLight(0.995f, 0.5f, 0.9f, 5000, 5000, -1000);

        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.alpha = true;
        rendererParameters.antialias = true;

        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);

        renderer.gammaInput = true;
        renderer.gammaOutput = true;


        container.appendChild(renderer.domElement);
    }

    private void addLight(float h, float s, float l, float x, float y, float z) {

        PointLight light = new PointLight(0xffffff, 1.5f, 2000);
        light.color.setHSL(h, s, l);
        light.position.set(x, y, z);
        scene.add(light);
        Lensflare lensflare = new Lensflare();
        lensflare.addElement(new LensflareElement(textureFlare0, 700, 0, light.color));
        lensflare.addElement(new LensflareElement(textureFlare3, 60, 0.6f));
        lensflare.addElement(new LensflareElement(textureFlare3, 70, 0.7f));
        lensflare.addElement(new LensflareElement(textureFlare3, 120, 0.9f));
        lensflare.addElement(new LensflareElement(textureFlare3, 70, 1));
        light.add(lensflare);
    }


    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - - lensflares -\n" +
                "\t\t\ttextures from <a href=\"http://ro.me\">ro.me</a> - fly with WASD/RF/QE + mouse");
    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                flyControls.update(clock.getDelta());
                renderer.render(scene, camera);
                animate();
            }
        });
    }

}

