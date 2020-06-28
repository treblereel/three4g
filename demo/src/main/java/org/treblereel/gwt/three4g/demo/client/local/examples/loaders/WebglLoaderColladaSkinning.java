package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.animation.AnimationAction;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.ColladaLoader;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/9/18.
 */
@InjectJavaScriptFor(elements = OrbitControls.class)
public class WebglLoaderColladaSkinning extends Attachable {

    public static final String name = "loader / collada / skinning";

    private Clock clock = new Clock();
    private AnimationMixer mixer;


    public WebglLoaderColladaSkinning() {

        camera = new PerspectiveCamera(25, aspect, 1, 10000);
        camera.position.set(15, 10, -15);
        scene = new Scene();
        clock = new Clock();
        // collada
        ColladaLoader loader = new ColladaLoader();
        loader.load("models/collada/stormtrooper/stormtrooper.dae", new OnLoadCallback<PropertyHolder>() {
            @Override
            public void onLoad(PropertyHolder collada) {
                Object3D avatar = collada.getProperty("scene");
                AnimationClip[] animations = collada.getProperty("animations");
                mixer = new AnimationMixer(avatar);
                AnimationAction action = mixer.clipAction(animations[0]).play();
                scene.add(avatar);
            }

        });

        GridHelper gridHelper = new GridHelper(10, 20);
        scene.add(gridHelper);
        //
        AmbientLight ambientLight = new AmbientLight(0xffffff, 0.2f);
        scene.add(ambientLight);

        DirectionalLight directionalLight = new DirectionalLight(0xffffff, 0.8f);
        directionalLight.position.set(1, 1, -1);
        scene.add(directionalLight);


        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setSize(window.innerWidth, window.innerHeight);

        container.appendChild(renderer.domElement);


        orbitControls = new OrbitControls(camera, renderer.domElement);
        orbitControls.target.set(0, 2, 0);
        orbitControls.update();

    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("webgl - collada - skinning");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                renderer.render(scene, camera);
                float delta = clock.getDelta();
                if (mixer != null) {
                    mixer.update(delta);
                }
                animate();
            }

        });
    }

}
