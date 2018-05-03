package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.parameters.ShapeGeometryParameters;

/**
 * Creates an one-sided polygonal geometry from one or more path shapes.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ShapeBufferGeometry extends BufferGeometry {

    public ShapeGeometryParameters parameters;

    /**
     * @param shape — a single shape.
     */
    public ShapeBufferGeometry(Shape shape) {

    }

    /**
     * @param shape         — a single shape.
     * @param curveSegments - Integer - Number of segments per shape. Default is 12.
     */
    public ShapeBufferGeometry(Shape shape, int curveSegments) {

    }

    /**
     * @param shapes - Array of shapes.
     */
    public ShapeBufferGeometry(Shape[] shapes) {

    }

    /**
     * @param shapes        —  Array of shapes.
     * @param curveSegments - Integer - Number of segments per shape. Default is 12.
     */
    public ShapeBufferGeometry(Shape[] shapes, int curveSegments) {

    }
}
