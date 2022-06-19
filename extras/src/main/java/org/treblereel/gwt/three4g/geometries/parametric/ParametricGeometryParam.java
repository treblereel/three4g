package org.treblereel.gwt.three4g.geometries.parametric;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.ParametricGeometryParam", namespace = JsPackage.GLOBAL)
public class ParametricGeometryParam {

    public OnCall func;

    public double slices;

    public double stacks;

    @JsFunction
    @FunctionalInterface
    public interface OnCall {
        void onCall(double u, double v, Vector3 target);
    }
}
