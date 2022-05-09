package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.SpotLight", namespace = JsPackage.GLOBAL)
public class SpotLight extends Light {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static SpotLight.ConstructorColorUnionType of(Object o) {
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

  public double angle;
  public double decay;
  public double distance;
  public double intensity;
  public boolean isSpotLight;
  public double penumbra;
  public Vector3 position;
  public double power;
  public SpotLightShadow shadow;
  public Object3D target;
  public String type;

  public SpotLight() {}

  public SpotLight(
      Color color,
      double intensity,
      double distance,
      double angle,
      double penumbra,
      double decay) {}

  public SpotLight(Color color, double intensity, double distance, double angle, double penumbra) {}

  public SpotLight(Color color, double intensity, double distance, double angle) {}

  public SpotLight(Color color, double intensity, double distance) {}

  public SpotLight(Color color, double intensity) {}

  public SpotLight(Color color) {}

  public SpotLight(
      SpotLight.ConstructorColorUnionType color,
      double intensity,
      double distance,
      double angle,
      double penumbra,
      double decay) {}

  public SpotLight(
      SpotLight.ConstructorColorUnionType color,
      double intensity,
      double distance,
      double angle,
      double penumbra) {}

  public SpotLight(
      SpotLight.ConstructorColorUnionType color, double intensity, double distance, double angle) {}

  public SpotLight(SpotLight.ConstructorColorUnionType color, double intensity, double distance) {}

  public SpotLight(SpotLight.ConstructorColorUnionType color, double intensity) {}

  public SpotLight(SpotLight.ConstructorColorUnionType color) {}

  public SpotLight(
      String color,
      double intensity,
      double distance,
      double angle,
      double penumbra,
      double decay) {}

  public SpotLight(
      String color, double intensity, double distance, double angle, double penumbra) {}

  public SpotLight(String color, double intensity, double distance, double angle) {}

  public SpotLight(String color, double intensity, double distance) {}

  public SpotLight(String color, double intensity) {}

  public SpotLight(String color) {}

  public SpotLight(
      double color,
      double intensity,
      double distance,
      double angle,
      double penumbra,
      double decay) {}

  public SpotLight(
      double color, double intensity, double distance, double angle, double penumbra) {}

  public SpotLight(double color, double intensity, double distance, double angle) {}

  public SpotLight(double color, double intensity, double distance) {}

  public SpotLight(double color, double intensity) {}

  public SpotLight(double color) {}
}
