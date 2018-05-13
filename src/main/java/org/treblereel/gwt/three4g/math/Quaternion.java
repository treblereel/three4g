package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Quaternion {

    /**
     * x - x coordinate
     * y - y coordinate
     * z - z coordinate
     * w - w coordinate
     * <p>
     * Changing this property will result in onChangeCallback being called.
     */
    public float x, y, z, w;

    @JsConstructor
    public Quaternion() {

    }

    @JsConstructor
    public Quaternion(float x, float y, float z, float w) {

    }

    /**
     * Returns a new Quaternion with the same x and y values as this one.
     *
     * @return Quaternion
     */
    public native Quaternion clone();

    /**
     * Returns the rotational conjugate of this quaternion. The conjugate of a quaternion represents the same rotation in
     * the opposite direction about the rotational axis.
     *
     * @return Quaternion
     */
    public native Quaternion conjugate();

    /**
     * Copies the x, y,	z and w properties of q into this quaternion.
     *
     * @param quaternion target Quaternion
     * @return instance of Quaternion
     */
    public native Quaternion copy(Quaternion quaternion);

    /**
     * @param quaternion - Quaternion that this quaternion will be compared to.
     * @return boolean
     */
    public native boolean equals(Quaternion quaternion);

    /**
     * Calculates the dot product of quaternions v and this one.
     *
     * @param quaternion Quaternion
     * @return float
     */
    public native float dot(Quaternion quaternion);

    /**
     * Sets this quaternion's x, y,	z and w properties from an array.
     *
     * @param array - array of format (x, y, z, w) used to construct the quaternion.
     * @return Quaternion
     */
    public native Quaternion fromArray(float[] array);

    /**
     * Sets this quaternion's x, y,	z and w properties from an array.
     *
     * @param array  - array of format (x, y, z, w) used to construct the quaternion.
     * @param offset - (optional) offset into the array. Default is 0.
     * @return Quaternion
     */
    public native Quaternion fromArray(float[] array, float offset);

    /**
     * Inverts this quaternion - calculate the conjugate and then normalizes the result.
     *
     * @return Quaternion
     */
    public native Quaternion inverse();

    /**
     * Computes the Euclidean length (straight-line length) of this quaternion, considered as a 4 dimensional vector.
     *
     * @return float
     */
    public native float length();

    /**
     * Computes the Euclidean length (straight-line length) of this quaternion, considered as a 4 dimensional vector.
     * This can be useful if you are comparing the lengths of two quaternions, as this is a slightly more efficient
     * calculation than length().
     *
     * @return float
     */
    public native float lengthSq();

    /**
     * Normalizes this quaternion - that is, calculated the quaternion that performs the same rotation as this one,
     * but has length equal to 1.
     *
     * @return instance of Quaternion
     */
    public native Quaternion normalize();

    /**
     * Multiplies this quaternion by q.
     *
     * @param quaternion Quaternion
     * @return instance of Quaternion
     */
    public native Quaternion multiply(Quaternion quaternion);

    /**
     * Sets this quaternion to a x b.
     * Adapted from the method outlined here.
     *
     * @param quaternion1 Quaternion
     * @param quaternion2 Quaternion
     * @return instance of Quaternion
     */
    public native Quaternion multiplyQuaternions(Quaternion quaternion1, Quaternion quaternion2);

    /**
     * This function is called whenever any of the following occurs:
     * The x, y, z or w properties are changed.
     * The set(), copy(), clone(), setFromAxisAngle(), setFromRotationMatrix(), conjugate(), normalize(), multiplyQuaternions(), slerp() or fromArray() functions are called.
     * setFromEuler() function is called with its update argument set to true.
     * By default it is the empty function, however you can change it if needed using onChange( onChangeCallback ).
     *
     * @param onChangeCallback onChangeCallback
     * @return instance of Quaternion
     */
    public native Quaternion onChange(OnChangeCallback onChangeCallback);


    /**
     * This function is called whenever any of the following occurs:
     * The x, y, z or w properties are changed.
     * The set(), copy(), clone(), setFromAxisAngle(), setFromRotationMatrix(), conjugate(), normalize(), multiplyQuaternions(),
     * slerp() or fromArray() functions are called.
     * setFromEuler() function is called with its update argument set to true.
     * By default it is the empty function, however you can change it if needed using onChange( onChangeCallback ).
     *
     * @return instance of Quaternion
     */
    public native Quaternion onChangeCallback();

    /**
     * Pre-multiplies this quaternion by quaternion.
     *
     * @param quaternion Quaternion
     * @return instance of Quaternion
     */
    public native Quaternion premultiply(Quaternion quaternion);

    /**
     * Handles the spherical linear interpolation between quaternions. t represents the amount of rotation between this quaternion (where t is 0) and qb (where t is 1). This quaternion is set to the result. Also see the static version of the slerp below.
     * // rotate a mesh towards a target quaternion
     * mesh.quaternion.slerp( endQuaternion, 0.01 );
     *
     * @param qb - The other quaternion rotation
     * @param t  - interpolation factor in the closed interval [0, 1].
     * @return instance of Quaternion
     */
    public native Quaternion slerp(Quaternion qb, float t);

    /**
     * Sets the x, y and z components of this quaternion.
     *
     * @param x components
     * @param y components
     * @param z components
     * @param w components
     * @return instance of Quaternion
     */
    public native Quaternion set(float x, float y, float z, float w);


    /**
     * Sets this quaternion from rotation specified by axis and angle.
     * Adapted from the method here.
     * Axis is assumed to be normalized, angle is in radians.
     *
     * @param axis  Vector3
     * @param angle is in radians
     * @return instance of Quaternion
     */
    public native Quaternion setFromAxisAngle(Vector3 axis, float angle);

    /**
     * Applies euler transform to this vector by converting the Euler object to a Quaternion and applying.
     *
     * @param euler source Euler
     * @return instance of Quaternion
     */
    public native Quaternion setFromEuler(Euler euler);

    /**
     * Sets this quaternion from rotation component of m.
     * Adapted from the method here.
     *
     * @param m source Matrix4
     * @return instance of Quaternion
     */
    public native Quaternion setFromRotationMatrix(Matrix4 m);

    /**
     * Sets this quaternion to the rotation required to rotate direction vector vFrom to direction vector vTo.
     * Adapted from the method here.
     * vFrom and vTo are assumed to be normalized.
     *
     * @param vFrom Vector3
     * @param vTo   Vector3
     * @return instance of Quaternion
     */
    public native Quaternion setFromUnitVectors(Vector3 vFrom, Vector3 vTo);

    /**
     * Returns the numerical elements of this quaternion in an array of format [x, y, z, w].
     *
     * @param array - An optional array to store the quaternion. If not specified, a new array will be created.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Returns the numerical elements of this quaternion in an array of format [x, y, z, w].
     *
     * @param array  - An optional array to store the quaternion. If not specified, a new array will be created.
     * @param offset - optional offset into the array.
     * @return float[]
     */
    public native float[] toArray(float[] array, int offset);


    /**
     * Unlike the normal method, the static version of slerp sets a target quaternion to the result of the slerp operation.
     * // Code setup
     * var startQuaternion = new Quaternion().set( 0, 0, 0, 1 ).normalize();
     * var endQuaternion = new Quaternion().set( 1, 1, 1, 1 ).normalize();
     * var t = 0;
     * <p>
     * // Update a mesh's rotation in the loop
     * t = ( t + 0.01 ) % 1; // constant angular momentum
     * Quaternion.slerp( startQuaternion, endQuaternion, mesh.quaternion, t );
     *
     * @param qStart  - The starting quaternion (where t is 0)
     * @param qEnd    - The ending quaternion (where t is 1)
     * @param qTarget - The target quaternion that gets set with the result
     * @param t       - interpolation factor in the closed interval [0, 1].
     * @return instance of Quaternion
     */
    public native Quaternion slerp(Quaternion qStart, Quaternion qEnd, Quaternion qTarget, float t);

    /**
     * Like the static slerp method above, but operates directly on flat arrays of numbers.
     *
     * @param dst        - The output array.
     * @param dstOffset  - An offset into the output array.
     * @param src0       - The source array of the starting quaternion.
     * @param srcOffset0 - An offset into the array src0.
     * @param src1       - The source array of the target quatnerion.
     * @param srcOffset1 - An offset into the array src1.
     * @param t          - Normalized interpolation factor (between 0 and 1).
     */
    public native void slerpFlat(float[] dst, int dstOffset, float[] src0, int srcOffset0, float[] src1, int srcOffset1, float t);


}
