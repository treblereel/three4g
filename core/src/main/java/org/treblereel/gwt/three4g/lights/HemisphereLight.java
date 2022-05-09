package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.HemisphereLight", namespace = JsPackage.GLOBAL)
public class HemisphereLight extends Light {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorGroundColorUnionType {
    @JsOverlay
    static HemisphereLight.ConstructorGroundColorUnionType of(Object o) {
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
  public interface ConstructorSkyColorUnionType {
    @JsOverlay
    static HemisphereLight.ConstructorSkyColorUnionType of(Object o) {
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

  public Color groundColor;
  public boolean isHemisphereLight;
  public Vector3 position;
  public String type;

  public HemisphereLight() {}

  public HemisphereLight(Color skyColor, Color groundColor, double intensity) {}

  public HemisphereLight(Color skyColor, Color groundColor) {}

  public HemisphereLight(
      Color skyColor,
      HemisphereLight.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLight(
      Color skyColor, HemisphereLight.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLight(Color skyColor, String groundColor, double intensity) {}

  public HemisphereLight(Color skyColor, String groundColor) {}

  public HemisphereLight(Color skyColor, double groundColor, double intensity) {}

  public HemisphereLight(Color skyColor, double groundColor) {}

  public HemisphereLight(Color skyColor) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor, Color groundColor, double intensity) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor, Color groundColor) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor,
      HemisphereLight.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor,
      HemisphereLight.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor,
      String groundColor,
      double intensity) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor, String groundColor) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor,
      double groundColor,
      double intensity) {}

  public HemisphereLight(
      HemisphereLight.ConstructorSkyColorUnionType skyColor, double groundColor) {}

  public HemisphereLight(HemisphereLight.ConstructorSkyColorUnionType skyColor) {}

  public HemisphereLight(String skyColor, Color groundColor, double intensity) {}

  public HemisphereLight(String skyColor, Color groundColor) {}

  public HemisphereLight(
      String skyColor,
      HemisphereLight.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLight(
      String skyColor, HemisphereLight.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLight(String skyColor, String groundColor, double intensity) {}

  public HemisphereLight(String skyColor, String groundColor) {}

  public HemisphereLight(String skyColor, double groundColor, double intensity) {}

  public HemisphereLight(String skyColor, double groundColor) {}

  public HemisphereLight(String skyColor) {}

  public HemisphereLight(double skyColor, Color groundColor, double intensity) {}

  public HemisphereLight(double skyColor, Color groundColor) {}

  public HemisphereLight(
      double skyColor,
      HemisphereLight.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLight(
      double skyColor, HemisphereLight.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLight(double skyColor, String groundColor, double intensity) {}

  public HemisphereLight(double skyColor, String groundColor) {}

  public HemisphereLight(double skyColor, double groundColor, double intensity) {}

  public HemisphereLight(double skyColor, double groundColor) {}

  public HemisphereLight(double skyColor) {}
}
