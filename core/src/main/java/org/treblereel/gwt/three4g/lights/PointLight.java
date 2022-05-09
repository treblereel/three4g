package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.PointLight", namespace = JsPackage.GLOBAL)
public class PointLight extends Light {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static PointLight.ConstructorColorUnionType of(Object o) {
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

  public double decay;
  public double distance;
  public double intensity;
  public double power;
  public PointLightShadow shadow;
  public String type;

  public PointLight() {}

  public PointLight(Color color, double intensity, double distance, double decay) {}

  public PointLight(Color color, double intensity, double distance) {}

  public PointLight(Color color, double intensity) {}

  public PointLight(Color color) {}

  public PointLight(
      PointLight.ConstructorColorUnionType color,
      double intensity,
      double distance,
      double decay) {}

  public PointLight(
      PointLight.ConstructorColorUnionType color, double intensity, double distance) {}

  public PointLight(PointLight.ConstructorColorUnionType color, double intensity) {}

  public PointLight(PointLight.ConstructorColorUnionType color) {}

  public PointLight(String color, double intensity, double distance, double decay) {}

  public PointLight(String color, double intensity, double distance) {}

  public PointLight(String color, double intensity) {}

  public PointLight(String color) {}

  public PointLight(double color, double intensity, double distance, double decay) {}

  public PointLight(double color, double intensity, double distance) {}

  public PointLight(double color, double intensity) {}

  public PointLight(double color) {}
}
