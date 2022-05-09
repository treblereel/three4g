package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.utils.WebGLUtils;

@JsType(isNative = true, name = "THREE.WebGLTextures", namespace = JsPackage.GLOBAL)
public class WebGLTextures {
  public WebGLTextures(
      WebGLRenderingContext gl,
      WebGLExtensions extensions,
      WebGLState state,
      WebGLProperties properties,
      WebGLCapabilities capabilities,
      WebGLUtils utils,
      WebGLInfo info) {}

  public native void allocateTextureUnit();

  public native void resetTextureUnits();

  public native void safeSetTexture2D(double texture, double slot);

  public native void safeSetTextureCube(double texture, double slot);

  public native void setTexture2D(double texture, double slot);

  public native void setTexture2DArray(double texture, double slot);

  public native void setTexture3D(double texture, double slot);

  public native void setTextureCube(double texture, double slot);

  public native void setupRenderTarget(double renderTarget);

  public native void updateMultisampleRenderTarget(double renderTarget);

  public native void updateRenderTargetMipmap(double renderTarget);
}
