package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.parameters.ShapeGeometryParameters;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ShapeGeometry extends Geometry {

    public ShapeGeometryParameters parameters;

    /**
     * @param shape — a single shape.
     */
    public ShapeGeometry(Shape shape) {

    }

    /**
     * @param shape         — a single shape.
     * @param curveSegments - Integer - Number of segments per shape. Default is 12.
     */
    public ShapeGeometry(Shape shape, int curveSegments) {

    }

    /**
     * @param shapes - Array of shapes.
     */
    public ShapeGeometry(Shape[] shapes) {

    }

    /**
     * @param shapes        —  Array of shapes.
     * @param curveSegments - Integer - Number of segments per shape. Default is 12.
     */
    public ShapeGeometry(Shape[] shapes, int curveSegments) {

    }
}