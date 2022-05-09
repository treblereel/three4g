package org.treblereel.gwt.three4g.extras;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;
import org.treblereel.gwt.three4g.textures.CubeTexture;

@JsType(isNative = true, name = "THREE.PMREMGenerator", namespace = JsPackage.GLOBAL)
public class PMREMGenerator {
  public PMREMGenerator(WebGLRenderer renderer) {}

  public native void compileCubemapShader();

  public native void compileEquirectangularShader();

  public native void dispose();

  public native WebGLRenderTarget fromCubemap(CubeTexture cubemap);

  public native WebGLRenderTarget fromEquirectangular(Texture equirectangular);

  public native WebGLRenderTarget fromScene(Scene scene, double sigma, double near, double far);

  public native WebGLRenderTarget fromScene(Scene scene, double sigma, double near);

  public native WebGLRenderTarget fromScene(Scene scene, double sigma);

  public native WebGLRenderTarget fromScene(Scene scene);
}
