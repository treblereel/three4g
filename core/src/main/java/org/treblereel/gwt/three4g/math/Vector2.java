package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;

@JsType(isNative = true, name = "THREE.Vector2", namespace = JsPackage.GLOBAL)
public class Vector2 implements Vector {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Vector2.FromArrayArrayUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsArray<Double> asJsArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isJsArray() {
      return (Object) this instanceof JsArray;
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ToArrayArrayUnionType {
    @JsOverlay
    static Vector2.ToArrayArrayUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsArray<Object> asJsArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isJsArray() {
      return (Object) this instanceof JsArray;
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ToArrayUnionType {
    @JsOverlay
    static Vector2.ToArrayUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsArray<Object> asJsArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isJsArray() {
      return (Object) this instanceof JsArray;
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }
  }

  public double height;
  public boolean isVector2;
  public double width;
  public double x;
  public double y;

  public Vector2() {}

  public Vector2(double x, double y) {}

  public Vector2(double x) {}

  public native Vector2 add(Vector2 v, Vector2 w);

  public native Vector2 add(Vector2 v);

  public native Vector2 addScalar(double s);

  public native Vector2 addScaledVector(Vector2 v, double s);

  public native Vector2 addVectors(Vector2 a, Vector2 b);

  public native double angle();

  public native Vector2 applyMatrix3(Matrix3 m);

  public native Vector2 ceil();

  public native Vector2 clamp(Vector2 min, Vector2 max);

  public native Vector2 clampLength(double min, double max);

  public native Vector2 clampScalar(double min, double max);

  @JsMethod(name = "clone")
  public native Vector2 clone_();

  public native Vector2 copy(Vector2 v);

  public native double cross(Vector2 v);

  public native double distanceTo(Vector2 v);

  @Deprecated
  public native double distanceToManhattan(Vector2 v);

  public native double distanceToSquared(Vector2 v);

  public native Vector2 divide(Vector2 v);

  public native Vector2 divideScalar(double s);

  public native double dot(Vector2 v);

  public native boolean equals(Vector2 v);

  public native Vector2 floor();

  public native Vector2 fromArray(Vector2.FromArrayArrayUnionType array, double offset);

  public native Vector2 fromArray(Vector2.FromArrayArrayUnionType array);

  @JsOverlay
  public final Vector2 fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Vector2.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector2 fromArray(JsArray<Double> array) {
    return fromArray(Js.<Vector2.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector2 fromArray(Object array, double offset) {
    return fromArray(Js.<Vector2.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector2 fromArray(Object array) {
    return fromArray(Js.<Vector2.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector2 fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector2 fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native Vector2 fromBufferAttribute(BufferAttribute attribute, double index);

  public native double getComponent(double index);

  public native double length();

  @Deprecated
  public native double lengthManhattan();

  public native double lengthSq();

  public native Vector2 lerp(Vector2 v, double alpha);

  public native Vector2 lerpVectors(Vector2 v1, Vector2 v2, double alpha);

  public native double manhattanDistanceTo(Vector2 v);

  public native double manhattanLength();

  public native Vector2 max(Vector2 v);

  public native Vector2 min(Vector2 v);

  public native Vector2 multiply(Vector2 v);

  public native Vector2 multiplyScalar(double scalar);

  public native Vector2 negate();

  public native Vector2 normalize();

  public native Vector2 random();

  public native Vector2 rotateAround(Vector2 center, double angle);

  public native Vector2 round();

  public native Vector2 roundToZero();

  public native Vector2 set(double x, double y);

  public native Vector2 setComponent(double index, double value);

  public native Vector2 setLength(double length);

  public native Vector2 setScalar(double scalar);

  public native Vector2 setX(double x);

  public native Vector2 setY(double y);

  public native Vector2 sub(Vector2 v);

  public native Vector2 subScalar(double s);

  public native Vector2 subVectors(Vector2 a, Vector2 b);

  public native Vector2.ToArrayUnionType toArray();

  @JsOverlay
  public final Vector2.ToArrayUnionType toArray(JsArray<Object> array, double offset) {
    return toArray(Js.<Vector2.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector2.ToArrayUnionType toArray(JsArray<Object> array) {
    return toArray(Js.<Vector2.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector2.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<Vector2.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector2.ToArrayUnionType toArray(Object[] array, double offset) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector2.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<Vector2.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector2.ToArrayUnionType toArray(Object[] array) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array));
  }

  public native Vector2.ToArrayUnionType toArray(
      Vector2.ToArrayArrayUnionType array, double offset);

  public native Vector2.ToArrayUnionType toArray(Vector2.ToArrayArrayUnionType array);
}
