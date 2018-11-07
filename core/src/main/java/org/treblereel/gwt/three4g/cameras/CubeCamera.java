package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.params.CubeCameraOptions;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTargetCube;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * Creates 6 cameras that render to a WebGLRenderTargetCube.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CubeCamera extends Object3D {

    /**
     * The cube texture that gets generated.
     */
    public WebGLRenderTargetCube renderTarget;

    /**
     * Constructs a CubeCamera that contains 6 PerspectiveCameras that render to a WebGLRenderTargetCube.
     *
     * @param near           -- The near clipping distance.
     * @param far            -- The far clipping distance
     * @param cubeResolution -- Sets the length of the cube's edges.
     */
    public CubeCamera(float near, float far, float cubeResolution) {

    }

    /**
     * Constructs a CubeCamera that contains 6 PerspectiveCameras that render to a WebGLRenderTargetCube.
     *
     * @param near           -- The near clipping distance.
     * @param far            -- The far clipping distance
     * @param cubeResolution -- Sets the length of the cube's edges.
     * @param options        -- CubeCameraOptions
     */
    public CubeCamera(float near, float far, float cubeResolution, CubeCameraOptions options) {

    }

    /**
     * Call this to update the renderTarget.
     *
     * @param renderer -- The current WebGL renderer
     * @param scene    -- The current scene
     */
    public native void update(WebGLRenderer renderer, Scene scene);

    /**
     * Call this to clear the renderTarget color, depth, and/or stencil buffers. The color buffer is set to the renderer's current clear color. Arguments default to true.
     *
     * @param renderer instance of WebGLRenderer
     */
    public native void clear(WebGLRenderer renderer);

    /**
     * Call this to clear the renderTarget color, depth, and/or stencil buffers. The color buffer is set to the renderer's current clear color. Arguments default to true.
     *
     * @param renderer instance of WebGLRenderer
     * @param color    clear the color buffer
     */
    public native void clear(WebGLRenderer renderer, boolean color);

    /**
     * Call this to clear the renderTarget color, depth, and/or stencil buffers. The color buffer is set to the renderer's current clear color. Arguments default to true.
     *
     * @param renderer instance of WebGLRenderer
     * @param color    clear the color buffer
     * @param depth    clear the depth buffer
     */
    public native void clear(WebGLRenderer renderer, boolean color, boolean depth);

    /**
     * Call this to clear the renderTarget color, depth, and/or stencil buffers. The color buffer is set to the renderer's current clear color. Arguments default to true.
     *
     * @param renderer instance of WebGLRenderer
     * @param color    clear the color buffer
     * @param depth    clear the depth buffer
     * @param stencil  clear the stencil buffer
     */
    public native void clear(WebGLRenderer renderer, boolean color, boolean depth, boolean stencil);
}
