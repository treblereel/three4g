package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.objects.Bone;

@JsType(isNative = true, name = "THREE.AnimationClip", namespace = JsPackage.GLOBAL)
public class AnimationClip {
  public static native JsArray<AnimationClip> CreateClipsFromMorphTargetSequences(
      JsArray<Object> morphTargets, double fps, boolean noLoop);

  @JsOverlay
  public static final JsArray<AnimationClip> CreateClipsFromMorphTargetSequences(
      Object[] morphTargets, double fps, boolean noLoop) {
    return CreateClipsFromMorphTargetSequences(
        Js.<JsArray<Object>>uncheckedCast(morphTargets), fps, noLoop);
  }

  public static native AnimationClip CreateFromMorphTargetSequence(
      String name, JsArray<Object> morphTargetSequence, double fps, boolean noLoop);

  @JsOverlay
  public static final AnimationClip CreateFromMorphTargetSequence(
      String name, Object[] morphTargetSequence, double fps, boolean noLoop) {
    return CreateFromMorphTargetSequence(
        name, Js.<JsArray<Object>>uncheckedCast(morphTargetSequence), fps, noLoop);
  }

  @JsOverlay
  public static final AnimationClip findByName(AnimationClip[] clipArray, String name) {
    return findByName(Js.<JsArray<AnimationClip>>uncheckedCast(clipArray), name);
  }

  public static native AnimationClip findByName(JsArray<AnimationClip> clipArray, String name);

  public static native AnimationClip parse(double json);

  @JsOverlay
  public static final AnimationClip parseAnimation(double animation, Bone[] bones) {
    return parseAnimation(animation, Js.<JsArray<Bone>>uncheckedCast(bones));
  }

  public static native AnimationClip parseAnimation(double animation, JsArray<Bone> bones);

  @JsMethod(name = "toJSON")
  public static native Object toJSON_STATIC();

  @JsMethod(name = "toJSON")
  public static native Object toJSON_STATIC(String key);

  public double blendMode;
  public double duration;
  public String name;
  public JsArray<JsObject> results;
  public JsArray<KeyframeTrack> tracks;
  public String uuid;

  @JsMethod(name = "clone")
  public native AnimationClip clone_();

  public native AnimationClip optimize();

  public native AnimationClip resetDuration();

  public native Object toJSON();

  public native Object toJSON(String key);

  public native AnimationClip trim();

  public native boolean validate();
}
