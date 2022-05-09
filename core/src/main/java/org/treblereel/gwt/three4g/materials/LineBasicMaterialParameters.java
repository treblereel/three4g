package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.LineBasicMaterialParameters", namespace = JsPackage.GLOBAL)
public interface LineBasicMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetColorUnionType {
    @JsOverlay
    static LineBasicMaterialParameters.GetColorUnionType of(Object o) {
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
  static LineBasicMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  LineBasicMaterialParameters.GetColorUnionType getColor();

  @JsProperty
  String getLinecap();

  @JsProperty
  String getLinejoin();

  @JsProperty
  double getLinewidth();

  @JsOverlay
  default void setColor(Color color) {
    setColor(Js.<LineBasicMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setColor(LineBasicMaterialParameters.GetColorUnionType color);

  @JsOverlay
  default void setColor(String color) {
    setColor(Js.<LineBasicMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  default void setColor(double color) {
    setColor(Js.<LineBasicMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setLinecap(String linecap);

  @JsProperty
  void setLinejoin(String linejoin);

  @JsProperty
  void setLinewidth(double linewidth);
}
