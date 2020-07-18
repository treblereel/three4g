package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

/**
 * This is the BufferGeometry port of CircleGeometry.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, name = "THREE.CircleBufferGeometry", namespace = JsPackage.GLOBAL)
public class CircleBufferGeometry extends BufferGeometry<CircleBufferGeometry> {

    /**
     * @param radius      — Radius of the circle, default = 1.
     * @param segments    — Number of segments (triangles), minimum = 3, default = 8.
     */
    @JsConstructor
    public CircleBufferGeometry(float radius, float segments) {

    }

    /**
     * @param radius      — Radius of the circle, default = 1.
     * @param segments    — Number of segments (triangles), minimum = 3, default = 8.
     * @param thetaStart  — Start angle for first segment, default = 0 (three o'clock position).
     */
    @JsConstructor
    public CircleBufferGeometry(float radius, float segments, float thetaStart) {

    }

    /**
     * @param radius      — Radius of the circle, default = 1.
     * @param segments    — Number of segments (triangles), minimum = 3, default = 8.
     * @param thetaStart  — Start angle for first segment, default = 0 (three o'clock position).
     * @param thetaLength — The central angle, often called theta, of the circular sector. The default is 2*Pi, which makes for a complete circle.
     */
    @JsConstructor
    public CircleBufferGeometry(float radius, float segments, float thetaStart, float thetaLength) {

    }

}
