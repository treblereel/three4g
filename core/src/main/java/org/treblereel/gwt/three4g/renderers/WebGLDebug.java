package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.WebGLRenderer.WebGLDebug", namespace = JsPackage.GLOBAL)
public interface WebGLDebug {
  @JsOverlay
  static WebGLDebug create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  boolean isCheckShaderErrors();

  @JsProperty
  void setCheckShaderErrors(boolean checkShaderErrors);
}
