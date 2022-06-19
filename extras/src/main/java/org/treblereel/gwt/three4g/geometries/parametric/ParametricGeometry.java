package org.treblereel.gwt.three4g.geometries.parametric;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.ParametricGeometry", namespace = JsPackage.GLOBAL)
public class ParametricGeometry extends BufferGeometry {

    public ParametricGeometry() {

    }

    public ParametricGeometry(ParametricGeometriesFunction func) {

    }

    public ParametricGeometry(ParametricGeometriesFunction func, double slices) {

    }

    public ParametricGeometry(ParametricGeometriesFunction func, double slices, double stacks) {

    }

    public ParametricGeometryParam parameters;

}
