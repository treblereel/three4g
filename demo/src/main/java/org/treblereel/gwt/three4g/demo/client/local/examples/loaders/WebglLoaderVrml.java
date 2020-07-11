package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.VRMLLoader;
import org.treblereel.gwt.three4g.extensions.resources.Extensions;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */

@InjectJavaScriptFor(elements = {OrbitControls.class, VRMLLoader.class})
public class WebglLoaderVrml extends Attachable {

    public static final String name = "loader / vrml";

    Extensions extensions = GWT.create(Extensions.class);

    public WebglLoaderVrml() {

        camera = new PerspectiveCamera(60, aspect, 0.01f, 1e10f);
        camera.position.z = 6;
        scene = new Scene();
        scene.add(camera);
        // light
        DirectionalLight dirLight = new DirectionalLight(0xffffff);
        dirLight.position.set(200, 200, 1000).normalize();
        camera.add(dirLight);
        camera.add(dirLight.target);
        VRMLLoader loader = new VRMLLoader();
        loader.load("models/vrml/house.wrl", new OnLoadCallback<Scene>() {
                    @Override
                    public void onLoad(Scene object) {
                        scene.add(object);
                    }
                }
        );


        renderer = new WebGLRenderer();
        setupWebGLRenderer(renderer);
        orbitControls = new OrbitControls(camera, renderer.domElement);
        //
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
        AppSetup.infoDiv.setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" vrml format loader test ").show();
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

    private void render() {
        renderer.render(scene, camera);
    }
}

