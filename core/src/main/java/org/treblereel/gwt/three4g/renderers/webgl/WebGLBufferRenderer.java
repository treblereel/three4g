package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLBufferRenderer", namespace = JsPackage.GLOBAL)
public class WebGLBufferRenderer {
  public WebGLBufferRenderer(
      WebGLRenderingContext gl,
      WebGLExtensions extensions,
      WebGLInfo info,
      WebGLCapabilities capabilities) {}

  public native void render(double start, double count);

  public native void renderInstances(double start, double count, double primcount);

  public native void setMode(double value);
}
