package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * A curve representing a 3d line segment.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LineCurve3 extends Curve {

    /**
     * Used to check whether this or derived classes are LineCurves3. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isLineCurve3;

    public Vector3 v1;

    public Vector3 v2;

    /**
     * @param v1 – The start point.
     * @param v2 - The end point.
     */
    public LineCurve3(Vector3 v1, Vector3 v2) {

    }
}
