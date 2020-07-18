package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Alias for EllipseCurve
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.ArcCurve", namespace = JsPackage.GLOBAL)
public class ArcCurve extends EllipseCurve {

    /**
     * Used to check whether this or derived classes are ArcCurves. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isArcCurve;

    /**
     * @param aX          – The X center of the ellipse. Default is 0.
     * @param aY          – The Y center of the ellipse. Default is 0.
     * @param xRadius     – The radius of the ellipse in the x direction. Default is 1.
     * @param yRadius     – The radius of the ellipse in the y direction. Default is 1.
     * @param aStartAngle – The start angle of the curve in radians starting from the middle right side. Default is 0.
     * @param aEndAngle   – The end angle of the curve in radians starting from the middle right side. Default is 2 x Math.PI.
     * @param aClockwise  – Whether the ellipse is drawn clockwise. Default is false.
     */
    public ArcCurve(float aX, float aY, float xRadius, float yRadius, float aStartAngle, float aEndAngle, boolean aClockwise) {

    }

    /**
     * @param aX          – The X center of the ellipse. Default is 0.
     * @param aY          – The Y center of the ellipse. Default is 0.
     * @param xRadius     – The radius of the ellipse in the x direction. Default is 1.
     * @param yRadius     – The radius of the ellipse in the y direction. Default is 1.
     * @param aStartAngle – The start angle of the curve in radians starting from the middle right side. Default is 0.
     * @param aEndAngle   – The end angle of the curve in radians starting from the middle right side. Default is 2 x Math.PI.
     * @param aClockwise  – Whether the ellipse is drawn clockwise. Default is false.
     * @param aRotation   – The rotation angle of the ellipse in radians, counterclockwise from the positive X axis (optional). Default is 0.
     */
    public ArcCurve(float aX, float aY, float xRadius, float yRadius, float aStartAngle, float aEndAngle, boolean aClockwise, float aRotation) {

    }

}
