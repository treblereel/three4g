package org.treblereel.gwt.three4g.renderers.shaders.shaderlib;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.ShaderLib.Shader", namespace = JsPackage.GLOBAL)
public interface Shader {
  @JsOverlay
  static Shader create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  String getFragmentShader();

  @JsProperty
  JsPropertyMap<JsObject> getUniforms();

  @JsProperty
  String getVertexShader();

  @JsProperty
  void setFragmentShader(String fragmentShader);

  @JsProperty
  void setUniforms(JsPropertyMap<JsObject> uniforms);

  @JsProperty
  void setVertexShader(String vertexShader);
}
