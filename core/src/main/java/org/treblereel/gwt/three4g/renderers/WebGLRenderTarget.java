package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.textures.DepthTexture;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.WebGLRenderTarget", namespace = JsPackage.GLOBAL)
public class WebGLRenderTarget {
  public double anisotropy;
  public double depth;
  public boolean depthBuffer;
  public DepthTexture depthTexture;
  public double format;
  public double generateMipmaps;
  public double height;
  public boolean isWebGLRenderTarget;
  public double magFilter;
  public double minFilter;
  public double offset;
  public double repeat;
  public Vector4 scissor;
  public boolean scissorTest;
  public boolean stencilBuffer;
  public Texture texture;
  public double type;
  public String uuid;
  public Vector4 viewport;
  public double width;
  public double wrapS;
  public double wrapT;

  public WebGLRenderTarget(double width, double height, WebGLRenderTargetOptions options) {}

  public WebGLRenderTarget(double width, double height) {}

  @JsMethod(name = "clone")
  public native WebGLRenderTarget clone_();

  public native WebGLRenderTarget copy(WebGLRenderTarget source);

  public native void dispose();

  public native void setSize(double width, double height, double depth);

  public native void setSize(double width, double height);

  public native void setTexture(Texture texture);
}
