package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.geometries.parameters.PolyhedronGeometryParameters;

/**
 * A polyhedron is a solid in three dimensions with flat faces. This class will take an array of vertices, project them
 * onto a sphere, and then divide them up to the desired level of detail.
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PolyhedronGeometry extends Geometry {

    public PolyhedronGeometryParameters parameters;

    /**
     * @param vertices — Array of points of the form [1,1,1, -1,-1,-1, ... ]
     * @param indices  — Array of indices that make up the faces of the form [0,1,2, 2,3,0, ... ]
     * @param radius   — Float - The radius of the final shape
     * @param detail   — Integer - How many levels to subdivide the geometry. The more detail, the smoother the shape.
     */
    public PolyhedronGeometry(int[] vertices, int[] indices, float radius, int detail) {

    }
}
