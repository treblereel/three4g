package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLExtensions", namespace = JsPackage.GLOBAL)
public class WebGLExtensions {
  public WebGLExtensions(WebGLRenderingContext gl) {}

  public native double get(String name);

  public native boolean has(String name);

  public native void init(WebGLCapabilities capabilities);
}
