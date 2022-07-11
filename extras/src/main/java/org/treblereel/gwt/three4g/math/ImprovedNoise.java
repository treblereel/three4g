package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.ImprovedNoise", namespace = JsPackage.GLOBAL)
public class ImprovedNoise {

    public native double noise(double x, double y, double z);
}
