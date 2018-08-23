package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 2/28/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Vector3 implements Vector {

    /**
     * Used to check whether this or derived classes are Vector3s. Default is true.
     * <p>
     * You should not change this, as it is used internally for optimisation.
     */
    public boolean isVector3;

    public float x, y, z;

    @JsConstructor
    public Vector3() {

    }

    @JsConstructor
    public Vector3(float x, float y, float z) {

    }

    /**
     * Adds v to this vector.
     *
     * @param vector3 source Vector3
     * @return Vector3
     */
    public native Vector3 add(Vector3 vector3);

    /**
     * Adds the scalar value s to this vector's x, y and z values.
     *
     * @param scalar as float value
     * @return Vector3
     */
    public native Vector3 addScalar(float scalar);

    /**
     * Adds the multiple of v and s to this vector.
     *
     * @param vector3 as Vector3 value
     * @param scalar  as float value
     * @return Vector3
     */
    public native Vector3 addScaledVector(Vector3 vector3, float scalar);

    /**
     * Sets this vector to a + b.
     *
     * @param a instance of Vector3
     * @param b instance of Vector3
     * @return instance of Vector3
     */
    public native Vector3 addVectors(Vector3 a, Vector3 b);

    /**
     * Applies a rotation specified by an axis and an angle to this vector.
     *
     * @param axis  - A normalized Vector3.
     * @param angle - An angle in radians.
     * @return Vector3
     */
    public native Vector3 applyAxisAngle(Vector3 axis, float angle);

    /**
     * Applies euler transform to this vector by converting the Euler object to a Quaternion and applying.
     *
     * @param euler instance of Euler
     * @return Vector3
     */
    public native Vector3 applyEuler(Euler euler);

    /**
     * Multiplies this vector by m.
     *
     * @param matrix3 source of Matrix3
     * @return Vector3
     */
    public native Vector3 applyMatrix3(Matrix3 matrix3);

    /**
     * Multiplies this vector (with an implicit 1 in the 4th dimension) and m, and divides by perspective.
     *
     * @param matrix4 source of Matrix4
     * @return Vector3
     */
    public native Vector3 applyMatrix4(Matrix4 matrix4);

    /**
     * Applies a Quaternion transform to this vector.
     *
     * @param quaternion source of Quaternion
     * @return Vector3
     */
    public native Vector3 applyQuaternion(Quaternion quaternion);

    /**
     * Returns the angle between this vector and vector v in radians.
     *
     * @param vector3 targeting Vector3
     * @return Vector3
     */
    public native Vector3 applyTo(Vector3 vector3);

    /**
     * The x, y and z components of the vector are rounded up to the nearest integer value.
     *
     * @return Vector3
     */
    public native Vector3 ceil();

    /**
     * If this vector's x, y or z value is greater than the max vector's x, y or z value, it is replaced by the corresponding value.
     * <p>
     * If this vector's x, y or z value is less than the min vector's x, y or z value, it is replaced by the corresponding value.
     *
     * @param min - the minimum x, y and z values.
     * @param max - the maximum x, y and z values in the desired range
     * @return Vector3
     */
    public native Vector3 clamp(Vector3 min, Vector3 max);

    /**
     * If this vector's length is greater than the max value, it is replaced by the max value.
     * <p>
     * If this vector's length is less than the min value, it is replaced by the min value.
     *
     * @param min - the minimum value the length will be clamped to
     * @param max - the maximum value the length will be clamped to
     * @return Vector3
     */
    public native Vector3 clampLength(float min, float max);

    /**
     * If this vector's x, y or z values are greater than the max value, they are replaced by the max value.
     * <p>
     * If this vector's x, y or z values are less than the min value, they are replaced by the min value.
     *
     * @param min - the minimum value the components will be clamped to
     * @param max - the maximum value the components will be clamped to
     * @return Vector3
     */
    public native Vector3 clampScalar(float min, float max);

    /**
     * Returns a new Vector3 with the same x and y values as this one.
     *
     * @return Vector3
     */
    public native Vector3 clone();

    /**
     * Copies the values of the passed Vector3's x and y properties to this Vector3.
     *
     * @param vector3 source Vector3
     * @return Vector3
     */
    public native Vector3 copy(Vector3 vector3);

    /**
     * Sets this vector to cross product of itself and v.
     *
     * @param vector3 source Vector3
     * @return Vector3
     */
    public native Vector3 cross(Vector3 vector3);

    /**
     * Sets this vector to cross product of a and b.
     *
     * @param a as Vector3
     * @param b as Vector3
     * @return Vector3
     */
    public native Vector3 crossVectors(Vector3 a, Vector3 b);

    /**
     * computes the distance from this vector to v.
     *
     * @param vector3 targeting Vector3
     * @return float
     */
    public native float distanceTo(Vector3 vector3);

    /**
     * Computes the Manhattan distance from this vector to v.
     *
     * @param vector3 targeting Vector3
     * @return float
     */
    public native float manhattanDistanceTo(Vector3 vector3);

    /**
     * Computes the squared distance from this vector to v. If you are just comparing the distance with another distance,
     * you should compare the distance squared instead as it is slightly more efficient to calculate.
     *
     * @param vector3 targeting Vector3
     * @return float
     */
    public native float distanceToSquared(Vector3 vector3);

    /**
     * Divides this vector by v.
     *
     * @param vector3 instance of Vector3
     * @return Vector3
     */
    public native Vector3 divide(Vector3 vector3);

    /**
     * Divides this vector by scalar s.
     * Sets vector to ( 0, 0, 0 ) if *s = 0*.
     *
     * @param scalar as float value
     * @return Vector3
     */
    public native Vector3 divideScalar(float scalar);

    /**
     * Calculates the dot product of this vector and v.
     *
     * @param vector3 instance of Vector3
     * @return float
     */
    public native float dot(Vector3 vector3);

    /**
     * Checks for strict equality of this vector and v.
     *
     * @param vector3 instance of Vector3
     * @return true if vectors are equal
     */
    public native boolean equals(Vector3 vector3);

    /**
     * The components of the vector are rounded down to the nearest integer value.
     *
     * @return Vector3
     */
    public native Vector3 floor();

    /**
     * Sets this vector's x value to be array[ offset + 0 ], y value to be array[ offset + 1 ] and z value to be array[ offs
     *
     * @param array - the source array.
     * @return Vector3
     */
    public native Vector3 fromArray(float[] array);

    /**
     * Sets this vector's x value to be array[ offset + 0 ], y value to be array[ offset + 1 ] and z value to be array[ offs
     *
     * @param array - the source array.
     * @return Vector3
     */
    public native Vector3 fromArray(JsArrayLike array);

    /**
     * Sets this vector's x value to be array[ offset + 0 ], y value to be array[ offset + 1 ] and z value to be array[ offs
     *
     * @param array  - the source array.
     * @param offset - (optional) offset into the array. Default is 0.
     * @return Vector3
     */
    public native Vector3 fromArray(float[] array, float offset);

    /**
     * Sets this vector's x value to be array[ offset + 0 ], y value to be array[ offset + 1 ] and z value to be array[ offs
     *
     * @param array  - the source array.
     * @param offset - (optional) offset into the array. Default is 0.
     * @return Vector3
     */
    public native Vector3 fromArray(JsArrayLike array, float offset);

    /**
     * Sets this vector's x, y and z values from the attribute.
     *
     * @param bufferAttribute - the source attribute.
     * @param index           - index in the attribute.
     * @return Vector3
     */
    public native Vector3 fromBufferAttribute(BufferAttribute bufferAttribute, int index);

    /**
     * If index equals 0 returns the x value.
     * If index equals 1 returns the y value.
     * If index equals 2 returns the z value.
     *
     * @param index - 0, 1 or 2.
     * @return float
     */
    public native float getComponent(int index);

    /**
     * Computes the Euclidean length (straight-line length) from (0, 0, 0) to (x, y, z).
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
     * Computes the square of the Euclidean length (straight-line length) from (0, 0, 0) to (x, y, z). If you
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
     * @param v     - Vector3 to interpolate towards.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Vector3
     */
    public native Vector3 lerp(Vector3 v, float alpha);

    /**
     * Sets this vector to be the vector linearly interpolated between v1 and v2 where alpha is the distance along
     * the line connecting the two vectors - alpha = 0 will be v1, and alpha = 1 will be v2.
     *
     * @param v1    - the starting Vector3.
     * @param v2    - Vector3 to interpolate towards.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Vector3
     */
    public native Vector3 lerpVectors(Vector3 v1, Vector3 v2, float alpha);

    /**
     * Inverts this vector - i.e. sets x = -x, y = -y and z = -z.
     *
     * @return Vector3
     */
    public native Vector3 negate();

    /**
     * Converts this vector to a unit vector - that is, sets it equal to the vector with the same direction as this one, but length 1.
     *
     * @return Vector3
     */
    public native Vector3 normalize();

    /**
     * If this vector's x, y or z value is less than v's x, y or z value, replace that value with the corresponding max value.
     *
     * @param vector3 instance of Vector3
     * @return Vector3
     */
    public native Vector3 max(Vector3 vector3);

    /**
     * If this vector's x, y or z value is greater than v's x, y or z value, replace that value with the corresponding min value.
     *
     * @param vector3 instance of Vector3
     * @return Vector3
     */
    public native Vector3 min(Vector3 vector3);

    /**
     * Multiplies this vector by scalar s.
     *
     * @param vector3 instance of Vector3
     * @return Vector3
     */
    public native Vector3 multiply(Vector3 vector3);

    /**
     * Multiplies this vector by scalar s.
     *
     * @param scalar instance of float
     * @return Vector3
     */
    public native Vector3 multiplyScalar(float scalar);

    /**
     * Sets this vector equal to a * b, component-wise.
     *
     * @param a instance of Vector3
     * @param b instance of Vector3
     * @return Vector3
     */
    public native Vector3 multiplyVectors(Vector3 a, Vector3 b);

    /**
     * Projects this vector onto a plane by subtracting this vector projected onto the plane's normal from this vector.
     *
     * @param planeNormal - A vector representing a plane normal.
     * @return Vector3
     */
    public native Vector3 projectOnPlane(Vector3 planeNormal);

    /**
     * Projects this vector onto another vector.
     *
     * @param vector3 instance of Vector3
     * @return Vector3
     */
    public native Vector3 projectOnVector(Vector3 vector3);

    /**
     * Reflect the vector off of plane orthogonal to normal. Normal is assumed to have unit length.
     *
     * @param normal - the normal to the reflecting plane
     * @return Vector3
     */
    public native Vector3 reflect(Vector3 normal);

    /**
     * The components of the vector are rounded to the nearest integer value
     *
     * @return Vector3
     */
    public native Vector3 round();

    /**
     * The components of the vector are rounded towards zero (up if negative, down if positive) to an integer value.
     *
     * @return Vector3
     */
    public native Vector3 roundToZero();

    /**
     * Sets the x, y and z components of this vector.
     *
     * @param x instance of float
     * @param y instance of float
     * @param z instance of float
     * @return Vector3
     */
    public native Vector3 set(float x, float y, float z);

    /**
     * If index equals 0 set x to value.
     * If index equals 1 set y to value
     * If index equals 2 set z to value
     *
     * @param index - 0, 1 or 2.
     * @param value - float
     */
    public native void setComponent(int index, float value);

    /**
     * Sets this vector from the cylindrical coordinates c.
     *
     * @param cylindrical instance of Cylindrical
     * @return instance of Vector3
     */
    public native Vector3 setFromCylindrical(Cylindrical cylindrical);

    /**
     * Sets this vector's x, y and z equal to the column of the matrix specified by the index.
     *
     * @param matrix4 instance of Matrix4
     * @param index   of column
     * @return instance of Vector3
     */
    public native Vector3 setFromMatrixColumn(Matrix4 matrix4, int index);

    /**
     * Sets this vector to the position elements of the transformation matrix m.
     *
     * @param matrix4 instance of Matrix4
     * @return instance of Vector3
     */
    public native Vector3 setFromMatrixPosition(Matrix4 matrix4);

    /**
     * Sets this vector to the scale elements of the transformation matrix m.
     *
     * @param matrix4 instance of Matrix4
     * @return instance of Vector3
     */
    public native Vector3 setFromMatrixScale(Matrix4 matrix4);

    /**
     * Sets this vector from the spherical coordinates s.
     *
     * @param spherical instance of Spherical
     * @return instance of Vector3
     */
    public native Vector3 setFromSpherical(Spherical spherical);

    /**
     * Sets this vector to the vector with the same direction as this one, but length l.
     *
     * @param length as float value
     * @return Vector3
     */
    public native Vector3 setLength(float length);

    /**
     * Set the x, y and z values of this vector both equal to scalar.
     *
     * @param scalar as float value
     * @return Vector3
     */
    public native Vector3 setScalar(float scalar);

    /**
     * Replaces this vector's x value with x.
     *
     * @param x as float value
     * @return Vector3
     */
    public native Vector3 setX(float x);

    /**
     * Replaces this vector's y value with y.
     *
     * @param y as float value
     * @return Vector3
     */
    public native Vector3 setY(float y);

    /**
     * Replaces this vector's z value with z.
     *
     * @param z as float value
     * @return Vector3
     */
    public native Vector3 setZ(float z);

    /**
     * Subtracts v from this vector.
     *
     * @param vector3 as Vector3 value
     * @return Vector3
     */
    public native Vector3 sub(Vector3 vector3);

    /**
     * Subtracts s from this vector's x and y components.
     *
     * @param scalar as float value
     * @return Vector3
     */
    public native Vector3 subScalar(float scalar);

    /**
     * Sets this vector to a - b.
     *
     * @param vector1 instance of Vector3
     * @param vector2 instance of Vector3
     * @return Vector3
     */
    public native Vector3 subVectors(Vector3 vector1, Vector3 vector2);

    /**
     * Returns an array [x, y, z], or copies x, y and z into the provided array.
     *
     * @return float[]
     */
    public native float[] toArray();

    /**
     * Returns an array [x, y, z], or copies x, y and z into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Returns an array [x, y, z], or copies x, y and z into the provided array.
     *
     * @param array - array to store the vector to. If this is not provided, a new array will be created.
     * @return float[]
     */
    public native float[] toArray(JsArrayLike array);

    /**
     * Returns an array [x, y, z], or copies x, y and z into the provided array.
     *
     * @param array  - array to store the vector to. If this is not provided, a new array will be created.
     * @param offset - optional offset into the array.
     * @return float[]
     */
    public native float[] toArray(float[] array, int offset);

    /**
     * Returns an array [x, y, z], or copies x, y and z into the provided array.
     *
     * @param array  - array to store the vector to. If this is not provided, a new array will be created.
     * @param offset - optional offset into the array.
     * @return float[]
     */
    public native float[] toArray(JsArrayLike array, int offset);

    /**
     * Transforms the direction of this vector by a matrix (the upper left 3 x 3 subset of a m) and then normalizes the result.
     *
     * @param matrix4 instance of Matrix4
     * @return Vector3
     */
    public native Vector3 transformDirection(Matrix4 matrix4);

    /**
     * Unprojects the vector with the camera's projection matrix.
     *
     * @param camera — camera to use in the projection.
     * @return instance of Vector3
     */
    public native Vector3 unproject(Camera camera);

}
