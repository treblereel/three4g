package org.treblereel.gwt.three4g.extras.curves;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.CatmullRomCurve3", namespace = JsPackage.GLOBAL)
public class CatmullRomCurve3 extends Curve {

    public CatmullRomCurve3() {

    }

    public CatmullRomCurve3(Vector3[] points) {

    }

    public CatmullRomCurve3(Vector3[] points, boolean closed) {

    }

    public CatmullRomCurve3(Vector3[] points, boolean closed, String curveType) {

    }

    public CatmullRomCurve3(Vector3[] points, boolean closed, String curveType, double tension) {

    }

    public CatmullRomCurve3(JsArray<Vector3> points) {

    }

    public CatmullRomCurve3(JsArray<Vector3> points, boolean closed) {

    }

    public CatmullRomCurve3(JsArray<Vector3> points, boolean closed, String curveType) {

    }

    public CatmullRomCurve3(JsArray<Vector3> points, boolean closed, String curveType, double tension) {

    }

    public String type;

    public Vector3[] points;

    public String curveType;

    public double tension;

    public boolean closed;
}
