package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTargetOptions;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.textures.CubeTexture;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.WebGLCubeRenderTarget", namespace = JsPackage.GLOBAL)
public class WebGLCubeRenderTarget {
  public CubeTexture texture;

  public WebGLCubeRenderTarget(double size, WebGLRenderTargetOptions options) {}

  public WebGLCubeRenderTarget(double size) {}

  public native void clear(WebGLRenderer renderer, boolean color, boolean depth, boolean stencil);

  public native WebGLCubeRenderTarget fromEquirectangularTexture(
      WebGLRenderer renderer, Texture texture);
}
