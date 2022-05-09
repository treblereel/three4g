package org.treblereel.gwt.three4g.math.interpolants;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.DiscreteInterpolant", namespace = JsPackage.GLOBAL)
public class DiscreteInterpolant {
  public DiscreteInterpolant(
      double parameterPositions, double samplesValues, double sampleSize, JsObject resultBuffer) {}

  public DiscreteInterpolant(
      double parameterPositions, double samplesValues, double sampleSize, Object resultBuffer) {}

  public DiscreteInterpolant(double parameterPositions, double samplesValues, double sampleSize) {}

  public native double interpolate_(double i1, double t0, double t, double t1);
}
