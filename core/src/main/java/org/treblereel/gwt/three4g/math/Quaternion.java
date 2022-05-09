package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Quaternion", namespace = JsPackage.GLOBAL)
public class Quaternion {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Quaternion.FromArrayArrayUnionType of(Object o) {
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
    static Quaternion.ToArrayArrayUnionType of(Object o) {
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
  public interface ToArrayUnionType {
    @JsOverlay
    static Quaternion.ToArrayUnionType of(Object o) {
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

  @JsFunction
  public interface _onChangeCallbackFn {
    void onInvoke();
  }

  @JsFunction
  public interface _onChangeCallbackFn0 {
    void onInvoke();
  }

  public static native JsArray<Double> multiplyQuaternionsFlat(
      JsArray<Double> dst,
      double dstOffset,
      JsArray<Double> src0,
      double srcOffset,
      JsArray<Double> src1,
      double stcOffset1);

  @JsOverlay
  public static final JsArray<Double> multiplyQuaternionsFlat(
      double[] dst,
      double dstOffset,
      double[] src0,
      double srcOffset,
      double[] src1,
      double stcOffset1) {
    return multiplyQuaternionsFlat(
        Js.<JsArray<Double>>uncheckedCast(dst),
        dstOffset,
        Js.<JsArray<Double>>uncheckedCast(src0),
        srcOffset,
        Js.<JsArray<Double>>uncheckedCast(src1),
        stcOffset1);
  }

  @Deprecated
  public static native double slerp(Quaternion qa, Quaternion qb, Quaternion qm, double t);

  public static native Quaternion slerpFlat(
      JsArray<Double> dst,
      double dstOffset,
      JsArray<Double> src0,
      double srcOffset,
      JsArray<Double> src1,
      double stcOffset1,
      double t);

  @JsOverlay
  public static final Quaternion slerpFlat(
      double[] dst,
      double dstOffset,
      double[] src0,
      double srcOffset,
      double[] src1,
      double stcOffset1,
      double t) {
    return slerpFlat(
        Js.<JsArray<Double>>uncheckedCast(dst),
        dstOffset,
        Js.<JsArray<Double>>uncheckedCast(src0),
        srcOffset,
        Js.<JsArray<Double>>uncheckedCast(src1),
        stcOffset1,
        t);
  }

  public Quaternion._onChangeCallbackFn0 _onChangeCallback;
  public boolean isQuaternion;
  public double w;
  public double x;
  public double y;
  public double z;

  public Quaternion() {}

  public Quaternion(double x, double y, double z, double w) {}

  public Quaternion(double x, double y, double z) {}

  public Quaternion(double x, double y) {}

  public Quaternion(double x) {}

  public native Quaternion _onChange(Quaternion._onChangeCallbackFn callback);

  public native double angleTo(Quaternion q);

  @JsMethod(name = "clone")
  public native Quaternion clone_();

  public native Quaternion conjugate();

  public native Quaternion copy(Quaternion q);

  public native double dot(Quaternion v);

  public native boolean equals(Quaternion v);

  public native Quaternion fromArray(Quaternion.FromArrayArrayUnionType array, double offset);

  public native Quaternion fromArray(Quaternion.FromArrayArrayUnionType array);

  @JsOverlay
  public final Quaternion fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Quaternion.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Quaternion fromArray(JsArray<Double> array) {
    return fromArray(Js.<Quaternion.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Quaternion fromArray(Object array, double offset) {
    return fromArray(Js.<Quaternion.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Quaternion fromArray(Object array) {
    return fromArray(Js.<Quaternion.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Quaternion fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Quaternion fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native Quaternion identity();

  @Deprecated
  public native Quaternion inverse();

  public native Quaternion invert();

  public native double length();

  public native double lengthSq();

  public native Quaternion multiply(Quaternion q);

  public native Quaternion multiplyQuaternions(Quaternion a, Quaternion b);

  @Deprecated
  public native double multiplyVector3(double v);

  public native Quaternion normalize();

  public native Quaternion premultiply(Quaternion q);

  public native Quaternion random();

  public native Quaternion rotateTowards(Quaternion q, double step);

  public native Quaternion set(double x, double y, double z, double w);

  public native Quaternion setFromAxisAngle(Vector3 axis, double angle);

  public native Quaternion setFromEuler(Euler euler, boolean update);

  public native Quaternion setFromEuler(Euler euler);

  public native Quaternion setFromRotationMatrix(Matrix4 m);

  public native Quaternion setFromUnitVectors(Vector3 vFrom, Vector3 vTo);

  public native Quaternion slerp(Quaternion qb, double t);

  public native Quaternion slerpQuaternions(Quaternion qa, Quaternion qb, double t);

  public native Quaternion.ToArrayUnionType toArray();

  @JsOverlay
  public final Quaternion.ToArrayUnionType toArray(JsArray<Double> array, double offset) {
    return toArray(Js.<Quaternion.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Quaternion.ToArrayUnionType toArray(JsArray<Double> array) {
    return toArray(Js.<Quaternion.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Quaternion.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<Quaternion.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Quaternion.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<Quaternion.ToArrayArrayUnionType>uncheckedCast(array));
  }

  public native Quaternion.ToArrayUnionType toArray(
      Quaternion.ToArrayArrayUnionType array, double offset);

  public native Quaternion.ToArrayUnionType toArray(Quaternion.ToArrayArrayUnionType array);

  @JsOverlay
  public final Quaternion.ToArrayUnionType toArray(double[] array, double offset) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Quaternion.ToArrayUnionType toArray(double[] array) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array));
  }
}
