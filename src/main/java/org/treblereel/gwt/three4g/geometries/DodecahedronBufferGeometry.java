package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.DodecahedronGeometryParameters;

/**
 * A class for generating a dodecahedron geometries.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DodecahedronBufferGeometry extends BufferGeometry {

    public DodecahedronGeometryParameters parameters;

    @JsConstructor
    public DodecahedronBufferGeometry(float radius, int detail) {

    }

}
