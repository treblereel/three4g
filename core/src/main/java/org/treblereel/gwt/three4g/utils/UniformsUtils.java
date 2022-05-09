package org.treblereel.gwt.three4g.utils;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.UniformsUtils", namespace = JsPackage.GLOBAL)
public class UniformsUtils {
  public static native double cloneUniforms(double uniforms_src);

  public static native double mergeUniforms(JsArray<JsObject> uniforms);

  @JsOverlay
  public static final double mergeUniforms(JsObject[] uniforms) {
    return mergeUniforms(Js.<JsArray<JsObject>>uncheckedCast(uniforms));
  }
}
