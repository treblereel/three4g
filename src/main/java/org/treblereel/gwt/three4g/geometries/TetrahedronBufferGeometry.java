package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.TetrahedronGeometryParameters;

/**
 * A class for generating a tetrahedron geometries.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TetrahedronBufferGeometry extends BufferGeometry {

    public TetrahedronGeometryParameters parameters;

    /**
     * @param radius — Radius of the tetrahedron. Default is 1.
     * @param detail — Default is 0. Setting this to a value greater than 0 adds vertices making it no longer a tetrahedron.
     */
    public TetrahedronBufferGeometry(float radius, int detail) {

    }
}
