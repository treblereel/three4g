package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * This is the BufferGeometry port of TorusKnotGeometry.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TorusKnotBufferGeometry extends BufferGeometry<TorusKnotBufferGeometry> {

    public float radius;
    public float tube;
    public int tubularSegments;
    public int radialSegments;
    public int p;
    public int q;

    public TorusKnotBufferGeometry() {

    }

    /**
     * @param radius - Radius of the torus. Default is 1.
     */
    public TorusKnotBufferGeometry(float radius) {

    }

    /**
     * @param radius - Radius of the torus. Default is 1.
     * @param tube   — Radius of the tube. Default is 0.4.
     */
    public TorusKnotBufferGeometry(float radius, float tube) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     */
    public TorusKnotBufferGeometry(float radius, float tube, int tubularSegments) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     * @param radialSegments  — Default is 8.
     */
    public TorusKnotBufferGeometry(float radius, float tube, int tubularSegments, int radialSegments) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     * @param radialSegments  — Default is 8.
     * @param p               — This value determines, how many times the geometry winds around its axis of rotational symmetry. Default is 2.
     */
    public TorusKnotBufferGeometry(float radius, float tube, int tubularSegments, int radialSegments, int p) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     * @param radialSegments  — Default is 8.
     * @param p               — This value determines, how many times the geometry winds around its axis of rotational symmetry. Default is 2.
     * @param q               — This value determines, how many times the geometry winds around a circle in the interior of the torus. Default is 3.
     */
    public TorusKnotBufferGeometry(float radius, float tube, int tubularSegments, int radialSegments, int p, int q) {

    }

}
