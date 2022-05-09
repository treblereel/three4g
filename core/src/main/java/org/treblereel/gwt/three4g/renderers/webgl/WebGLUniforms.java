package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.WebGLUniforms", namespace = JsPackage.GLOBAL)
public class WebGLUniforms {
  public static native JsArray<JsObject> seqWithValue(double seq, JsArray<JsObject> values);

  @JsOverlay
  public static final JsArray<JsObject> seqWithValue(double seq, JsObject[] values) {
    return seqWithValue(seq, Js.<JsArray<JsObject>>uncheckedCast(values));
  }

  public static native void upload(
      WebGLRenderingContext gl, double seq, JsArray<JsObject> values, WebGLTextures textures);

  @JsOverlay
  public static final void upload(
      WebGLRenderingContext gl, double seq, JsObject[] values, WebGLTextures textures) {
    upload(gl, seq, Js.<JsArray<JsObject>>uncheckedCast(values), textures);
  }

  public WebGLUniforms(WebGLRenderingContext gl, WebGLProgram program) {}

  public native void setOptional(WebGLRenderingContext gl, double object, String name);

  public native void setValue(
      WebGLRenderingContext gl, String name, double value, WebGLTextures textures);
}
