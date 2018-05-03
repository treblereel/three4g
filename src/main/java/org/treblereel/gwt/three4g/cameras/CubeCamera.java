package org.treblereel.gwt.three4g.cameras;

import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTargetCube;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * Creates 6 cameras that render to a WebGLRenderTargetCube.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
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
    public CubeCamera(Number near, Number far, Number cubeResolution) {

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
     * @param renderer
     * @param color
     * @param depth
     * @param stencil
     */
    public native void clear(WebGLRenderer renderer, boolean color, boolean depth, boolean stencil);
}
