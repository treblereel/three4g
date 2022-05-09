package org.treblereel.gwt.three4g.helpers;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;

@JsType(isNative = true, name = "THREE.ArrowHelper", namespace = JsPackage.GLOBAL)
public class ArrowHelper extends Object3D {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConeMeshTypeParameter1UnionType {
    @JsOverlay
    static ArrowHelper.ConeMeshTypeParameter1UnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsArray<Material> asJsArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default Material asMaterial() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isJsArray() {
      return (Object) this instanceof JsArray;
    }

    @JsOverlay
    default boolean isMaterial() {
      return (Object) this instanceof Material;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorColorUnionType {
    @JsOverlay
    static ArrowHelper.ConstructorColorUnionType of(Object o) {
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
  public interface SetColorColorUnionType {
    @JsOverlay
    static ArrowHelper.SetColorColorUnionType of(Object o) {
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

  public Mesh<BufferGeometry, ConeMeshTypeParameter1UnionType> cone;
  public Line line;
  public String type;

  public ArrowHelper() {}

  public ArrowHelper(
      Vector3 dir,
      Vector3 origin,
      double length,
      Color color,
      double headLength,
      double headWidth) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length, Color color, double headLength) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length, Color color) {}

  public ArrowHelper(
      Vector3 dir,
      Vector3 origin,
      double length,
      ArrowHelper.ConstructorColorUnionType color,
      double headLength,
      double headWidth) {}

  public ArrowHelper(
      Vector3 dir,
      Vector3 origin,
      double length,
      ArrowHelper.ConstructorColorUnionType color,
      double headLength) {}

  public ArrowHelper(
      Vector3 dir, Vector3 origin, double length, ArrowHelper.ConstructorColorUnionType color) {}

  public ArrowHelper(
      Vector3 dir,
      Vector3 origin,
      double length,
      String color,
      double headLength,
      double headWidth) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length, String color, double headLength) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length, String color) {}

  public ArrowHelper(
      Vector3 dir,
      Vector3 origin,
      double length,
      double color,
      double headLength,
      double headWidth) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length, double color, double headLength) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length, double color) {}

  public ArrowHelper(Vector3 dir, Vector3 origin, double length) {}

  public ArrowHelper(Vector3 dir, Vector3 origin) {}

  public ArrowHelper(Vector3 dir) {}

  @JsOverlay
  public final void setColor(Color color) {
    setColor(Js.<ArrowHelper.SetColorColorUnionType>uncheckedCast(color));
  }

  public native void setColor(ArrowHelper.SetColorColorUnionType color);

  @JsOverlay
  public final void setColor(String color) {
    setColor(Js.<ArrowHelper.SetColorColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  public final void setColor(double color) {
    setColor(Js.<ArrowHelper.SetColorColorUnionType>uncheckedCast(color));
  }

  public native void setDirection(Vector3 dir);

  public native void setLength(double length, double headLength, double headWidth);

  public native void setLength(double length, double headLength);

  public native void setLength(double length);
}
