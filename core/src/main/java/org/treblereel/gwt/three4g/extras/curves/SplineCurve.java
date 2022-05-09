package org.treblereel.gwt.three4g.extras.curves;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector2;

@JsType(isNative = true, name = "THREE.SplineCurve", namespace = JsPackage.GLOBAL)
public class SplineCurve extends Curve {
  public JsArray<Vector2> points;
  public String type;

  public SplineCurve() {}

  public SplineCurve(JsArray<Vector2> points) {}

  public SplineCurve(Vector2[] points) {}
}
