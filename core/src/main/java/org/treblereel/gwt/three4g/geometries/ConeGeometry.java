package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * A class for generating cone geometries
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, name = "THREE.ConeGeometry", namespace = JsPackage.GLOBAL)
public class ConeGeometry extends Geometry {

    public float radius;
    public float height;
    public int radialSegments;
    public int heightSegments;
    public boolean openEnded;
    public float thetaStart;
    public float thetaLength;

    /**
     * @param radius         — Radius of the cone base. Default is 1.
     * @param height         — Height of the cone. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cone. Default is 8
     */
    @JsConstructor
    public ConeGeometry(float radius, float height, int radialSegments) {

    }

    /**
     * @param radius         — Radius of the cone base. Default is 1.
     * @param height         — Height of the cone. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cone. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cone. Default is 1.
     */
    @JsConstructor
    public ConeGeometry(float radius, float height, int radialSegments, int heightSegments) {

    }

    /**
     * @param radius         — Radius of the cone base. Default is 1.
     * @param height         — Height of the cone. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cone. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cone. Default is 1.
     * @param openEnded      — A Boolean indicating whether the base of the cone is open or capped. Default is false, meaning capped.
     */
    @JsConstructor
    public ConeGeometry(float radius, float height, int radialSegments, int heightSegments, boolean openEnded) {

    }

    /**
     * @param radius         — Radius of the cone base. Default is 1.
     * @param height         — Height of the cone. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cone. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cone. Default is 1.
     * @param openEnded      — A Boolean indicating whether the base of the cone is open or capped. Default is false, meaning capped.
     * @param thetaStart     — Start angle for first segment, default = 0 (three o'clock position).
     */
    @JsConstructor
    public ConeGeometry(float radius, float height, int radialSegments, int heightSegments, boolean openEnded, float thetaStart) {

    }

    /**
     * @param radius         — Radius of the cone base. Default is 1.
     * @param height         — Height of the cone. Default is 1.
     * @param radialSegments — Number of segmented faces around the circumference of the cone. Default is 8
     * @param heightSegments — Number of rows of faces along the height of the cone. Default is 1.
     * @param openEnded      — A Boolean indicating whether the base of the cone is open or capped. Default is false, meaning capped.
     * @param thetaStart     — Start angle for first segment, default = 0 (three o'clock position).
     * @param thetaLength    — The central angle, often called theta, of the circular sector. The default is 2*Pi, which makes for a complete cone.
     */
    @JsConstructor
    public ConeGeometry(float radius, float height, int radialSegments, int heightSegments, boolean openEnded, float thetaStart, float thetaLength) {

    }
}
