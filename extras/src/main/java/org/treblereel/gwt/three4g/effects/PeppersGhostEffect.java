package org.treblereel.gwt.three4g.effects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.PeppersGhostEffect", namespace = JsPackage.GLOBAL)
public class PeppersGhostEffect {

    public PeppersGhostEffect(WebGLRenderer renderer) {

    }
    public double cameraDistance;
    public boolean reflectFromAbove;

    public native void render(Scene scene, Camera camera);
    public native void  setSize(double width, double height);
}
