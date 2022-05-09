package org.treblereel.gwt.three4g.utils;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.utils", namespace = JsPackage.GLOBAL)
public class Utils {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ColorRepresentationUnionType {
    @JsOverlay
    static Utils.ColorRepresentationUnionType of(Object o) {
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

  public static Utils.ColorRepresentationUnionType ColorRepresentation;
}
