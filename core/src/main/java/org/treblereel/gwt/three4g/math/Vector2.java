package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 2/28/18.
 */
@JsType(isNative = true, name = "THREE.Vector2", namespace = JsPackage.GLOBAL)
public class Vector2 implements Vector {

    /**
     * Used to check whether this or derived classes are Vector2s. Default is true.
     * <p>
     * You should not change this, as it is used internally for optimisation.
     */
    public boolean isVector2;

    /**
     * Alias for y.
     */
    public float height;

    /**
     * Alias for x.
     */
    public float width;

    public float x, y;

    public Vector2() {

    }

    @JsConstructor
    public Vector2(float x, float y) {

    }

    /**
     * Adds v to this vector.
     *
     * @param vector2 instance of Vector2
     * @return instance of Vector2
     */
    public native Vector2 add(Vector2 vector2);

    /**
     * Adds the scalar value s to this vector's x and y values.
     *
     * @param scalar as float
     * @return Vector2
     */
    public native Vector2 addScalar(float scalar);

    /**
     * Adds the multiple of v and s to this vector.
     *
     * @param vector2 instance of Vector2
     * @param scalar  as float
     * @return Vector2
     */
    public native Vector2 addScaledVector(Vector2 vector2, float scalar);

    /**
     * Sets this vector to a + b.
     *
     * @param a instance of Vector2
     * @param b instance of Vector2
     * @return instance of Vector2
     */
    public native Vector2 addVectors(Vector2 a, Vector2 b);

    /**
     * Computes the angle in radians of this vector with respect to the positive x-axis.
     *
     * @return float angle
     */
    public native float angle();

    /**
     * Multiplies this vector (with an implicit 1 as the 3rd component) by m.
     *
     * @param matrix3 source Matrix3
     * @return Vector2
     */
    public native Vector2 applyMatrix3(Matrix3 matrix3);

    /**
     * The x and y components of the vector are rounded up to the nearest integer value.
     *
     * @return Vector2
     */
    public native Vector2 ceil();

    /**
     * If this vector's x or y value is greater than the max vector's x or y value, it is replaced by the corresponding value.
     * <p>
     * If this vector's x or y value is less than the min vector's x or y value, it is replaced by the corresponding value.
     *
     * @param min - the minimum x and y values.
     * @param max - the maximum x and y values in the desired range
     * @return Vector2
     */
    public native Vector2 clamp(Vector2 min, Vector2 max);

    /**
     * If this vector's length is greater than the max value, it is replaced by the max value.
     * <p>
     * If this vector's length is less than the min value, it is replaced by the min value.
     *
     * @param min - the minimum value the length will be clamped to
     * @param max - the maximum value the length will be clamped to
     * @return Vector2
     */
    public native Vector2 clampLength(float min, float max);

    /**
     * If this vector's x or y values are greater than the max value, they are replaced by the max value.
     * <p>
     * If this vector's x or y values are less than the min value, they are replaced by the min value.
     *
     * @param min - the minimum value the components will be clamped to
     * @param max - the maximum value the components will be clamped to
     * @return Vector2
     */
    public native Vector2 clampScalar(float min, float max);

    /**
     * Returns a new Vector2 with the same x and y values as this one.
     *
     * @return Vector2
     */
    public native Vector2 clone();

    /**
     * Copies the values of the passed Vector2's x and y properties to this Vector2.
     *
     * @param vector2 source Vector2
     * @return Vector2
     */
    public native Vector2 copy(Vector2 vector2);

    /**
     * computes the distance from this vector to v.
     *
     * @param vector2 targeting Vector2
     * @return float
     */
    public native float distanceTo(Vector2 vector2);

    /**
     * Computes the Manhattan distance from this vector to v.
     *
     * @param vector2 targeting Vector2
     * @return float distance
     */
    public native float manhattanDistanceTo(Vector2 vector2);

    /**
     * Computes the squared distance from this vector to v. If you are just comparing the distance with another
     * distance, you should compare the distance squared instead as it is slightly more efficient to calculate.
     *
     * @param vector2 targeting Vector2
     * @return float distance
     */
    public native float distanceToSquared(Vector2 vector2);

