package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.InterleavedBufferAttribute;

@JsType(isNative = true, name = "THREE.Vector3", namespace = JsPackage.GLOBAL)
public class Vector3 implements Vector {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Vector3.FromArrayArrayUnionType of(Object o) {
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
  public interface FromBufferAttributeAttributeUnionType {
    @JsOverlay
    static Vector3.FromBufferAttributeAttributeUnionType of(Object o) {
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

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ToArrayArrayUnionType {
    @JsOverlay
    static Vector3.ToArrayArrayUnionType of(Object o) {
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
    static Vector3.ToArrayUnionType of(Object o) {
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

  public boolean isVector3;
  public double x;
  public double y;
  public double z;

  public Vector3() {}

  public Vector3(double x, double y, double z) {}

  public Vector3(double x, double y) {}

  public Vector3(double x) {}

  public native Vector3 add(Vector3 v);

  public native Vector3 addScalar(double s);

  public native Vector3 addScaledVector(Vector3 v, double s);

  public native Vector3 addVectors(Vector3 a, Vector3 b);

  public native double angleTo(Vector3 v);

  public native Vector3 applyAxisAngle(Vector3 axis, double angle);

  public native Vector3 applyEuler(Euler euler);

  public native Vector3 applyMatrix3(Matrix3 m);

  public native Vector3 applyMatrix4(Matrix4 m);

  public native Vector3 applyNormalMatrix(Matrix3 m);

  public native Vector3 applyQuaternion(Quaternion q);

  public native Vector3 ceil();

  public native Vector3 clamp(Vector3 min, Vector3 max);

  public native Vector3 clampLength(double min, double max);

  public native Vector3 clampScalar(double min, double max);

  @JsMethod(name = "clone")
  public native Vector3 clone_();

  public native Vector3 copy(Vector3 v);

  public native Vector3 cross(Vector3 a);

  public native Vector3 crossVectors(Vector3 a, Vector3 b);

  public native double distanceTo(Vector3 v);

  @Deprecated
  public native double distanceToManhattan(Vector3 v);

  public native double distanceToSquared(Vector3 v);

  public native Vector3 divide(Vector3 v);

  public native Vector3 divideScalar(double s);

  public native double dot(Vector3 v);

  public native boolean equals(Vector3 v);

  public native Vector3 floor();

  public native Vector3 fromArray(Vector3.FromArrayArrayUnionType array, double offset);

  public native Vector3 fromArray(Vector3.FromArrayArrayUnionType array);

  @JsOverlay
  public final Vector3 fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Vector3.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector3 fromArray(JsArray<Double> array) {
    return fromArray(Js.<Vector3.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector3 fromArray(Object array, double offset) {
    return fromArray(Js.<Vector3.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector3 fromArray(Object array) {
    return fromArray(Js.<Vector3.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector3 fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector3 fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector3 fromBufferAttribute(BufferAttribute attribute, double index) {
    return fromBufferAttribute(
        Js.<Vector3.FromBufferAttributeAttributeUnionType>uncheckedCast(attribute), index);
  }

  public native Vector3 fromBufferAttribute(
      Vector3.FromBufferAttributeAttributeUnionType attribute, double index);

  @JsOverlay
  public final Vector3 fromBufferAttribute(InterleavedBufferAttribute attribute, double index) {
    return fromBufferAttribute(
        Js.<Vector3.FromBufferAttributeAttributeUnionType>uncheckedCast(attribute), index);
  }

  public native double getComponent(double index);

  public native double length();

  @Deprecated
  public native double lengthManhattan();

  public native double lengthSq();

  public native Vector3 lerp(Vector3 v, double alpha);

  public native Vector3 lerpVectors(Vector3 v1, Vector3 v2, double alpha);

  public native double manhattanDistanceTo(Vector3 v);

  public native double manhattanLength();

  public native Vector3 max(Vector3 v);

  public native Vector3 min(Vector3 v);

  public native Vector3 multiply(Vector3 v);

  public native Vector3 multiplyScalar(double s);

  public native Vector3 multiplyVectors(Vector3 a, Vector3 b);

  public native Vector3 negate();

  public native Vector3 normalize();

  public native Vector3 project(Camera camera);

  public native Vector3 projectOnPlane(Vector3 planeNormal);

  public native Vector3 projectOnVector(Vector3 v);

  public native Vector3 random();

  public native Vector3 randomDirection();

  public native Vector3 reflect(Vector3 vector);

  public native Vector3 round();

  public native Vector3 roundToZero();

  public native Vector3 set(double x, double y, double z);

  public native Vector3 setComponent(double index, double value);

  public native Vector3 setFromCylindrical(Cylindrical s);

  public native Vector3 setFromCylindricalCoords(double radius, double theta, double y);

  public native Vector3 setFromMatrix3Column(Matrix3 matrix, double index);

  public native Vector3 setFromMatrixColumn(Matrix4 matrix, double index);

  public native Vector3 setFromMatrixPosition(Matrix4 m);

  public native Vector3 setFromMatrixScale(Matrix4 m);

  public native Vector3 setFromSpherical(Spherical s);

  public native Vector3 setFromSphericalCoords(double r, double phi, double theta);

  public native Vector3 setLength(double l);

  public native Vector3 setScalar(double scalar);

  public native Vector3 setX(double x);

  public native Vector3 setY(double y);

  public native Vector3 setZ(double z);

  public native Vector3 sub(Vector3 a);

  public native Vector3 subScalar(double s);

  public native Vector3 subVectors(Vector3 a, Vector3 b);

  public native Vector3.ToArrayUnionType toArray();

  @JsOverlay
  public final Vector3.ToArrayUnionType toArray(JsArray<Object> array, double offset) {
    return toArray(Js.<Vector3.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector3.ToArrayUnionType toArray(JsArray<Object> array) {
    return toArray(Js.<Vector3.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector3.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<Vector3.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector3.ToArrayUnionType toArray(Object[] array, double offset) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Vector3.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<Vector3.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Vector3.ToArrayUnionType toArray(Object[] array) {
    return toArray(Js.<JsArray<Object>>uncheckedCast(array));
  }

  public native Vector3.ToArrayUnionType toArray(
      Vector3.ToArrayArrayUnionType array, double offset);

  public native Vector3.ToArrayUnionType toArray(Vector3.ToArrayArrayUnionType array);

  public native Vector3 transformDirection(Matrix4 m);

  public native Vector3 unproject(Camera camera);
}
