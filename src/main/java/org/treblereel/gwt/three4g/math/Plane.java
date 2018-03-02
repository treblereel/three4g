package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * A two dimensional surface that extends infinitely in 3d space, represented in Hessian normal form by a unit
 * length normal vector and a constant.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Plane {

    /**
     * a unit length Vector3 defining the normal of the plane. Default is (1, 0, 0).
     */
    public Vector3 normal;

    /**
     * the signed distance from the origin to the plane. Default is 0.
     */
    public float constant;

    @JsConstructor
    public Plane() {

    }

    @JsConstructor
    public Plane(Vector3 vector3, float constant) {

    }

    /**
     * Apply a Matrix4 to the plane. The matrix must be an affine, homogeneous transform.
     *
     * @param matrix - the Matrix4 to apply.ix
     * @return
     */

    public native Plane applyMatrix4(Matrix4 matrix);

    /**
     * Apply a Matrix4 to the plane. The matrix must be an affine, homogeneous transform.
     * If supplying an optionalNormalMatrix, it can be created like so:
     * Matrix3 optionalNormalMatrix = new Matrix3().getNormalMatrix( matrix );
     *
     * @param matrix - the Matrix4 to apply.
     * @param optionalNormalMatrix - (optional) pre-computed normal Matrix3 of the Matrix4 being applied.
     * @return
     */
    public native Plane applyMatrix4(Matrix4 matrix, Matrix3 optionalNormalMatrix);

    /**
     * Returns a new plane with the same normal and constant as this one.
     *
     * @return Plane
     */
    public native Plane clone();

    /**
     * Returns a Vector3 coplanar to the plane, by calculating the projection of the normal vector at the origin onto the plane.
     *
     * @return Vector3
     */
    public native Vector3 coplanarPoint();

    /**
     * Returns a Vector3 coplanar to the plane, by calculating the projection of the normal vector at the origin onto the plane.
     * optionalTarget if specified, the result will be copied into this Vector3, otherwise a new Vector3 will be created.
     *
     * @param optionalTarget
     * @return Plane
     */
    public native Vector3 coplanarPoint(Vector3 optionalTarget);

    /**
     * Copies the values of the passed plane's normal and constant properties to this plane.
     *
     * @param plane
     * @return Plane
     */
    public native Plane clone(Plane plane);

    /**
     * Returns the signed distance from the point to the plane.
     *
     * @param point
     * @return float
     */
    public native float distanceToPoint(Vector3 point);

    /**
     * Returns the signed distance from the sphere to the plane.
     *
     * @param sphere
     * @return float
     */
    public native float distanceToPoint(Sphere sphere);

    /**
     * Checks to see if two planes are equal (their normal and constant properties match).
     *
     * @param plane
     * @return boolean
     */
    public native boolean equals(Plane plane);

    /**
     * Returns the intersection point of the passed line and the plane. Returns undefined if the line does not intersect. Returns the
     * line's starting point if the line is coplanar with the plane.
     *
     * @param line - the Line3 to check for intersection.
     * @return Vector3
     */
    public native Vector3 intersectLine(Line3 line);

    /**
     * Returns the intersection point of the passed line and the plane. Returns undefined if the line does not intersect. Returns the
     * line's starting point if the line is coplanar with the plane.
     *
     * @param line           - the Line3 to check for intersection.
     * @param optionalTarget - the result will be copied into this Vector3, otherwise a new Vector3 will be created.
     * @return Vector3
     */
    public native Vector3 intersectLine(Line3 line, Vector3 optionalTarget);

    /**
     * Determines whether or not this plane intersects box.
     *
     * @param box - the Box3 to check for intersection.
     * @return boolean
     */
    public native boolean intersectsBox(Box3 box);

    /**
     * Tests whether a line segment intersects with (passes through) the plane.
     *
     * @param line - the Line3 to check for intersection.
     * @return
     */
    public native boolean intersectsLine(Line3 line);

    /**
     * Tests whether a line segment intersects with (passes through) the Sphere.
     *
     * @param sphere - the Sphere to check for intersection.
     * @return
     */
    public native boolean intersectsSphere(Sphere sphere);

    /**
     * Negates both the normal vector and the constant.
     *
     * @return Plane
     */
    public native Plane negate();

    /**
     * Normalizes the normal vector, and adjusts the constant value accordingly.
     *
     * @return Plane
     */
    public native Plane normalize();

    /**
     * Projects a point onto the plane.
     *
     * @param point - the Vector3 to project onto the plane.
     * @return Vector3
     */
    public native Vector3 projectPoint(Vector3 point);

    /**
     * Projects a point onto the plane.
     *
     * @param point          - the Vector3 to project onto the plane.
     * @param optionalTarget - the result will be copied into this Vector3, otherwise a new Vector3 will be created.
     * @return Vector3
     */
    public native Vector3 projectPoint(Vector3 point, Vector3 optionalTarget);

    /**
     * Sets the plane's normal and constant properties.
     *
     * @param normal   - a unit length Vector3 defining the normal of the plane.
     * @param constant - the signed distance from the origin to the plane. Default is 0.
     * @return Plane
     */
    public native Plane set(Vector3 normal, float constant);

    /**
     * Set the individual components that define the plane.
     *
     * @param x - x value of the unit length normal vector.
     * @param y - y value of the unit length normal vector.
     * @param z - z value of the unit length normal vector.
     * @param w - w value of the unit length normal vector.
     * @return Plane
     */
    public native Plane setComponents(float x, float y, float z, float w);

    /**
     * Defines the plane based on the 3 provided points. The winding order is assumed to be counter-clockwise, and determines the direction of the normal.
     *
     * @param a - first point on the plane.
     * @param b - second point on the plane.
     * @param c - third point on the plane.
     * @return Plane
     */
    public native Plane setFromCoplanarPoints(Vector3 a, Vector3 b, Vector3 c);

    /**
     * Sets the plane's properties as defined by a normal and an arbitrary coplanar point.
     *
     * @param normal - a unit length Vector3 defining the normal of the plane.
     * @param point  - Vector3
     * @return Plane
     */
    public native Plane setFromNormalAndCoplanarPoint(Vector3 normal, Vector3 point);

    /**
     * Translates the plane by the distance defined by the offset vector. Note that this only affects the plane constant
     * and will not affect the normal vector.
     *
     * @param offset - the amount to move the plane by.
     * @return Plane
     */
    public native Plane translate (Vector3 offset);
}

