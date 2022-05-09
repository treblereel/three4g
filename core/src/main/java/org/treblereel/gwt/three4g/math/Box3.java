package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.Box3", namespace = JsPackage.GLOBAL)
public class Box3 {
  public boolean isBox3;
  public Vector3 max;
  public Vector3 min;

  public Box3() {}

  public Box3(Vector3 min, Vector3 max) {}

  public Box3(Vector3 min) {}

  public native Box3 applyMatrix4(Matrix4 matrix);

  public native Vector3 clampPoint(Vector3 point, Vector3 target);

  @JsMethod(name = "clone")
  public native Box3 clone_();

  public native boolean containsBox(Box3 box);

  public native boolean containsPoint(Vector3 point);

  public native Box3 copy(Box3 box);

  public native double distanceToPoint(Vector3 point);

  @Deprecated
  public native double empty();

  public native boolean equals(Box3 box);

  public native Box3 expandByObject(Object3D object);

  public native Box3 expandByPoint(Vector3 point);

  public native Box3 expandByScalar(double scalar);

  public native Box3 expandByVector(Vector3 vector);

  public native Sphere getBoundingSphere(Sphere target);

  public native Vector3 getCenter(Vector3 target);

  public native Vector3 getParameter(Vector3 point, Vector3 target);

  public native Vector3 getSize(Vector3 target);

  public native Box3 intersect(Box3 box);

  public native boolean intersectsBox(Box3 box);

  public native boolean intersectsPlane(Plane plane);

  public native boolean intersectsSphere(Sphere sphere);

  public native boolean intersectsTriangle(Triangle triangle);

  public native boolean isEmpty();

  @Deprecated
  public native double isIntersectionBox(double b);

  @Deprecated
  public native double isIntersectionSphere(double s);

  public native Box3 makeEmpty();

  public native Box3 set(Vector3 min, Vector3 max);

  public native Box3 setFromArray(Object array);

  public native Box3 setFromBufferAttribute(BufferAttribute bufferAttribute);

  public native Box3 setFromCenterAndSize(Vector3 center, Vector3 size);

  public native Box3 setFromObject(Object3D object);

  public native Box3 setFromPoints(JsArray<Vector3> points);

  @JsOverlay
  public final Box3 setFromPoints(Vector3[] points) {
    return setFromPoints(Js.<JsArray<Vector3>>uncheckedCast(points));
  }

  public native Box3 translate(Vector3 offset);

  public native Box3 union(Box3 box);
}
