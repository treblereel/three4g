package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * A series of lines drawn between pairs of vertices.
 * <p>
 * This is nearly the same	as Line; the only difference is that it is rendered using gl.LINES instead of gl.LINE_STRIP.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LineSegments extends Line {

    /**
     *
     */
    public boolean isLineSegments;

    @JsConstructor
    public LineSegments() {

    }

    /**
     * If no material is supplied, a randomized line material will be created and assigned to the object.
     *
     * @param geometry — vertices representing the line segment(s). Default is a new BufferGeometry.
     * @param material — material for the line. Default is a new LineBasicMaterial with random color.
     */
    @JsConstructor
    public LineSegments(Geometry geometry, Material material) {

    }

}
