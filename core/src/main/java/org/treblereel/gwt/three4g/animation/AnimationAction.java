package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * AnimationActions schedule the performance of the animations which are stored in AnimationClips.
 * <p>
 * Note: Most of AnimationAction's methods can be chained.
 * <p>
 * For an overview of the different elements of the three.js animation system see the "Animation System" article in the
 * "Next Steps" section of the manual.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/12/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class AnimationAction {

    /**
     * If clampWhenFinished is set to true the animation will automatically be paused on its last frame.
     * <p>
     * If clampWhenFinished is set to false, enabled will automatically be switched to false when the last loop of the action has finished, so that this action has no further impact.
     * <p>
     * Default is false.
     * <p>
     * Note: clampWhenFinished has no impact if the action is interrupted (it has only an effect if its last loop has really finished).
     */
    public boolean clampWhenFinished;

    /**
     * Setting enabled to false disables this action, so that it has no impact. Default is true.
     * <p>
     * When the action is re-enabled, the animation continues from its current time (setting enabled to false doesn't reset the action).
     * <p>
     * Note: Setting enabled to true doesn’t automatically restart the animation. Setting enabled to true will only restart the animation immediately if the following condition is fulfilled: paused is false, this action has not been deactivated in the meantime (by executing a stop or reset command), and neither weight nor timeScale is 0.
     */
    public boolean enabled;

    /**
     * The looping mode (can be changed with setLoop). Default is THREE.LoopRepeat (with an infinite number of repetitions)
     * <p>
     * Must be one of these constants:
     * THREE.LoopOnce - playing the clip once,
     * THREE.LoopRepeat - playing the clip with the choosen number of repetitions, each time jumping from the end of the clip directly to its beginning,
     * THREE.LoopPingPong - playing the clip with the choosen number of repetitions, alternately playing forward and backward.
     */
    public int loop;


    /**
     * Setting paused to true pauses the execution of the action by setting the effective time scale to 0. Default is false.
     */
    public boolean paused;

    /**
     * The number of repetitions of the performed AnimationClip over the course of this action. Can be set via setLoop. Default is Infinity.
     * <p>
     * Setting this number has no effect, if the loop mode is set to THREE.LoopOnce.
     */
    public int repetitions;

    /**
     * The local time of this action (in seconds, starting with 0).
     * <p>
     * The value gets clamped or wrapped to 0...clip.duration (according to the loop state). It can be scaled relativly to
     * the global mixer time by changing timeScale (using setEffectiveTimeScale or setDuration).
     */
    public double time;

    /**
     * Scaling factor for the time. A value of 0 causes the animation to pause. Negative values cause the animation to play backwards. Default is 1.
     * <p>
     * Properties/methods concerning timeScale (respectively time) are: getEffectiveTimeScale, halt, paused, setDuration, setEffectiveTimeScale, stopWarping, syncWith, warp.
     */
    public double timeScale;

    /**
     * The degree of influence of this action (in the interval [0, 1]). Values between 0 (no impact) and 1 (full impact) can be used to blend between several actions. Default is 1.
     * <p>
     * Properties/methods concerning weight are: crossFadeFrom, crossFadeTo, enabled, fadeIn, fadeOut, getEffectiveWeight, setEffectiveWeight, stopFading.
     */
    public float weight;

    /**
     * Enables smooth interpolation without separate clips for start, loop and end. Default is true.
     */
    public boolean zeroSlopeAtEnd;

    /**
     * Enables smooth interpolation without separate clips for start, loop and end. Default is true.
     */
    public boolean zeroSlopeAtStart;

    /**
     * Note: Instead of calling this constructor directly you should instantiate an AnimationAction with AnimationMixer.clipAction
     * since this method provides caching for better performance.
     *
     * @param mixer     - the AnimationMixer that is controlled by this action.
     * @param clip      - the AnimationClip that holds the animation data for this action.
     * @param localRoot - the root object on which this action is performed.
     */
    @JsConstructor
    public AnimationAction(AnimationMixer mixer, AnimationClip clip, Object3D localRoot) {

    }


    /**
     * Causes this action to fade in, fading out another action simultaneously, within the passed time interval. This method can be chained.
     * <p>
     * If warpBoolean is true, additional warping (gradually changes of the time scales) will be applied.
     * <p>
     * Note: Like with fadeIn/fadeOut, the fading starts/ends with a weight of 1.
     *
     * @param fadeOutAction     instance of AnimationAction
     * @param durationInSeconds as double value
     * @param warpBoolean       as boolean value
     * @return instance of AnimationAction
     */
    public native AnimationAction crossFadeFrom(AnimationAction fadeOutAction, double durationInSeconds, boolean warpBoolean);

    /**
     * Causes this action to fade out, fading in another action simultaneously, within the passed time interval. This method can be chained.
     * <p>
     * If warpBoolean is true, additional warping (gradually changes of the time scales) will be applied.
     * <p>
     * Note: Like with fadeIn/fadeOut, the fading starts/ends with a weight of 1.
     *
     * @param fadeInAction      instance of AnimationAction
     * @param durationInSeconds as double value
     * @param warpBoolean       as boolean value
     * @return instance of AnimationAction
     */
    public native AnimationAction crossFadeTo(AnimationAction fadeInAction, double durationInSeconds, boolean warpBoolean);

    /**
     * Increases the weight of this action gradually from 0 to 1, within the passed time interval. This method can be chained.
     *
     * @param durationInSeconds as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction fadeIn(double durationInSeconds);

    /**
     * Decreases the weight of this action gradually from 1 to 0, within the passed time interval. This method can be chained.
     *
     * @param durationInSeconds as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction fadeOut(double durationInSeconds);

    /**
     * Returns the effective time scale (considering the current states of warping and paused).
     *
     * @return effective time scale
     */
    public native double getEffectiveTimeScale();

    /**
     * Returns the effective weight (considering the current states of fading and enabled).
     *
     * @return effective weight
     */
    public native double getEffectiveWeight();

    /**
     * Returns the clip which holds the animation data for this action.
     *
     * @return instance of AnimationClip
     */
    public native AnimationClip getClip();

    /**
     * Returns the mixer which is responsible for playing this action.
     *
     * @return instance of AnimationMixer
     */
    public native AnimationMixer getMixer();

    /**
     * Returns the root object on which this action is performed.
     *
     * @return instance of Object3D
     */
    public native Object3D getRoot();

    /**
     * Decelerates this animation's speed to 0 by decreasing timeScale gradually (starting from its current value), within the passed time interval. This method can be chained.
     *
     * @param durationInSeconds as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction halt(double durationInSeconds);

    /**
     * Returns true if the action’s time is currently running.
     * <p>
     * In addition to being activated in the mixer (see isScheduled) the following conditions must be fulfilled: paused is equal to false, enabled is equal to true, timeScale is different from 0, and there is no scheduling for a delayed start (startAt).
     * <p>
     * Note: isRunning being true doesn’t necessarily mean that the animation can actually be seen. This is only the case, if weight is additionally set to a non-zero value.
     *
     * @return true if running
     */
    public native boolean isRunning();

    /**
     * Returns true, if this action is activated in the mixer.
     * <p>
     * Note: This doesn’t necessarily mean that the animation is actually running (compare the additional conditions for isRunning).
     *
     * @return true if scheduled
     */
    public native boolean isScheduled();

    /**
     * Tells the mixer to activate the action. This method can be chained.
     * <p>
     * Note: Activating this action doesn’t necessarily mean that the animation starts immediately: If the action had
     * already finished before (by reaching the end of its last loop), or if a time for a delayed start has been set
     * (via startAt), a reset must be executed first. Some other settings (paused=true, enabled=false, weight=0, timeScale=0)
     * can prevent the animation from playing, too.
     *
     * @return instance of AnimationAction
     */
    public native AnimationAction play();


    /**
     * Resets the action. This method can be chained.
     * <p>
     * This method sets paused to false, enabled to true, time to 0, interrupts any scheduled fading and warping, and removes the internal loop count and scheduling for delayed starting.
     * <p>
     * Note: .reset is always called by stop, but .reset doesn’t call .stop itself. This means: If you want both, resetting and stopping, don’t call .reset; call .stop instead.
     *
     * @return instance of AnimationAction
     */
    public native AnimationAction reset();

    /**
     * Sets the duration for a single loop of this action (by adjusting timeScale and stopping any scheduled warping). This method can be chained.
     *
     * @param durationInSeconds as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction setDuration(double durationInSeconds);

    /**
     * Sets the timeScale and stops any scheduled warping. This method can be chained.
     * <p>
     * If paused is false, the effective time scale (an internal property) will also be set to this value; otherwise the effective time scale (directly affecting the animation at this moment) will be set to 0.
     * <p>
     * Note: .paused will not be switched to true automatically, if .timeScale is set to 0 by this method.
     *
     * @param timeScale as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction setEffectiveTimeScale(double timeScale);

    /**
     * Sets the weight and stops any scheduled fading. This method can be chained.
     * <p>
     * If enabled is true, the effective weight (an internal property) will also be set to this value; otherwise the effective weight (directly affecting the animation at this moment) will be set to 0.
     * <p>
     * Note: .enabled will not be switched to false automatically, if .weight is set to 0 by this method.
     *
     * @param weight as float value
     * @return instance of AnimationAction
     */
    public native AnimationAction setEffectiveWeight(float weight);

    /**
     * Sets the loop mode and the number of repetitions. This method can be chained.
     *
     * @param loopMode    as int value
     * @param repetitions as int value
     * @return instance of AnimationAction
     */
    public native AnimationAction setLoop(int loopMode, int repetitions);

    /**
     * Defines the time for a delayed start (usually passed as AnimationMixer.time + deltaTimeInSeconds). This method can be chained.
     * <p>
     * Note: The animation will only start at the given time, if .startAt is chained with play, or if the action has already been activated in the mixer (by a previous call of .play, without stopping or resetting it in the meantime).
     *
     * @param startTimeInSeconds as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction startAt(double startTimeInSeconds);

    /**
     * Tells the mixer to deactivate this action. This method can be chained.
     * <p>
     * The action will be immediately stopped and completely reset.
     * <p>
     * Note: You can stop all active actions on the same mixer in one go via mixer.stopAllAction.
     *
     * @return instance of AnimationAction
     */
    public native AnimationAction stop();

    /**
     * Stops any scheduled fading which is applied to this action. This method can be chained.
     *
     * @return instance of AnimationAction
     */
    public native AnimationAction stopFading();

    /**
     * Stops any scheduled warping which is applied to this action. This method can be chained.
     *
     * @return instance of AnimationAction
     */
    public native AnimationAction stopWarping();

    /**
     * Synchronizes this action with the passed other action. This method can be chained.
     * <p>
     * Synchronizing is done by setting this action’s time and timeScale values to the corresponding values of the other action (stopping any scheduled warping).
     * <p>
     * Note: Future changes of the other action's time and timeScale will not be detected.
     *
     * @param otherAction instance of AnimationAction
     * @return instance of AnimationAction
     */
    public native AnimationAction syncWith(AnimationAction otherAction);

    /**
     * Changes the playback speed, within the passed time interval, by modifying timeScale gradually from startTimeScale to endTimeScale. This method can be chained.
     *
     * @param startTimeScale    as double value
     * @param endTimeScale      as double value
     * @param durationInSeconds as double value
     * @return instance of AnimationAction
     */
    public native AnimationAction warp(double startTimeScale, double endTimeScale, double durationInSeconds);

}
