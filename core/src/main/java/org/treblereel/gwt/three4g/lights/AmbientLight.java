package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.AmbientLight", namespace = JsPackage.GLOBAL)
public class AmbientLight extends Light {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static AmbientLight.ConstructorColorUnionType of(Object o) {
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

  public boolean isAmbientLight;
  public String type;

  public AmbientLight() {}

  public AmbientLight(Color color, double intensity) {}

  public AmbientLight(Color color) {}

  public AmbientLight(AmbientLight.ConstructorColorUnionType color, double intensity) {}

  public AmbientLight(AmbientLight.ConstructorColorUnionType color) {}

  public AmbientLight(String color, double intensity) {}

  public AmbientLight(String color) {}

  public AmbientLight(double color, double intensity) {}

  public AmbientLight(double color) {}
}
