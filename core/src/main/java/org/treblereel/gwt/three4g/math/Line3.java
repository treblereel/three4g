package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Line3 {

    /**
     * Vector3 representing the start point of the line.
     */
    public Vector3 start;

    /**
     * Vector3 representing the end point of the line.
     */
    public Vector3 end;

    /**
     * Creates a new Line3.
     */
    @JsConstructor
    public Line3() {

    }

    /**
     * Creates a new Line3.
     *
     * @param start - Start of the line segment. Default is (0, 0, 0).
     * @param end   - End of the line segment. Default is (0, 0, 0).
     */
    @JsConstructor
    public Line3(Vector3 start, Vector3 end) {

    }

    /**
     * Applies a matrix transform to the line segment.
     *
     * @param matrix instance of matrix4
     * @return instance of Line3
     */
    public native Line3 applyMatrix4(Matrix4 matrix);

    /**
     * Returns a vector at a certain position along the line. When t = 0, it returns the start vector, and when t = 1 it returns the end vector.
     *
     * @param t      - Use values 0-1 to return a position along the line segment.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 at(float t, Vector3 target);

    /**
     * Returns a new Line3 with the same start and end vectors as this one.
     *
     * @return instance of Line3
     */
    public native Line3 clone();

    /**
     * Returns the closets point on the line. If clampToLine is true, then the returned value will be clamped to the line segment.
     *
     * @param point       - return the closest point on the line to this point.
     * @param clampToLine - whether to clamp the returned value to the line segment.
     * @param target      — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 closestPointToPoint(Vector3 point, boolean clampToLine, Vector3 target);

    /**
     * @param point       - the point for which to return a point parameter.
     * @param clampToLine - Whether to clamp the result to the range [0, 1].
     * @return Returns a point parameter based on the closest point as projected on the line segement. If clampToLine is true, then the returned value will be between 0 and 1
     */
    public native float closestPointToPointParameter(Vector3 point, boolean clampToLine);

    /**
     * Copies the passed line's start and end vectors to this line.
     *
     * @param line instance of Line
     * @return instance of Line
     */
    public native Line3 copy(Line3 line);

    /**
     * @param target — the result will be copied into this Vector3.
     * @return Returns the delta vector of the line segment ( end vector minus the start vector).
     */
    public native Vector3 delta(Vector3 target);

    /**
     * @return Returns the Euclidean distance (straight-line distance) between the line's start and end points.
     */
    public native float distance();

    /**
     * @return Returns the square of the Euclidean distance (straight-line distance) between the line's start and end vectors.
     */
    public native float distanceSq();

    /**
     * @param line - Line3 to compare with this one.
     * @return Returns true if both line's start and en points are equal.
     */
    public native boolean equals(Line3 line);

    /**
     * @param target — the result will be copied into this Vector3.
     * @return Returns the center of the line segment.
     */
    public native Vector3 getCenter(Vector3 target);

    /**
     * @param start - set the start point of the line.
     * @param end   - set the end point of the line.
     * @return Sets the start and end values by copying the provided vectors.
     */
    public native Line3 set(Vector3 start, Vector3 end);


}
