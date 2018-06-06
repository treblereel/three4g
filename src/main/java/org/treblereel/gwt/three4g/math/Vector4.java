package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Vector4 implements Vector {


    /**
     * Used to check whether this or derived classes are Vector4s. Default is true.
     * <p>
     * You should not change this, as it is used internally for optimisation.
     */
    public boolean isVector4;

    /**
     * x - the x value of the vector. Default is 0.
     * y - the y value of the vector. Default is 0.
     * z - the z value of the vector. Default is 0.
     * w - the w value of the vector. Default is 1.
     */
    public float x, y, z, w;


    @JsConstructor
    public Vector4() {

    }

    @JsConstructor
    public Vector4(float x, float y, float z, float w) {

    }

    /**
     * Adds v to this vector.
     *
     * @param vector4 instance of Vector4
     * @return Vector4
     */
    public native Vector4 add(Vector4 vector4);

    /**
     * Adds the scalar value s to this vector's x, y and z values.
     *
     * @param scalar as float value
     * @return Vector4
     */
    public native Vector4 addScalar(float scalar);

    /**
     * Adds the multiple of v and s to this vector.
     *
     * @param vector4 instance of Vector4
     * @param scalar  as float value
     * @return Vector4
     */
    public native Vector4 addScaledVector(Vector4 vector4, float scalar);

    /**
     * Sets this vector to a + b.
     *
     * @param a instance of Vector4
     * @param b instance of Vector4
     * @return Vector4
     */
    public native Vector4 addVectors(Vector4 a, Vector4 b);

    /**
     * Multiplies this vector by 4 x 4 m.
     *
     * @param matrix4 instance of Matrix4
     * @return Vector4
     */
    public native Vector4 applyMatrix4(Matrix4 matrix4);

    /**
     * The x, y, z and w components of the vector are rounded up to the nearest integer value.
     *
     * @return Vector4
     */
    public native Vector4 ceil();

    /**
     * If this vector's x, y, z or w value is greater than the max vector's x, y, z or w value, it is replaced by the corresponding value.
     * <p>
     * If this vector's x, y, z or w value is less than the min vector's x, y, z or w value, it is replaced by the corresponding value.
     *
     * @param min - the minimum x, y, z and w values.
     * @param max - the maximum x, y, z and w values in the desired range
     * @return Vector4
     */
    public native Vector4 clamp(Vector4 min, Vector4 max);

    /**
     * If this vector's length is greater than the max value, it is replaced by the max value.
     * <p>
     * If this vector's length is less than the min value, it is replaced by the min value.
     *
     * @param min - the minimum value the length will be clamped to
     * @param max - the maximum value the length will be clamped to
     * @return Vector4
     */
    public native Vector4 clampLength(float min, float max);

    /**
     * If this vector's x, y, z or w values are greater than the max value, they are replaced by the max value.
     * <p>
     * If this vector's x, y, z or w values are less than the min value, they are replaced by the min value.
     *
     * @param min - the minimum value the components will be clamped to
     * @param max - the maximum value the components will be clamped to
     * @return Vector4
     */
    public native Vector4 clampScalar(float min, float max);

    /**
     * Returns a new Vector4 with the same x and y values as this one.
     *
     * @return Vector4
     */
    public native Vector4 clone();

    /**
     * Copies the values of the passed Vector4's x and y properties to this Vector4.
     *
     * @param vector4 instance of Vector4
     * @return Vector4
     */
    public native Vector4 copy(Vector4 vector4);

    /**
     * Divides this vector by scalar s.
     * Sets vector to ( 0, 0, 0, 0 ) if *s = 0*.
     *
     * @param scalar as float value
     * @return Vector4
     */
    public native Vector4 divideScalar(float scalar);

    /**
     * Calculates the dot product of this vector and v.
     *
     * @param vector4 instance of Vector4
     * @return float
     */
    public native float dot(Vector4 vector4);

    /**
     * Checks for strict equality of this vector and v.
     *
     * @param vector4 instance of Vector4
     * @return boolean
     */
    public native boolean equals(Vector4 vector4);

    /**
     * The components of the vector are rounded down to the nearest integer value.
     *
     * @return Vector4
     */
    public native Vector4 floor();

    /**
     * Sets this vector's x value to be array[ offset + 0 ], y value to be array[ offset + 1 ] z value to be array[ offset + 2 ]
     * and w value to be array[ offset + 3 ].
     *
     * @param array - the source array.
     * @return Vector4
     */
    public native Vector4 fromArray(float[] array);

    /**
     * Sets this vector's x value to be array[ offset + 0 ], y value to be array[ offset + 1 ] z value to be array[ offset + 2 ]
     * and w value to be array[ offset + 3 ].
     *
     * @param array  - the source array.
     * @param offset - (optional) offset into the array. Default is 0.
     * @return Vector4
     */
    public native Vector4 fromArray(float[] array, float offset);

    /**
     * Sets this vector's x, y, z and w values from the attribute.
     *
     * @param attribute - the source attribute.
     * @param index     - index in the attribute.
     * @return Vector4
     */
    public native Vector4 fromBufferAttribute(BufferAttribute attribute, int index);

    /**
     * If index equals 0 returns the x value.
     * If index equals 1 returns the y value.
     * If index equals 2 returns the z value.
     * If index equals 3 returns the w value.
     *
     * @param index - 0, 1, 2 or 3.
     * @return float
     */
    public native float getComponent(int index);

    /**
     * Computes the Euclidean length (straight-line length) from (0, 0, 0, 0) to (x, y, z, w).
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
     * Computes the square of the Euclidean length (straight-line length) from (0, 0, 0, 0) to (x, y, z, w). If you are
     * comparing the lengths of vectors, you should compare the length squared instead as it is slightly more efficient
     * to calculate.
     *
     * @return float
     */
    public native float lengthSq();

    /**
     * Linearly interpolates between this vector and v, where alpha is the distance along
     * the line - alpha = 0 will be this vector, and alpha = 1 will be v.
     *
     * @param v     - Vector4 to interpolate towards.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Vector4
     */
    public native Vector4 lerp(Vector4 v, float alpha);

    /**
     * v1 - the starting Vector4.
     * v2 - Vector4 to interpolate towards.
     * alpha - interpolation factor in the closed interval [0, 1].
     * <p>
     * Sets this vector to be the vector linearly interpolated between v1 and v2 where alpha is the distance along
     * the line connecting the two vectors - alpha = 0 will be v1, and alpha = 1 will be v2.
     *
     * @param v1    - the starting Vector4.
     * @param v2    - Vector4 to interpolate towards.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Vector4
     */
    public native Vector4 lerpVectors(Vector4 v1, Vector4 v2, float alpha);

    /**
     * Inverts this vector - i.e. sets x = -x, y = -y, z = -z and w = -w.
     *
     * @return Vector4
     */
    public native Vector4 negate();

    /**
     * Converts this vector to a unit vector - that is, sets it equal to the vector with the same direction as this one, but length 1.
     *
     * @return Vector4
     */
    public native Vector4 normalize();

    /**
     * If this vector's x, y or z value is less than v's x, y or z value, replace that value with the corresponding max value.
     *
     * @param Vector4 instance of Vector4
     * @return Vector4
     */
    public native Vector4 max(Vector4 Vector4);

    /**
     * If this vector's x, y or z value is greater than v's x, y or z value, replace that value with the corresponding min value.
     *
     * @param Vector4 instance of Vector4
     * @return Vector4
     */
    public native Vector4 min(Vector4 Vector4);

    /**
     * Multiplies this vector by scalar s.
     *
     * @param scalar as float value
     * @return Vector4
     */
    public native Vector4 multiplyScalar(float scalar);

    /**
     * The components of the vector are rounded to the nearest integer value
     *
     * @return Vector4 instance of Vector4
     */
    public native Vector4 round();

    /**
     * The components of the vector are rounded towards zero (up if negative, down if positive) to an integer value.
     *
     * @return Vector4
     */
    public native Vector4 roundToZero();

    /**
     * Sets the x, y and z components of this vector.
     *
     * @param x as float value
     * @param y as float value
     * @param z as float value
     * @param w as float value
     * @return Vector4
     */
    public native Vector4 set(float x, float y, float z, float w);

    /**
     * Sets the x, y and z components of this vector to the quaternion's axis and w to the angle.
     *
     * @param quaternion - a normalized Quaterion
     * @return Vector4
     */
    public native Vector4 setAxisAngleFromQuaternion(Quaternion quaternion);

    /**
     * Sets the x, y and z to the axis of rotation and w to the angle.
     *
     * @param m - a Matrix4 of which the upper left 3x3 matrix is a pure rotation matrix.
     * @return Vector4
     */
    public native Vector4 setAxisAngleFromRotationMatrix(Matrix4 m);

    /**
     * If index equals 0 set x to value.
     * If index equals 1 set y to value
     * If index equals 2 set z to value
     * If index equals 3 set w to value.
     *
     * @param index - 0, 1 or 2.
     * @param value - float
     */
    public native void setComponent(int index, float value);

    /**
     * Sets this vector to the vector with the same direction as this one, but length l.
     *
     * @param length as float value
     * @return Vector4
     */
    public native Vector4 setLength(float length);

    /**
     * Set the x, y, z and w values of this vector both equal to scalar.
     *
     * @param scalar as float value
     * @return Vector4
     */
    public native Vector4 setScalar(float scalar);

    /**
     * Replaces this vector's x value with x.
     *
     * @param x as float value
     * @return Vector4
     */
    public native Vector4 setX(float x);

    /**
     * Replaces this vector's y value with y.
     *
     * @param y as float value
     * @return Vector4
     */
    public native Vector4 setY(float y);

    /**
     * Replaces this vector's z value with z.
     *
     * @param z as float value
     * @return Vector4
     */
    public native Vector4 setZ(float z);

    /**
     * Replaces this vector's w value with w.
     *
     * @param w as float value
     * @return Vector4
     */
    public native Vector4 setW(float w);

    /**
     * Subtracts v from this vector.
     *
     * @param Vector4 instance of Vector4
     * @return Vector4
     */
    public native Vector4 sub(Vector4 Vector4);

    /**
     * Subtracts s from this vector's x and y components.
     *
     * @param scalar as float value
     * @return Vector4
     */
    public native Vector4 subScalar(float scalar);

    /**
     * Sets this vector to a - b.
     *
     * @param vector1 instance of Vector4
     * @param vector2 instance of Vector4
     * @return Vector4
     */
    public native Vector4 subVectors(Vector4 vector1, Vector4 vector2);

    /**
     * Returns an array [x, y, z, w], or copies x, y, z and w into the provided array.
     *
     * @return float[]
     */
    public native float[] toArray();

    /**
     * Returns an array [x, y, z, w], or copies x, y, z and w into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Returns an array [x, y, z, w], or copies x, y, z and w into the provided array.
     *
     * @param array  - array to store the vector to. If this is not provided, a new array will be created.
     * @param offset - optional offset into the array.
     * @return float[]
     */
    public native float[] toArray(float[] array, int offset);

}
