package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * This is the BufferGeometry port of TorusGeometry.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TorusBufferGeometry extends BufferGeometry<TorusBufferGeometry> {

    public float radius;
    public float tube;
    public int radialSegments;
    public int tubularSegments;
    public float arc;

    public TorusBufferGeometry() {

    }

    /**
     * @param radius - Radius of the torus, from the center of the torus to the center of the tube. Default is 1.
     */
    public TorusBufferGeometry(float radius) {

    }

    /**
     * @param radius - Radius of the torus, from the center of the torus to the center of the tube. Default is 1.
     * @param tube   — Radius of the tube. Default is 0.4.
     */
    public TorusBufferGeometry(float radius, float tube) {

    }

    /**
     * @param radius         - Radius of the torus, from the center of the torus to the center of the tube. Default is 1.
     * @param tube           — Radius of the tube. Default is 0.4.
     * @param radialSegments — Default is 8
     */
    public TorusBufferGeometry(float radius, float tube, int radialSegments) {

    }

    /**
     * @param radius          - Radius of the torus, from the center of the torus to the center of the tube. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param radialSegments  — Default is 8
     * @param tubularSegments — Default is 6.
     */
    public TorusBufferGeometry(float radius, float tube, int radialSegments, int tubularSegments) {

    }

    /**
     * @param radius          - Radius of the torus, from the center of the torus to the center of the tube. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param radialSegments  — Default is 8
     * @param tubularSegments — Default is 6.
     * @param arc             — Central angle. Default is Math.PI * 2.
     */
    public TorusBufferGeometry(float radius, float tube, int radialSegments, int tubularSegments, float arc) {

    }
}
