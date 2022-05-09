package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.ArcCurve", namespace = JsPackage.GLOBAL)
public class ArcCurve extends EllipseCurve {
  public String type;

  public ArcCurve(
      double aX,
      double aY,
      double aRadius,
      double aStartAngle,
      double aEndAngle,
      boolean aClockwise) {
    // This super call is here only for the code to compile; it is never executed.
    super(0, 0, 0, 0, 0, 0, false, 0);
  }
}
