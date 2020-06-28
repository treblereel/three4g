package org.treblereel.gwt.three4g.demo.client.local.examples.lights;

import com.google.gwt.animation.client.AnimationScheduler;
import java.util.Date;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.geometries.SphereBufferGeometry;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@InjectJavaScriptFor(elements = OBJLoader.class)
public class WebglLightsPointlights extends Attachable {

    public static final String name = "lights / pointlights";

    public Clock clock = new Clock();
    private Object3D object;
    private PointLight light1, light2, light3, light4;


    public WebglLightsPointlights() {

        camera = new PerspectiveCamera(50, aspect, 1, 1000);
        camera.position.z = 100;
        scene = new Scene();
        //model
        OBJLoader loader = new OBJLoader();
        loader.load("models/obj/walt/WaltHead.obj", new OnLoadCallback<Object3D>() {
            @Override
            public void onLoad(Object3D obj) {
                object = obj;
                object.scale.multiplyScalar(0.8f);
                object.position.y = -30;
                scene.add(object);
            }
        });

        MeshBasicMaterialParameters meshBasicMaterialParameters = new MeshBasicMaterialParameters();
        meshBasicMaterialParameters.color = new Color(0xff0040);

        SphereBufferGeometry sphere = new SphereBufferGeometry(0.5f, 16, 8);
        //lights
        light1 = new PointLight(0xff0040, 2, 50);
        light1.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light1);

        light2 = new PointLight(0x0040ff, 2, 50);
        meshBasicMaterialParameters.color = new Color(0x0040ff);
        light2.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light2);

        light3 = new PointLight(0x80ff80, 2, 50);
        meshBasicMaterialParameters.color = new Color(0x80ff80);
        light3.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light3);

        light4 = new PointLight(0xffaa00, 2, 50);
        meshBasicMaterialParameters.color = new Color(0xffaa00);
        light4.add(new Mesh(sphere, new MeshBasicMaterial(meshBasicMaterialParameters)));
        scene.add(light4);

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);

    }


    @Override
    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("- point lights WebGL demo.<br />\n" +
                "\t\t\tWalt Disney head by <a href=\"http://davidoreilly.com/post/18087489343/disneyhead\" target=\"_blank\" rel=\"noopener\" style='color:orange;'>David OReilly</a>");

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
        double time = new Date().getTime() * 0.0005;
        double delta = clock.getDelta();
        if (object != null) object.rotation.y -= 0.5 * delta;
        light1.position.x = (float) Math.sin(time * 0.7) * 30;
        light1.position.y = (float) Math.cos(time * 0.5) * 40;
        light1.position.z = (float) Math.cos(time * 0.3) * 30;
        light2.position.x = (float) Math.cos(time * 0.3) * 30;
        light2.position.y = (float) Math.sin(time * 0.5) * 40;
        light2.position.z = (float) Math.sin(time * 0.7) * 30;
        light3.position.x = (float) Math.sin(time * 0.7) * 30;
        light3.position.y = (float) Math.cos(time * 0.3) * 40;
        light3.position.z = (float) Math.sin(time * 0.5) * 30;
        light4.position.x = (float) Math.sin(time * 0.3) * 30;
        light4.position.y = (float) Math.cos(time * 0.7) * 40;
        light4.position.z = (float) Math.sin(time * 0.5) * 30;
        renderer.render(scene, camera);
    }

}




