package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Create a smooth 3d spline curve from a series of points using the Catmull-Rom algorithm.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.CatmullRomCurve3", namespace = JsPackage.GLOBAL)
public class CatmullRomCurve3 extends Curve {

    /**
     * Used to check whether this or derived classes are CatmullRomCurve3s. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isCatmullRomCurve3;

    public Vector3[] points;

    public boolean closed;

    public String curveType;

    public float tension;

    /**
     * @param points – An array of Vector3 points
     */
    public CatmullRomCurve3(Vector3[] points) {

    }

    /**
     * @param points – An array of Vector3 points
     * @param closed – Whether the curve is closed. Default is false.
     */
    public CatmullRomCurve3(Vector3[] points, boolean closed) {

    }

    /**
     * @param points    – An array of Vector3 points
     * @param closed    – Whether the curve is closed. Default is false.
     * @param curveType – Type of the curve. Default is centripetal.
     */
    public CatmullRomCurve3(Vector3[] points, boolean closed, String curveType) {

    }

    /**
     * @param points    – An array of Vector3 points
     * @param closed    – Whether the curve is closed. Default is false.
     * @param curveType – Type of the curve. Default is centripetal.
     * @param tension   – Tension of the curve. Default is 0.5.
     */
    public CatmullRomCurve3(Vector3[] points, boolean closed, String curveType, float tension) {

    }
}
