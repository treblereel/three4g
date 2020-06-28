package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRenderTargetParameters;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@JsType(isNative = true, namespace = "THREE")
public class WebGLCubeRenderTarget extends WebGLRenderTarget {

    public WebGLCubeRenderTarget(WebGLRenderTargetParameters params) {

    }

    /**
     * @param renderer — the renderer.
     * @param texture — the equirectangular texture.
     * @return Use this method if you want to convert an equirectangular panorama to the cubemap format.
     */
    public native WebGLCubeRenderTarget fromEquirectangularTexture(WebGLRenderer renderer, Texture texture);
}
