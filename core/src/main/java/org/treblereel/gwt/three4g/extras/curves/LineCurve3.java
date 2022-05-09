package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.extras.core.Curve;

@JsType(isNative = true, name = "THREE.LineCurve3", namespace = JsPackage.GLOBAL)
public class LineCurve3 extends Curve {
  public String type;
  public Vector3 v1;
  public Vector3 v2;

  public LineCurve3(Vector3 v1, Vector3 v2) {}
}
