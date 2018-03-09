package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/9/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PlaneGeometry extends Geometry {

    /**
     * @param width  — Width along the X axis. Default is 1.
     * @param height — Height along the Y axis. Default is 1.
     */
    @JsConstructor
    public PlaneGeometry(int width, int height) {
    }

    /**
     * @param width  — Width along the X axis. Default is 1.
     * @param height — Height along the Y axis. Default is 1.
     * @param widthSegments — Default is 1.
     */
    @JsConstructor
    public PlaneGeometry(int width, int height, int widthSegments) {
    }

    /**
     * @param width  — Width along the X axis. Default is 1.
     * @param height — Height along the Y axis. Default is 1.
     * @param widthSegments — Default is 1.
     * @param heightSegments — Default is 1.
     */
    @JsConstructor
    public PlaneGeometry(int width, int height, int widthSegments, int heightSegments) {
    }
}
