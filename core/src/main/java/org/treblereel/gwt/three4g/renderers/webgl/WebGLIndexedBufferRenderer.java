package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLIndexedBufferRenderer", namespace = JsPackage.GLOBAL)
public class WebGLIndexedBufferRenderer {
  public WebGLIndexedBufferRenderer(
      WebGLRenderingContext gl, double extensions, double info, double capabilities) {}

  public native void render(double start, double count);

  public native void renderInstances(double start, double count, double primcount);

  public native void setIndex(double index);

  public native void setMode(double value);
}
