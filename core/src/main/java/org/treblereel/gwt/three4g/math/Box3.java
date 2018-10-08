package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * Represents a box or cube in 3D space. The main purpose of this is to represent the Minimum Bounding Boxes for objects.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Box3 implements Box {

    /**
     * Used to check whether this or derived classes are Box3s. Default is true.
     */
    public boolean isBox3;

    /**
     * Vector3 representing the lower (x, y, z) boundary of the box.
     * Default is ( + Infinity, + Infinity, + Infinity ).
     */
    public Vector3 min;

    /**
     * Vector3 representing the upper (x, y, z) boundary of the box.
     * Default is ( - Infinity, - Infinity, - Infinity ).
     */
    public Vector3 max;

    @JsConstructor
    public Box3() {

    }

    /**
     * @param min - Vector3 representing the lower (x, y, z) boundary of the box. Default is ( + Infinity, + Infinity, + Infinity ).
     * @param max - Vector3 representing the lower upper (x, y, z) boundary of the box. Default is ( - Infinity, - Infinity, - Infinity ).
     */
    public Box3(Vector3 min, Vector3 max) {

    }

    /**
     * Transforms this Box3 with the supplied matrix.
     *
     * @param matrix - The Matrix4 to apply
     * @return instance of Box3
     */
    public native Box3 applyMatrix4(Matrix4 matrix);

    /**
     * Clamps the point within the bounds of this box.
     *
     * @param point  - Vector3 to clamp.
     * @param target — the result will be copied into this Vector3.
     * @return instance of Vector3
     */
    public native Vector3 clampPoint(Vector3 point, Vector3 target);

    /**
     * @return Returns a new Vector3 with the same min and max as this one.
     */
    public native Vector3 clone();

    /**
     * @param box - Box3 to test for inclusion.
     * @return Returns true if this box includes the entirety of box. If this and box are identical,
     * * this function also returns true.
     */
    public native boolean containsBox(Box3 box);

    /**
     * @param point - Vector3 to check for inclusion.
     * @return Returns true if the specified point lies within or on the boundaries of this box.
     */
    public native boolean containsPoint(Vector3 point);

    /**
     * Copies the min and max from box to this box.
     *
     * @param box - Box3 to copy.
     * @return box instance of Box3
     */
    public native Box3 copy(Box3 box);

    /**
     * @param point - Vector3 to measure distance to.
     * @return Returns the distance from any edge of this box to the specified point. If the point lies inside of this box, the distance will be 0.
     */
    public native float distanceToPoint(Vector3 point);

    /**
     * @param box - Box to compare with this one.
     * @return Returns true if this box and box share the same lower and upper bounds.
     */
    public native boolean equals(Box3 box);

    /**
     * Expands the boundaries of this box to include object and its children, accounting for the object's, and children's, world transforms.
     *
     * @param object - Object3D to expand the box by.
     * @return box instance of Box3
     */
    public native Box3 expandByObject(Object3D object);

    /**
     * @param point - Vector3 that should be included in the box.
     * @return Expands the boundaries of this box to include point.
     */
    public native Box3 expandByPoint(Vector3 point);

    /**
     * Expands each dimension of the box by scalar. If negative, the dimensions of the box will be contracted.
     *
     * @param scalar - Distance to expand the box by.
     * @return box instance of Box3
     */
    public native Box3 expandByScalar(float scalar);

    /**
     * Expands this box equilaterally by vector. The width of this box will be expanded by the x component of vector in both directions. The height of this box will be expanded by the y component of vector in both directions.
     *
     * @param vector - Vector3 to expand the box by.
     * @return box instance of Box3
     */
    public native Box3 expandByVector(Vector3 vector);

    /**
     * Gets a Sphere that bounds the box.
     *
     * @param target — the result will be copied into this Sphere.
     * @return Gets a Sphere that bounds the box.
     */
    public native Sphere getBoundingSphere(Sphere target);

    /**
     * @param target — the result will be copied into this Vector3.
     * @return Returns the center point of the box as a Vector3.
     */
    public native Vector3 getCenter(Vector3 target);

    /**
     * @param point  - Vector3.
     * @param target — the result will be copied into this Vector3.
     * @return Returns a point as a proportion of this box's width and height.
     */
    public native Vector3 getParameter(Vector3 point, Vector3 target);

    /**
     * @param target — the result will be copied into this Vector3.
     * @return Returns the width and height of this box.
     */
    public native Vector3 getSize(Vector3 target);

    /**
     * @param box - Box to intersect with.
     * @return Returns the intersection of this and box, setting the upper bound of this box to the lesser of the two boxes' upper bounds and the lower bound of this box to the greater of the two boxes' lower bounds.
     */
    public native Box3 intersect(Box3 box);

    /**
     * Determines whether or not this box intersects box.
     *
     * @param box - Box to check for intersection against.
     * @return true, if this box intersects box
     */
    public native boolean intersectsBox(Box3 box);

    /**
     * Determines whether or not this box intersects plane.
     *
     * @param plane - Plane to check for intersection against.
     * @return true, if this plane intersects box
     */
    public native boolean intersectsPlane(Plane plane);

    /**
     * Determines whether or not this box intersects sphere.
     *
     * @param sphere - Sphere to check for intersection against.
     * @return true, if this box intersects sphere
     */
    public native boolean intersectsSphere(Sphere sphere);

    /**
     * Determines whether or not this box intersects triangle.
     *
     * @param triangle - Triangle to check for intersection against.
     * @return true, if this box intersects box
     */
    public native boolean intersectsTriangle(Triangle triangle);

    /**
     * Note that a box with equal lower and upper bounds still includes one point, the one both bounds share.
     *
     * @return Returns true if this box includes zero points within its bounds.
     */
    public native boolean isEmpty();

    /**
     * Makes this box empty.
     *
     * @return empty Box3
     */
    public native Box3 makeEmpty();

    /**
     * Sets the lower and upper (x, y, z) boundaries of this box.
     *
     * @param min - Vector3 representing the lower (x, y, z) boundary of the box.
     * @param max - Vector3 representing the lower upper (x, y, z) boundary of the box.
     * @return instance of Box3
     */
    public native Box3 set(Vector3 min, Vector3 max);

    /**
     * Sets the upper and lower bounds of this box to include all of the data in array.
     *
     * @param array -- An array of position data that the resulting box will envelop.
     * @return instance of Box3
     */
    public native Box3 setFromArray(int[] array);

    /**
     * Sets the upper and lower bounds of this box to include all of the data in attribute.
     *
     * @param attribute - A buffer attribute of position data that the resulting box will envelop.
     * @return instance of Box3
     */
    public native Box3 setFromBufferAttribute(BufferAttribute attribute);

    /**
     * Centers this box on center and sets this box's width and height to the values specified in size.
     *
     * @param center - Desired center position of the box (Vector3).
     * @param size   - Desired x, y and z dimensions of the box (Vector3).
     * @return instance of Box3
     */
    public native Box3 setFromCenterAndSize(Vector3 center, Vector3 size);


    /**
     * Computes the world-axis-aligned bounding box of an Object3D (including its children), accounting for the object's, and children's, world transforms.
     *
     * @param object - Object3D to compute the bounding box of.
     * @return instance of Box3
     */
    public native Box3 setFromObject(Object3D object);


    /**
     * Sets the upper and lower bounds of this box to include all of the points in points.
     *
     * @param points - Array of Vector3s that the resulting box will contain.
     * @return instance of Box3
     */
    public native Box3 setFromPoints(Vector3... points);

    /**
     * Adds offset to both the upper and lower bounds of this box, effectively moving this box offset units in 3D space.     *
     *
     * @param offset - Direction and distance of offset.
     * @return instance of Box3
     */
    public native Box3 translate(Vector3 offset);

    /**
     * Unions this box with box, setting the upper bound of this box to the greater of the two boxes' upper bounds and the lower bound of this box to the lesser of the two boxes' lower bounds.
     *
     * @param box - Box that will be unioned with this box.
     * @return instance of Box3
     */
    public native Box3 union(Box3 box);
}

