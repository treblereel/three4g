package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.CinematicCamera", namespace = JsPackage.GLOBAL)
public class CinematicCamera extends PerspectiveCamera {

    public CinematicCamera(double fov, double aspect, double near, double far) {
    }

    public JsPropertyMap postprocessing;

    public JsPropertyMap shaderSettings;

    public ShaderMaterial materialDepth;

    public double coc;

    public double aperture;

    public double fNumber;

    public double hyperFocal;

    public double filmGauge;

    public native double linearize(double depth);

    public native double smoothstep(double near, double far, double depth);

    public native double saturate(double x);

    public native void focusAt(double focusDistance);


    public native void initPostProcessing();

    public native void renderCinematic(Scene scene, WebGLRenderer renderer);

    public native void setLens(int focalLength);

    public native void setLens(int focalLength, double frameHeight);

    public native void setLens(int focalLength, double frameHeight, double fNumber);
    public native void setLens(int focalLength, double frameHeight, double fNumber, double coc);

}
