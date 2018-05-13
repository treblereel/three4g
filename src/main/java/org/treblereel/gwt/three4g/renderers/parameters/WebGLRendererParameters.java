package org.treblereel.gwt.three4g.renderers.parameters;

import elemental2.dom.HTMLCanvasElement;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 2/27/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class WebGLRendererParameters {

    public HTMLCanvasElement canvas;
    public WebGLRenderingContext context;
    public String precision; // Can be "highp", "mediump" or "lowp". Defaults to "highp" if supported by the device
    public boolean alpha;
    public boolean premultipliedAlpha;
    public boolean antialias;
    public boolean stencil;
    public boolean preserveDrawingBuffer;
    public String powerPreference; // Can be "high-performance", "low-power" or "default"
    public boolean depth;
    public boolean logarithmicDepthBuffer;

}
