package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.core.TraverseCallback;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.loaders.OBJLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressEvent;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.loaders.managers.OnProgress;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/10/18.
 */
@InjectJavaScriptFor(elements = OBJLoader.class)
public class WebglLoaderObj extends Attachable {

    public static final String name = "loader / obj";
    private Vector2 mouse = new Vector2();
    private HTMLDivElement panel = (HTMLDivElement) DomGlobal.document.getElementById("panel");


    public WebglLoaderObj() {

        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.z = 250;
        // scene
        scene = new Scene();
        AmbientLight ambientLight = new AmbientLight(0xcccccc, 0.4f);
        scene.add(ambientLight);
        PointLight pointLight = new PointLight(0xffffff, 0.8f);
        camera.add(pointLight);
        scene.add(camera);
        // texture
        LoadingManager manager = new LoadingManager();
        manager.onProgress = new OnProgress() {
            @Override
            public void onProgress(String url, int itemsLoaded, int itemsTotal) {
                GWT.log(" " + url + " " + itemsLoaded + " " + itemsTotal);
            }
        };

        TextureLoader textureLoader = new TextureLoader(manager);
        Texture texture = textureLoader.load("textures/UV_Grid_Sm.jpg");
        // model
        OnProgressCallback onProgress = new OnProgressCallback() {
            @Override
            public void onProgress(OnProgressEvent request) {
                GWT.log("" + request.lengthComputable + " " + request.loaded + " " + request.total);
            }
        };

        OnErrorCallback onError = new OnErrorCallback() {
            @Override
            public void onError(PropertyHolder err) {
                GWT.log(" onError ");
            }
        };

        OBJLoader loader = new OBJLoader(manager);
        loader.load("models/obj/male02/male02.obj", new OnLoadCallback<Object3D>() {

            @Override
            public void onLoad(Object3D object) {

                object.traverse(new TraverseCallback() {

                    @Override
                    public void onEvent(Object3D child) {
                        if (child instanceof Mesh) {
                            ((MeshPhongMaterial) ((Mesh) child).material).map = texture;
                        }
                    }
                });

                object.position.y = -95;
                scene.add(object);
            }


        }, onProgress, onError);
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("- OBJLoader test");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();
                renderer.render(scene, camera);
                animate();

            }
        });
    }

}