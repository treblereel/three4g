package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.JsObject;
import org.treblereel.gwt.three4g.math.Vector;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Defines an arbitrary 2d shape plane using paths with optional holes. It can be used with ExtrudeGeometry, ShapeGeometry, to get points, or to get triangulated faces.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/27/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Shape extends Path {

    /**
     * An array of paths that define the holes in the shape.
     */
    public Path[] holes;

    @JsConstructor
    public Shape() {

    }

    @JsConstructor
    public Shape(Vector2[] points) {

    }

    /**
     * UUID of this object instance. This gets automatically assigned, so this shouldn't be edited.
     *
     * @return uuid
     */
    @JsProperty(name = "uuid")
    public native int getUuid();

    /**
     * Call getPoints on the shape and the .holes array, and return an object of the form:
     * {
     * shape
     * holes
     * } where shape and holes are arrays of Vector2s.
     *
     * @param divisions -- The fineness of the result.
     * @return JsPropertyMap as a holder for shape and holes
     */
    public native JsObject extractPoints(int divisions);

    @JsOverlay
    public Vector[] getShape(int divisions) {
        return getPoints(divisions);
    }

    @JsOverlay
    public Vector[] getHoles(int divisions) {
        return getHoles(divisions);
    }

    /**
     * Get an array of Vector2s that represent the holes in the shape.
     *
     * @param divisions -- The fineness of the result.
     * @return array of Vector2s that represent the holes in the shape.
     */
    public native Vector2[] getPointsHoles(int divisions);

}
