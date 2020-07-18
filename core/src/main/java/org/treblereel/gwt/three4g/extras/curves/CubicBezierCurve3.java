package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Create a smooth 3d cubic bezier curve, defined by a start point, endpoint and two control points.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.CubicBezierCurve3", namespace = JsPackage.GLOBAL)
public class CubicBezierCurve3 extends Curve {

    /**
     * Used to check whether this or derived classes are CubicBezierCurves3. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isCubicBezierCurve3;

    public Vector3 v0;

    public Vector3 v1;

    public Vector3 v2;

    public Vector3 v3;

    /**
     * @param v0 – The starting point.
     * @param v1 – The first control point.
     * @param v2 – The second control point.
     * @param v3 – The ending point.
     */
    public CubicBezierCurve3(Vector3 v0, Vector3 v1, Vector3 v2, Vector3 v3) {

    }

}
