package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.extras.core.Curve;

@JsType(isNative = true, name = "THREE.LineCurve", namespace = JsPackage.GLOBAL)
public class LineCurve extends Curve {
  public String type;
  public Vector2 v1;
  public Vector2 v2;

  public LineCurve(Vector2 v1, Vector2 v2) {}
}
