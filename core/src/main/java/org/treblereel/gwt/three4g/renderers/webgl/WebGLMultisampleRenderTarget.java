package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTargetOptions;

@JsType(isNative = true, name = "THREE.WebGLMultisampleRenderTarget", namespace = JsPackage.GLOBAL)
public class WebGLMultisampleRenderTarget {
  public boolean isWebGLMultisampleRenderTarget;
  public double samples;

  public WebGLMultisampleRenderTarget(
      double width, double height, WebGLRenderTargetOptions options) {}

  public WebGLMultisampleRenderTarget(double width, double height) {}
}
