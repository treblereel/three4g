package org.treblereel.gwt.three4g.geometries.parametric;

import jsinterop.annotations.JsFunction;
import org.treblereel.gwt.three4g.math.Vector3;

@JsFunction
@FunctionalInterface
public interface ParametricGeometriesFunction {

    Vector3 onCall(double u, double v, Vector3 target);
}
