package org.treblereel.gwt.three4g.demo.client.animation;

import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.utils.SkeletonUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Page(path = "webgl_animation_multiple")
public class WebglAnimationMultiple implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Clock clock = new Clock();
    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private JsArray<AnimationMixer> mixers = new JsArray<>();

    private Scene scene;

    private boolean run, ready;


    @PostConstruct
    public void init() {
        root.appendChild(stats.dom);

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        renderer.outputEncoding = THREE.sRGBEncoding;
        renderer.shadowMap.enabled = true;
        root.appendChild(renderer.domElement);

        camera = new PerspectiveCamera(45, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000);
        camera.position.set(2, 3, -6);
        camera.lookAt(0, 1, 0);


        scene = new Scene();
        scene.setBackground(new Color(0xa0a0a0));
        scene.setFog(new Fog(0xa0a0a0, 10, 50));

        HemisphereLight hemiLight = new HemisphereLight(0xffffff, 0x444444);
        hemiLight.position.set(0, 20, 0);
        scene.add(hemiLight);

        DirectionalLight dirLight = new DirectionalLight(0xffffff);
        dirLight.position.set(-3, 10, -10);
        dirLight.castShadow = true;
        dirLight.shadow.camera.top = 4;
        dirLight.shadow.camera.bottom = -4;
        dirLight.shadow.camera.left = -4;
        dirLight.shadow.camera.right = 4;
        dirLight.shadow.camera.near = 0.1;
        dirLight.shadow.camera.far = 40;
        scene.add(dirLight);

        MeshPhongMaterialParameters phongMaterialParameters = MeshPhongMaterialParameters.create();
        phongMaterialParameters.setColor(0x999999);
        phongMaterialParameters.setDepthWrite(false);

        Mesh mesh = new Mesh(new PlaneGeometry(200, 200), new MeshPhongMaterial(phongMaterialParameters));
        mesh.rotation.x = -Math.PI / 2;
        mesh.receiveShadow = true;
        scene.add(mesh);

        GLTFLoader loader = new GLTFLoader();

        loader.load("models/gltf/Soldier.glb", (OnLoadCallback<PropertyHolder>) result -> {
            Object3D scene = result.getProperty("scene");

            scene.traverse(object -> {
                if (object instanceof Mesh) {
                    object.castShadow = true;
                }
                return null;
            });

            Object3D model1 = SkeletonUtils.clone(scene);
            Object3D model2 = SkeletonUtils.clone(scene);
            Object3D model3 = SkeletonUtils.clone(scene);

            AnimationMixer mixer1 = new AnimationMixer( model1 );
            AnimationMixer mixer2 = new AnimationMixer( model2 );
            AnimationMixer mixer3 = new AnimationMixer( model3 );

            AnimationClip[] animations = result.getProperty("animations");

            mixer1.clipAction( animations[ 0 ] ).play(); // idle
            mixer2.clipAction( animations[ 1 ] ).play(); // run
            mixer3.clipAction( animations[ 3 ] ).play(); // walk

            model1.position.x = - 2;
            model2.position.x = 0;
            model3.position.x = 2;

            this.scene.add( model1, model2, model3 );
            mixers.push( mixer1, mixer2, mixer3 );

            ready = true;
        });

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if (camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());
        if (run && ready) {
            stats.update();
            double delta = clock.getDelta();

            mixers.forEach((mixer, p1, p2) -> {
                mixer.update(delta);
                return null;
            });
            renderer.render(scene, camera);
        }
    }

    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "This demo shows how to clone a skinned mesh using <strong>SkeletonUtils.clone()</strong><br/>\n" +
                "\t\t\tSoldier model from <a href=\"https://www.mixamo.com\" target=\"_blank\" rel=\"noopener\">https://www.mixamo.com</a>.";

        run = true;
        animate();
    }
}
