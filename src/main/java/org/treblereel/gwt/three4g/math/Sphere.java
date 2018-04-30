package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Sphere {

    /**
     * A Vector3 defining the center of the sphere. Default is (0, 0, 0).
     */
    public Vector3 center;

    /**
     * The radius of the sphere. Default is 0.
     */
    public float radius;

    /**
     * Creates a new Sphere.
     */
    @JsConstructor
    public Sphere() {

    }

    /**
     * Creates a new Sphere.
     *
     * @param center - center of the sphere. Default is a Vector3 at (0, 0, 0).
     * @param radius - radius of the sphere. Default is 0.
     */
    @JsConstructor
    public Sphere(Vector3 center, Vector3 radius) {

    }

    /**
     * Transforms this sphere with the provided Matrix4.
     *
     * @param matrix - the Matrix4 to apply
     * @return
     */
    public native Sphere applyMatrix4(Matrix4 matrix);

    /**
     * Clamps a point within the sphere. If the point is is outside the sphere, it will clamp it to the closets point on the edge of the sphere. Points already inside the sphere will not be affected.
     *
     * @param point  - Vector3 The point to clamp.
     * @param target — the result will be copied into this Vector3.
     * @return
     */
    public native Vector3 clampPoint(Vector3 point, Vector3 target);

    /**
     * Returns a new sphere with the same center and radius as this one.
     *
     * @return
     */
    public native Sphere clone();

    /**
     * Checks to see if the sphere contains the provided point inclusive of the surface of the sphere.
     *
     * @param point - the Vector3 to be checked
     * @return
     */
    public native boolean containsPoint(Vector3 point);

    /**
     * Copies the values of the passed sphere's center and radius properties to this sphere.
     *
     * @param sphere
     */
    public native Sphere copy(Sphere sphere);

    /**
     * Returns the closest distance from the boundary of the sphere to the point. If the sphere contains the point, the distance will be negative.
     *
     * @param point
     * @return
     */
    public native float distanceToPoint(Vector3 point);

    /**
     * Checks to see if the sphere is empty (the radius set to 0).
     *
     * @return
     */
    public native boolean empty();

    /**
     * Checks to see if the two spheres' centers and radii are equal.
     *
     * @param sphere
     * @return
     */
    public native boolean equals(Sphere sphere);

    /**
     * Returns aMinimum Bounding Box for the sphere.
     *
     * @param target — the result will be copied into this Box3.
     * @return
     */
    public native Box3 getBoundingBox(Box3 target);

    /**
     * Determines whether or not this sphere intersects a given box.
     *
     * @param box - Box3 to check for intersection against.
     * @return
     */
    public native boolean intersectsBox(Box3 box);

    /**
     * Determines whether or not this sphere intersects a given plane.
     *
     * @param plane - Plane to check for intersection against.
     * @return
     */
    public native boolean intersectsPlane(Plane plane);

    /**
     * Checks to see if two spheres intersect.
     *
     * @param sphere - Sphere to check for intersection against.
     * @return
     */
    public native boolean intersectsSphere(Sphere sphere);

    /**
     * Sets the center and radius properties of this sphere.
     *
     * @param center - center of the sphere.
     * @param radius - radius of the sphere.
     * @return
     */
    public native Sphere set(Vector3 center, float radius);


    /**
     * Computes the minimum bounding sphere for an array of points. If optionalCenteris given, it is used as the sphere's center. Otherwise, the center of the axis-aligned bounding box encompassing points is calculated.
     *
     * @param points - an Array of Vector3 positions.
     * @return
     */
    public native Sphere setFromPoints(Vector3[] points);

    /**
     * Computes the minimum bounding sphere for an array of points. If optionalCenteris given, it is used as the sphere's center. Otherwise, the center of the axis-aligned bounding box encompassing points is calculated.
     *
     * @param points         - an Array of Vector3 positions.
     * @param optionalCenter - Optional Vector3 position for the sphere's center.
     * @return
     */
    public native Sphere setFromPoints(Vector3[] points, Vector3 optionalCenter);

    /**
     * Translate the sphere's center by the provided offset Vector3.
     *
     * @param offset
     * @return
     */
    public native Sphere translate(Vector3 offset);
}
