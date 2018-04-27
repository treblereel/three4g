package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/27/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Interpolations {

    /**
     * Used internally by QuadraticBezierCurve3, QuadraticBezierCurve and Font.
     *
     * @param t -- interpolation weight.
     * @param p0, p1, p2 -- the starting, control and end points defining the curve.
     * @return
     */
    @JsMethod(name = "CatmullRom")
    public native float catmullRom(float t, float p0, float p1, float p2, float p3);

    /**
     * Used internally by CubicBezierCurve3, CubicBezierCurve and Font.
     *
     * @param t -- interpolation weight.
     * @param p0, p1, p2, p3 -- the starting, control(twice) and end points defining the curve.
     * @return
     */
    @JsMethod(name = "CubicBezier")
    public native float cubicBezier(float t, float p0, float p1, float p2, float p3);


}
