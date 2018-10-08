package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * CircleGeometry is a simple shape of Euclidean geometry. It is contructed from a number of triangular segments that are
 * oriented around a central point and extend as far out as a given radius. It is built counter-clockwise from a start
 * angle and a given central angle. It can also be used to create regular polygons, where the number of segments determines
 * the number of sides.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CircleGeometry extends Geometry {

    /**
     * @param radius      — Radius of the circle, default = 1.
     * @param segments    — Number of segments (triangles), minimum = 3, default = 8.
     */
    @JsConstructor
    public CircleGeometry(float radius, float segments) {

    }

    /**
     * @param radius      — Radius of the circle, default = 1.
     * @param segments    — Number of segments (triangles), minimum = 3, default = 8.
     * @param thetaStart  — Start angle for first segment, default = 0 (three o'clock position).
     */
    @JsConstructor
    public CircleGeometry(float radius, float segments, float thetaStart) {

    }

    /**
     * @param radius      — Radius of the circle, default = 1.
     * @param segments    — Number of segments (triangles), minimum = 3, default = 8.
     * @param thetaStart  — Start angle for first segment, default = 0 (three o'clock position).
     * @param thetaLength — The central angle, often called theta, of the circular sector. The default is 2*Pi, which makes for a complete circle.
     */
    @JsConstructor
    public CircleGeometry(float radius, float segments, float thetaStart, float thetaLength) {

    }
}
