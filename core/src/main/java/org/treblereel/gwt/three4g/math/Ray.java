package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * A ray that emits from an origin in a certain direction. This is used by the Raycaster to assist with raycasting. Raycasting
 * is used for mouse picking (working out what objects in the 3D space the mouse is over) amongst other things.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/24/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Ray {

    /**
     * The origin of the Ray. Default is a Vector3 at (0, 0, 0).
     */
    public Vector3 origin;

    /**
     * The direction of the Ray. This must be normalized (with Vector3.normalize) for the methods to operate properly. Default is a Vector3 at (0, 0, 0).
     */
    public Vector3 direction;

    /**
     * @param origin    - the origin of the Ray. Default is a Vector3 at (0, 0, 0).
     * @param direction - Vector3 The direction of the Ray. This must be normalized (with Vector3.normalize) for the methods to operate properly. Default is a Vector3 at (0, 0, 0).
     */
    @JsConstructor
    public Ray(Vector3 origin, Vector3 direction) {

    }

    /**
     * Transform this Ray by the Matrix4.
     *
     * @param matrix4 - the Matrix4 to apply to this Ray.
     * @return instance of Ray
     */
    public native Ray applyMatrix4(Matrix4 matrix4);

    /**
     * Get a Vector3 that is a given distance along this Ray.
     *
     * @param t      - the distance along the Ray to retrieve a position for.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 at(float t, Vector3 target);

    /**
     * Creates a clone of this instance.
     *
     * @return instance of Ray
     */
    public native Ray clone();

    /**
     * Get the point along this Ray that is closest to the Vector3 provided.
     *
     * @param point  - the point to get the closest approach to.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 closestPointToPoint(Vector3 point, Vector3 target);

    /**
     * Copies another Ray object to this instance.
     *
     * @param source Ray
     * @return instance of Ray
     */
    public native Ray copy(Ray source);

    /**
     * Get the squared distance of the closest approach between the Ray and the Vector3.
     *
     * @param point - the Vector3 to compute a distance to.
     * @return instance of Ray
     */
    public native float distanceSqToPoint(Vector3 point);


    /**
     * Get the squared distance between this Ray and a line segment.
     *
     * @param v0 - the start of the line segment.
     * @param v1 - the end of the line segment.
     * @return squared distance
     */
    public native float distanceSqToSegment(Vector3 v0, Vector3 v1);

    /**
     * Get the squared distance between this Ray and a line segment.
     *
     * @param v0                 - the start of the line segment.
     * @param v1                 - the end of the line segment.
     * @param optionalPointOnRay - if this is provided, it receives the point on this Ray that is closest to the segment.
     * @return squared distance
     */
    public native float distanceSqToSegment(Vector3 v0, Vector3 v1, Vector3 optionalPointOnRay);


    /**
     * Get the squared distance between this Ray and a line segment.
     *
     * @param v0                     - the start of the line segment.
     * @param v1                     - the end of the line segment.
     * @param optionalPointOnRay     - if this is provided, it receives the point on this Ray that is closest to the segment.
     * @param optionalPointOnSegment -  if this is provided, it receives the point on the line segment that is closest to this Ray.
     * @return squared distance
     */
    public native float distanceSqToSegment(Vector3 v0, Vector3 v1, Vector3 optionalPointOnRay, Vector3 optionalPointOnSegment);

    /**
     * Get the distance from origin to the Plane, or null if the Ray doesn't intersect the Plane.
     *
     * @param plane - the Plane to get the distance to.
     * @return squared distance
     */
    public native float distanceToPlane(Plane plane);

    /**
     * Get the distance of the closest approach between the Ray and the point.
     *
     * @param point - Vector3 The Vector3 to compute a distance to.
     * @return squared distance
     */
    public native float distanceToPoint(Vector3 point);

    /**
     * Returns true if this and the other ray have equal offset and direction.
     *
     * @param ray - the Ray to compare to.
     * @return if this ray is equal
     */
    public native boolean equals(Ray ray);

    /**
     * Intersect this Ray with a Box3, returning the intersection point or null if there is no intersection.
     *
     * @param box    - the Box3 to intersect with.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 intersectBox(Box3 box, Vector3 target);

    /**
     * Intersect this Ray with a Plane, returning the intersection point or null if there is no intersection.
     *
     * @param plane  - the Plane to intersect with.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 intersectPlane(Plane plane, Vector3 target);

    /**
     * Intersect this Ray with a Sphere, returning the intersection point or null if there is no intersection.
     *
     * @param sphere - the Sphere to intersect with.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 intersectSphere(Sphere sphere, Vector3 target);

    /**
     * Intersect this Ray with a triangle, returning the intersection point or null if there is no intersection.
     *
     * @param a,              - The Vector3 point
     * @param b               - The Vector3 point
     * @param c               - The Vector3 point.
     * @param backfaceCulling - whether to use backface culling.
     * @param target          — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 intersectTriangle(Vector3 a, Vector3 b, Vector3 c, boolean backfaceCulling, Vector3 target);


    /**
     * Return true if this Ray intersects with the Box3.
     *
     * @param box - the Box3 to intersect with.
     * @return true if intersects with a Box
     */
    public native boolean intersectsBox(Box3 box);

    /**
     * Return true if this Ray intersects with the Plane.
     *
     * @param plane - the Plane to intersect with.
     * @return true if intersects with a Plane
     */
    public native boolean intersectsPlane(Plane plane);

    /**
     * Return true if this Ray intersects with the Sphere.
     *
     * @param sphere - the Sphere to intersect with.
     * @return true if intersects with a Sphere
     */
    public native boolean intersectsSphere(Sphere sphere);

    /**
     * Adjusts the direction of the ray to point at the vector in world coordinates.
     *
     * @param v - The Vector3 to look at.
     * @return instance of Ray
     */
    public native Ray lookAt(Vector3 v);

    /**
     * Shift the origin of this Ray along its direction by the distance given.
     *
     * @param t - The distance along the Ray to interpolate.
     * @return instance of Ray
     */
    public native Ray recast(float t);

    /**
     * Copy the parameters to the origin and direction properties of this ray.
     *
     * @param origin    - the origin of the Ray.
     * @param direction - the direction of the Ray. This must be normalized (with Vector3.normalize) for the methods to operate properly.
     * @return instance of Ray
     */
    public native Ray set(Vector3 origin, Vector3 direction);

}
