package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Create a smooth 2d cubic bezier curve, defined by a start point, endpoint and two control points.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.CubicBezierCurve", namespace = JsPackage.GLOBAL)
public class CubicBezierCurve extends Curve {

    /**
     * Used to check whether this or derived classes are CubicBezierCurves. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isCubicBezierCurve;

    public Vector2 v0;

    public Vector2 v1;

    public Vector2 v2;

    public Vector2 v3;

    /**
     * @param v0 – The starting point.
     * @param v1 – The first control point.
     * @param v2 – The second control point.
     * @param v3 – The ending point.
     */
    public CubicBezierCurve(Vector2 v0, Vector2 v1, Vector2 v2, Vector2 v3) {

    }

}
