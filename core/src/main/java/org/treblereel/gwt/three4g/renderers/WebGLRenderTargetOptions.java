package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.DepthTexture;

@JsType(isNative = true, name = "THREE.WebGLRenderTargetOptions", namespace = JsPackage.GLOBAL)
public interface WebGLRenderTargetOptions {
  @JsOverlay
  static WebGLRenderTargetOptions create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getAnisotropy();

  @JsProperty
  DepthTexture getDepthTexture();

  @JsProperty
  double getEncoding();

  @JsProperty
  double getFormat();

  @JsProperty
  double getMagFilter();

  @JsProperty
  double getMinFilter();

  @JsProperty
  double getType();

  @JsProperty
  double getWrapS();

  @JsProperty
  double getWrapT();

  @JsProperty
  boolean isDepthBuffer();

  @JsProperty
  boolean isGenerateMipmaps();

  @JsProperty
  boolean isStencilBuffer();

  @JsProperty
  void setAnisotropy(double anisotropy);

  @JsProperty
  void setDepthBuffer(boolean depthBuffer);

  @JsProperty
  void setDepthTexture(DepthTexture depthTexture);

  @JsProperty
  void setEncoding(double encoding);

  @JsProperty
  void setFormat(double format);

  @JsProperty
  void setGenerateMipmaps(boolean generateMipmaps);

  @JsProperty
  void setMagFilter(double magFilter);

  @JsProperty
  void setMinFilter(double minFilter);

  @JsProperty
  void setStencilBuffer(boolean stencilBuffer);

  @JsProperty
  void setType(double type);

  @JsProperty
  void setWrapS(double wrapS);

  @JsProperty
  void setWrapT(double wrapT);
}
