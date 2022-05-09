package org.treblereel.gwt.three4g.utils;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.WebGLUtils", namespace = JsPackage.GLOBAL)
public class WebGLUtils {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorGlUnionType {
    @JsOverlay
    static WebGLUtils.ConstructorGlUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default WebGLRenderingContext asWebGLRenderingContext() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }

    @JsOverlay
    default boolean isWebGLRenderingContext() {
      return (Object) this instanceof WebGLRenderingContext;
    }
  }

  public WebGLUtils(WebGLUtils.ConstructorGlUnionType gl, double extensions, double capabilities) {}

  public WebGLUtils(Object gl, double extensions, double capabilities) {}

  public WebGLUtils(WebGLRenderingContext gl, double extensions, double capabilities) {}

  public native void convert(double p);
}
