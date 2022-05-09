package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.Line3", namespace = JsPackage.GLOBAL)
public class Line3 {
  public Vector3 end;
  public Vector3 start;

  public Line3() {}

  public Line3(Vector3 start, Vector3 end) {}

  public Line3(Vector3 start) {}

  public native Line3 applyMatrix4(Matrix4 matrix);

  public native Vector3 at(double t, Vector3 target);

  @JsMethod(name = "clone")
  public native Line3 clone_();

  public native Vector3 closestPointToPoint(Vector3 point, boolean clampToLine, Vector3 target);

  public native double closestPointToPointParameter(Vector3 point, boolean clampToLine);

  public native double closestPointToPointParameter(Vector3 point);

  public native Line3 copy(Line3 line);

  public native Vector3 delta(Vector3 target);

  public native double distance();

  public native double distanceSq();

  public native boolean equals(Line3 line);

  public native Vector3 getCenter(Vector3 target);

  public native Line3 set();

  public native Line3 set(Vector3 start, Vector3 end);

  public native Line3 set(Vector3 start);
}
