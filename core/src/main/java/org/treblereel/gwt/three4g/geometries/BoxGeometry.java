package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.geometries.parameters.BoxGeometryParameters;

/**
 * BoxGeometry is the quadrilateral primitive geometry class. It is typically used for creating a cube or irregular
 * quadrilateral of the dimensions provided with the 'width', 'height', and 'depth' constructor arguments.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/7/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BoxGeometry extends Geometry {

    public BoxGeometryParameters parameters;

    @JsConstructor
    public BoxGeometry() {
    }

    /**
     * @param width  — Width of the sides on the X axis. Default is 1.
     * @param height — Height of the sides on the Y axis. Default is 1.
     * @param depth  — Depth of the sides on the Z axis. Default is 1.
     */
    @JsConstructor
    public BoxGeometry(float width, float height, float depth) {

    }

    /**
     * @param width          — Width of the sides on the X axis. Default is 1.
     * @param height         — Height of the sides on the Y axis. Default is 1.
     * @param depth          — Depth of the sides on the Z axis. Default is 1.
     * @param widthSegments  — Optional. Number of segmented faces along the width of the sides. Default is 1.
     * @param heightSegments — Optional. Number of segmented faces along the height of the sides. Default is 1.
     * @param depthSegments  — Optional. Number of segmented faces along the depth of the sides. Default is 1.
     */
    @JsConstructor
    public BoxGeometry(float width, float height, float depth, int widthSegments, int heightSegments, int depthSegments) {

    }
}
