package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.Line;

@JsType(isNative = true, name = "THREE.DirectionalLightHelper", namespace = JsPackage.GLOBAL)
public class DirectionalLightHelper extends Object3D {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ColorUnionType {
    @JsOverlay
    static DirectionalLightHelper.ColorUnionType of(Object o) {
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
  public interface ConstructorColorUnionType {
    @JsOverlay
    static DirectionalLightHelper.ConstructorColorUnionType of(Object o) {
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

  public DirectionalLightHelper.ColorUnionType color;
  public DirectionalLight light;
  public Line lightPlane;
  public Matrix4 matrix;
  public boolean matrixAutoUpdate;
  public Line targetLine;

  public DirectionalLightHelper(DirectionalLight light, double size, Color color) {}

  public DirectionalLightHelper(
      DirectionalLight light,
      double size,
      DirectionalLightHelper.ConstructorColorUnionType color) {}

  public DirectionalLightHelper(DirectionalLight light, double size, String color) {}

  public DirectionalLightHelper(DirectionalLight light, double size, double color) {}

  public DirectionalLightHelper(DirectionalLight light, double size) {}

  public DirectionalLightHelper(DirectionalLight light) {}

  public native void dispose();

  public native void update();
}
