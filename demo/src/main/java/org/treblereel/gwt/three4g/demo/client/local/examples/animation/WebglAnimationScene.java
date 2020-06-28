package org.treblereel.gwt.three4g.demo.client.local.examples.animation;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.json.client.JSONObject;
import elemental2.core.JsObject;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.InjectJavaScriptFor;
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
import org.treblereel.gwt.three4g.extensions.loaders.DRACOLoader;
import org.treblereel.gwt.three4g.extensions.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.lights.AmbientLight;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.loaders.CubeTextureLoader;
import org.treblereel.gwt.three4g.materials.MeshStandardMaterial;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.CubeTexture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com> Created by treblereel on 3/9/18.
 */
@InjectJavaScriptFor(elements = {OrbitControls.class, DRACOLoader.class, GLTFLoader.class})
public class WebglAnimationScene extends Attachable {

    public static final String name = "animation / keyframes";
    private AnimationMixer mixer;
    private PointLight pointLight;

    private Clock clock = new Clock();

    public WebglAnimationScene() {

        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        setupWebGLRenderer(renderer);
        renderer.gammaOutput = true;
        renderer.gammaFactor = 2.2;

        scene = new Scene();
        scene.background = new Color(0xbfe3dd);

        camera = new PerspectiveCamera(40, window.innerWidth / window.innerHeight, 1, 100);
        camera.position.set(5, 2, 8);

        orbitControls = new OrbitControls(camera, renderer.domElement);
        orbitControls.target.set(0, 0.5f, 0);
        orbitControls.enablePan = false;

        scene.add(new AmbientLight(0x404040));

        pointLight = new PointLight(0xffffff, 1);
        pointLight.position.copy(camera.position);
        scene.add(pointLight);

        // envmap
        String path = "textures/cube/Park2/";
        String format = ".jpg";
        CubeTexture envMap = new CubeTextureLoader().load(new String[]{
                path + "posx" + format, path + "negx" + format,
                path + "posy" + format, path + "negy" + format,
                path + "posz" + format, path + "negz" + format
        });

        DRACOLoader dracoLoader = new DRACOLoader();
        dracoLoader.setDecoderPath("js/libs/draco/gltf/");
        GLTFLoader<PropertyHolder> loader = new GLTFLoader<>();
        loader.setDRACOLoader(dracoLoader);

        loader.load("models/gltf/LittlestTokyo.glb", result -> {
            Scene model = result.getProperty("scene");
            model.position.set(1, 1, 0);
            model.scale.set(0.01f, 0.01f, 0.01f);
            model.traverse(child -> {
                if (child instanceof Mesh) {
                    ((MeshStandardMaterial) ((Mesh) child).material).envMap = envMap;
                }
            });

            scene.add(model);
            mixer = new AnimationMixer(model);
            AnimationClip[] clips = result.getProperty("animations");
            mixer.clipAction(clips[0]).play();
        });
    }

    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js")
                .setInnetHtml(
                        " <span style=\"color:black;\"> webgl - animation - keyframes\n</span>"
                                + "\t\t\t<p>\n"
                                + "\t\t\t\t<span style=\"color:black;\">Model: </span><a style='color:black;' href=\"https://www.artstation.com/artwork/1AGwX\" target=\"_blank\" rel=\"noopener\">Littlest Tokyo</a><span style=\"color:black;\"> by\n</span>"
                                + "\t\t\t\t<a href=\"https://www.artstation.com/glenatron\" target=\"_blank\" rel=\"noopener\">Glen Fox</a><span style=\"color:black;\">, CC Attribution.\n</span>"
                                + "\t\t\t</p>");
    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null && mixer != null) {
                double delta = clock.getDelta();
                mixer.update(delta);
                orbitControls.update();
                renderer.render(scene, camera);
            }
            animate();
        });
    }
}
