package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.TraverseCallback;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.TrackballControls;
import org.treblereel.gwt.three4g.extensions.loaders.TDSLoader;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.TextureLoader;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/8/18.
 */
@InjectJavaScriptFor(elements = {TrackballControls.class, TDSLoader.class})
public class WebglLoader3ds extends Attachable {

    public static final String name = "loader / 3ds";

    public WebglLoader3ds() {

        camera = new PerspectiveCamera(60, aspect, 0.1f, 10);
        camera.position.z = 2;
        trackballControls = new TrackballControls(camera);
        scene = new Scene();
        scene.add(new HemisphereLight());
        DirectionalLight directionalLight = new DirectionalLight(0xffeedd);
        directionalLight.position.set(0, 0, 2);
        scene.add(directionalLight);
        //3ds files dont store normal maps
        TextureLoader textureLoader = new TextureLoader();
        Texture normal = textureLoader.load("models/3ds/portalgun/textures/normal.jpg");
        TDSLoader loader = new TDSLoader();
        loader.setResourcePath("models/3ds/portalgun/textures/");
        loader.load("models/3ds/portalgun/portalgun.3ds", new OnLoadCallback<Object3D>() {
            @Override
            public void onLoad(Object3D object) {

                object.traverse(new TraverseCallback() {
                    @Override
                    public void onEvent(Object3D child) {
                        if (child instanceof Mesh) {
                            Mesh mesh = child.cast();
                            ((MeshPhongMaterial) mesh.material).normalMap = normal;
                        }
                    }
                });

                scene.add(object);

                // renderer
                renderer = new WebGLRenderer();
                renderer.setSize(window.innerWidth, window.innerHeight);
                container.appendChild(renderer.domElement);


            }
        });
    }

    @Override
    protected void doAttachScene() {
        root.appendChild(container);
        renderer.setSize(getWidth(), getHeight());
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - 3DS loader");


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
