package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsType;

/**
 * A geometric triangle as defined by three Vector3s representing its three corners.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Triangle {

    /**
     * The first corner of the triangle. Default is a Vector3 at (0, 0, 0).
     */
    public Vector3 a;

    /**
     * The second corner of the triangle. Default is a Vector3 at (0, 0, 0).
     */

    public Vector3 b;
    /**
     * the final corner of the triangle. Default is a Vector3 at (0, 0, 0)
     */
    public Vector3 c;

    /**
     * Creates a new Triangle.
     * @param a - the first corner of the triangle. Default is a Vector3 at (0, 0, 0).
     * @param b - the second corner of the triangle. Default is a Vector3 at (0, 0, 0).
     * @param c - the final corner of the triangle. Default is a Vector3 at (0, 0, 0).
     */
    public Triangle(Vector3 a, Vector3 b, Vector3 c) {

    }

    public native static boolean isFrontFacing(Vector3 a, Vector3 b, Vector3 c, Vector3 direction);

    /**
     * @return Returns a new triangle with the same a, b and c properties as this one.
     */
    public native Triangle clone();

    /**
     * @param point - Vector3
     * @param target — the result will be copied into this Vector3.
     * @return Returns the closest point on the triangle to point.
     */
    public native Vector3 closestPointToPoint(Vector3 point, Vector3 target);

    /**
     * @param point - Vector3 to check.
     * @return Returns true if the passed point, when projected onto the plane of the triangle, lies within the triangle.
     */
    public native boolean containsPoint(Vector3 point);

    /**
     * Copies the values of the passed triangles's a, b and c properties to this triangle.
     * @param triangle instance of Triangle
     * @return instance of Triangle
     */
    public native Triangle copy(Triangle triangle);

    /**
     * @param triangle - Triangle to compare with this one.
     * @return Returns true if the two triangles have identical a, b and c properties.
     */
    public native boolean equals(Triangle triangle);

    /**
     * @return Return the area of the triangle.
     */
    public native float getArea();

    /**
     * @param point - Vector3
     * @param target — the result will be copied into this Vector3.
     * @return Return a barycentric coordinate from the given vector.
     */
    public native Vector3 getBarycoord(Vector3 point, Vector3 target);

    /**
     * @param target — the result will be copied into this Vector3.
     * @return Calculate the midpoint of the triangle.
     */
    public native Vector3 getMidpoint(Vector3 target);

    /**
     * @param target — the result will be copied into this Vector3.
     * @return Calculate the normal vector of the triangle.
     */
    public native Vector3 getNormal(Vector3 target);

    /**
     * @param target — the result will be copied into this Plane.
     * @return Calculate a plane based on the triangle. .
     */
    public native Plane getPlane(Plane target);

    /**
     * @param box - Box to check for intersection against.
     * @return Determines whether or not this triangle intersects box.
     */
    public native boolean intersectsBox(Box3 box);

    /**
     * @param a corner of the triangle
     * @param b corner of the triangle
     * @param c corner of the triangle
     * @return instance of Triangle
     */
    public native Triangle set(Vector3 a, Vector3 b, Vector3 c);

    /**
     * Sets the triangle's vectors to the vectors in the array.
     * @param points - Array of Vector3s
     * @param i0 - Integer index
     * @param i1 - Integer index
     * @param i2 - Integer index
     * @return instance of Triangle
     */
    public native Triangle setFromPointsAndIndices(Vector3[] points, int i0, int i1, int i2);

    public native boolean isFrontFacing(Vector3 direction);
}
