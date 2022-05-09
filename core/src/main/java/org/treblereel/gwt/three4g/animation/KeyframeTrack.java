package org.treblereel.gwt.three4g.animation;

import elemental2.core.Float32Array;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.interpolants.CubicInterpolant;
import org.treblereel.gwt.three4g.math.interpolants.DiscreteInterpolant;
import org.treblereel.gwt.three4g.math.interpolants.LinearInterpolant;

@JsType(isNative = true, name = "THREE.KeyframeTrack", namespace = JsPackage.GLOBAL)
public class KeyframeTrack {
  public static native Object toJSON();

  public static native Object toJSON(String key);

  public double DefaultInterpolation;
  public Float32Array TimeBufferType;
  public Float32Array ValueBufferType;
  public String ValueTypeName;
  public String name;
  public Float32Array times;
  public Float32Array values;

  public KeyframeTrack(String name, Object times, Object values, double interpolation) {}

  public KeyframeTrack(String name, Object times, Object values) {}

  public native DiscreteInterpolant InterpolantFactoryMethodDiscrete(double result);

  public native LinearInterpolant InterpolantFactoryMethodLinear(double result);

  public native CubicInterpolant InterpolantFactoryMethodSmooth(double result);

  @JsMethod(name = "clone")
  public native KeyframeTrack clone_();

  public native double getInterpolation();

  public native double getValueSize();

  public native KeyframeTrack optimize();

  public native KeyframeTrack scale(double timeScale);

  public native KeyframeTrack setInterpolation(double interpolation);

  public native KeyframeTrack shift(double timeOffset);

  public native KeyframeTrack trim(double startTime, double endTime);

  public native boolean validate();
}
