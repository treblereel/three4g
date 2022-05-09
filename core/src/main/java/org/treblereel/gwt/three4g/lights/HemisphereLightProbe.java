package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.HemisphereLightProbe", namespace = JsPackage.GLOBAL)
public class HemisphereLightProbe extends LightProbe {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorGroundColorUnionType {
    @JsOverlay
    static HemisphereLightProbe.ConstructorGroundColorUnionType of(Object o) {
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
    static HemisphereLightProbe.ConstructorSkyColorUnionType of(Object o) {
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

  public boolean isHemisphereLightProbe;

  public HemisphereLightProbe() {}

  public HemisphereLightProbe(Color skyColor, Color groundColor, double intensity) {}

  public HemisphereLightProbe(Color skyColor, Color groundColor) {}

  public HemisphereLightProbe(
      Color skyColor,
      HemisphereLightProbe.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      Color skyColor, HemisphereLightProbe.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLightProbe(Color skyColor, String groundColor, double intensity) {}

  public HemisphereLightProbe(Color skyColor, String groundColor) {}

  public HemisphereLightProbe(Color skyColor, double groundColor, double intensity) {}

  public HemisphereLightProbe(Color skyColor, double groundColor) {}

  public HemisphereLightProbe(Color skyColor) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor,
      Color groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor, Color groundColor) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor,
      HemisphereLightProbe.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor,
      HemisphereLightProbe.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor,
      String groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor, String groundColor) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor,
      double groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      HemisphereLightProbe.ConstructorSkyColorUnionType skyColor, double groundColor) {}

  public HemisphereLightProbe(HemisphereLightProbe.ConstructorSkyColorUnionType skyColor) {}

  public HemisphereLightProbe(String skyColor, Color groundColor, double intensity) {}

  public HemisphereLightProbe(String skyColor, Color groundColor) {}

  public HemisphereLightProbe(
      String skyColor,
      HemisphereLightProbe.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      String skyColor, HemisphereLightProbe.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLightProbe(String skyColor, String groundColor, double intensity) {}

  public HemisphereLightProbe(String skyColor, String groundColor) {}

  public HemisphereLightProbe(String skyColor, double groundColor, double intensity) {}

  public HemisphereLightProbe(String skyColor, double groundColor) {}

  public HemisphereLightProbe(String skyColor) {}

  public HemisphereLightProbe(double skyColor, Color groundColor, double intensity) {}

  public HemisphereLightProbe(double skyColor, Color groundColor) {}

  public HemisphereLightProbe(
      double skyColor,
      HemisphereLightProbe.ConstructorGroundColorUnionType groundColor,
      double intensity) {}

  public HemisphereLightProbe(
      double skyColor, HemisphereLightProbe.ConstructorGroundColorUnionType groundColor) {}

  public HemisphereLightProbe(double skyColor, String groundColor, double intensity) {}

  public HemisphereLightProbe(double skyColor, String groundColor) {}

  public HemisphereLightProbe(double skyColor, double groundColor, double intensity) {}

  public HemisphereLightProbe(double skyColor, double groundColor) {}

  public HemisphereLightProbe(double skyColor) {}
}
