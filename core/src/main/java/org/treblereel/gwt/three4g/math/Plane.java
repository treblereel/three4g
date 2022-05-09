package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.objects.Line3;

@JsType(isNative = true, name = "THREE.Plane", namespace = JsPackage.GLOBAL)
public class Plane {
  public double constant;
  public boolean isPlane;
  public Vector3 normal;

  public Plane() {}

  public Plane(Vector3 normal, double constant) {}

  public Plane(Vector3 normal) {}

  public native Plane applyMatrix4(Matrix4 matrix, Matrix3 optionalNormalMatrix);

  public native Plane applyMatrix4(Matrix4 matrix);

  @JsMethod(name = "clone")
  public native Plane clone_();

  public native Vector3 coplanarPoint(Vector3 target);

  public native Plane copy(Plane plane);

  public native double distanceToPoint(Vector3 point);

  public native double distanceToSphere(Sphere sphere);

  public native boolean equals(Plane plane);

  public native Vector3 intersectLine(Line3 line, Vector3 target);

  public native boolean intersectsBox(Box3 box);

  public native boolean intersectsLine(Line3 line);

  public native boolean intersectsSphere(Sphere sphere);

  @Deprecated
  public native double isIntersectionLine(double l);

  public native Plane negate();

  public native Plane normalize();

  public native Vector3 orthoPoint(Vector3 point, Vector3 target);

  public native Vector3 projectPoint(Vector3 point, Vector3 target);

  public native Plane set(Vector3 normal, double constant);

  public native Plane setComponents(double x, double y, double z, double w);

  public native Plane setFromCoplanarPoints(Vector3 a, Vector3 b, Vector3 c);

  public native Plane setFromNormalAndCoplanarPoint(Vector3 normal, Vector3 point);

  public native Plane translate(Vector3 offset);
}
