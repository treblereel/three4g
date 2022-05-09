package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.renderers.webgl.webglrenderlists.WebGLRenderList;

@JsType(isNative = true, name = "THREE.WebGLRenderLists", namespace = JsPackage.GLOBAL)
public class WebGLRenderLists {
  public WebGLRenderLists(WebGLProperties properties) {}

  public native void dispose();

  public native WebGLRenderList get(Scene scene, double renderCallDepth);
}