    /**
     * Divides this vector by v.
     *
     * @param vector2 source Vector2
     * @return Vector2
     */
    public native Vector2 divide(Vector2 vector2);

    /**
     * Divides this vector by scalar s.
     * Sets vector to ( 0, 0 ) if s = 0.
     *
     * @param scalar as float value
     * @return Vector2
     */
    public native Vector2 divideScalar(float scalar);

    /**
     * Calculates the dot product of this vector and v.
     *
     * @param vector2 targeting Vector2
     * @return float
     */
    public native float dot(Vector2 vector2);

    /**
     * Calculates the cross product of this vector and v. Note that a 'cross-product' in 2D is not well-defined.
     * This function computes a geometric cross-product often used in 2D graphics
     *
     * @param vector2 instance of Vector2
     * @return cross product as float
     */
    public native float cross(Vector2 vector2);

    /**
     * Checks for strict equality of this vector and v.
     *
     * @param vector2 targeting Vector2
     * @return true it vectors are equal
     */
    public native boolean equals(Vector2 vector2);

    /**
     * The components of the vector are rounded down to the nearest integer value.
     *
     * @return Vector2
     */
    public native Vector2 floor();

    /**
     * Sets this vector's x value to be array[ offset ] and y value to be array[ offset + 1 ].
     *
     * @param array - the source array of floats.
     * @return Vector2
     */
    public native Vector2 fromArray(float[] array);

    /**
     * Sets this vector's x value to be array[ offset ] and y value to be array[ offset + 1 ].
     *
     * @param array - the source array of floats.
     * @return Vector2
     */
    public native Vector2 fromArray(JsArrayLike array);

    /**
     * Sets this vector's x value to be array[ offset ] and y value to be array[ offset + 1 ].
     *
     * @param array  - the source array.
     * @param offset - (optional) offset into the array. Default is 0.
     * @return Vector2
     */
    public native Vector2 fromArray(float[] array, float offset);

    /**
     * Sets this vector's x value to be array[ offset ] and y value to be array[ offset + 1 ].
     *
     * @param array  - the source array.
     * @param offset - (optional) offset into the array. Default is 0.
     * @return Vector2
     */
    public native Vector2 fromArray(JsArrayLike array, float offset);

    /**
     * Sets this vector's x and y values from the attribute.
     *
     * @param bufferAttribute - the source attribute.
     * @param offset          - index in the attribute.
     * @return Vector2
     */
    public native Vector2 fromBufferAttribute(BufferAttribute bufferAttribute, int offset);

    /**
     * index - 0 or 1.
     * <p>
     * If index equals 0 returns the x value.
     * If index equals 1 returns the y value.
     *
     * @param index component index
     * @return float
     */
    public native float getComponent(int index);

    /**
     * Computes the Euclidean length (straight-line length) from (0, 0) to (x, y).
     *
     * @return float
     */
    public native float length();

    /**
     * Computes the Manhattan length of this vector.
     *
     * @return float
     */
    public native float manhattanLength();

    /**
     * Computes the square of the Euclidean length (straight-line length) from (0, 0) to (x, y). If you
     * are comparing the lengths of vectors, you should compare the length squared instead as it is slightly
     * more efficient to calculate.
     *
     * @return float
     */
    public native float lengthSq();

    /**
     * Linearly interpolates between this vector and v, where alpha is the distance along
     * the line - alpha = 0 will be this vector, and alpha = 1 will be v.
     *
     * @param v     - Vector2 to interpolate towards.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Vector2
     */
    public native Vector2 lerp(Vector2 v, float alpha);

    /**
     * Sets this vector to be the vector linearly interpolated between v1 and v2 where alpha is the distance along
     * the line connecting the two vectors - alpha = 0 will be v1, and alpha = 1 will be v2.
     *
     * @param v1    - the starting Vector2.
     * @param v2    - Vector2 to interpolate towards.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Vector2
     */
    public native Vector2 lerpVectors(Vector2 v1, Vector2 v2, float alpha);

