package org.treblereel.gwt.three4g.curves;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;

@JsType(isNative = true, name = "THREE.Curves.VivianiCurve", namespace = JsPackage.GLOBAL)
public class VivianiCurve extends Curve {

    public double scale;

    public VivianiCurve(double scale) {

    }
}
