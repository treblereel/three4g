package org.treblereel.gwt.three4g.demo.client.animation;


import elemental2.core.JsArray;
import elemental2.core.JsMap;
import elemental2.core.JsNumber;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import io.crysknife.client.IsElement;
import io.crysknife.ui.navigation.client.local.Page;
import io.crysknife.ui.navigation.client.local.PageHiding;
import io.crysknife.ui.navigation.client.local.PageShown;
import jsinterop.annotations.JsFunction;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.lilgui4g.FunctionController;
import org.treblereel.gwt.lilgui4g.GUI;
import org.treblereel.gwt.lilgui4g.GUIProperty;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.animation.AnimationAction;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.animation.AnimationUtils;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.controls.OrbitControls;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.core.events.Event;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.core.events.EventListener;
import org.treblereel.gwt.three4g.demo.client.utils.Stats;
import org.treblereel.gwt.three4g.geometries.PlaneGeometry;
import org.treblereel.gwt.three4g.helpers.SkeletonHelper;
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

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Page(path = "webgl_animation_skinning_additive_blending")
public class WebglAnimationSkinningAdditiveBlending implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private boolean run, ready;

    private GUI panel;

    private Scene scene;

    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private Clock clock = new Clock();
    private Stats stats = new Stats();

    private AnimationMixer mixer;

    private Object3D model;

    private SkeletonHelper skeleton;

    private JsArray<FunctionController> crossFadeControls = new JsArray<>();

    private String currentBaseAction = "idle";

    private int numAnimations;

    private List allActions = new ArrayList();

    JsMap<String, JsPropertyMap> baseActions = new JsMap<>();

    JsMap<String, JsPropertyMap> additiveActions = new JsMap<>();


    @PostConstruct
    public void init() {

        root.appendChild(stats.dom);

        JsPropertyMap idle = JsPropertyMap.of();
        idle.set("weight", 1);
        baseActions.set("idle", idle);

        JsPropertyMap walk = JsPropertyMap.of();
        walk.set("weight", 0);
        baseActions.set("walk", walk);

        JsPropertyMap run = JsPropertyMap.of();
        run.set("weight", 0);
        baseActions.set("run", run);

        JsPropertyMap sneak_pose = JsPropertyMap.of();
        sneak_pose.set("weight", 0);
        additiveActions.set("sneak_pose", sneak_pose);

        JsPropertyMap sad_pose = JsPropertyMap.of();
        sad_pose.set("weight", 0);
        additiveActions.set("sad_pose", sad_pose);

        JsPropertyMap agree = JsPropertyMap.of();
        agree.set("weight", 0);
        additiveActions.set("agree", agree);

        JsPropertyMap headShake = JsPropertyMap.of();
        headShake.set("weight", 0);
        additiveActions.set("headShake", headShake);

        WebGLRendererParameters webGLRendererParameters = WebGLRendererParameters.create();
        webGLRendererParameters.setAntialias(true);

        renderer = new WebGLRenderer(webGLRendererParameters);
        renderer.setPixelRatio(DomGlobal.window.devicePixelRatio);
        renderer.setSize(DomGlobal.window.innerWidth * 0.8, DomGlobal.window.innerHeight * 0.8);
        renderer.outputEncoding = THREE.sRGBEncoding;
        renderer.shadowMap.enabled = true;
        root.appendChild(renderer.domElement);

        // camera
        camera = new PerspectiveCamera( 45, DomGlobal.window.innerWidth * 0.8 / DomGlobal.window.innerHeight * 0.8, 1, 100 );
        camera.position.set( - 1, 2, 3 );

        OrbitControls controls = new OrbitControls( camera, renderer.domElement );
        controls.enablePan = false;
        controls.enableZoom = false;
        controls.target.set( 0, 1, 0 );
        controls.update();


        scene = new Scene();
        scene.setBackground(new Color( 0xa0a0a0 ));
        scene.setFog(new Fog( 0xa0a0a0, 10, 50 ));

        HemisphereLight hemiLight = new HemisphereLight( 0xffffff, 0x444444 );
        hemiLight.position.set( 0, 20, 0 );
        scene.add( hemiLight );

        DirectionalLight dirLight = new DirectionalLight( 0xffffff );
        dirLight.position.set( 3, 10, 10 );
        dirLight.castShadow = true;
        dirLight.shadow.camera.top = 2;
        dirLight.shadow.camera.bottom = - 2;
        dirLight.shadow.camera.left = - 2;
        dirLight.shadow.camera.right = 2;
        dirLight.shadow.camera.near = 0.1;
        dirLight.shadow.camera.far = 40;
        scene.add( dirLight );

        // ground

        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setColor(0x999999);
        meshPhongMaterialParameters.setDepthWrite(false);

        Mesh mesh = new Mesh( new PlaneGeometry( 100, 100 ), new MeshPhongMaterial(meshPhongMaterialParameters));
        mesh.rotation.x = - Math.PI / 2;
        mesh.receiveShadow = true;
        scene.add( mesh );

        GLTFLoader loader = new GLTFLoader();
        loader.load( "models/gltf/Xbot.glb",  (OnLoadCallback<PropertyHolder>) gltf -> {

            model = gltf.getProperty("scene");
            scene.add( model );

            model.traverse( object -> {
                if (object instanceof Mesh) object.castShadow = true;
                    return null;
            });

            skeleton = new SkeletonHelper( model );
            skeleton.visible = false;
            scene.add( skeleton );

            AnimationClip[] animations = gltf.getProperty("animations");
            mixer = new AnimationMixer(model);

            for ( int i = 0; i < animations.length; ++ i ) {

                AnimationClip clip = animations[ i ];
                String name = clip.name;

                if ( baseActions.has(name) ) {
                    AnimationAction action = mixer.clipAction(clip);

                    activateAction( action );
                    baseActions.get(name).set("action", action);

                    allActions.add( action );

                } else if ( additiveActions.has(name)) {

                    // Make the clip additive and remove the reference frame
                    AnimationUtils.makeClipAdditive( clip );
                    if (clip.name.endsWith("_pose")) {
                        clip = AnimationUtils.subclip( clip, clip.name, 2, 3, 30 );
                    }

                    AnimationAction action = mixer.clipAction( clip );

                    activateAction( action );
                    additiveActions.get(name).set("action", action);
                    allActions.add( action );

                }

            }

            createPanel();
            ready = true;

        });

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);

    }

    private void createPanel() {
        GUIProperty property = new GUIProperty().setWidth(310);

        panel = new GUI(property);

        GUI folder1 = panel.addFolder( "Base Actions" );
        GUI folder2 = panel.addFolder( "Additive Action Weights" );
        GUI folder3 = panel.addFolder( "General Speed" );

        JsPropertyMap panelSettings = JsPropertyMap.of();
        panelSettings.set("modify time scale", 1.0);


		JsArray<String> baseNames = new JsArray<>();
        baseNames.push("None");


        baseActions.forEach((p0, p1, p2) -> {
            baseNames.push(p1);
            return null;
        });

        for ( int i = 0, l = baseNames.length; i != l; ++ i ) {

            String name = baseNames.getAt(i);
            JsPropertyMap settings = baseActions.get(name);

            panelSettings.set(name, (Fn) () -> {
                JsPropertyMap currentSettings = baseActions.get(currentBaseAction);
                AnimationAction currentAction = currentSettings != null ? Js.uncheckedCast(currentSettings.get("action")) : null;
                AnimationAction action = settings != null ? Js.uncheckedCast(settings.get("action")) : null;
                prepareCrossFade( currentAction, action, 0.35 );
            });
            crossFadeControls.push( folder1.addFunction( panelSettings, name ) );

        }

        additiveActions.forEach((settings, name, p2) -> {
            panelSettings.set(name, settings.get("weight"));

            folder2.addNumber( panelSettings, name, 0.0, 1.0, 0.01 ).listen().onChange(weight -> {
                setWeight(Js.uncheckedCast(settings.get("action")), weight.doubleValue());
                settings.set("weight", weight);
            });

            return null;
        });

        folder3.addNumber( panelSettings, "modify time scale", 0.0, 1.5, 0.01 ).onChange(n ->  modifyTimeScale(n.doubleValue()));

        folder1.open();
        folder2.open();
        folder3.open();


        crossFadeControls.forEach((control, p1, p2) -> {
            Js.asPropertyMap(control).set("setInactive", (SetInactive) () -> control.domElement().classList.add( "control-inactive" ));
            Js.asPropertyMap(control).set("setActive", (SetActive) () -> control.domElement().classList.remove( "control-inactive" ));


            JsPropertyMap settings = baseActions.get(control.property());

            if ( settings == null || !settings.has("weight") ) {
                Js.<SetInactive>uncheckedCast(Js.asPropertyMap(control).get("setInactive")).onInactive();
            }
            return null;
        });
    }

    private void setWeight(AnimationAction action, double weight ) {

        action.enabled = true;
        action.setEffectiveTimeScale( 1 );
        action.setEffectiveWeight( weight );

    }

    private void activateAction(AnimationAction action ) {
        AnimationClip clip = action.getClip();
        JsPropertyMap settings = baseActions.has(clip.name)  ? baseActions.get(clip.name) :  additiveActions.get(clip.name);
        setWeight( action, new JsNumber(settings.get("weight")).valueOf());
        action.play();
    }

    private void modifyTimeScale(double speed ) {
        mixer.timeScale = speed;
    }

    private void prepareCrossFade(AnimationAction startAction, AnimationAction  endAction, double duration ) {

        // If the current action is "idle", execute the crossfade immediately;
        // else wait until the current action has finished its current loop
        if ( currentBaseAction == "idle" || startAction != null || endAction != null) {
            executeCrossFade( startAction, endAction, duration );
        } else {
            synchronizeCrossFade( startAction, endAction, duration );
        }

        // Update control colors
        if ( endAction != null) {
            AnimationClip clip = endAction.getClip();
            currentBaseAction = clip.name;
        } else {
            currentBaseAction = "None";
        }

        crossFadeControls.forEach((control, p1, p2) -> {
            String name = control.property();
            if ( name.equals(currentBaseAction)) {
                Js.<SetActive>uncheckedCast(Js.asPropertyMap(control).get("setActive")).onActive();
            } else {
                Js.<SetInactive>uncheckedCast(Js.asPropertyMap(control).get("setInactive")).onInactive();
            }
            return null;
        });
    }

    EventListener onLoopFinished;


    private void synchronizeCrossFade(AnimationAction startAction, AnimationAction endAction, double duration ) {

        onLoopFinished = new EventListener() {
            @Override
            public void onInvoke(Event e1) {
                JsPropertyMap event = Js.asPropertyMap(e1);
                if(event.has("action")) {
                    AnimationAction action = Js.uncheckedCast(event.get("action"));
                    if ( action == startAction ) {
                        mixer.removeEventListener( "loop", onLoopFinished );
                        executeCrossFade( startAction, endAction, duration );
                    }
                }
            }
        };

        mixer.addEventListener("loop", onLoopFinished);
    }

    private void executeCrossFade(AnimationAction startAction, AnimationAction endAction, double duration ) {

        // Not only the start action, but also the end action must get a weight of 1 before fading
        // (concerning the start action this is already guaranteed in this place)

        if ( endAction != null) {

            setWeight( endAction, 1 );
            endAction.time = 0;

            if ( startAction != null) {

                // Crossfade with warping

                startAction.crossFadeTo( endAction, duration, true );

            } else {

                // Fade in

                endAction.fadeIn( duration );

            }

        } else {

            // Fade out

            startAction.fadeOut( duration );

        }

    }


    @PageHiding
    private void onHide() {
        run = false;
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");
        while (info.firstChild != null) {
            info.removeChild(info.firstChild);
        }
        panel.hide();
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> - Skeletal Additive Animation Blending\n" +
                "\t\t\t(model from <a href=\"https://www.mixamo.com/\" target=\"_blank\" rel=\"noopener\">mixamo.com</a>)<br/>";

        run = true;
        animate();
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
            for ( int i = 0; i < numAnimations; ++ i ) {
                AnimationAction action = (AnimationAction) allActions.get(i);
                AnimationClip clip = action.getClip();
                JsPropertyMap settings = baseActions.has(clip.name)  ? baseActions.get(clip.name) :  additiveActions.get(clip.name);
                settings.set("weight", action.getEffectiveWeight());
            }

            // Get the time elapsed since the last frame, used for mixer update

            double mixerUpdateDelta = clock.getDelta();

            // Update the animation mixer, the stats panel, and render this frame


            stats.update();
            mixer.update(mixerUpdateDelta);
            renderer.render(scene, camera);
        }
    }

    @FunctionalInterface
    @JsFunction
    private interface SetInactive {

        void onInactive();
    }

    @FunctionalInterface
    @JsFunction
    private interface SetActive {

        void onActive();
    }

    @FunctionalInterface
    @JsFunction
    private interface Fn {

        void invoke();
    }
}
