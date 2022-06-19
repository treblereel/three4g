package org.treblereel.gwt.three4g.geometries.parametric;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.ParametricGeometries", namespace = JsPackage.GLOBAL)
public class ParametricGeometries {

    public static ParametricGeometriesFunction klein;

    public static native ParametricGeometriesFunction plane(double width, double height);

    public static ParametricGeometriesFunction mobius;

    public static ParametricGeometriesFunction mobius3d;
}
