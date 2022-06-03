package org.treblereel.gwt.three4g.demo.client.animation;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventTarget;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.ProgressEvent;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.annotations.JsFunction;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.lilgui4g.OptionController;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.animation.AnimationAction;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.core.events.EventListener;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.helpers.GridHelper;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.loaders.DRACOLoader;
import org.treblereel.gwt.three4g.loaders.GLTFLoader;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterial;
import org.treblereel.gwt.three4g.materials.MeshPhongMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Fog;
import org.treblereel.gwt.three4g.scenes.Scene;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Page(path = "webgl_animation_skinning_morph")
public class WebglAnimationSkinningMorph implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Clock clock = new Clock();
    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private AnimationMixer mixer;

    private OrbitControls controls;

    private Scene scene;
    private Object3D model;

    private boolean run, ready;

    private JsPropertyMap api = JsPropertyMap.of();

    private AnimationAction activeAction, previousAction;

    private Map<String, AnimationAction> actions = new HashMap<>();

    @PostConstruct
    public void init() {
        api.set("state", "Walking");

        root.appendChild(stats.dom);

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8);
        renderer.outputEncoding = THREE.sRGBEncoding;
        root.appendChild(renderer.domElement);

        scene = new Scene();
        scene.setBackground(new Color( 0xe0e0e0 ));
        scene.setFog(new Fog( 0xe0e0e0, 20, 100 ));

        camera = new PerspectiveCamera( 45, DomGlobal.window.innerWidth * 0.8 / DomGlobal.window.innerHeight * 0.8, 0.25, 100 );
        camera.position.set( - 5, 3, 10 );
        camera.lookAt( new Vector3( 0, 2, 0 ) );

        controls = new OrbitControls( camera, renderer.domElement );
        controls.enablePan = false;
        controls.enableZoom = false;
        controls.target.set( 0, 1, 0 );
        controls.update();


        DRACOLoader dracoLoader = new DRACOLoader();
        dracoLoader.setDecoderPath( "js/libs/draco/gltf/" );

        // lights

        HemisphereLight hemiLight = new HemisphereLight( 0xffffff, 0x444444 );
        hemiLight.position.set( 0, 20, 0 );
        scene.add( hemiLight );

        DirectionalLight dirLight = new DirectionalLight( 0xffffff );
        dirLight.position.set( 0, 20, 10 );
        scene.add( dirLight );

        // ground

        MeshPhongMaterialParameters meshPhongMaterial = MeshPhongMaterialParameters.create();
        meshPhongMaterial.setColor(0x999999);
        meshPhongMaterial.setDepthWrite(false);

        Mesh mesh = new Mesh( new PlaneGeometry( 2000, 2000 ), new MeshPhongMaterial(meshPhongMaterial));
        mesh.rotation.x = - Math.PI / 2;
        scene.add( mesh );

        GridHelper grid = new GridHelper( 200, 40, 0x000000, 0x000000 );
        grid.material.opacity = 0.2;
        grid.material.transparent = true;
        scene.add( grid );

        // model

        GLTFLoader loader = new GLTFLoader();
        loader.load("models/gltf/RobotExpressive/RobotExpressive.glb", (OnLoadCallback<PropertyHolder>) gltf -> {
            model = gltf.getProperty("scene");

            scene.add(model);
            AnimationClip[] animations = gltf.getProperty("animations");
            createGUI(model, animations);

            ready = true;


        }, new OnProgressCallback() {
            @Override
            public void onProgress(ProgressEvent<EventTarget> request) {
                DomGlobal.console.log(request.loaded);
            }
        });

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
    }

    private JsArray<String> emotes;

    private GUI emoteFolder;

    private void createEmoteCallback(String name ) {

        api.set(name, (Fn) () -> {
            fadeToAction(name, 0.2);
            mixer.addEventListener("finished", restoreState);
        });

        emoteFolder.addFunction( api, name );
    }

    private void createGUI(Object3D model, AnimationClip[] animations) {

        JsArray<String> states = new JsArray<>();
        states.push("Idle", "Walking", "Running", "Dance", "Death", "Sitting", "Standing");
        emotes = new JsArray<>();
        emotes.push("Jump", "Yes", "No", "Wave", "Punch", "ThumbsUp");

        GUI gui = new GUI();

        mixer = new AnimationMixer(model);

        for (int i = 0; i < animations.length; i++) {

            AnimationClip clip = animations[i];
            AnimationAction action = mixer.clipAction(clip);

            actions.put(clip.name, action);

            if (emotes.indexOf(clip.name) >= 0 || states.indexOf(clip.name) >= 4) {

                action.clampWhenFinished = true;
                action.loop = THREE.LoopOnce;

            }

        }

        // states

        GUI statesFolder = gui.addFolder("States");

        OptionController clipCtrl = statesFolder.addOption(api, "state", states);

        clipCtrl.onChange(result -> fadeToAction(api.get("state").toString(), 0.5));

        statesFolder.open();

        // emotes

        emoteFolder = gui.addFolder("Emotes");


        for ( int i = 0; i < emotes.length; i ++ ) {

            createEmoteCallback( emotes.getAt(i) );

        }

        emoteFolder.open();

        // expressions

        Mesh face = model.getObjectByName( "Head_4" );

        JsArray<String> expressions = JsObject.keys(face.morphTargetDictionary);
        GUI expressionFolder = gui.addFolder( "Expressions" );

        for ( int i = 0; i < expressions.length; i ++ ) {
            expressionFolder.addNumber( face.morphTargetInfluences, i + "", 0, 1, 0.01 ).name( expressions.getAt(i));
        }

        activeAction = actions.get("Walking");
        activeAction.play();

        expressionFolder.open();

    }

    private EventListener restoreState = event -> restoreState();

    private void  restoreState() {
        mixer.removeEventListener( "finished", restoreState );
        fadeToAction( api.get("state").toString(), 0.2 );
    }

    private void  fadeToAction(String name, double duration ) {

        previousAction = activeAction;
        activeAction = actions.get(name);

        if ( previousAction != activeAction ) {
            previousAction.fadeOut( duration );
        }

        activeAction
                .reset()
                .setEffectiveTimeScale( 1 )
                .setEffectiveWeight( 1 )
                .fadeIn( duration )
                .play();

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if(camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {
            stats.update();
            double delta = clock.getDelta();
            mixer.update(delta);
            controls.update();
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

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> webgl - animation - keyframes<br/>\n" +
                "\t\t\tModel: <a href=\"https://artstation.com/artwork/1AGwX\" target=\"_blank\" rel=\"noopener\">Littlest Tokyo</a> by\n" +
                "\t\t\t<a href=\"https://artstation.com/glenatron\" target=\"_blank\" rel=\"noopener\">Glen Fox</a>, CC Attribution.";

        run = true;
        animate();
    }

    @JsFunction
    @FunctionalInterface
    public interface Fn {
        void call();
    }
}
