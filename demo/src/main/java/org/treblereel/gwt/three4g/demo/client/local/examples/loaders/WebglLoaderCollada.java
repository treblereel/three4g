package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.ColladaLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.loaders.managers.OnLoad;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/9/18.
 */
@InjectJavaScriptFor(elements = ColladaLoader.class)
public class WebglLoaderCollada extends Attachable {

    public static final String name = "loader / collada";

    private Clock clock = new Clock();
    private Group elf;

    public WebglLoaderCollada() {


        camera = new PerspectiveCamera(45, aspect, 0.1f, 2000);
        camera.position.set(8, 10, 8);
        camera.lookAt(new Vector3(0, 3, 0));
        scene = new Scene();
        // loading manager
        LoadingManager loadingManager = new LoadingManager(new OnLoad() {
            @Override
            public void onLoad() {
                scene.add(elf);
            }
        });

        // collada
        ColladaLoader loader = new ColladaLoader(loadingManager);
        loader.load("models/collada/elf/elf.dae", object -> elf = object.getProperty("scene"));

        AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4f);
        scene.add(ambientLight);
        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 0.8f);
        directionalLight.position.set(1, 1, 0).normalize();
        scene.add(directionalLight);
        //
        renderer = new WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);

        container.appendChild(renderer.domElement);

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" collada loader\n" +
                "\t\t\t| Elf Girl by <a href=\"https://sketchfab.com/yellow09\" target=\"_blank\" rel=\"noopener\">halloween</a> is licensed under <a href=\"https://creativecommons.org/licenses/by/4.0/\" target=\"_blank\" rel=\"noopener\">CC Attribution</a>");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                float delta = clock.getDelta();
                if (elf != null) {
                    elf.rotation.z += delta * 0.5;
                }
                renderer.render(scene, camera);
                animate();

            }
        });
    }

}
