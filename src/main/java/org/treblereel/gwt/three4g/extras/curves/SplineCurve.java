package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Create a smooth 2d spline curve from a series of points. Internally this uses Interpolations.CatmullRom to create the curve.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SplineCurve extends Curve {

    /**
     * Used to check whether this or derived classes are SplineCurves. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isSplineCurve;

    /**
     * The array of Vector2 points that define the curve.
     */
    public Vector2[] points;

    /**
     * @param points – An array of Vector2 points that define the curve.
     */
    public SplineCurve(Vector2[] points) {

    }
}
