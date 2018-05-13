package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.geometries.parameters.OctahedronGeometryParameters;

/**
 * A class for generating an octahedron geometry.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class OctahedronGeometry extends Geometry {

    public OctahedronGeometryParameters parameters;

    /**
     * @param radius — Radius of the octahedron. Default is 1.
     * @param detail — Default is 0. Setting this to a value greater than zero add vertices making it no longer an octahedron.
     */
    public OctahedronGeometry(float radius, int detail) {

    }
}
