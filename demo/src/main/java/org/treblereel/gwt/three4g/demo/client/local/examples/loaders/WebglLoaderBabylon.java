package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import java.util.Random;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extensions.loaders.BabylonLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.loaders.managers.OnProgress;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/10/18.
 */
@InjectJavaScriptFor(elements = {TrackballControls.class, BabylonLoader.class})
public class WebglLoaderBabylon extends Attachable {

    public static final String name = "loader / babylon";

    public WebglLoaderBabylon() {

        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.z = 100;
        trackballControls = new TrackballControls(camera);
        // scene
        scene = new Scene();
        // texture
        LoadingManager manager = new LoadingManager();

        manager.onProgress = new OnProgress() {
            @Override
            public void onProgress(String url, int itemsLoaded, int itemsTotal) {
                GWT.log(" " + url + " " + itemsLoaded + " " + itemsTotal);

            }
        };

        MeshBasicMaterial material = new MeshBasicMaterial();
        material.color = new Color("red");

        // model
        BabylonLoader loader = new BabylonLoader(manager);
        loader.load("models/babylon/skull.babylon", object -> {
            Scene babylonScene = object.cast();
            babylonScene.traverse(object1 -> {
                MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
                parameters.color = new Color(new Random().nextInt() * 0xffffff);
                if (object1 instanceof Mesh) {
                    ((Mesh) object1).material = new MeshPhongMaterial(parameters);
                }
            });
            scene = babylonScene;
            animate();

        });

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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - BabylonLoader test");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                trackballControls.update();
                renderer.render(scene, camera);
                animate();

            }
        });
    }

}
