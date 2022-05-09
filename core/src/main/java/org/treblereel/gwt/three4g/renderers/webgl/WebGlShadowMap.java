package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.lights.Light;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.WebGLShadowMap", namespace = JsPackage.GLOBAL)
public class WebGLShadowMap {
  public boolean autoUpdate;
  public double cullFace;
  public boolean enabled;
  public boolean needsUpdate;
  public double type;

  public WebGLShadowMap(
          WebGLRenderer _renderer, WebGLObjects _objects, WebGLCapabilities _capabilities) {}

  public native void render(JsArray<Light> shadowsArray, Scene scene, Camera camera);

  @JsOverlay
  public final void render(Light[] shadowsArray, Scene scene, Camera camera) {
    render(Js.<JsArray<Light>>uncheckedCast(shadowsArray), scene, camera);
  }
}
