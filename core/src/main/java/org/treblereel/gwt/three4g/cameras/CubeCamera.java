package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.webgl.WebGLCubeRenderTarget;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.CubeCamera", namespace = JsPackage.GLOBAL)
public class CubeCamera extends Object3D {
  public WebGLCubeRenderTarget renderTarget;
  public String type;

  public CubeCamera(double near, double far, WebGLCubeRenderTarget renderTarget) {}

  public native void update(WebGLRenderer renderer, Scene scene);
}
