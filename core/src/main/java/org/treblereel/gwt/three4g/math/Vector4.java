package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;

@JsType(isNative = true, name = "THREE.Vector4", namespace = JsPackage.GLOBAL)
public class Vector4 implements Vector {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Vector4.FromArrayArrayUnionType of(Object o) {
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
    static Vector4.ToArrayArrayUnionType of(Object o) {
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
    static Vector4.ToArrayUnionType of(Object o) {
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
  public boolean isVector4;
  public double w;
  public double width;
  public double x;
  public double y;
  public double z;

  public Vector4() {}

  public Vector4(double x, double y, double z, double w) {}

  public Vector4(double x, double y, double z) {}

  public Vector4(double x, double y) {}

  public Vector4(double x) {}

  public native Vector4 add(Vector4 v);

  public native Vector4 addScalar(double scalar);

  public native Vector4 addScaledVector(Vector4 v, double s);

  public native Vector4 addVectors(Vector4 a, Vector4 b);

  public native Vector4 applyMatrix4(Matrix4 m);

  public native Vector4 ceil();

  public native Vector4 clamp(Vector4 min, Vector4 max);

  public native Vector4 clampScalar(double min, double max);

  @JsMethod(name = "clone")
  public native Vector4 clone_();

  public native Vector4 copy(Vector4 v);

  public native Vector4 divideScalar(double s);

  public native double dot(Vector4 v);

  public native boolean equals(Vector4 v);

  public native Vector4 floor();

  public native Vector4 fromArray(Vector4.FromArrayArrayUnionType array, double offset);

  public native Vector4 fromArray(Vector4.FromArrayArrayUnionType array);

  @JsOverlay
  public final Vector4 fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Vector4.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector4 fromArray(JsArray<Double> array) {
    return fromArray(Js.<Vector4.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector4 fromArray(Object array, double offset) {
    return fromArray(Js.<Vector4.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector4 fromArray(Object array) {
    return fromArray(Js.<Vector4.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector4 fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector4 fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native Vector4 fromBufferAttribute(BufferAttribute attribute, double index);

  public native double getComponent(double index);

  public native double length();

  public native double lengthSq();

  public native Vector4 lerp(Vector4 v, double alpha);

  public native Vector4 lerpVectors(Vector4 v1, Vector4 v2, double alpha);

  public native double manhattanLength();

  public native Vector4 max(Vector4 v);

  public native Vector4 min(Vector4 v);

  public native Vector4 multiply(Vector4 v);

  public native Vector4 multiplyScalar(double s);

  public native Vector4 negate();

  public native Vector4 normalize();

  public native Vector4 random();

  public native Vector4 round();

  public native Vector4 roundToZero();

  public native Vector4 set(double x, double y, double z, double w);

  public native Vector4 setAxisAngleFromQuaternion(Quaternion q);

  public native Vector4 setAxisAngleFromRotationMatrix(Matrix4 m);

  public native Vector4 setComponent(double index, double value);

  public native Vector4 setLength(double length);

  public native Vector4 setScalar(double scalar);

  public native Vector4 setW(double w);

  public native Vector4 setX(double x);

  public native Vector4 setY(double y);

  public native Vector4 setZ(double z);

  public native Vector4 sub(Vector4 v);

  public native Vector4 subScalar(double s);

  public native Vector4 subVectors(Vector4 a, Vector4 b);

  public native Vector4.ToArrayUnionType toArray();

  @JsOverlay
  public final Vector4.ToArrayUnionType toArray(JsArray<Object> array, double offset) {
    return toArray(Js.<Vector4.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector4.ToArrayUnionType toArray(JsArray<Object> array) {
    return toArray(Js.<Vector4.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector4.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<Vector4.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector4.ToArrayUnionType toArray(Object[] array, double offset) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector4.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<Vector4.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector4.ToArrayUnionType toArray(Object[] array) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array));
  }

  public native Vector4.ToArrayUnionType toArray(
      Vector4.ToArrayArrayUnionType array, double offset);

  public native Vector4.ToArrayUnionType toArray(Vector4.ToArrayArrayUnionType array);
}
