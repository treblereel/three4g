package org.treblereel.gwt.three4g.math.interpolants;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.CubicInterpolant", namespace = JsPackage.GLOBAL)
public class CubicInterpolant {
  public CubicInterpolant(
      double parameterPositions, double samplesValues, double sampleSize, JsObject resultBuffer) {}

  public CubicInterpolant(
      double parameterPositions, double samplesValues, double sampleSize, Object resultBuffer) {}

  public CubicInterpolant(double parameterPositions, double samplesValues, double sampleSize) {}

  public native double interpolate_(double i1, double t0, double t, double t1);
}
