package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLCapabilities", namespace = JsPackage.GLOBAL)
public class WebGLCapabilities {
  public boolean floatFragmentTextures;
  public boolean floatVertexTextures;
  public boolean isWebGL2;
  public boolean logarithmicDepthBuffer;
  public double maxAttributes;
  public double maxCubemapSize;
  public double maxFragmentUniforms;
  public double maxTextureSize;
  public double maxTextures;
  public double maxVaryings;
  public double maxVertexTextures;
  public double maxVertexUniforms;
  public String precision;
  public boolean vertexTextures;

  public WebGLCapabilities(
      WebGLRenderingContext gl, double extensions, WebGLCapabilitiesParameters parameters) {}

  public native double getMaxAnisotropy();

  public native String getMaxPrecision(String precision);
}
