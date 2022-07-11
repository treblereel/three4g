package org.treblereel.gwt.three4g.curves;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector;

@JsType(isNative = true, name = "THREE.NURBSCurve", namespace = JsPackage.GLOBAL)
public class NURBSCurve extends Curve {

    public JsArray controlPoints;

    public NURBSCurve(
            double degree,
            double[] knots,
            Vector[] controlPoints) {

    }

    public NURBSCurve(
            double degree,
            JsArray<Double> knots,
            Vector[] controlPoints) {

    }

    public NURBSCurve(
            double degree,
            double[] knots,
            JsArray<Vector> controlPoints) {

    }

    public NURBSCurve(
            double degree,
            JsArray<Double> knots,
            JsArray<Vector> controlPoints) {

    }


    public NURBSCurve(
            double degree,
            double[] knots,
            Vector[] controlPoints,
            double startKnot,
            double endKnot) {

    }

    public NURBSCurve(
            double degree,
            JsArray<Double> knots,
            Vector[] controlPoints,
            double startKnot,
            double endKnot) {

    }

    public NURBSCurve(
            double degree,
            double[] knots,
            JsArray<Vector> controlPoints,
            double startKnot,
            double endKnot) {

    }

    public NURBSCurve(
            double degree,
            JsArray<Double> knots,
            JsArray<Vector> controlPoints,
            double startKnot,
            double endKnot) {

    }
}
