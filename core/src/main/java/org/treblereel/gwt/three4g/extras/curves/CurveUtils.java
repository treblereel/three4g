package org.treblereel.gwt.three4g.extras.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.CatmullRomCurve3.CurveUtils", namespace = JsPackage.GLOBAL)
public class CurveUtils {

    public native static double tangentQuadraticBezier(double t, double p0, double p1, double p2);
    public native static double tangentCubicBezier(double t, double p0, double p1, double p2, double p3);
    public native static double tangentSpline(double t, double p0, double p1, double p2, double p3);
    public native static double interpolate(double p0, double p1, double p2, double p3, double t);

}
