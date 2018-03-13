package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.EventDispatcher;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * The AnimationMixer is a player for animations on a particular object in the scene. When multiple objects in the scene
 * are animated independently, one AnimationMixer may be used for each object.
 * <p>
 * For an overview of the different elements of the three.js animation system see the "Animation System" article in the
 * "Next Steps" section of the manual.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationMixer extends EventDispatcher {

    /**
     * The global mixer time (in seconds; starting with 0 on the mixer's creation).
     */
    public int time;

    /**
     * A scaling factor for the global mixer time.
     * <p>
     * Note: Setting the mixer's timeScale to 0 and later back to 1 is a possibility to pause/unpause all actions that are controlled by this mixer.
     */
    public int timeScale; //TODO


    /**
     * @param rootObject - the object whose animations shall be played by this mixer.
     */
    @JsConstructor
    public AnimationMixer(Object3D rootObject) {

    }

    /**
     * Returns an AnimationAction for the passed clip, optionally using a root object different from the mixer's default root. The first parameter can be either an AnimationClip object or the name of an AnimationClip.
     * <p>
     * If an action fitting these parameters doesn't yet exist, it will be created by this method.
     * <p>
     * Note: Calling this method several times with the same parameters returns always the same clip instance.
     *
     * @param clip
     * @return
     */
    public native AnimationAction clipAction(AnimationClip clip);

    /**
     * Returns an AnimationAction for the passed clip, optionally using a root object different from the mixer's default root. The first parameter can be either an AnimationClip object or the name of an AnimationClip.
     * <p>
     * If an action fitting these parameters doesn't yet exist, it will be created by this method.
     * <p>
     * Note: Calling this method several times with the same parameters returns always the same clip instance.
     *
     * @param clip
     * @param optionalRoot
     * @return
     */
    public native AnimationAction clipAction(AnimationClip clip, Object3D optionalRoot);

    /**
     * Returns an existing AnimationAction for the passed clip, optionally using a root object different from the mixer's default root.
     * <p>
     * The first parameter can be either an AnimationClip object or the name of an AnimationClip.
     *
     * @param clip
     * @return
     */
    public native AnimationAction existingAction(AnimationClip clip);

    /**
     * Returns an existing AnimationAction for the passed clip, optionally using a root object different from the mixer's default root.
     * <p>
     * The first parameter can be either an AnimationClip object or the name of an AnimationClip.
     *
     * @param clip
     * @param optionalRoot
     * @return
     */
    public native AnimationAction existingAction(AnimationClip clip, Object3D optionalRoot);

    /**
     * Returns this mixer's root object.
     *
     * @return
     */
    public native Object3D getRoot();

    /**
     * Deactivates all previously scheduled actions on this mixer.
     *
     * @return
     */
    public native AnimationMixer stopAllAction();

    /**
     * Advances the global mixer time and updates the animation.
     * <p>
     * This is usually done in the render loop, passing clock.getDelta scaled by the mixer's timeScale).
     *
     * @param deltaTimeInSeconds
     * @return
     */
    public native AnimationMixer update(Number deltaTimeInSeconds);

    /**
     * Deallocates all memory resources for a clip.
     *
     * @param clip
     */
    public native void update(AnimationClip clip);

    /**
     * Deallocates all memory resources for a root object.
     *
     * @param root
     */
    public native void uncacheRoot(Object3D root);

    /**
     * Deallocates all memory resources for an action.
     *
     * @param clip
     */
    public native void uncacheAction(AnimationClip clip);

    /**
     * Deallocates all memory resources for an action.
     *
     * @param clip
     * @param root
     */
    public native void uncacheAction(AnimationClip clip, Object3D root);

}
