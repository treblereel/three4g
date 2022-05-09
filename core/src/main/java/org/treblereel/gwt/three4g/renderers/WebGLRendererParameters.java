package org.treblereel.gwt.three4g.renderers;

import elemental2.dom.HTMLCanvasElement;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.WebGLRendererParameters", namespace = JsPackage.GLOBAL)
public interface WebGLRendererParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetCanvasUnionType {
    @JsOverlay
    static WebGLRendererParameters.GetCanvasUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default HTMLCanvasElement asHTMLCanvasElement() {
      return Js.cast(this);
    }

    @JsOverlay
    default OffscreenCanvas asOffscreenCanvas() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isHTMLCanvasElement() {
      return (Object) this instanceof HTMLCanvasElement;
    }
  }

  @JsOverlay
  static WebGLRendererParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  WebGLRendererParameters.GetCanvasUnionType getCanvas();

  @JsProperty
  WebGLRenderingContext getContext();

  @JsProperty
  String getPowerPreference();

  @JsProperty
  String getPrecision();

  @JsProperty
  boolean isAlpha();

  @JsProperty
  boolean isAntialias();

  @JsProperty
  boolean isDepth();

  @JsProperty
  boolean isFailIfMajorPerformanceCaveat();

  @JsProperty
  boolean isLogarithmicDepthBuffer();

  @JsProperty
  boolean isPremultipliedAlpha();

  @JsProperty
  boolean isPreserveDrawingBuffer();

  @JsProperty
  boolean isStencil();

  @JsProperty
  void setAlpha(boolean alpha);

  @JsProperty
  void setAntialias(boolean antialias);

  @JsProperty
  void setCanvas(WebGLRendererParameters.GetCanvasUnionType canvas);

  @JsOverlay
  default void setCanvas(HTMLCanvasElement canvas) {
    setCanvas(Js.<WebGLRendererParameters.GetCanvasUnionType>uncheckedCast(canvas));
  }

  @JsOverlay
  default void setCanvas(OffscreenCanvas canvas) {
    setCanvas(Js.<WebGLRendererParameters.GetCanvasUnionType>uncheckedCast(canvas));
  }

  @JsProperty
  void setContext(WebGLRenderingContext context);

  @JsProperty
  void setDepth(boolean depth);

  @JsProperty
  void setFailIfMajorPerformanceCaveat(boolean failIfMajorPerformanceCaveat);

  @JsProperty
  void setLogarithmicDepthBuffer(boolean logarithmicDepthBuffer);

  @JsProperty
  void setPowerPreference(String powerPreference);

  @JsProperty
  void setPrecision(String precision);

  @JsProperty
  void setPremultipliedAlpha(boolean premultipliedAlpha);

  @JsProperty
  void setPreserveDrawingBuffer(boolean preserveDrawingBuffer);

  @JsProperty
  void setStencil(boolean stencil);
}
