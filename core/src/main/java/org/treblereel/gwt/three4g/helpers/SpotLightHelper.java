package org.treblereel.gwt.three4g.helpers;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.Light;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.LineSegments;

@JsType(isNative = true, name = "THREE.SpotLightHelper", namespace = JsPackage.GLOBAL)
public class SpotLightHelper extends Object3D {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ColorUnionType {
    @JsOverlay
    static SpotLightHelper.ColorUnionType of(Object o) {
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
  public interface ConeLineSegmentsTypeParameter1UnionType {
    @JsOverlay
    static SpotLightHelper.ConeLineSegmentsTypeParameter1UnionType of(Object o) {
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
    static SpotLightHelper.ConstructorColorUnionType of(Object o) {
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

  public SpotLightHelper.ColorUnionType color;
  public LineSegments<BufferGeometry, ConeLineSegmentsTypeParameter1UnionType> cone;
  public Light light;
  public Matrix4 matrix;
  public boolean matrixAutoUpdate;

  public SpotLightHelper(Light light, Color color) {}

  public SpotLightHelper(Light light, SpotLightHelper.ConstructorColorUnionType color) {}

  public SpotLightHelper(Light light, String color) {}

  public SpotLightHelper(Light light, double color) {}

  public SpotLightHelper(Light light) {}

  public native void dispose();

  public native void update();
}
