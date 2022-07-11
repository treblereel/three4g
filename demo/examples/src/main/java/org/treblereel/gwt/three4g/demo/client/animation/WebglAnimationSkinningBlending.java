package org.treblereel.gwt.three4g.demo.client.animation;

import elemental2.core.JsArray;
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
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
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

@Singleton
@Page(path = "webgl_animation_skinning_blending")
public class WebglAnimationSkinningBlending implements IsElement<HTMLDivElement> {

    @Inject
    private HTMLDivElement root;

    private Clock clock = new Clock();
    private Stats stats = new Stats();
    private WebGLRenderer renderer;

    private PerspectiveCamera camera;

    private AnimationMixer mixer;

    private Scene scene;
    private Object3D model;

    private boolean run, ready, singleStepMode;

    private SkeletonHelper skeleton;

    private AnimationAction idleAction, walkAction, runAction;
    private double idleWeight, walkWeight, runWeight;

    private double sizeOfNextStep = 0;

    private AnimationAction[] actions;

    private GUI panel;

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

        camera = new PerspectiveCamera( 45, DomGlobal.window.innerWidth / DomGlobal.window.innerHeight, 1, 1000 );

        camera.position.set( 1, 2, - 3 );
        camera.lookAt( 0, 1, 0 );

        clock = new Clock();

        scene = new Scene();
        scene.setBackground(new Color( 0xa0a0a0));
        scene.setFog(new Fog( 0xa0a0a0, 10, 50 ));

        HemisphereLight hemiLight = new HemisphereLight( 0xffffff, 0x444444 );
        hemiLight.position.set( 0, 20, 0 );
        scene.add( hemiLight );

        DirectionalLight dirLight = new DirectionalLight( 0xffffff );
        dirLight.position.set( - 3, 10, - 10 );
        dirLight.castShadow = true;
        dirLight.shadow.camera.top = 2;
        dirLight.shadow.camera.bottom = - 2;
        dirLight.shadow.camera.left = - 2;
        dirLight.shadow.camera.right = 2;
        dirLight.shadow.camera.near = 0.1;
        dirLight.shadow.camera.far = 40;
        scene.add( dirLight );

        // scene.add( new THREE.CameraHelper( dirLight.shadow.camera ) );

        // ground
        MeshPhongMaterialParameters meshPhongMaterialParameters = MeshPhongMaterialParameters.create();
        meshPhongMaterialParameters.setColor(0x999999);
        meshPhongMaterialParameters.setDepthWrite(false);

        Mesh mesh = new Mesh( new PlaneGeometry( 100, 100 ), new MeshPhongMaterial(meshPhongMaterialParameters));
        mesh.rotation.x = - Math.PI / 2;
        mesh.receiveShadow = true;
        scene.add( mesh );

        GLTFLoader loader = new GLTFLoader();
        loader.load( "models/gltf/Soldier.glb", (OnLoadCallback<PropertyHolder>) gltf -> {

            model = gltf.getProperty("scene");
            scene.add(model);

            model.traverse(object -> {
                if (object instanceof Mesh) object.castShadow = true;
                return null;
            });

            //

            skeleton = new SkeletonHelper(model);
            skeleton.visible = false;
            scene.add(skeleton);

            //

            createPanel();


            //
            AnimationClip[] animations = gltf.getProperty("animations");

            mixer = new AnimationMixer(model);

            idleAction = mixer.clipAction(animations[0]);
            walkAction = mixer.clipAction(animations[3]);
            runAction = mixer.clipAction(animations[1]);

            actions = new AnimationAction[] { idleAction, walkAction, runAction };

            activateAllActions();

            ready = true;

        } );

