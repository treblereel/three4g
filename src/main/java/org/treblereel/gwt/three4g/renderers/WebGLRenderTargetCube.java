package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRenderTargetCubeParameters;

/**
 * Used by the CubeCamera as its WebGLRenderTarget.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebGLRenderTargetCube extends WebGLRenderTarget {

    /**
     * The activeCubeFace property corresponds to a cube side (PX 0, NX 1, PY 2, NY 3, PZ 4, NZ 5) and is used and set internally by the CubeCamera.
     */
    public int activeCubeFace;

    /**
     *
     * @param width - The width of the renderTarget.
     * @param height - The height of the renderTarget.
     */
    public WebGLRenderTargetCube(float width, float height) {

    }

    /**
     *
     * @param width - The width of the renderTarget.
     * @param height - The height of the renderTarget.
     * @param options - object that holds texture parameters for an auto-generated target texture and depthBuffer/stencilBuffer booleans. For an explanation of the texture parameters see Texture. The following are valid options:
     */
    public WebGLRenderTargetCube(float width, float height, WebGLRenderTargetCubeParameters options) {

    }
}
