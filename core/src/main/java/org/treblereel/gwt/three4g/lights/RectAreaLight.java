package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.RectAreaLight", namespace = JsPackage.GLOBAL)
public class RectAreaLight extends Light {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static RectAreaLight.ConstructorColorUnionType of(Object o) {
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

  public double height;
  public double intensity;
  public boolean isRectAreaLight;
  public double power;
  public String type;
  public double width;

  public RectAreaLight() {}

  public RectAreaLight(Color color, double intensity, double width, double height) {}

  public RectAreaLight(Color color, double intensity, double width) {}

  public RectAreaLight(Color color, double intensity) {}

  public RectAreaLight(Color color) {}

  public RectAreaLight(
      RectAreaLight.ConstructorColorUnionType color,
      double intensity,
      double width,
      double height) {}

  public RectAreaLight(
      RectAreaLight.ConstructorColorUnionType color, double intensity, double width) {}

  public RectAreaLight(RectAreaLight.ConstructorColorUnionType color, double intensity) {}

  public RectAreaLight(RectAreaLight.ConstructorColorUnionType color) {}

  public RectAreaLight(String color, double intensity, double width, double height) {}

  public RectAreaLight(String color, double intensity, double width) {}

  public RectAreaLight(String color, double intensity) {}

  public RectAreaLight(String color) {}

  public RectAreaLight(double color, double intensity, double width, double height) {}

  public RectAreaLight(double color, double intensity, double width) {}

  public RectAreaLight(double color, double intensity) {}

  public RectAreaLight(double color) {}
}
