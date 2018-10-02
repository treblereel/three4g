package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Create a smooth 3d quadratic bezier curve, defined by a startpoint, endpoint and a single control point.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class QuadraticBezierCurve3 extends Curve {

    /**
     * Used to check whether this or derived classes are QuadraticBezierCurves3. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isQuadraticBezierCurve3;

    public Vector3 v0;

    public Vector3 v1;

    public Vector3 v2;

    /**
     * @param v0 – The startpoint.
     * @param v1 – The control point.
     * @param v2 – The endpoint.
     */
    public QuadraticBezierCurve3(Vector3 v0, Vector3 v1, Vector3 v2) {

    }
}
