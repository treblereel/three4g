package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.color.HSL;
import org.treblereel.gwt.three4g.core.BufferAttribute;

@JsType(isNative = true, name = "THREE.Color", namespace = JsPackage.GLOBAL)
public class Color {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColor_or_rUnionType {
    @JsOverlay
    static Color.ConstructorColor_or_rUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FromArrayArrayUnionType {
    @JsOverlay
    static Color.FromArrayArrayUnionType of(Object o) {
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
  public interface SetColorUnionType {
    @JsOverlay
    static Color.SetColorUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ToArrayArray_or_xyzUnionType {
    @JsOverlay
    static Color.ToArrayArray_or_xyzUnionType of(Object o) {
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
    static Color.ToArrayUnionType of(Object o) {
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

  public static double NAMES;
  public double b;
  public double g;
  public boolean isColor;
  public double r;

  public Color() {}

  public Color(Color color_or_r, double g, double b) {}

  public Color(Color color_or_r, double g) {}

  public Color(Color color_or_r) {}

  public Color(Color.ConstructorColor_or_rUnionType color_or_r, double g, double b) {}

  public Color(Color.ConstructorColor_or_rUnionType color_or_r, double g) {}

  public Color(Color.ConstructorColor_or_rUnionType color_or_r) {}

  public Color(String color_or_r, double g, double b) {}

  public Color(String color_or_r, double g) {}

  public Color(String color_or_r) {}

  public Color(double color_or_r, double g, double b) {}

  public Color(double color_or_r, double g) {}

  public Color(double color_or_r) {}

  public native Color add(Color color);

  public native Color addColors(Color color1, Color color2);

  public native Color addScalar(double s);

  @JsMethod(name = "clone")
  public native Color clone_();

  public native Color convertGammaToLinear();

  public native Color convertGammaToLinear(double gammaFactor);

  public native Color convertLinearToGamma();

  public native Color convertLinearToGamma(double gammaFactor);

  public native Color convertLinearToSRGB();

  public native Color convertSRGBToLinear();

  public native Color copy(Color color);

  public native Color copyGammaToLinear(Color color, double gammaFactor);

  public native Color copyGammaToLinear(Color color);

  public native Color copyLinearToGamma(Color color, double gammaFactor);

  public native Color copyLinearToGamma(Color color);

  public native Color copyLinearToSRGB(Color color);

  public native Color copySRGBToLinear(Color color);

  public native boolean equals(Color color);

  public native Color fromArray(Color.FromArrayArrayUnionType array, double offset);

  public native Color fromArray(Color.FromArrayArrayUnionType array);

  @JsOverlay
  public final Color fromArray(JsArray<Double> array, double offset) {
    return fromArray(Js.<Color.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Color fromArray(JsArray<Double> array) {
    return fromArray(Js.<Color.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Color fromArray(Object array, double offset) {
    return fromArray(Js.<Color.FromArrayArrayUnionType>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Color fromArray(Object array) {
    return fromArray(Js.<Color.FromArrayArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  public final Color fromArray(double[] array, double offset) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final Color fromArray(double[] array) {
    return fromArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native Color fromBufferAttribute(BufferAttribute attribute, double index);

  public native HSL getHSL(HSL target);

  public native double getHex();

  public native String getHexString();

  public native String getStyle();

  public native Color lerp(Color color, double alpha);

  public native Color lerpColors(Color color1, Color color2, double alpha);

  public native Color lerpHSL(Color color, double alpha);

  public native Color multiply(Color color);

  public native Color multiplyScalar(double s);

  public native Color offsetHSL(double h, double s, double l);

  @JsOverlay
  public final Color set(Color color) {
    return set(Js.<Color.SetColorUnionType>uncheckedCast(color));
  }

  public native Color set(Color.SetColorUnionType color);

  @JsOverlay
  public final Color set(String color) {
    return set(Js.<Color.SetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  public final Color set(double color) {
    return set(Js.<Color.SetColorUnionType>uncheckedCast(color));
  }

  public native Color setColorName(String style);

  public native Color setHSL(double h, double s, double l);

  public native Color setHex(double hex);

  public native Color setRGB(double r, double g, double b);

  public native Color setScalar(double scalar);

  public native Color setStyle(String style);

  public native Color sub(Color color);

  public native Color.ToArrayUnionType toArray();

  @JsOverlay
  public final Color.ToArrayUnionType toArray(JsArray<Double> array_or_xyz, double offset) {
    return toArray(Js.<Color.ToArrayArray_or_xyzUnionType>uncheckedCast(array_or_xyz), offset);
  }

  @JsOverlay
  public final Color.ToArrayUnionType toArray(JsArray<Double> array_or_xyz) {
    return toArray(Js.<Color.ToArrayArray_or_xyzUnionType>uncheckedCast(array_or_xyz));
  }

  @JsOverlay
  public final Color.ToArrayUnionType toArray(Object array_or_xyz, double offset) {
    return toArray(Js.<Color.ToArrayArray_or_xyzUnionType>uncheckedCast(array_or_xyz), offset);
  }

  @JsOverlay
  public final Color.ToArrayUnionType toArray(Object array_or_xyz) {
    return toArray(Js.<Color.ToArrayArray_or_xyzUnionType>uncheckedCast(array_or_xyz));
  }

  public native Color.ToArrayUnionType toArray(
      Color.ToArrayArray_or_xyzUnionType array_or_xyz, double offset);

  public native Color.ToArrayUnionType toArray(Color.ToArrayArray_or_xyzUnionType array_or_xyz);

  @JsOverlay
  public final Color.ToArrayUnionType toArray(double[] array_or_xyz, double offset) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array_or_xyz), offset);
  }

  @JsOverlay
  public final Color.ToArrayUnionType toArray(double[] array_or_xyz) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array_or_xyz));
  }
}
