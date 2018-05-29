package org.treblereel.gwt.three4g.examples.vr;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/28/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebVR {
    public native static HTMLElement createButton(WebGLRenderer renderer);
}
