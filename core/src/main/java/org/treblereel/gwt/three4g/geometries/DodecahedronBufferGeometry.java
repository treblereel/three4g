package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.DodecahedronGeometryParameters;

/**
 * A class for generating a dodecahedron geometries.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, name = "THREE.DodecahedronBufferGeometry", namespace = JsPackage.GLOBAL)
public class DodecahedronBufferGeometry extends BufferGeometry<DodecahedronBufferGeometry> {

    public DodecahedronGeometryParameters parameters;

    @JsConstructor
    public DodecahedronBufferGeometry(float radius, int detail) {

    }

}
