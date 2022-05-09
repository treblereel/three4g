package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.DirectionalLight", namespace = JsPackage.GLOBAL)
public class DirectionalLight extends Light {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static DirectionalLight.ConstructorColorUnionType of(Object o) {
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

  public double intensity;
  public boolean isDirectionalLight;
  public Vector3 position;
  public DirectionalLightShadow shadow;
  public Object3D target;
  public String type;

  public DirectionalLight() {}

  public DirectionalLight(Color color, double intensity) {}

  public DirectionalLight(Color color) {}

  public DirectionalLight(DirectionalLight.ConstructorColorUnionType color, double intensity) {}

  public DirectionalLight(DirectionalLight.ConstructorColorUnionType color) {}

  public DirectionalLight(String color, double intensity) {}

  public DirectionalLight(String color) {}

  public DirectionalLight(double color, double intensity) {}

  public DirectionalLight(double color) {}
}
