package org.treblereel.gwt.three4g.extensions.vr;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.webvr.WebXROptions;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/28/18.
 */
@Three4gElement(paths = "js/vr/WebVR.js")
@JsType(namespace = "THREE", isNative = true, name = "WEBVR")
public class WebVR {

    public native static HTMLElement createButton(WebGLRenderer renderer);

    public native static HTMLElement createButton(WebGLRenderer renderer, WebXROptions options);
}
