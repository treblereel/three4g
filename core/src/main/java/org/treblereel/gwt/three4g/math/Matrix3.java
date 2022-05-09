package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Matrix3", namespace = JsPackage.GLOBAL)
public class Matrix3 {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Matrix3.FromArrayArrayUnionType of(Object o) {
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
  public interface GetInverseMatrixUnionType {
    @JsOverlay
    static Matrix3.GetInverseMatrixUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Matrix3 asMatrix3() {
      return Js.cast(this);
    }

    @JsOverlay
    default Matrix4 asMatrix4() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isMatrix3() {
      return (Object) this instanceof Matrix3;
    }

    @JsOverlay
    default boolean isMatrix4() {
      return (Object) this instanceof Matrix4;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ToArrayArrayUnionType {
    @JsOverlay
    static Matrix3.ToArrayArrayUnionType of(Object o) {
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
    static Matrix3.ToArrayUnionType of(Object o) {
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
  public native Matrix3 clone_();

  public native Matrix3 copy(Matrix3 m);

  public native double determinant();

  public native boolean equals(Matrix3 matrix);

  public native Matrix3 extractBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);

  @Deprecated
  public native JsArray<Double> flattenToArrayOffset(JsArray<Double> array, double offset);

  @JsOverlay
  @Deprecated
  public final JsArray<Double> flattenToArrayOffset(double[] array, double offset) {
    return flattenToArrayOffset(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  public native Matrix3 fromArray(Matrix3.FromArrayArrayUnionType array, double offset);

  public native Matrix3 fromArray(Matrix3.FromArrayArrayUnionType array);

  @JsOverlay
  public final Matrix3 fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Matrix3.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix3 fromArray(JsArray<Double> array) {
    return fromArray(Js.<Matrix3.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix3 fromArray(Object array, double offset) {
    return fromArray(Js.<Matrix3.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix3 fromArray(Object array) {
    return fromArray(Js.<Matrix3.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix3 fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix3 fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  @Deprecated
  public native Matrix3 getInverse(
      Matrix3.GetInverseMatrixUnionType matrix, boolean throwOnDegenerate);

  @Deprecated
  public native Matrix3 getInverse(Matrix3.GetInverseMatrixUnionType matrix);

  @JsOverlay
  @Deprecated
  public final Matrix3 getInverse(Matrix3 matrix, boolean throwOnDegenerate) {
    return getInverse(
        Js.<Matrix3.GetInverseMatrixUnionType>uncheckedCast(matrix), throwOnDegenerate);
  }

  @JsOverlay
  @Deprecated
  public final Matrix3 getInverse(Matrix3 matrix) {
    return getInverse(Js.<Matrix3.GetInverseMatrixUnionType>uncheckedCast(matrix));
  }

  @JsOverlay
  @Deprecated
  public final Matrix3 getInverse(Matrix4 matrix, boolean throwOnDegenerate) {
    return getInverse(
        Js.<Matrix3.GetInverseMatrixUnionType>uncheckedCast(matrix), throwOnDegenerate);
  }

  @JsOverlay
  @Deprecated
  public final Matrix3 getInverse(Matrix4 matrix) {
    return getInverse(Js.<Matrix3.GetInverseMatrixUnionType>uncheckedCast(matrix));
  }

  public native Matrix3 getNormalMatrix(Matrix4 matrix4);

  public native Matrix3 identity();

  public native Matrix3 invert();

  public native Matrix3 multiply(Matrix3 m);

  public native Matrix3 multiplyMatrices(Matrix3 a, Matrix3 b);

  public native Matrix3 multiplyScalar(double s);

  @Deprecated
  public native double multiplyVector3(Vector3 vector);

  @Deprecated
  public native double multiplyVector3Array(double a);

  public native Matrix3 premultiply(Matrix3 m);

  public native Matrix3 rotate(double theta);

  public native Matrix3 scale(double sx, double sy);

  public native Matrix3 set(
      double n11,
      double n12,
      double n13,
      double n21,
      double n22,
      double n23,
      double n31,
      double n32,
      double n33);

  public native Matrix3 setFromMatrix4(Matrix4 m);

  public native Matrix3 setUvTransform(
      double tx, double ty, double sx, double sy, double rotation, double cx, double cy);

  public native Matrix3.ToArrayUnionType toArray();

  @JsOverlay
  public final Matrix3.ToArrayUnionType toArray(JsArray<Object> array, double offset) {
    return toArray(Js.<Matrix3.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix3.ToArrayUnionType toArray(JsArray<Object> array) {
    return toArray(Js.<Matrix3.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix3.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<Matrix3.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix3.ToArrayUnionType toArray(Object[] array, double offset) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Matrix3.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<Matrix3.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Matrix3.ToArrayUnionType toArray(Object[] array) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array));
  }

  public native Matrix3.ToArrayUnionType toArray(
      Matrix3.ToArrayArrayUnionType array, double offset);

  public native Matrix3.ToArrayUnionType toArray(Matrix3.ToArrayArrayUnionType array);

  public native Matrix3 translate(double tx, double ty);

  public native Matrix3 transpose();

  public native Matrix3 transposeIntoArray(JsArray<Double> r);

  @JsOverlay
  public final Matrix3 transposeIntoArray(double[] r) {
    return transposeIntoArray(Js.<JsArray<Double>>uncheckedCast(r));
  }
}
