package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.FogExp2", namespace = JsPackage.GLOBAL)
public class FogExp2 implements FogBase {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorHexUnionType {
    @JsOverlay
    static FogExp2.ConstructorHexUnionType of(Object o) {
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
  public double density;
  public boolean isFogExp2;
  public String name;

  public FogExp2(FogExp2.ConstructorHexUnionType hex, double density) {}

  public FogExp2(FogExp2.ConstructorHexUnionType hex) {}

  public FogExp2(String hex, double density) {}

  public FogExp2(String hex) {}

  public FogExp2(double hex, double density) {}

  public FogExp2(double hex) {}

  @JsMethod(name = "clone")
  public native FogExp2 clone_();

  @JsProperty
  public native Color getColor();

  @JsProperty
  public native String getName();

  @JsProperty
  public native void setColor(Color color);

  @JsProperty
  public native void setName(String name);

  public native Object toJSON();

  public native Object toJSON(String key);
}
