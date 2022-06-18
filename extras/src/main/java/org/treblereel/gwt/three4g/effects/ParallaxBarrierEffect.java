package org.treblereel.gwt.three4g.effects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.ParallaxBarrierEffect", namespace = JsPackage.GLOBAL)
public class ParallaxBarrierEffect {

    public ParallaxBarrierEffect(WebGLRenderer renderer) {

    }

    public native void render(Scene scene, Camera camera);

    public native void setSize(double width, double height);

}
