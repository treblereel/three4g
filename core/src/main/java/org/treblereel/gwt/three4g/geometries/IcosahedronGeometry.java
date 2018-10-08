package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.geometries.parameters.IcosahedronGeometryParameters;

/**
 * A class for generating an icosahedron geometry.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class IcosahedronGeometry extends Geometry {

    public IcosahedronGeometryParameters parameters;

    /**
     * @param radius — Default is 1.
     * @param detail — Default is 0. Setting this to a value greater than 0 adds more vertices making it no longer an
     *               icosahedron. When detail is greater than 1, it's effectively a sphere.
     */
    public IcosahedronGeometry(float radius, int detail) {

    }

}
