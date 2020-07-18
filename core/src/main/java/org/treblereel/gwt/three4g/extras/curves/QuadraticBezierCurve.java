package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Create a smooth 2d quadratic bezier curve, defined by a startpoint, endpoint and a single control point.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.QuadraticBezierCurve", namespace = JsPackage.GLOBAL)
public class QuadraticBezierCurve extends Curve {

    /**
     * Used to check whether this or derived classes are QuadraticBezierCurves. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isQuadraticBezierCurve;

    public Vector2 v0;

    public Vector2 v1;

    public Vector2 v2;

    /**
     * @param v0 – The startpoint.
     * @param v1 – The control point.
     * @param v2 – The endpoint.
     */
    public QuadraticBezierCurve(Vector2 v0, Vector2 v1, Vector2 v2) {

    }
}
