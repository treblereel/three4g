package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector2;

/**
 * This class is used to convert a series of shapes to an array of Paths, for example an SVG shape to a path (see the example below).
 * It is used internally by Font to convert a font in JSON format to a series of paths.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/27/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ShapePath {

    /**
     * Array of Paths.
     */
    public Path[] subPaths;

    /**
     * The current Path that is being generated.
     */
    public Path[] currentPath;


    @JsConstructor
    public ShapePath() {

    }

    /**
     * Starts a new Path and calls Path.moveTo( x, y ) on that Path. Also points currentPath to that Path.
     */
    public native void moveTo(float x, float y);

    /**
     * This creates a line from the currentPath's offset to X and Y and updates the offset to X and Y.
     */
    public native void lineTo(float x, float y);


    /**
     * This creates a quadratic curve from the currentPath's offset to x and y with cpX and cpY as control point and updates
     * the currentPath's offset to x and y.
     *
     * @param cpX
     * @param cpY
     * @param x
     * @param y
     */
    public native void quadraticCurveTo(float cpX, float cpY, float x, float y);

    /**
     * This creates a bezier curve from the currentPath's offset to x and y with cp1X, cp1Y and cp1X, cp1Y as control points
     * and updates the currentPath's offset to x and y.
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
     * Connects a new SplineCurve onto the currentPath.
     *
     * @param points - An array of Vector2s
     */
    public native void splineThru(Vector2 points);

    /**
     * Converts the subPaths array into an array of Shapes. By default solid shapes are defined clockwise (CW) and holes
     * are defined counterclockwise (CCW). If isCCW is set to true, then those are flipped. If the parameter noHoles is
     * set to true then all paths are set as solid shapes and isCCW is ignored.
     *
     * @param isCCW   -- Changes how solids and holes are generated
     * @param noHoles -- Whether or not to generate holes
     * @return
     */
    public native Shape[] toShapes(boolean isCCW, boolean noHoles);
}
