package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.Light", namespace = JsPackage.GLOBAL)
public class Light extends Object3D {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorHexUnionType {
    @JsOverlay
    static Light.ConstructorHexUnionType of(Object o) {
      return Js.cast(o);
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
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  public Color color;
  public double intensity;
  public boolean isLight;
  public LightShadow shadow;
  public double shadowBias;
  public double shadowCameraBottom;
  public double shadowCameraFar;
  public double shadowCameraFov;
  public double shadowCameraLeft;
  public double shadowCameraNear;
  public double shadowCameraRight;
  public double shadowCameraTop;
  public double shadowMapHeight;
  public double shadowMapWidth;
  public String type;

  public Light() {}

  public Light(Light.ConstructorHexUnionType hex, double intensity) {}

  public Light(Light.ConstructorHexUnionType hex) {}

  public Light(String hex, double intensity) {}

  public Light(String hex) {}

  public Light(double hex, double intensity) {}

  public Light(double hex) {}

  public native void dispose();
}
