package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.WebGLCapabilitiesParameters", namespace = JsPackage.GLOBAL)
public interface WebGLCapabilitiesParameters {
  @JsOverlay
  static WebGLCapabilitiesParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  String getPrecision();

  @JsProperty
  boolean isLogarithmicDepthBuffer();

  @JsProperty
  void setLogarithmicDepthBuffer(boolean logarithmicDepthBuffer);

  @JsProperty
  void setPrecision(String precision);
}
