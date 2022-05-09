package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Box2", namespace = JsPackage.GLOBAL)
public class Box2 {
  public Vector2 max;
  public Vector2 min;

  public Box2() {}

  public Box2(Vector2 min, Vector2 max) {}

  public Box2(Vector2 min) {}

  public native Vector2 clampPoint(Vector2 point, Vector2 target);

  @JsMethod(name = "clone")
  public native Box2 clone_();

  public native boolean containsBox(Box2 box);

  public native boolean containsPoint(Vector2 point);

  public native Box2 copy(Box2 box);

  public native double distanceToPoint(Vector2 point);

  @Deprecated
  public native double empty();

  public native boolean equals(Box2 box);

  public native Box2 expandByPoint(Vector2 point);

  public native Box2 expandByScalar(double scalar);

  public native Box2 expandByVector(Vector2 vector);

  public native Vector2 getCenter(Vector2 target);

  public native Vector2 getParameter(Vector2 point, Vector2 target);

  public native Vector2 getSize(Vector2 target);

  public native Box2 intersect(Box2 box);

  public native boolean intersectsBox(Box2 box);

  public native boolean isEmpty();

  @Deprecated
  public native double isIntersectionBox(double b);

  public native Box2 makeEmpty();

  public native Box2 set(Vector2 min, Vector2 max);

  public native Box2 setFromCenterAndSize(Vector2 center, Vector2 size);

  public native Box2 setFromPoints(JsArray<Vector2> points);

  @JsOverlay
  public final Box2 setFromPoints(Vector2[] points) {
    return setFromPoints(Js.<JsArray<Vector2>>uncheckedCast(points));
  }

  public native Box2 translate(Vector2 offset);

  public native Box2 union(Box2 box);
}
