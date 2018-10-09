package org.treblereel.gwt.three4g.extensions.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
@Three4gElement(paths = "js/geometries/BoxLineGeometry.js")
@JsType(isNative = true, namespace = "THREE")
public class BoxLineGeometry extends BufferGeometry {

    /**
     * @param width          — Width of the sides on the X axis. Default is 1.
     * @param height         — Height of the sides on the Y axis. Default is 1.
     * @param depth          — Depth of the sides on the Z axis. Default is 1.
     * @param widthSegments  —  Number of segmented faces along the width of the sides. Default is 1.
     * @param heightSegments —  Number of segmented faces along the height of the sides. Default is 1.
     * @param depthSegments  —  Number of segmented faces along the depth of the sides. Default is 1.
     */
    @JsConstructor
    public BoxLineGeometry(float width, float height, float depth, int widthSegments, int heightSegments, int depthSegments) {

    }
}