        DomGlobal.window.addEventListener("resize", evt -> onWindowResize(), false);
    }

    private JsPropertyMap settings = JsPropertyMap.of();

    private JsArray<FunctionController> crossFadeControls = new JsArray();


    private void createPanel() {

        GUIProperty property = new GUIProperty().setWidth(310);

        panel = new GUI(property);

        GUI folder1 = panel.addFolder( "Visibility");
        GUI folder2 = panel.addFolder( "Activation/Deactivation");
        GUI folder3 = panel.addFolder( "Pausing/Stepping");
        GUI folder4 = panel.addFolder( "Crossfading");
        GUI folder5 = panel.addFolder( "Blend Weights");
        GUI folder6 = panel.addFolder( "General Speed");


        settings.set("show model", true);
        settings.set("show skeleton", false);
        settings.set("deactivate all", (Fn) () -> deactivateAllActions());
        settings.set("activate all", (Fn) () -> activateAllActions());
        settings.set("pause/continue", (Fn) () -> pauseContinue());
        settings.set("make single step", (Fn) () -> toSingleStepMode());
        settings.set("modify step size", 0.05);
        settings.set("from walk to idle", (Fn) () -> prepareCrossFade( walkAction, idleAction, 1.0 ));
        settings.set("from idle to walk", (Fn) () -> prepareCrossFade( idleAction, walkAction, 0.5 ));
        settings.set("from walk to run", (Fn) () -> prepareCrossFade( walkAction, runAction, 2.5 ));
        settings.set("from run to walk", (Fn) () -> prepareCrossFade( runAction, walkAction, 5.0 ));

        settings.set("use default duration", true);
        settings.set("set custom duration", 3.5);
        settings.set("modify idle weight", 0.0);
        settings.set("modify walk weight", 1.0);
        settings.set("modify run weight", 0.0);
        settings.set("modify time scale", 1.0);


        folder1.addBoolean( settings, "show model" ).onChange(result -> showModel(result));

        folder1.addBoolean( settings, "show skeleton" ).onChange(result -> showSkeleton(result));
        folder2.addFunction( settings, "deactivate all" );
        folder2.addFunction( settings, "activate all" );
        folder3.addFunction( settings, "pause/continue" );
        folder3.addFunction( settings, "make single step" );
        folder3.addNumber(settings, "modify step size", 0.01, 0.1, 0.001 );

        crossFadeControls.push(folder4.addFunction(settings, "from walk to idle"));
        crossFadeControls.push(folder4.addFunction(settings, "from idle to walk"));
        crossFadeControls.push(folder4.addFunction(settings, "from walk to run"));
        crossFadeControls.push(folder4.addFunction(settings, "from run to walk"));


        folder4.addFunction( settings, "use default duration" );
        folder4.addNumber( settings, "set custom duration", 0, 10, 0.01 );

        folder5.addNumber( settings, "modify idle weight", 0.0, 1.0, 0.01 ).listen()
                .onChange(weight -> setWeight( idleAction, weight.doubleValue()));
        folder5.addNumber( settings, "modify walk weight", 0.0, 1.0, 0.01 ).listen()
                .onChange(weight -> setWeight( walkAction, weight.doubleValue()));

        folder5.addNumber( settings, "modify run weight", 0.0, 1.0, 0.01 ).listen()
                .onChange(weight -> setWeight( runAction, weight.doubleValue()));

        folder6.addNumber( settings, "modify time scale", 0.0, 1.5, 0.01 ).onChange(weight -> modifyTimeScale(weight.doubleValue()));

        folder1.open();
        folder2.open();
        folder3.open();
        folder4.open();
        folder5.open();
        folder6.open();

    }

    private void showModel(boolean visibility) {
        model.visible = visibility;
    }


    private void showSkeleton(boolean  visibility) {
        skeleton.visible = visibility;
    }


    private void modifyTimeScale(double speed) {
        mixer.timeScale = speed;
    }


    private void deactivateAllActions() {
        for (AnimationAction action : actions) {
            action.stop();
        }
    }

    private void  activateAllActions() {

        setWeight( idleAction, (double) settings.get("modify idle weight"));
        setWeight( walkAction, (double)  settings.get("modify walk weight"));
        setWeight( runAction, (double) settings.get("modify run weight"));

        for (AnimationAction action : actions) {
            action.play();
        }
    }

    private void pauseContinue() {
        if ( singleStepMode ) {

            singleStepMode = false;
            unPauseAllActions();
        } else {
            if ( idleAction.paused ) {
                unPauseAllActions();
            } else {
                pauseAllActions();
            }
        }
    }

    private void pauseAllActions() {
        for (AnimationAction action : actions) {
            action.paused = true;
        }
    }

    private void unPauseAllActions() {
        for (AnimationAction action : actions) {
            action.paused = false;
        }
    }

    private void toSingleStepMode() {

        unPauseAllActions();

        singleStepMode = true;

        sizeOfNextStep = (double) settings.get("modify step size");

    }

    private void prepareCrossFade(AnimationAction startAction, AnimationAction endAction, double defaultDuration ) {

        // Switch default / custom crossfade duration (according to the user"s choice)

        double duration = setCrossFadeDuration( defaultDuration );

        // Make sure that we don"t go on in singleStepMode, and that all actions are unpaused

        singleStepMode = false;
        unPauseAllActions();

        // If the current action is "idle" (duration 4 sec), execute the crossfade immediately;
        // else wait until the current action has finished its current loop

        if ( startAction == idleAction ) {

            executeCrossFade( startAction, endAction, duration );

        } else {

            synchronizeCrossFade( startAction, endAction, duration );

        }

    }

    private double setCrossFadeDuration(double defaultDuration ) {

        // Switch default crossfade duration <-> custom crossfade duration

        if ( (boolean) settings.get("use default duration")) {

            return defaultDuration;

        } else {
            return (double) settings.get("set custom duration");
        }

    }

    private void synchronizeCrossFade(AnimationAction startAction, AnimationAction endAction, double duration ) {
        EventListener onLoopFinished = new EventListener() {
            @Override
            public void onInvoke(Event event) {
                AnimationAction action = Js.uncheckedCast(Js.asPropertyMap(event));
                if (action == startAction ) {
                    mixer.removeEventListener( "loop", Js.uncheckedCast(this));
                    executeCrossFade( startAction, endAction, duration );
                }
            }
        };
        mixer.addEventListener("loop", onLoopFinished);
    }

    private void executeCrossFade(AnimationAction startAction, AnimationAction endAction, double duration) {

        // Not only the start action, but also the end action must get a weight of 1 before fading
        // (concerning the start action this is already guaranteed in this place)

        setWeight( endAction, 1 );
        endAction.time = 0;

        // Crossfade with warping - you can also try without warping by setting the third parameter to false

        startAction.crossFadeTo( endAction, duration, true );

    }

    // This function is needed, since animationAction.crossFadeTo() disables its start action and sets
    // the start action"s timeScale to ((start animation"s duration) / (end animation"s duration))

    private void setWeight(AnimationAction action, double weight ) {

        action.enabled = true;
        action.setEffectiveTimeScale( 1 );
        action.setEffectiveWeight( weight );

    }

    // Called by the render loop

    private void updateWeightSliders() {
        settings.set("modify idle weight", idleWeight);
        settings.set("modify walk weight", walkWeight);
        settings.set("modify run weight", runWeight);
    }

    // Called by the render loop

    private void updateCrossFadeControls() {

        if ( idleWeight == 1 && walkWeight == 0 && runWeight == 0 ) {

            crossFadeControls.getAt(0).disable();

            crossFadeControls.getAt(1).enable();
            crossFadeControls.getAt(2).disable();
            crossFadeControls.getAt(3).disable();

        }

        if ( idleWeight == 0 && walkWeight == 1 && runWeight == 0 ) {

            crossFadeControls.getAt(0).enable();
            crossFadeControls.getAt(1).disable();
            crossFadeControls.getAt(2).enable();
            crossFadeControls.getAt(3).disable();

        }

        if ( idleWeight == 0 && walkWeight == 0 && runWeight == 1 ) {

            crossFadeControls.getAt(0).disable();
            crossFadeControls.getAt(1).disable();
            crossFadeControls.getAt(2).disable();
            crossFadeControls.getAt(3).enable();

        }

    }

    public HTMLDivElement getElement() {
        return root;
    }

    private void onWindowResize() {
        if(camera != null && renderer != null) {
            camera.aspect = DomGlobal.window.innerWidth / DomGlobal.window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(DomGlobal.window.innerWidth, DomGlobal.window.innerHeight);
        }
    }

    private void animate() {
        DomGlobal.requestAnimationFrame(timestamp -> animate());

        if (run && ready) {

            idleWeight = idleAction.getEffectiveWeight();
            walkWeight = walkAction.getEffectiveWeight();
            runWeight = runAction.getEffectiveWeight();

            // Update the panel values if weights are modified from "outside" (by crossfadings)
            updateWeightSliders();

            // Enable/disable crossfade controls according to current weight values
            updateCrossFadeControls();

            // Get the time elapsed since the last frame, used for mixer update (if not in single step mode)
            double mixerUpdateDelta = clock.getDelta();

            // If in single step mode, make one step and then do nothing (until the user clicks again)
            if ( singleStepMode ) {

                mixerUpdateDelta = sizeOfNextStep;
                sizeOfNextStep = 0;

            }

            // Update the animation mixer, the stats panel, and render this frame


            stats.update();
            mixer.update(mixerUpdateDelta);
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

        panel.hide();
    }

    @PageShown
    private void onShow() {
        HTMLDivElement info = (HTMLDivElement) DomGlobal.document.getElementById("info");

        info.innerHTML = "<a href=\"https://threejs.org\" target=\"_blank\" rel=\"noopener\">three.js</a> - Skeletal Animation Blending\n" +
                "\t\t\t(model from <a href=\"https://www.mixamo.com/\" target=\"_blank\" rel=\"noopener\">mixamo.com</a>)<br/>\n" +
                "\t\t\tNote: crossfades are possible with blend weights being set to (1,0,0), (0,1,0) or (0,0,1)";

        run = true;
        animate();
    }

    @JsFunction
    @FunctionalInterface
    public interface Fn {
        void call();
    }
}
