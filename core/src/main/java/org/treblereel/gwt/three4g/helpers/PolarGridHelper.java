package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

@JsType(isNative = true, name = "THREE.PolarGridHelper", namespace = JsPackage.GLOBAL)
public class PolarGridHelper extends LineSegments {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColor1UnionType {
    @JsOverlay
    static PolarGridHelper.ConstructorColor1UnionType of(Object o) {
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
    static PolarGridHelper.ConstructorColor2UnionType of(Object o) {
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

  public PolarGridHelper() {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      Color color1,
      Color color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      Color color1,
      PolarGridHelper.ConstructorColor2UnionType color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      Color color1,
      String color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      Color color1,
      double color2) {}

  public PolarGridHelper(
      double radius, double radials, double circles, double divisions, Color color1) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      PolarGridHelper.ConstructorColor1UnionType color1,
      Color color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      PolarGridHelper.ConstructorColor1UnionType color1,
      PolarGridHelper.ConstructorColor2UnionType color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      PolarGridHelper.ConstructorColor1UnionType color1,
      String color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      PolarGridHelper.ConstructorColor1UnionType color1,
      double color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      PolarGridHelper.ConstructorColor1UnionType color1) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      String color1,
      Color color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      String color1,
      PolarGridHelper.ConstructorColor2UnionType color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      String color1,
      String color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      String color1,
      double color2) {}

  public PolarGridHelper(
      double radius, double radials, double circles, double divisions, String color1) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      double color1,
      Color color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      double color1,
      PolarGridHelper.ConstructorColor2UnionType color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      double color1,
      String color2) {}

  public PolarGridHelper(
      double radius,
      double radials,
      double circles,
      double divisions,
      double color1,
      double color2) {}

  public PolarGridHelper(
      double radius, double radials, double circles, double divisions, double color1) {}

  public PolarGridHelper(double radius, double radials, double circles, double divisions) {}

  public PolarGridHelper(double radius, double radials, double circles) {}

  public PolarGridHelper(double radius, double radials) {}

  public PolarGridHelper(double radius) {}
}
