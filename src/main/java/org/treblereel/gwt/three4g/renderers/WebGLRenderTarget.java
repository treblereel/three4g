package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRenderTargetParameters;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A render target is a buffer where the video card draws pixels for a scene that	is being rendered in the background. It is used in different effects, such as applying postprocessing to a rendered image before displaying it on the screen.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebGLRenderTarget extends RenderTarget {

    /**
     * The width of the render target.
     */
    public Number width;

    /**
     * The height of the render target.
     */
    public Number height;

    /**
     * A rectangular area inside the render target's viewport. Fragments that are outside the area will be discarded.
     */
    public Vector4 scissor;

    /**
     * Indicates whether the scissor test is active or not.
     */
    public boolean scissorTest;

    /**
     * The viewport of this render target.
     */
    public Vector4 viewport;

    /**
     * This texture instance holds the rendered pixels. Use it as input for further processing.
     */
    public Texture texture;

    /**
     * Renders to the depth buffer. Default is true.
     */
    public boolean depthBuffer;

    /**
     * Renders to the stencil buffer. Default is true.
     */
    public boolean stencilBuffer;

    /**
     * If set, the scene depth will be rendered to this texture. Default is null.
     */
    public Texture depthTexture;


    public WebGLRenderTarget() {

    }

    /**
     * @param width  - The width of the renderTarget.
     * @param height - The height of the renderTarget.
     */
    public WebGLRenderTarget(Number width, Number height) {

    }

    /**
     * @param width  - The width of the renderTarget.
     * @param height - The height of the renderTarget.
     * @param webGLRenderTargetParameters options, instance of WebGLRenderTargetParameters
     */
    public WebGLRenderTarget(Number width, Number height, WebGLRenderTargetParameters webGLRenderTargetParameters) {

    }

    /**
     * Sets the size of the render target.
     *
     * @param width  as double
     * @param height as double
     */
    public native void setSize(double width, double height);

    /**
     * Creates a copy of this render target.
     *
     * @return instance of WebGLRenderTarget
     */
    public native WebGLRenderTarget clone();

    /**
     * Adopts the settings of the given render target.
     *
     * @param source instance of WebGLRenderTarget
     * @return instance of WebGLRenderTarget
     */
    public native WebGLRenderTarget copy(WebGLRenderTarget source);

    /**
     * Dispatches a dispose event.
     */
    public native void dispose();
}
