package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * Generate geometry representing a parametric surface.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/22/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ParametricGeometry extends Geometry {

    /**
     * @param func   — A function that takes in a u and v value each between 0 and 1 and returns a Vector3
     * @param slices — The count of slices to use for the parametric function
     * @param stacks — The count of stacks to use for the parametric function
     */
    @JsConstructor
    public ParametricGeometry(ParametricGeometryFunction func, int slices, int stacks) {

    }

}
