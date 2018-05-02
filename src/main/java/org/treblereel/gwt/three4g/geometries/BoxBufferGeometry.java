package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/7/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BoxBufferGeometry extends BufferGeometry {

    /**
     * @param width  — Width of the sides on the X axis. Default is 1.
     * @param height — Height of the sides on the Y axis. Default is 1.
     * @param depth  — Depth of the sides on the Z axis. Default is 1.
     */
    @JsConstructor
    public BoxBufferGeometry(float width, float height, float depth) {

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
    public BoxBufferGeometry(float width, float height, float depth, int widthSegments, int heightSegments, int depthSegments) {

    }
}
