package org.treblereel.gwt.three4g.demo.client.local.examples.misc;

import com.google.gwt.animation.client.AnimationScheduler;
import org.treblereel.gwt.three4g.THREE;
import org.treblereel.gwt.three4g.animation.AnimationAction;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.animation.AnimationMixer;
import org.treblereel.gwt.three4g.animation.AnimationObjectGroup;
import org.treblereel.gwt.three4g.animation.KeyframeTrack;
import org.treblereel.gwt.three4g.animation.tracks.ColorKeyframeTrack;
import org.treblereel.gwt.three4g.animation.tracks.NumberKeyframeTrack;
import org.treblereel.gwt.three4g.animation.tracks.QuaternionKeyframeTrack;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.core.Clock;
import org.treblereel.gwt.three4g.demo.client.local.AppSetup;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.utils.StatsProducer;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/11/18.
 */
public class MiscAnimationGroups extends Attachable {

    public static final String name = "animation / groups";

    private AnimationMixer mixer;
    private Clock clock = new Clock();

    public MiscAnimationGroups() {

        scene = new Scene();
        //
        camera = new PerspectiveCamera(40, aspect, 1, 1000);
        camera.position.set(50, 50, 100);
        camera.lookAt(scene.position);
        // all objects of this animation group share a common animation state
        AnimationObjectGroup animationGroup = new AnimationObjectGroup();
        //
        BoxBufferGeometry geometry = new BoxBufferGeometry(5, 5, 5);
        MeshBasicMaterial material = new MeshBasicMaterial();
        material.transparent = true;
        //
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Mesh mesh = new Mesh(geometry, material);
                mesh.position.x = 32 - (16 * i);
                mesh.position.y = 0;
                mesh.position.z = 32 - (16 * j);
                scene.add(mesh);
                animationGroup.add(mesh);
            }
        }
        // create some keyframe tracks
        Vector3 xAxis = new Vector3(1, 0, 0);
        Quaternion qInitial = new Quaternion().setFromAxisAngle(xAxis, 0);
        Quaternion qFinal = new Quaternion().setFromAxisAngle(xAxis, (float) Math.PI);

        QuaternionKeyframeTrack quaternionKF = new QuaternionKeyframeTrack(".quaternion", new float[]{0, 1, 2}, new float[]{qInitial.x, qInitial.y, qInitial.z, qInitial.w, qFinal.x, qFinal.y, qFinal.z, qFinal.w, qInitial.x, qInitial.y, qInitial.z, qInitial.w});
        ColorKeyframeTrack colorKF = new ColorKeyframeTrack(".material.color", new float[]{0, 1, 2 }, new float[]{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, THREE.InterpolateDiscrete);
        NumberKeyframeTrack opacityKF = new NumberKeyframeTrack(".material.opacity", new float[]{ 0, 1, 2 }, new float[]{ 1, 0, 1 });
        // create clip
        KeyframeTrack[] keyframeTrack = new KeyframeTrack[3];
        keyframeTrack[0] = quaternionKF;
        keyframeTrack[1] = colorKF;
        keyframeTrack[2] = opacityKF;

        AnimationClip clip = new AnimationClip("default", 3, keyframeTrack);
        // apply the animation group to the mixer as the root object
        mixer = new AnimationMixer(animationGroup);
        AnimationAction clipAction = mixer.clipAction(clip);
        clipAction.play();
        //
        WebGLRendererParameters parameters = new WebGLRendererParameters();
        parameters.antialias = true;
        renderer = new WebGLRenderer(parameters);
        renderer.setPixelRatio(devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);
    }

    public void doAttachScene() {
        root.appendChild(renderer.domElement);
        onWindowResize();
        animate();
    }

    @Override
    protected void doAttachInfo() {
        AppSetup.infoDiv.show().setHrefToInfo("http://threejs.org").setTextContentToInfo("three.js").setInnetHtml(" - webgl - animation - groups");
    }

    private void animate() {
        StatsProducer.getStats().update();
        AnimationScheduler.get().requestAnimationFrame(timestamp -> {
            if (root.parentNode != null) {
                render();
                animate();
            }
        });
    }

    private void render() {

        float delta = clock.getDelta();
        mixer.update(delta);
        renderer.render(scene, camera);
    }
}

