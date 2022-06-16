package org.treblereel.gwt.three4g.effects;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.AsciiEffect", namespace = JsPackage.GLOBAL)
public class AsciiEffect {

    public HTMLElement domElement;

    public AsciiEffect(WebGLRenderer renderer, String charSet, AsciiEffectOptions options) {

    }

    public native void render(Scene scene, Camera camera);

    public native void  setSize(double width, double height);
}
