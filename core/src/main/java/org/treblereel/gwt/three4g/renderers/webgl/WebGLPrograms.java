package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.WebGLPrograms", namespace = JsPackage.GLOBAL)
public class WebGLPrograms {
  public JsArray<WebGLProgram> programs;

  public WebGLPrograms(
      WebGLRenderer renderer,
      WebGLCubeMaps cubemaps,
      WebGLExtensions extensions,
      WebGLCapabilities capabilities,
      WebGLBindingStates bindingStates,
      WebGLClipping clipping) {}

  public native WebGLProgram acquireProgram(double parameters, String cacheKey);

  public native double getParameters(
          Material material, double lights, JsArray<JsObject> shadows, Scene scene, double object);

  @JsOverlay
  public final double getParameters(
      Material material, double lights, JsObject[] shadows, Scene scene, double object) {
    return getParameters(
        material, lights, Js.<JsArray<JsObject>>uncheckedCast(shadows), scene, object);
  }

  public native String getProgramCacheKey(double parameters);

  public native JsObject getUniforms(Material material);

  public native void releaseProgram(WebGLProgram program);
}
