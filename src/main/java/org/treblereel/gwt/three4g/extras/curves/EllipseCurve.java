package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;

/**
 * Creates a 2d curve in the shape of an ellipse. Setting the xRadius equal to the yRadius will result in a circle.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class EllipseCurve extends Curve {

    public float aX;

    public float aY;

    public float xRadius;

    public float yRadius;

    public float aStartAngle;

    public float aEndAngle;

    public boolean aClockwise;

    public float aRotation;

    /**
     * Used to check whether this or derived classes are ellipses. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isEllipseCurve;


    protected EllipseCurve(){

    }


    /**
     * @param aX          – The X center of the ellipse. Default is 0.
     * @param aY          – The Y center of the ellipse. Default is 0.
     * @param xRadius     – The radius of the ellipse in the x direction. Default is 1.
     * @param yRadius     – The radius of the ellipse in the y direction. Default is 1.
     * @param aStartAngle – The start angle of the curve in radians starting from the middle right side. Default is 0.
     * @param aEndAngle   – The end angle of the curve in radians starting from the middle right side. Default is 2 x Math.PI.
     * @param aClockwise  – Whether the ellipse is drawn clockwise. Default is false.
     */
    public EllipseCurve(float aX, float aY, float xRadius, float yRadius, float aStartAngle, float aEndAngle, boolean aClockwise) {

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
    public EllipseCurve(float aX, float aY, float xRadius, float yRadius, float aStartAngle, float aEndAngle, boolean aClockwise, float aRotation) {

    }


}
