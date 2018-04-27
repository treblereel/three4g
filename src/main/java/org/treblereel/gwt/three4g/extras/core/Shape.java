package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Defines an arbitrary 2d shape plane using paths with optional holes. It can be used with ExtrudeGeometry, ShapeGeometry, to get points, or to get triangulated faces.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
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
     * divisions -- The fineness of the result.
     * <p>
     * Call getPoints on the shape and the .holes array, and return an object of the form:
     * {
     * shape
     * holes
     * } where shape and holes are arrays of Vector2s.
     *
     * @param divisions -- The fineness of the result.
     * @return
     */
    public native Vector2[] extractPoints(int divisions);

    /**
     * Get an array of Vector2s that represent the holes in the shape.
     *
     * @param divisions -- The fineness of the result.
     * @return
     */
    public native Vector2[] getPointsHoles(int divisions);


}
