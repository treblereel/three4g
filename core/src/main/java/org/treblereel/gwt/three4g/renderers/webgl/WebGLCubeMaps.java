package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

@JsType(isNative = true, name = "THREE.WebGLCubeMaps", namespace = JsPackage.GLOBAL)
public class WebGLCubeMaps {
  public WebGLCubeMaps(WebGLRenderer renderer) {}

  public native void dispose();

  public native double get(double texture);
}
