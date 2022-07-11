package org.treblereel.gwt.three4g.curves;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.NURBSSurface", namespace = JsPackage.GLOBAL)
public class NURBSSurface {


    public NURBSSurface(int degree1,
                        int degree2,
                        int[] knots1,
                        int[] knots2,
                        Vector[][] controlPoints) {

    }

    public NURBSSurface(double degree1,
                        double degree2,
                        double[] knots1,
                        double[] knots2,
                        Vector[][] controlPoints) {

    }

    public NURBSSurface(double degree1,
                        double degree2,
                        JsArray<Double> knots1,
                        JsArray<Double> knots2,
                        Vector[][] controlPoints) {

    }

    public NURBSSurface(double degree1,
                        double degree2,
                        double[] knots1,
                        double[] knots2,
                        JsArray<JsArray<Vector>> controlPoints) {
    }

    public NURBSSurface(double degree1,
                        double degree2,
                        JsArray<Double> knots1,
                        JsArray<Double> knots2,
                        JsArray<JsArray<Vector>> controlPoints) {
    }

    public native void getPoint(double t1, double t2, Vector3 target) ;

}
