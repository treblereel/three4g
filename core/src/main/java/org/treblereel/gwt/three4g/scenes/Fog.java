package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.Fog", namespace = JsPackage.GLOBAL)
public class Fog implements FogBase {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static Fog.ConstructorColorUnionType of(Object o) {
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

  public Color color;
  public double far;
  public boolean isFog;
  public String name;
  public double near;

  public Fog(Color color, double near, double far) {}

  public Fog(Color color, double near) {}

  public Fog(Color color) {}

  public Fog(Fog.ConstructorColorUnionType color, double near, double far) {}

  public Fog(Fog.ConstructorColorUnionType color, double near) {}

  public Fog(Fog.ConstructorColorUnionType color) {}

  public Fog(String color, double near, double far) {}

  public Fog(String color, double near) {}

  public Fog(String color) {}

  public Fog(double color, double near, double far) {}

  public Fog(double color, double near) {}

  public Fog(double color) {}

  @JsMethod(name = "clone")
  public native Fog clone_();

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
