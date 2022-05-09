package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLObjects", namespace = JsPackage.GLOBAL)
public class WebGLObjects {
  public WebGLObjects(
      WebGLRenderingContext gl, double geometries, double attributes, double info) {}

  public native void dispose();

  public native double update(double object);
}
