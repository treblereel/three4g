package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.PointsMaterialParameters", namespace = JsPackage.GLOBAL)
public interface PointsMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetColorUnionType {
    @JsOverlay
    static PointsMaterialParameters.GetColorUnionType of(Object o) {
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

  @JsOverlay
  static PointsMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Texture getAlphaMap();

  @JsProperty
  PointsMaterialParameters.GetColorUnionType getColor();

  @JsProperty
  Texture getMap();

  @JsProperty
  double getSize();

  @JsProperty
  boolean isSizeAttenuation();

  @JsProperty
  void setAlphaMap(Texture alphaMap);

  @JsOverlay
  default void setColor(Color color) {
    setColor(Js.<PointsMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setColor(PointsMaterialParameters.GetColorUnionType color);

  @JsOverlay
  default void setColor(String color) {
    setColor(Js.<PointsMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  default void setColor(double color) {
    setColor(Js.<PointsMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setMap(Texture map);

  @JsProperty
  void setSize(double size);

  @JsProperty
  void setSizeAttenuation(boolean sizeAttenuation);
}
