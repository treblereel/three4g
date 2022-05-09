package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.SphericalHarmonics3", namespace = JsPackage.GLOBAL)
public class SphericalHarmonics3 {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static SphericalHarmonics3.FromArrayArrayUnionType of(Object o) {
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
    static SphericalHarmonics3.ToArrayArrayUnionType of(Object o) {
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
    static SphericalHarmonics3.ToArrayUnionType of(Object o) {
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

  public static native void getBasisAt(Vector3 normal, JsArray<Double> shBasis);

  @JsOverlay
  public static final void getBasisAt(Vector3 normal, double[] shBasis) {
    getBasisAt(normal, Js.<JsArray<Double>>uncheckedCast(shBasis));
  }

  public JsArray<Vector3> coefficients;
  public boolean isSphericalHarmonics3;

  public native SphericalHarmonics3 add(SphericalHarmonics3 sh);

  public native SphericalHarmonics3 addScaledSH(SphericalHarmonics3 sh, double s);

  @JsMethod(name = "clone")
  public native SphericalHarmonics3 clone_();

  public native SphericalHarmonics3 copy(SphericalHarmonics3 sh);

  public native boolean equals(SphericalHarmonics3 sh);

  public native SphericalHarmonics3 fromArray(
      SphericalHarmonics3.FromArrayArrayUnionType array, double offset);

  public native SphericalHarmonics3 fromArray(SphericalHarmonics3.FromArrayArrayUnionType array);

  @JsOverlay
  public final SphericalHarmonics3 fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<SphericalHarmonics3.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final SphericalHarmonics3 fromArray(JsArray<Double> array) {
    return fromArray(Js.<SphericalHarmonics3.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final SphericalHarmonics3 fromArray(Object array, double offset) {
    return fromArray(Js.<SphericalHarmonics3.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final SphericalHarmonics3 fromArray(Object array) {
    return fromArray(Js.<SphericalHarmonics3.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final SphericalHarmonics3 fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final SphericalHarmonics3 fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native Vector3 getAt(Vector3 normal, Vector3 target);

  public native Vector3 getIrradianceAt(Vector3 normal, Vector3 target);

  public native SphericalHarmonics3 lerp(SphericalHarmonics3 sh, double alpha);

  public native SphericalHarmonics3 scale(double s);

  public native SphericalHarmonics3 set(JsArray<Vector3> coefficients);

  @JsOverlay
  public final SphericalHarmonics3 set(Vector3[] coefficients) {
    return set(Js.<JsArray<Vector3>>uncheckedCast(coefficients));
  }

  public native SphericalHarmonics3.ToArrayUnionType toArray();

  @JsOverlay
  public final SphericalHarmonics3.ToArrayUnionType toArray(JsArray<Double> array, double offset) {
    return toArray(Js.<SphericalHarmonics3.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final SphericalHarmonics3.ToArrayUnionType toArray(JsArray<Double> array) {
    return toArray(Js.<SphericalHarmonics3.ToArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final SphericalHarmonics3.ToArrayUnionType toArray(Object array, double offset) {
    return toArray(Js.<SphericalHarmonics3.ToArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final SphericalHarmonics3.ToArrayUnionType toArray(Object array) {
    return toArray(Js.<SphericalHarmonics3.ToArrayArrayUnionType>uncheckedCast(array));
  }

  public native SphericalHarmonics3.ToArrayUnionType toArray(
      SphericalHarmonics3.ToArrayArrayUnionType array, double offset);

  public native SphericalHarmonics3.ToArrayUnionType toArray(
      SphericalHarmonics3.ToArrayArrayUnionType array);

  @JsOverlay
  public final SphericalHarmonics3.ToArrayUnionType toArray(double[] array, double offset) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final SphericalHarmonics3.ToArrayUnionType toArray(double[] array) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native SphericalHarmonics3 zero();
}
