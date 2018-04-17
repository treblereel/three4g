package org.treblereel.gwt.three4g.renderers;

import elemental2.dom.HTMLCanvasElement;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true)
public class WebGLRenderingContext {

    public static String FRAGMENT_SHADER;

    public static String VERTEX_SHADER;


    /**
     * A read-only back-reference to the HTMLCanvasElement. Might be null if it is not associated with a <canvas> element.
     */
    public HTMLCanvasElement canvas;

    /**
     * The read-only width of the current drawing buffer. Should match the width of the canvas element associated with this context.
     */
    public double drawingBufferWidth;

    /**
     * The read-only height of the current drawing buffer. Should match the height of the canvas element associated with this context.
     */
    public double drawingBufferHeight;

    /**
     * Returns a WebGLContextAttributes object that contains the actual context parameters. Might return null, if the context is lost.
     * @return
     */
    public native ContextAttributes getContextAttributes();


    /**
     * Pushes frames back to the original HTMLCanvasElement, if the context is not directly fixed to a specific canvas.
     */
    public native void commit();

    /**
     * Returns true if the context is lost, otherwise returns false.
     * @return
     */
    public native boolean isContextLost();
}
