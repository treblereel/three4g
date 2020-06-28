package org.treblereel.gwt.three4g.demo.client.local.examples.loaders;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.TraverseCallback;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.extensions.controls.OrbitControls;
import org.treblereel.gwt.three4g.extensions.loaders.FBXLoader;
import org.treblereel.gwt.three4g.geometries.PlaneBufferGeometry;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/9/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, FBXLoader.class})
public class WebglLoaderFbx extends Attachable {

    public static final String name = "loader / fbx";

    private Clock clock = new Clock();
    private AnimationMixer mixer;

    public WebglLoaderFbx() {


        camera = new PerspectiveCamera(45, aspect, 1, 2000);
        camera.position.set(100, 200, 300);

        orbitControls = new OrbitControls(camera, root);
        orbitControls.target.set(0, 100, 0);
        orbitControls.update();

        scene = new Scene();
        scene.background = new Color(0xa0a0a0);
        scene.fog = new Fog(0xa0a0a0, 200, 1000);

        HemisphereLight hemisphereLight = new HemisphereLight(0xffffff, 0x444444);
        hemisphereLight.position.set(0, 200, 0);
        scene.add(hemisphereLight);
        DirectionalLight light = new DirectionalLight(0xffffff);
        light.position.set(0, 200, 100);
        light.castShadow = true;
        OrthographicCamera camera = (OrthographicCamera) light.shadow.camera;

        camera.top = 180;
        camera.bottom = -100;
        camera.left = -120;
        camera.right = 120;
        scene.add(light);

        MeshPhongMaterialParameters parameters = new MeshPhongMaterialParameters();
        parameters.color = new Color(0x999999);
        parameters.depthWrite = false;

        Mesh mesh = new Mesh(new PlaneBufferGeometry(2000, 2000), new MeshPhongMaterial(parameters));
        mesh.rotation.x = (float) (-Math.PI / 2);
        mesh.receiveShadow = true;
        scene.add(mesh);
        GridHelper grid = new GridHelper(2000, 20, new Color(0x000000), new Color(0x000000));
        grid.material.opacity = 0.2f;
        grid.material.transparent = true;
        scene.add(grid);
        // model
        FBXLoader loader = new FBXLoader();
        loader.load("models/fbx/Samba_Dancing.fbx", new OnLoadCallback<Group>() {
            @Override
            public void onLoad(Group group) {

                mixer = new AnimationMixer(group);
                AnimationClip[] clips = group.getProperty("animations");
                mixer.clipAction(clips[0]).play();

                group.traverse(new TraverseCallback() {
                    @Override
                    public void onEvent(Object3D child) {
                        if (child instanceof Mesh) {
                            child.castShadow = true;
                            child.receiveShadow = true;
                        }
                    }
                });
                scene.add(group);
            }
        });


        //
        WebGLRendererParameters rendererParameters = new WebGLRendererParameters();
        rendererParameters.antialias = true;
        renderer = new WebGLRenderer(rendererParameters);
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.shadowMap.enabled = true;
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
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml("Character and animation from <a href=\"https://www.mixamo.com/\" target=\"_blank\" rel=\"noopener\">Mixamo</a>");


    }

    private void animate() {
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                StatsProducer.getStats().update();

                if (mixer != null) {
                    mixer.update(clock.getDelta());
                }
                renderer.render(scene, camera);
                animate();

            }
        });
    }

}
