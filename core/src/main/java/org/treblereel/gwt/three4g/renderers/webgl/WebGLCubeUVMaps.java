package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

@JsType(isNative = true, name = "THREE.WebGLCubeUVMaps", namespace = JsPackage.GLOBAL)
public class WebGLCubeUVMaps {
  public WebGLCubeUVMaps(WebGLRenderer renderer) {}

  public native void dispose();

  public native <T> double get(T texture);
}
