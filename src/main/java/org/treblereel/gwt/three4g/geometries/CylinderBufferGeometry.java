package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * This is the BufferGeometry port of CylinderGeometry.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/21/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CylinderBufferGeometry extends BufferGeometry {

    /**
     * Radius of the cylinder at the top. Default is 1.
     */
    public float radiusTop;

    /**
     * Radius of the cylinder at the bottom. Default is 1.
     */
    public float radiusBottom;

    /**
     * Height of the cylinder. Default is 1.
     */
    public float height;

    /**
     * Number of segmented faces around the circumference of the cylinder. Default is 8
     */
    public int radialSegments;

    /**
     * Number of rows of faces along the height of the cylinder. Default is 1.
     */
    public int heightSegments;

    /**
     * A Boolean indicating whether the ends of the cylinder are open or capped. Default is false, meaning capped.
     */
    public boolean openEnded;

    /**
     * Start angle for first segment, default = 0 (three o'clock position).
     */
    public float thetaStart;

    /**
     * The central angle, often called theta, of the circular sector. The default is 2*Pi, which makes for a complete cylinder.
     */
    public float thetaLength;

    /**
     * @param radiusTop      — Radius of the cylinder at the top. Default is 1.
     * @param radiusBottom   — Radius of the cylinder at the bottom. Default is 1.
     * @param height         — Height of the cylinder. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cylinder. Default is 8
     */
    @JsConstructor
    public CylinderBufferGeometry(float radiusTop, float radiusBottom, float height, int radialSegments) {
    }

    /**
     * @param radiusTop      — Radius of the cylinder at the top. Default is 1.
     * @param radiusBottom   — Radius of the cylinder at the bottom. Default is 1.
     * @param height         — Height of the cylinder. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cylinder. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cylinder. Default is 1.
     */
    public CylinderBufferGeometry(float radiusTop, float radiusBottom, float height, int radialSegments, int heightSegments) {
    }

    /**
     * @param radiusTop      — Radius of the cylinder at the top. Default is 1.
     * @param radiusBottom   — Radius of the cylinder at the bottom. Default is 1.
     * @param height         — Height of the cylinder. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cylinder. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cylinder. Default is 1.
     * @param openEnded      — A Boolean indicating whether the ends of the cylinder are open or capped. Default is false, meaning capped.
     */
    public CylinderBufferGeometry(float radiusTop, float radiusBottom, float height, int radialSegments, int heightSegments,
                                  boolean openEnded) {
    }

    /**
     * @param radiusTop      — Radius of the cylinder at the top. Default is 1.
     * @param radiusBottom   — Radius of the cylinder at the bottom. Default is 1.
     * @param height         — Height of the cylinder. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cylinder. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cylinder. Default is 1.
     * @param openEnded      — A Boolean indicating whether the ends of the cylinder are open or capped. Default is false, meaning capped.
     * @param thetaStart     — Start angle for first segment, default = 0 (three o'clock position).
     */
    public CylinderBufferGeometry(float radiusTop, float radiusBottom, float height, int radialSegments, int heightSegments,
                                  boolean openEnded, float thetaStart) {
    }

    /**
     * @param radiusTop      — Radius of the cylinder at the top. Default is 1.
     * @param radiusBottom   — Radius of the cylinder at the bottom. Default is 1.
     * @param height         — Height of the cylinder. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cylinder. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cylinder. Default is 1.
     * @param openEnded      — A Boolean indicating whether the ends of the cylinder are open or capped. Default is false, meaning capped.
     * @param thetaStart     — Start angle for first segment, default = 0 (three o'clock position).
     * @param thetaLength    — The central angle, often called theta, of the circular sector. The default is 2*Pi, which makes for a complete cylinder.
     */
    @JsConstructor
    public CylinderBufferGeometry(float radiusTop, float radiusBottom, float height, int radialSegments, int heightSegments,
                                  boolean openEnded, float thetaStart, float thetaLength) {

    }
}
