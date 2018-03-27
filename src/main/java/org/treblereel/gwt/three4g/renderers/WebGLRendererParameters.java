package org.treblereel.gwt.three4g.renderers;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 2/27/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class WebGLRendererParameters {

    public HTMLElement canvas;
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