    /**
     * Inverts this vector - i.e. sets x = -x and y = -y.
     *
     * @return Vector2
     */
    public native Vector2 negate();

    /**
     * Converts this vector to a unit vector - that is, sets it equal to the vector with the same direction as this one, but length 1.
     *
     * @return Vector2
     */
    public native Vector2 normalize();

    /**
     * If this vector's x or y value is less than v's x or y value, replace that value with the corresponding max value.
     *
     * @param vector2 source Vector2
     * @return Vector2
     */
    public native Vector2 max(Vector2 vector2);

    /**
     * If this vector's x or y value is greater than v's x or y value, replace that value with the corresponding min value.
     *
     * @param vector2 source Vector2
     * @return Vector2
     */
    public native Vector2 min(Vector2 vector2);

    /**
     * Multiplies this vector by scalar s.
     *
     * @param vector2 source Vector2
     * @return Vector2
     */
    public native Vector2 multiply(Vector2 vector2);

    /**
     * Multiplies this vector by scalar s.
     *
     * @param scalar source float scalar
     * @return Vector2
     */
    public native Vector2 multiplyScalar(float scalar);

    /**
     * Rotates the vector around center by angle radians.
     *
     * @param center - the point around which to rotate.
     * @param angle  - the angle to rotate, in radians.
     * @return Vector2
     */
    public native Vector2 rotateAround(Vector2 center, float angle);

    /**
     * The components of the vector are rounded to the nearest integer value
     *
     * @return Vector2
     */
    public native Vector2 round();

    /**
     * The components of the vector are rounded towards zero (up if negative, down if positive) to an integer value.
     *
     * @return instance of Vector2
     */
    public native Vector2 roundToZero();

    /**
     * Sets the x and y components of this vector.
     *
     * @param x component
     * @param y component
     * @return Vector2
     */
    public native Vector2 set(float x, float y);

    /**
     * If index equals 0 set x to value.
     * If index equals 1 set y to value
     *
     * @param index - 0 or 1.
     * @param value - float
     */
    public native void setComponent(int index, float value);

    /**
     * Sets this vector to the vector with the same direction as this one, but length l.
     *
     * @param length as float
     * @return Vector2
     */
    public native Vector2 setLength(float length);

    /**
     * Sets the x and y values of this vector both equal to scalar.
     *
     * @param scalar as float
     * @return Vector2
     */
    public native Vector2 setScalar(float scalar);

    /**
     * Replaces this vector's x value with x.
     *
     * @param x component of Vector2
     * @return Vector2
     */
    public native Vector2 setX(float x);

    /**
     * Replaces this vector's y value with y.
     *
     * @param y component of Vector2
     * @return Vector2
     */
    public native Vector2 setY(float y);

    /**
     * Subtracts v from this vector.
     *
     * @param vector2 Subtract from
     * @return Vector2
     */
    public native Vector2 sub(Vector2 vector2);

    /**
     * Subtracts s from this vector's x and y components.
     *
     * @param scalar Subtract float scalar
     * @return Vector2
     */
    public native Vector2 subScalar(float scalar);

    /**
     * Sets this vector to a - b.
     *
     * @param vector1 sub vector
     * @param vector2 sub vector
     * @return Vector2
     */
    public native Vector2 subVectors(Vector2 vector1, Vector2 vector2);

    /**
     * Returns an array [x, y], or copies x and y into the provided array.
     *
     * @return float[]
     */
    public native float[] toArray();

    /**
     * Returns an array [x, y], or copies x and y into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Returns an array [x, y], or copies x and y into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @return float[]
     */
    public native float[] toArray(JsArrayLike array);

    /**
     * Returns an array [x, y], or copies x and y into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @param index - offset into the array.
     * @return float[]
     */
    public native float[] toArray(float[] array, int index);

    /**
     * Returns an array [x, y], or copies x and y into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @param index - offset into the array.
     * @return float[]
     */
    public native float[] toArray(JsArrayLike array, int index);

}
