package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Ray", namespace = JsPackage.GLOBAL)
public class Ray {
  public Vector3 direction;
  public Vector3 origin;

  public Ray() {}

  public Ray(Vector3 origin, Vector3 direction) {}

  public Ray(Vector3 origin) {}

  public native Ray applyMatrix4(Matrix4 matrix4);

  public native Vector3 at(double t, Vector3 target);

  @JsMethod(name = "clone")
  public native Ray clone_();

  public native Vector3 closestPointToPoint(Vector3 point, Vector3 target);

  public native Ray copy(Ray ray);

  public native double distanceSqToPoint(Vector3 point);

  public native double distanceSqToSegment(
      Vector3 v0, Vector3 v1, Vector3 optionalPointOnRay, Vector3 optionalPointOnSegment);

  public native double distanceSqToSegment(Vector3 v0, Vector3 v1, Vector3 optionalPointOnRay);

  public native double distanceSqToSegment(Vector3 v0, Vector3 v1);

  public native double distanceToPlane(Plane plane);

  public native double distanceToPoint(Vector3 point);

  public native boolean equals(Ray ray);

  public native Vector3 intersectBox(Box3 box, Vector3 target);

  public native Vector3 intersectPlane(Plane plane, Vector3 target);

  public native Vector3 intersectSphere(Sphere sphere, Vector3 target);

  public native Vector3 intersectTriangle(
      Vector3 a, Vector3 b, Vector3 c, boolean backfaceCulling, Vector3 target);

  public native boolean intersectsBox(Box3 box);

  public native boolean intersectsPlane(Plane plane);

  public native boolean intersectsSphere(Sphere sphere);

  @Deprecated
  public native double isIntersectionBox(double b);

  @Deprecated
  public native double isIntersectionPlane(double p);

  @Deprecated
  public native double isIntersectionSphere(double s);

  public native Ray lookAt(Vector3 v);

  public native Ray recast(double t);

  public native Ray set(Vector3 origin, Vector3 direction);
}
