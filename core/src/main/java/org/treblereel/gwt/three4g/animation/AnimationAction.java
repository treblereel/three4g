package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.AnimationAction", namespace = JsPackage.GLOBAL)
public class AnimationAction {
  public double blendMode;
  public boolean clampWhenFinished;
  public boolean enabled;
  public double loop;
  public boolean paused;
  public double repetitions;
  public double time;
  public double timeScale;
  public double weight;
  public boolean zeroSlopeAtEnd;
  public boolean zeroSlopeAtStart;

  public AnimationAction(
          AnimationMixer mixer, AnimationClip clip, Object3D localRoot, double blendMode) {}

  public AnimationAction(AnimationMixer mixer, AnimationClip clip, Object3D localRoot) {}

  public AnimationAction(AnimationMixer mixer, AnimationClip clip) {}

  public native AnimationAction crossFadeFrom(
      AnimationAction fadeOutAction, double duration, boolean warp);

  public native AnimationAction crossFadeTo(
      AnimationAction fadeInAction, double duration, boolean warp);

  public native AnimationAction fadeIn(double duration);

  public native AnimationAction fadeOut(double duration);

  public native AnimationClip getClip();

  public native double getEffectiveTimeScale();

  public native double getEffectiveWeight();

  public native AnimationMixer getMixer();

  public native Object3D getRoot();

  public native AnimationAction halt(double duration);

  public native boolean isRunning();

  public native boolean isScheduled();

  public native AnimationAction play();

  public native AnimationAction reset();

  public native AnimationAction setDuration(double duration);

  public native AnimationAction setEffectiveTimeScale(double timeScale);

  public native AnimationAction setEffectiveWeight(double weight);

  public native AnimationAction setLoop(double mode, double repetitions);

  public native AnimationAction startAt(double time);

  public native AnimationAction stop();

  public native AnimationAction stopFading();

  public native AnimationAction stopWarping();

  public native AnimationAction syncWith(AnimationAction action);

  public native AnimationAction warp(double statTimeScale, double endTimeScale, double duration);
}
