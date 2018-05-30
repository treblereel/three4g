package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsType;

/**
 * Represents a box in 2D space.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Box2 implements Box {

    /**
     * Vector2 representing the lower (x, y) boundary of the box.
     * Default is ( + Infinity, + Infinity ).
     */
    public Vector2 min;

    /**
     * Vector2 representing the lower upper (x, y) boundary of the box.
     * Default is ( - Infinity, - Infinity ).
     */
    public Vector2 max;


    public Box2() {

    }

    /**
     * Creates a Box2 bounded by min and max.
     *
     * @param min - Vector2 representing the lower (x, y) boundary of the box. Default is ( + Infinity, + Infinity ).
     * @param max - Vector2 representing the lower upper (x, y) boundary of the box. Default is ( - Infinity, - Infinity ).
     */
    public Box2(Vector2 min, Vector2 max) {

    }

    /**
     * Clamps the point within the bounds of this box.
     *
     * @param point  - Vector2 to clamp.
     * @param target — the result will be copied into this Vector2.
     * @return instance of Vector2
     */
    public native Vector2 clampPoint(Vector2 point, Vector2 target);

    /**
     * @return Returns a new Box2 with the same min and max as this one.
     */
    public native Box2 clone();

    /**
     * @param box - Box2 to test for inclusion.
     * @return Returns true if this box includes the entirety of box. If this and box are identical,
     * * this function also returns true.
     */
    public native boolean containsBox(Box2 box);

    /**
     * @param point - Vector2 to check for inclusion.
     * @return Returns true if the specified point lies within or on the boundaries of this box.
     */
    public native boolean containsPoint(Vector2 point);

    /**
     * Copies the min and max from box to this box.
     *
     * @param box instance of Box2
     * @return box instance of Box2
     */
    public native Box2 copy(Box2 box);

    /**
     * @param point - Vector2 to measure distance to.
     * @return Returns the distance from any edge of this box to the specified point. If the point lies inside of this box, the distance will be 0.
     */
    public native float distanceToPoint(Vector2 point);

    /**
     * @param box - Box to compare with this one.
     * @return Returns true if this box and box share the same lower and upper bounds.
     */
    public native boolean equals(Box2 box);

    /**
     * @param point - Vector2 that should be included in the box.
     * @return Expands the boundaries of this box to include point.
     */
    public native Box2 expandByPoint(Vector2 point);

    /**
     * Expands each dimension of the box by scalar. If negative, the dimensions of the box will be contracted.
     *
     * @param scalar - Distance to expand the box by.
     * @return box instance of Box2
     */
    public native Box2 expandByScalar(float scalar);

    /**
     * Expands this box equilaterally by vector. The width of this box will be expanded by the x component of vector in both directions. The height of this box will be expanded by the y component of vector in both directions.
     *
     * @param vector - Vector2 to expand the box by.
     * @return box instance of Box2
     */
    public native Box2 expandByVector(Vector2 vector);

    /**
     * @param target — the result will be copied into this Vector2.
     * @return Returns the center point of the box as a Vector2.
     */
    public native Vector2 getCenter(Vector2 target);

    /**
     * @param point  - Vector2.
     * @param target — the result will be copied into this Vector2.
     * @return Returns a point as a proportion of this box's width and height.
     */
    public native Vector2 getParameter(Vector2 point, Vector2 target);

    /**
     * @param target — the result will be copied into this Vector2.
     * @return Returns the width and height of this box.
     */
    public native Vector2 getSize(Vector2 target);

    /**
     * @param box - Box to intersect with.
     * @return Returns the intersection of this and box, setting the upper bound of this box to the lesser of the two boxes' upper bounds and the lower bound of this box to the greater of the two boxes' lower bounds.
     */
    public native Box2 intersect(Box2 box);

    /**
     * Determines whether or not this box intersects box.
     *
     * @param box - Box to check for intersection against.
     * @return true, if this box intersects box
     */
    public native boolean intersectsBox(Box2 box);

    /**
     * Note that a box with equal lower and upper bounds still includes one point, the one both bounds share.
     *
     * @return Returns true if this box includes zero points within its bounds.
     */
    public native boolean isEmpty();

    /**
     * Makes this box empty.
     *
     * @return empty Box2
     */
    public native Box2 makeEmpty();

    /**
     * Sets the lower and upper (x, y) boundaries of this box.
     *
     * @param min - Vector2 representing the lower (x, y) boundary of the box.
     * @param max - Vector2 representing the lower upper (x, y) boundary of the box.
     * @return
     */
    public native Box2 set(Vector2 min, Vector2 max);

    /**
     * Centers this box on center and sets this box's width and height to the values specified in size.
     *
     * @param center - Desired center position of the box (Vector2).
     * @param size   - Desired x and y dimensions of the box (Vector2).
     * @return instance of Box2
     */
    public native Box2 setFromCenterAndSize(Vector2 center, Vector2 size);

    /**
     * Sets the upper and lower bounds of this box to include all of the points in points.
     *
     * @param points - Array of Vector2s that the resulting box will contain.
     * @return instance of Box2
     */
    public native Box2 setFromPoints(Vector2... points);

    /**
     * Adds offset to both the upper and lower bounds of this box, effectively moving this box offset units in 2D space.
     *
     * @param offset - Direction and distance of offset.
     * @return instance of Box2
     */
    public native Box2 translate(Vector2 offset);

    /**
     * Unions this box with box, setting the upper bound of this box to the greater of the two boxes' upper bounds and the lower bound of this box to the lesser of the two boxes' lower bounds.
     *
     * @param box - Box that will be unioned with this box.
     * @return instance of Box2
     */
    public native Box2 union(Box2 box);


}
