package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * Creates meshes with axial symmetry like vases. The lathe rotates around the Y axis.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LatheGeometry extends Geometry {

    public Vector2[] points;
    public int segments;
    public float phiStart;
    public float phiLength;

    /**
     * @param points — Array of Vector2s. The x-coordinate of each point must be greater than zero.
     */
    public LatheGeometry(Vector2[] points) {

    }

    /**
     * @param points   — Array of Vector2s. The x-coordinate of each point must be greater than zero.
     * @param segments — the number of circumference segments to generate. Default is 12.
     */
    public LatheGeometry(Vector2[] points, int segments) {

    }

    /**
     * @param points   — Array of Vector2s. The x-coordinate of each point must be greater than zero.
     * @param segments — the number of circumference segments to generate. Default is 12.
     * @param phiStart — the starting angle in radians. Default is 0.
     */
    public LatheGeometry(Vector2[] points, int segments, float phiStart) {

    }

    /**
     * @param points    — Array of Vector2s. The x-coordinate of each point must be greater than zero.
     * @param segments  — the number of circumference segments to generate. Default is 12.
     * @param phiStart  — the starting angle in radians. Default is 0.
     * @param phiLength — the radian (0 to 2PI) range of the lathed section 2PI is a closed lathe, less than 2PI is a portion. Default is 2PI.
     */
    public LatheGeometry(Vector2[] points, int segments, float phiStart, float phiLength) {

    }

}

