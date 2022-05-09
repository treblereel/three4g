package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.AnimationUtils", namespace = JsPackage.GLOBAL)
public class AnimationUtils {
  public static native double arraySlice(double array, double from, double to);

  public static native double convertArray(double array, double type, boolean forceClone);

  public static native void flattenJSON(
      JsArray<String> jsonKeys,
      JsArray<JsObject> times,
      JsArray<JsObject> values,
      String valuePropertyName);

  @JsOverlay
  public static final void flattenJSON(
      String[] jsonKeys, JsObject[] times, JsObject[] values, String valuePropertyName) {
    flattenJSON(
        Js.<JsArray<String>>uncheckedCast(jsonKeys),
        Js.<JsArray<JsObject>>uncheckedCast(times),
        Js.<JsArray<JsObject>>uncheckedCast(values),
        valuePropertyName);
  }

  public static native JsArray<Double> getKeyFrameOrder(JsArray<Double> times);

  @JsOverlay
  public static final JsArray<Double> getKeyFrameOrder(double[] times) {
    return getKeyFrameOrder(Js.<JsArray<Double>>uncheckedCast(times));
  }

  public static native boolean isTypedArray(double object);

  public static native AnimationClip makeClipAdditive(
      AnimationClip targetClip, double referenceFrame, AnimationClip referenceClip, double fps);

  public static native AnimationClip makeClipAdditive(
      AnimationClip targetClip, double referenceFrame, AnimationClip referenceClip);

  public static native AnimationClip makeClipAdditive(
      AnimationClip targetClip, double referenceFrame);

  public static native AnimationClip makeClipAdditive(AnimationClip targetClip);

  public static native JsArray<JsObject> sortedArray(
      JsArray<JsObject> values, double stride, JsArray<Double> order);

  @JsOverlay
  public static final JsArray<JsObject> sortedArray(
      JsObject[] values, double stride, double[] order) {
    return sortedArray(
        Js.<JsArray<JsObject>>uncheckedCast(values),
        stride,
        Js.<JsArray<Double>>uncheckedCast(order));
  }

  public static native AnimationClip subclip(
      AnimationClip sourceClip, String name, double startFrame, double endFrame, double fps);

  public static native AnimationClip subclip(
      AnimationClip sourceClip, String name, double startFrame, double endFrame);
}
