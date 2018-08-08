package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/12/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PlaneBufferGeometry extends BufferGeometry<PlaneBufferGeometry> {

    public float width; // — Width along the X axis. Default is 1.

    public float height; // — Height along the Y axis. Default is 1.

    public int widthSegments; // — Default is 1.

    public int heightSegments; // — Default is 1.

    /**
     * @param width  — Width along the X axis. Default is 1.
     * @param height — Height along the Y axis. Default is 1.
     */
    @JsConstructor
    public PlaneBufferGeometry(float width, float height) {
    }

    /**
     * @param width         — Width along the X axis. Default is 1.
     * @param height        — Height along the Y axis. Default is 1.
     * @param widthSegments — Default is 1.
     */
    @JsConstructor
    public PlaneBufferGeometry(float width, float height, int widthSegments) {
    }

    /**
     * @param width          — Width along the X axis. Default is 1.
     * @param height         — Height along the Y axis. Default is 1.
     * @param widthSegments  — Default is 1.
     * @param heightSegments — Default is 1.
     */
    @JsConstructor
    public PlaneBufferGeometry(float width, float height, int widthSegments, int heightSegments) {
    }

}
