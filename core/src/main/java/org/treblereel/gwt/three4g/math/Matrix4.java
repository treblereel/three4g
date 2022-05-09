package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Matrix4", namespace = JsPackage.GLOBAL)
public class Matrix4 {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Matrix4.FromArrayArrayUnionType of(Object o) {
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
  public interface SetPositionVUnionType {
    @JsOverlay
    static Matrix4.SetPositionVUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default Vector3 asVector3() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isVector3() {
      return (Object) this instanceof Vector3;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ToArrayArrayUnionType {
    @JsOverlay
    static Matrix4.ToArrayArrayUnionType of(Object o) {
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
    static Matrix4.ToArrayUnionType of(Object o) {
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

  public JsArray<Double> elements;

  @JsMethod(name = "clone")
  public native Matrix4 clone_();

  public native Matrix4 compose(Vector3 translation, Quaternion rotation, Vector3 scale);

  public native Matrix4 copy(Matrix4 m);

  public native Matrix4 copyPosition(Matrix4 m);

  @Deprecated
  public native void crossVector(double v);

  public native Matrix4 decompose(Vector3 translation, Quaternion rotation, Vector3 scale);

  public native double determinant();

  public native boolean equals(Matrix4 matrix);

  public native Matrix4 extractBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);

  @Deprecated
  public native Matrix4 extractPosition(Matrix4 m);

  public native Matrix4 extractRotation(Matrix4 m);

  @Deprecated
  public native JsArray<Double> flattenToArrayOffset(JsArray<Double> array, double offset);

  @JsOverlay
  @Deprecated
  public final JsArray<Double> flattenToArrayOffset(double[] array, double offset) {
    return flattenToArrayOffset(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  public native Matrix4 fromArray(Matrix4.FromArrayArrayUnionType array, double offset);

  public native Matrix4 fromArray(Matrix4.FromArrayArrayUnionType array);

  @JsOverlay
  public final Matrix4 fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Matrix4.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix4 fromArray(JsArray<Double> array) {
    return fromArray(Js.<Matrix4.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix4 fromArray(Object array, double offset) {
    return fromArray(Js.<Matrix4.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix4 fromArray(Object array) {
    return fromArray(Js.<Matrix4.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix4 fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix4 fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  @Deprecated
  public native Matrix3 getInverse(Matrix3 matrix);

  public native double getMaxScaleOnAxis();

  public native Matrix4 identity();

  public native Matrix4 invert();

  public native Matrix4 lookAt(Vector3 eye, Vector3 target, Vector3 up);

  public native Matrix4 makeBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);

  public native Matrix4 makeOrthographic(
      double left, double right, double top, double bottom, double near, double far);

  public native Matrix4 makePerspective(
      double left_or_fov,
      double right_or_aspect,
      double bottom_or_near,
      double top_or_far,
      double near,
      double far);

  public native Matrix4 makePerspective(
      double left_or_fov,
      double right_or_aspect,
      double bottom_or_near,
      double top_or_far,
      double near);

  public native Matrix4 makePerspective(
      double left_or_fov, double right_or_aspect, double bottom_or_near, double top_or_far);

  public native Matrix4 makeRotationAxis(Vector3 axis, double angle);

  public native Matrix4 makeRotationFromEuler(Euler euler);

  public native Matrix4 makeRotationFromQuaternion(Quaternion q);

  public native Matrix4 makeRotationX(double theta);

  public native Matrix4 makeRotationY(double theta);

  public native Matrix4 makeRotationZ(double theta);

  public native Matrix4 makeScale(double x, double y, double z);

  public native Matrix4 makeShear(double xy, double xz, double yx, double yz, double zx, double zy);

  public native Matrix4 makeTranslation(double x, double y, double z);

  public native Matrix4 multiply(Matrix4 m);

  public native Matrix4 multiplyMatrices(Matrix4 a, Matrix4 b);

  public native Matrix4 multiplyScalar(double s);

  @Deprecated
  public native Matrix4 multiplyToArray(Matrix4 a, Matrix4 b, JsArray<Double> r);

  @JsOverlay
  @Deprecated
  public final Matrix4 multiplyToArray(Matrix4 a, Matrix4 b, double[] r) {
    return multiplyToArray(a, b, Js.<JsArray<Double>>uncheckedCast(r));
  }

  @Deprecated
  public native double multiplyVector3(double v);

  @Deprecated
  public native JsArray<Double> multiplyVector3Array(JsArray<Double> array);

  @JsOverlay
  @Deprecated
  public final JsArray<Double> multiplyVector3Array(double[] array) {
    return multiplyVector3Array(Js.<JsArray<Double>>uncheckedCast(array));
  }

  @Deprecated
  public native double multiplyVector4(double v);

  public native Matrix4 premultiply(Matrix4 m);

  @Deprecated
  public native void rotateAxis(double v);

  public native Matrix4 scale(Vector3 v);

  public native Matrix4 set(
      double n11,
      double n12,
      double n13,
      double n14,
      double n21,
      double n22,
      double n23,
      double n24,
      double n31,
      double n32,
      double n33,
      double n34,
      double n41,
      double n42,
      double n43,
      double n44);

  public native Matrix4 setFromMatrix3(Matrix3 m);

  public native Matrix4 setPosition(Matrix4.SetPositionVUnionType v, double y, double z);

  public native Matrix4 setPosition(Matrix4.SetPositionVUnionType v, double y);

  public native Matrix4 setPosition(Matrix4.SetPositionVUnionType v);

  @JsOverlay
  public final Matrix4 setPosition(Vector3 v, double y, double z) {
    return setPosition(Js.<Matrix4.SetPositionVUnionType>uncheckedCast(v), y, z);
  }

  @JsOverlay
  public final Matrix4 setPosition(Vector3 v, double y) {
    return setPosition(Js.<Matrix4.SetPositionVUnionType>uncheckedCast(v), y);
  }

  @JsOverlay
  public final Matrix4 setPosition(Vector3 v) {
    return setPosition(Js.<Matrix4.SetPositionVUnionType>uncheckedCast(v));
  }

  @JsOverlay
  public final Matrix4 setPosition(double v, double y, double z) {
    return setPosition(Js.<Matrix4.SetPositionVUnionType>uncheckedCast(v), y, z);
  }

  @JsOverlay
  public final Matrix4 setPosition(double v, double y) {
    return setPosition(Js.<Matrix4.SetPositionVUnionType>uncheckedCast(v), y);
  }

  @JsOverlay
  public final Matrix4 setPosition(double v) {
    return setPosition(Js.<Matrix4.SetPositionVUnionType>uncheckedCast(v));
  }

  @Deprecated
  public native Matrix4 setRotationFromQuaternion(Quaternion q);

  public native Matrix4.ToArrayUnionType toArray();

  @JsOverlay
  public final Matrix4.ToArrayUnionType toArray(JsArray<Object> array, double offset) {
    return toArray(Js.<Matrix4.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix4.ToArrayUnionType toArray(JsArray<Object> array) {
    return toArray(Js.<Matrix4.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix4.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<Matrix4.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix4.ToArrayUnionType toArray(Object[] array, double offset) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix4.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<Matrix4.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix4.ToArrayUnionType toArray(Object[] array) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array));
  }

  public native Matrix4.ToArrayUnionType toArray(
      Matrix4.ToArrayArrayUnionType array, double offset);

  public native Matrix4.ToArrayUnionType toArray(Matrix4.ToArrayArrayUnionType array);

  public native Matrix4 transpose();
}
