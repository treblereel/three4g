package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.InterleavedBufferAttribute;

@JsType(isNative = true, name = "THREE.Triangle", namespace = JsPackage.GLOBAL)
public class Triangle implements Vector {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetFromAttributeAndIndicesAttributeUnionType {
    @JsOverlay
    static Triangle.SetFromAttributeAndIndicesAttributeUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default BufferAttribute asBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default InterleavedBufferAttribute asInterleavedBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isBufferAttribute() {
      return (Object) this instanceof BufferAttribute;
    }

    @JsOverlay
    default boolean isInterleavedBufferAttribute() {
      return (Object) this instanceof InterleavedBufferAttribute;
    }
  }

  public static native boolean containsPoint(Vector3 point, Vector3 a, Vector3 b, Vector3 c);

  public static native Vector3 getBarycoord(
      Vector3 point, Vector3 a, Vector3 b, Vector3 c, Vector3 target);

  public static native Vector3 getNormal(Vector3 a, Vector3 b, Vector3 c, Vector3 target);

  public static native Vector2 getUV(
      Vector3 point,
      Vector3 p1,
      Vector3 p2,
      Vector3 p3,
      Vector2 uv1,
      Vector2 uv2,
      Vector2 uv3,
      Vector2 target);

  public static native boolean isFrontFacing(Vector3 a, Vector3 b, Vector3 c, Vector3 direction);

  public Vector3 a;
  public Vector3 b;
  public Vector3 c;

  public Triangle() {}

  public Triangle(Vector3 a, Vector3 b, Vector3 c) {}

  public Triangle(Vector3 a, Vector3 b) {}

  public Triangle(Vector3 a) {}

  @JsMethod(name = "clone")
  public native Triangle clone_();

  public native Vector3 closestPointToPoint(Vector3 point, Vector3 target);

  public native boolean containsPoint(Vector3 point);

  public native Triangle copy(Triangle triangle);

  public native boolean equals(Triangle triangle);

  public native double getArea();

  public native Vector3 getBarycoord(Vector3 point, Vector3 target);

  public native Vector3 getMidpoint(Vector3 target);

  public native Vector3 getNormal(Vector3 target);

  public native Plane getPlane(Plane target);

  public native Vector2 getUV(Vector3 point, Vector2 uv1, Vector2 uv2, Vector2 uv3, Vector2 target);

  public native boolean intersectsBox(Box3 box);

  public native boolean isFrontFacing(Vector3 direction);

  public native Triangle set(Vector3 a, Vector3 b, Vector3 c);

  @JsOverlay
  public final Triangle setFromAttributeAndIndices(
      BufferAttribute attribute, double i0, double i1, double i2) {
    return setFromAttributeAndIndices(
        Js.<Triangle.SetFromAttributeAndIndicesAttributeUnionType>uncheckedCast(attribute),
        i0,
        i1,
        i2);
  }

  @JsOverlay
  public final Triangle setFromAttributeAndIndices(
      InterleavedBufferAttribute attribute, double i0, double i1, double i2) {
    return setFromAttributeAndIndices(
        Js.<Triangle.SetFromAttributeAndIndicesAttributeUnionType>uncheckedCast(attribute),
        i0,
        i1,
        i2);
  }

  public native Triangle setFromAttributeAndIndices(
      Triangle.SetFromAttributeAndIndicesAttributeUnionType attribute,
      double i0,
      double i1,
      double i2);

  public native Triangle setFromPointsAndIndices(
      JsArray<Vector3> points, double i0, double i1, double i2);

  @JsOverlay
  public final Triangle setFromPointsAndIndices(Vector3[] points, double i0, double i1, double i2) {
    return setFromPointsAndIndices(Js.<JsArray<Vector3>>uncheckedCast(points), i0, i1, i2);
  }
}
