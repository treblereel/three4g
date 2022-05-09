package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLProperties", namespace = JsPackage.GLOBAL)
public class WebGLProperties {
  public native void dispose();

  public native double get(double object);

  public native void remove(double object);

  public native double update(double object, double key, double value);
}
