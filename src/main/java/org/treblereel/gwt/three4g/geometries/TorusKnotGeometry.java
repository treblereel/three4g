package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * Creates a torus knot, the particular shape of which is defined by a pair of coprime integers, p and q. If p and q are
 * not coprime, the result will be a torus link.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TorusKnotGeometry extends Geometry {

    public float radius;
    public float tube;
    public int tubularSegments;
    public int radialSegments;
    public int p;
    public int q;

    public TorusKnotGeometry() {

    }

    /**
     * @param radius - Radius of the torus. Default is 1.
     */
    public TorusKnotGeometry(float radius) {

    }

    /**
     * @param radius - Radius of the torus. Default is 1.
     * @param tube   — Radius of the tube. Default is 0.4.
     */
    public TorusKnotGeometry(float radius, float tube) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     */
    public TorusKnotGeometry(float radius, float tube, int tubularSegments) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     * @param radialSegments  — Default is 8.
     */
    public TorusKnotGeometry(float radius, float tube, int tubularSegments, int radialSegments) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     * @param radialSegments  — Default is 8.
     * @param p               — This value determines, how many times the geometry winds around its axis of rotational symmetry. Default is 2.
     */
    public TorusKnotGeometry(float radius, float tube, int tubularSegments, int radialSegments, int p) {

    }

    /**
     * @param radius          - Radius of the torus. Default is 1.
     * @param tube            — Radius of the tube. Default is 0.4.
     * @param tubularSegments — Default is 64.
     * @param radialSegments  — Default is 8.
     * @param p               — This value determines, how many times the geometry winds around its axis of rotational symmetry. Default is 2.
     * @param q               — This value determines, how many times the geometry winds around a circle in the interior of the torus. Default is 3.
     */
    public TorusKnotGeometry(float radius, float tube, int tubularSegments, int radialSegments, int p, int q) {

    }

}
