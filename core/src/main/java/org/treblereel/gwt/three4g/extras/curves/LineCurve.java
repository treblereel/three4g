package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * A curve representing a 2d line segment.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.LineCurve", namespace = JsPackage.GLOBAL)
public class LineCurve extends Curve {

    /**
     * Used to check whether this or derived classes are LineCurves. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isLineCurve;

    public Vector2 v1;

    public Vector2 v2;

    /**
     * @param v1 – The start point.
     * @param v2 - The end point.
     */
    public LineCurve(Vector2 v1, Vector2 v2) {

    }
}
