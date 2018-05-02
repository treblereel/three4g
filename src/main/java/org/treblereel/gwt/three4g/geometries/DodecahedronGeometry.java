package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.DodecahedronGeometryParameters;

/**
 * A class for generating a dodecahedron geometries.


 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DodecahedronGeometry extends BufferGeometry {

    public DodecahedronGeometryParameters parameters;

    @JsConstructor
    public DodecahedronGeometry(float radius, int detail) {

    }

}
