package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * Frustums are used to determine what is inside the camera's field of view. They help speed up the rendering process - object which lie outside a camera's frustum can safely be excluded from rendering.
 * <p>
 * This class is mainly intended for use internally by a renderer for calculating a camera or shadowCamera's frustum.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Frustum {

    /**
     * Array of 6 planes.
     */
    public Plane[] planes;

    public Frustum() {

    }

    /**
     * @param p0 - defaults to a new Plane.
     */
    public Frustum(Plane p0) {

    }

    /**
     * @param p0 - defaults to a new Plane.
     * @param p1 - defaults to a new Plane.
     */
    public Frustum(Plane p0, Plane p1) {

    }

    /**
     * @param p0 - defaults to a new Plane.
     * @param p1 - defaults to a new Plane.
     * @param p2 - defaults to a new Plane.
     */
    public Frustum(Plane p0, Plane p1, Plane p2) {

    }

    /**
     * @param p0 - defaults to a new Plane.
     * @param p1 - defaults to a new Plane.
     * @param p2 - defaults to a new Plane.
     * @param p3 - defaults to a new Plane.
     */
    public Frustum(Plane p0, Plane p1, Plane p2, Plane p3) {

    }

    /**
     * @param p0 - defaults to a new Plane.
     * @param p1 - defaults to a new Plane.
     * @param p2 - defaults to a new Plane.
     * @param p3 - defaults to a new Plane.
     * @param p4 - defaults to a new Plane.
     */
    public Frustum(Plane p0, Plane p1, Plane p2, Plane p3, Plane p4) {

    }

    /**
     * @param p0 - defaults to a new Plane.
     * @param p1 - defaults to a new Plane.
     * @param p2 - defaults to a new Plane.
     * @param p3 - defaults to a new Plane.
     * @param p4 - defaults to a new Plane.
     * @param p5 - defaults to a new Plane.
     */
    public Frustum(Plane p0, Plane p1, Plane p2, Plane p3, Plane p4, Plane p5) {

    }

    /**
     * @return Return a new Frustum with the same parameters as this one.
     */
    public native Frustum clone();

    /**
     * Checks to see if the frustum contains the point.
     *
     * @param point - Vector3 to test.
     * @return true, if contains
     */
    public native boolean containsPoint(Vector3 point);

    /**
     * Copies the properties of the passed frustum into this one.
     *
     * @param frustum - The frustum to copy
     * @return instance of Frustum
     */
    public native Frustum copy(Frustum frustum);

    /**
     * @param m instance of Matrix
     * @return instance of Frustum
     */
    public native Frustum setFromMatrix(Matrix m);

    /**
     * Return true if box intersects with this frustum.
     *
     * @param box - Box3 to check for intersection.
     * @return Return true if box intersects with this frustum.
     */
    public native boolean intersectsBox(Box3 box);

    /**
     * Checks whether the object's bounding sphere is intersecting the Frustum.
     * Note that the object must have a Geometry or BufferGeometry so that the bounding sphere can be calculated.
     *
     * @param object to check
     * @return true, if object's bounding sphere is intersecting the Frustum
     */
    public native boolean intersectsObject(Object3D object);

}
