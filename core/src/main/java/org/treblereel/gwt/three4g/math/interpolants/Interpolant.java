package org.treblereel.gwt.three4g.math.interpolants;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Interpolant", namespace = JsPackage.GLOBAL)
public class Interpolant {
  public double parameterPositions;
  public double resultBuffer;
  public double sampleValues;
  public double valueSize;

  public Interpolant(
      double parameterPositions, double sampleValues, double sampleSize, JsObject resultBuffer) {}

  public Interpolant(
      double parameterPositions, double sampleValues, double sampleSize, Object resultBuffer) {}

  public Interpolant(double parameterPositions, double sampleValues, double sampleSize) {}

  public native double evaluate(double time);
}
