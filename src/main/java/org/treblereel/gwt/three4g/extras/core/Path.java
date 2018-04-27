package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * A 2D path representation. The class provides methods for creating paths and contours of 2D shapes similar to the 2D Canvas API.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/27/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Path extends CurvePath {

    public Vector2 currentPoint; //TODO check this

    @JsConstructor
    public Path() {

    }

    @JsConstructor
    public Path(Vector2[] points) {

    }

    /**
     * Adds an absolutely positioned EllipseCurve to the path.
     *
     * @param x,         y -- The absolute center of the arc.
     * @param radius     -- The radius of the arc.
     * @param startAngle -- The start angle in radians.
     * @param endAngle   -- The end angle in radians.
     * @param clockwise  -- Sweep the arc clockwise. Defaults to false.
     */
    public native void absarc(float x, float y, float radius, float startAngle, float endAngle, float clockwise);

    /**
     * Adds an absolutely positioned EllipseCurve to the path.
     *
     * @param x,         y -- The absolute center of the ellipse.
     * @param xRadius    -- The radius of the ellipse in the x axis.
     * @param yRadius    -- The radius of the ellipse in the y axis.
     * @param startAngle -- The start angle in radians.
     * @param endAngle   -- The end angle in radians.
     * @param clockwise  -- Sweep the ellipse clockwise. Defaults to false.
     */
    public native void absellipse(float x, float y, float xRadius, float yRadius, float startAngle, float endAngle, float clockwise);

    /**
     * Adds an absolutely positioned EllipseCurve to the path.
     *
     * @param x,         y -- The absolute center of the ellipse.
     * @param xRadius    -- The radius of the ellipse in the x axis.
     * @param yRadius    -- The radius of the ellipse in the y axis.
     * @param startAngle -- The start angle in radians.
     * @param endAngle   -- The end angle in radians.
     * @param clockwise  -- Sweep the ellipse clockwise. Defaults to false.
     * @param rotation   -- The rotation angle of the ellipse in radians, counterclockwise from the positive X axis.
     */
    public native void absellipse(float x, float y, float xRadius, float yRadius, float startAngle, float endAngle, float clockwise, float rotation);

    /**
     * Adds an EllipseCurve to the path, positioned relative to .currentPoint.
     *
     * @param x,         y -- The center of the arc offset from the last call.
     * @param radius     -- The radius of the arc.
     * @param startAngle -- The start angle in radians.
     * @param endAngle   -- The end angle in radians.
     * @param clockwise  -- Sweep the arc clockwise. Defaults to false.
     */
    public native void arc(float x, float y, float radius, float startAngle, float endAngle, float clockwise);

    /**
     * This creates a bezier curve from .currentPoint with (cp1X, cp1Y) and (cp2X, cp2Y) as control points and updates .currentPoint to x and y.
     *
     * @param cp1X
     * @param cp1Y
     * @param cp2X
     * @param cp2Y
     * @param x
     * @param y
     */
    public native void bezierCurveTo(float cp1X, float cp1Y, float cp2X, float cp2Y, float x, float y);

    /**
     * @param x,         y -- The center of the ellipse offset from the last call.
     * @param xRadius    -- The radius of the ellipse in the x axis.
     * @param yRadius    -- The radius of the ellipse in the y axis.
     * @param startAngle -- The start angle in radians.
     * @param endAngle   -- The end angle in radians.
     * @param clockwise  -- Sweep the ellipse clockwise. Defaults to false.
     */
    public native void ellipse(float x, float y, float xRadius, float yRadius, float startAngle, float endAngle, float clockwise);

    /**
     * @param x,         y -- The center of the ellipse offset from the last call.
     * @param xRadius    -- The radius of the ellipse in the x axis.
     * @param yRadius    -- The radius of the ellipse in the y axis.
     * @param startAngle -- The start angle in radians.
     * @param endAngle   -- The end angle in radians.
     * @param clockwise  -- Sweep the ellipse clockwise. Defaults to false.
     * @param rotation   -- The rotation angle of the ellipse in radians, counterclockwise from the positive X axis.
     */
    public native void ellipse(float x, float y, float xRadius, float yRadius, float startAngle, float endAngle, float clockwise, float rotation);

    /**
     * connects a LineCurve from .currentPoint to x, y onto the path.
     *
     * @param x
     * @param y
     */
    public native void lineTo(float x, float y);

    /**
     * Move the .currentPoint to x, y.
     *
     * @param x
     * @param y
     */
    public native void moveTo(float x, float y);

    /**
     * Creates a quadratic curve from .currentPoint with cpX and cpY as control point and updates .currentPoint to x and y.
     *
     * @param cpX
     * @param cpY
     * @param x
     * @param y
     */
    public native void quadraticCurveTo(float cpX, float cpY, float x, float y);

    /**
     * Points are added to the curves array as LineCurves.
     *
     * @param points -- array of Vector2s.
     */
    public native void setFromPoints(Vector2 points);

    /**
     * Connects a new SplineCurve onto the path.
     * @param points - An array of Vector2s
     */
    public native void splineThru(Vector2 points);


}
