package org.treblereel.gwt.three4g.effects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.math.Matrix3;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.AnaglyphEffect", namespace = JsPackage.GLOBAL)
public class AnaglyphEffect {

    public AnaglyphEffect(WebGLRenderer position) {

    }

    public AnaglyphEffect(WebGLRenderer position, double width) {

    }

    public AnaglyphEffect(WebGLRenderer position, double width, double height) {

    }

    public Matrix3 colorMatrixLeft;
    public Matrix3 colorMatrixRight;


    public native void dispose();

    public native void render(Scene scene, Camera camera);

    public native void setSize(double width, double height);

}
