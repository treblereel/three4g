package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Sphere", namespace = JsPackage.GLOBAL)
public class Sphere {
  public Vector3 center;
  public double radius;

  public Sphere() {}

  public Sphere(Vector3 center, double radius) {}

  public Sphere(Vector3 center) {}

  public native Sphere applyMatrix4(Matrix4 matrix);

  public native Vector3 clampPoint(Vector3 point, Vector3 target);

  @JsMethod(name = "clone")
  public native Sphere clone_();

  public native boolean containsPoint(Vector3 point);

  public native Sphere copy(Sphere sphere);

  public native double distanceToPoint(Vector3 point);

  @Deprecated
  public native double empty();

  public native boolean equals(Sphere sphere);

  public native Sphere expandByPoint(Vector3 point);

  public native Box3 getBoundingBox(Box3 target);

  public native boolean intersectsBox(Box3 box);

  public native boolean intersectsPlane(Plane plane);

  public native boolean intersectsSphere(Sphere sphere);

  public native boolean isEmpty();

  public native Sphere makeEmpty();

  public native Sphere set(Vector3 center, double radius);

  public native Sphere setFromPoints(JsArray<Vector3> points, Vector3 optionalCenter);

  public native Sphere setFromPoints(JsArray<Vector3> points);

  @JsOverlay
  public final Sphere setFromPoints(Vector3[] points, Vector3 optionalCenter) {
    return setFromPoints(Js.<JsArray<Vector3>>uncheckedCast(points), optionalCenter);
  }

  @JsOverlay
  public final Sphere setFromPoints(Vector3[] points) {
    return setFromPoints(Js.<JsArray<Vector3>>uncheckedCast(points));
  }

  public native Sphere translate(Vector3 offset);

  public native Sphere union(Sphere sphere);
}
