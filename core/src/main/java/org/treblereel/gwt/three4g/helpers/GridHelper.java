package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

@JsType(isNative = true, name = "THREE.GridHelper", namespace = JsPackage.GLOBAL)
public class GridHelper extends LineSegments {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColor1UnionType {
    @JsOverlay
    static GridHelper.ConstructorColor1UnionType of(Object o) {
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
  public interface ConstructorColor2UnionType {
    @JsOverlay
    static GridHelper.ConstructorColor2UnionType of(Object o) {
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
  public interface SetColorsColor1UnionType {
    @JsOverlay
    static GridHelper.SetColorsColor1UnionType of(Object o) {
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
  public interface SetColorsColor2UnionType {
    @JsOverlay
    static GridHelper.SetColorsColor2UnionType of(Object o) {
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

  public String type;

  public GridHelper() {}

  public GridHelper(double size, double divisions, Color color1, Color color2) {}

  public GridHelper(
      double size, double divisions, Color color1, GridHelper.ConstructorColor2UnionType color2) {}

  public GridHelper(double size, double divisions, Color color1, String color2) {}

  public GridHelper(double size, double divisions, Color color1, double color2) {}

  public GridHelper(double size, double divisions, Color color1) {}

  public GridHelper(
      double size, double divisions, GridHelper.ConstructorColor1UnionType color1, Color color2) {}

  public GridHelper(
      double size,
      double divisions,
      GridHelper.ConstructorColor1UnionType color1,
      GridHelper.ConstructorColor2UnionType color2) {}

  public GridHelper(
      double size, double divisions, GridHelper.ConstructorColor1UnionType color1, String color2) {}

  public GridHelper(
      double size, double divisions, GridHelper.ConstructorColor1UnionType color1, double color2) {}

  public GridHelper(double size, double divisions, GridHelper.ConstructorColor1UnionType color1) {}

  public GridHelper(double size, double divisions, String color1, Color color2) {}

  public GridHelper(
      double size, double divisions, String color1, GridHelper.ConstructorColor2UnionType color2) {}

  public GridHelper(double size, double divisions, String color1, String color2) {}

  public GridHelper(double size, double divisions, String color1, double color2) {}

  public GridHelper(double size, double divisions, String color1) {}

  public GridHelper(double size, double divisions, double color1, Color color2) {}

  public GridHelper(
      double size, double divisions, double color1, GridHelper.ConstructorColor2UnionType color2) {}

  public GridHelper(double size, double divisions, double color1, String color2) {}

  public GridHelper(double size, double divisions, double color1, double color2) {}

  public GridHelper(double size, double divisions, double color1) {}

  public GridHelper(double size, double divisions) {}

  public GridHelper(double size) {}

  @Deprecated
  public native void setColors();

  @JsOverlay
  @Deprecated
  public final void setColors(Color color1, Color color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(Color color1, GridHelper.SetColorsColor2UnionType color2) {
    setColors(Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1), color2);
  }

  @JsOverlay
  @Deprecated
  public final void setColors(Color color1, String color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(Color color1, double color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(Color color1) {
    setColors(Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(GridHelper.SetColorsColor1UnionType color1, Color color2) {
    setColors(color1, Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @Deprecated
  public native void setColors(
      GridHelper.SetColorsColor1UnionType color1, GridHelper.SetColorsColor2UnionType color2);

  @JsOverlay
  @Deprecated
  public final void setColors(GridHelper.SetColorsColor1UnionType color1, String color2) {
    setColors(color1, Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(GridHelper.SetColorsColor1UnionType color1, double color2) {
    setColors(color1, Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @Deprecated
  public native void setColors(GridHelper.SetColorsColor1UnionType color1);

  @JsOverlay
  @Deprecated
  public final void setColors(String color1, Color color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(String color1, GridHelper.SetColorsColor2UnionType color2) {
    setColors(Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1), color2);
  }

  @JsOverlay
  @Deprecated
  public final void setColors(String color1, String color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(String color1, double color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(String color1) {
    setColors(Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(double color1, Color color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(double color1, GridHelper.SetColorsColor2UnionType color2) {
    setColors(Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1), color2);
  }

  @JsOverlay
  @Deprecated
  public final void setColors(double color1, String color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(double color1, double color2) {
    setColors(
        Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1),
        Js.<GridHelper.SetColorsColor2UnionType>uncheckedCast(color2));
  }

  @JsOverlay
  @Deprecated
  public final void setColors(double color1) {
    setColors(Js.<GridHelper.SetColorsColor1UnionType>uncheckedCast(color1));
  }
}
