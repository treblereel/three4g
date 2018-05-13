package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsFunction;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/22/18.
 */
@JsFunction
@FunctionalInterface
public interface ParametricGeometryFunction {
    Vector3 call(float u, float v);
}
