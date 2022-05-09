package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsObject;
import elemental2.webgl.WebGLShader;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

@JsType(isNative = true, name = "THREE.WebGLProgram", namespace = JsPackage.GLOBAL)
public class WebGLProgram {
  public double attributes;
  public String cacheKey;
  public WebGLShader fragmentShader;
  public double id;
  public String name;
  public double program;
  public double uniforms;
  public double usedTimes;
  public WebGLShader vertexShader;

  public WebGLProgram(WebGLRenderer renderer, String cacheKey, JsObject parameters) {}

  public WebGLProgram(WebGLRenderer renderer, String cacheKey, Object parameters) {}

  public native void destroy();

  public native double getAttributes();

  public native WebGLUniforms getUniforms();
}
