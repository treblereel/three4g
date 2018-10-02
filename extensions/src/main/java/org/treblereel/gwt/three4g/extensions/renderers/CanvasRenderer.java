package org.treblereel.gwt.three4g.extensions.renderers;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;
import org.treblereel.gwt.three4g.scenes.Scene;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/27/18.
 */
@Three4gElement(paths = {"js/renderers/CanvasRenderer.js", "js/renderers/Projector.js"})
@JsType(isNative = true, namespace = "THREE")
public class CanvasRenderer {
    public HTMLElement domElement;

    public native void setPixelRatio(double devicePixelRatio);

    public native void setSize(double innerWidth, double innerHeight);

    public native void render(Scene scene, OrthographicCamera camera);
}
