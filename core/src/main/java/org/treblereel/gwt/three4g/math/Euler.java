package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Euler {

    /**
     * the angle of the x, y and z axis in radians. Default is 0.
     */
    public float x, y, z;

    /**
     * Used to check whether this or derived classes are Eulers. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isEuler;

    /**
     * The order in which to apply rotations. Default is 'XYZ', which means that the object will first be rotated around its X axis, then its Y axis and finally its Z axis. Other possibilities are: 'YZX', 'ZXY', 'XZY', 'YXZ' and 'ZYX'. These must be in upper case.
     * <p>
     * Three.js uses intrinsic Tait-Bryan angles. This means that rotations are performed with respect to the local coordinate system. That is, for order 'XYZ', the rotation is first around the local-X axis (which is the same as the world-X axis), then around local-Y (which may now be different from the world Y-axis), then local-Z (which may be different from the world Z-axis).
     * <p>
     * If the order is changed, onChangeCallback will be called.
     */
    public String order;


    public Euler() {

    }

    public Euler(float x) {

    }

    public Euler(float x, float y) {

    }

    public Euler(float x, float y, float z) {

    }

    public Euler(float x, float y, float z, String order) {

    }

    /**
     * Copies value of euler to this euler.
     *
     * @param euler Euler
     * @return Euler
     */
    public native Euler copy(Euler euler);

    /**
     * Checks for strict equality of this Euler and euler.
     *
     * @param euler Euler
     * @return boolean
     */
    public native boolean equals(Euler euler);

    /**
     * array of length 3 or 4. The optional 4th argument corresponds to the order.
     * Assigns this euler's x angle to array[0].
     * Assigns this euler's y angle to array[1].
     * Assigns this euler's z angle to array[2].
     *
     * @param array float[] array
     * @return Euler
     */
    public native Euler fromArray(float[] array);

    /**
     * Assigns this euler's x angle to array[0].
     * Assigns this euler's y angle to array[1].
     * Assigns this euler's z angle to array[2].
     *
     * @param array of length 3 or 4. The optional 4th argument corresponds to the order.
     * @param order a string representing the order that the rotations are applied.
     * @return Euler
     */
    public native Euler fromArray(float[] array, String order);

    /**
     * By default this is an empty function, however it can be set via onChange().
     * It gets called after changing the x, y, z or order properties, and also after calling most setter functions (see those for details).
     *
     * @return Euler
     */
    public native Euler onChangeCallback();

    /**
     * onChangeCallback - set the value of the onChangeCallback() function.
     *
     * @param onChangeCallback Callback
     * @return Euler
     */
    public native Euler onChange(OnChangeCallback onChangeCallback);

    /**
     * Resets the euler angle with a new order by creating a quaternion from this euler angle and then setting this euler angle with the quaternion and the new order.
     * <p>
     * WARNING: this discards revolution information.
     *
     * @param newOrder new order
     * @return Euler
     */
    public native Euler reorder(String newOrder);

    /**
     * Sets the angles of this euler transform and optionally the order and then call onChangeCallback().
     *
     * @param x - the angle of the x axis in radians.
     * @param y - the angle of the y axis in radians.
     * @param z - the angle of the z axis in radians.
     * @return Euler
     */
    public native Euler set(float x, float y, float z);

    /**
     * Sets the angles of this euler transform and optionally the order and then call onChangeCallback().
     *
     * @param x     - the angle of the x axis in radians.
     * @param y     - the angle of the y axis in radians.
     * @param z     - the angle of the z axis in radians.
     * @param order - (optional) a string representing the order that the rotations are applied.
     * @return Euler
     */
    public native Euler set(float x, float y, float z, String order);

    /**
     * m - a Matrix4 of which the upper 3x3 of matrix is a pure rotation matrix (i.e. unscaled).
     * Sets the angles of this euler transform from a pure rotation matrix based on the orientation specified by order.
     *
     * @param m - a Matrix4 of which the upper 3x3 of matrix is a pure rotation matrix (i.e. unscaled).
     * @return Euler
     */
    public native Euler setFromRotationMatrix(Matrix4 m);

    /**
     * Sets the angles of this euler transform from a pure rotation matrix based on the orientation specified by order.
     *
     * @param m     - a Matrix4 of which the upper 3x3 of matrix is a pure rotation matrix (i.e. unscaled).
     * @param order - a string representing the order that the rotations are applied.
     * @return Euler
     */
    public native Euler setFromRotationMatrix(Matrix4 m, String order);

    /**
     * Sets the angles of this euler transform from a normalized quaternion based on the orientation specified by order.
     *
     * @param q - a normalized quaternion.
     * @return Euler
     */
    public native Euler setFromQuaternion(Quaternion q);

    /**
     * Sets the angles of this euler transform from a normalized quaternion based on the orientation specified by order.
     *
     * @param q     - a normalized quaternion.
     * @param order - a string representing the order that the rotations are applied.
     * @return Euler
     */
    public native Euler setFromQuaternion(Quaternion q, String order);

    /**
     * Set the x, y and z, and optionally update the order. onChangeCallback() is called after these changes are made.
     *
     * @param vector - Vector3.
     * @return Euler
     */
    public native Euler setFromVector3(Vector3 vector);

    /**
     * Set the x, y and z, and optionally update the order. onChangeCallback() is called after these changes are made.
     *
     * @param vector - Vector3.
     * @param order  - a string representing the order that the rotations are applied.
     * @return Euler
     */
    public native Euler setFromVector3(Vector3 vector, String order);

    /**
     * Returns an array of the form [x, y, z, order ].
     *
     * @return float[]
     */
    public native float[] toArray();

    /**
     * Returns an array of the form [x, y, z, order ].
     *
     * @param array - array to store the euler in.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Returns an array of the form [x, y, z, order ].
     *
     * @param array  - array to store the euler in.
     * @param offset offset in the array.
     * @return float[]
     */
    public native float[] toArray(float[] array, int offset);

    /**
     * Returns the Euler's x, y and z properties as a Vector3.
     *
     * @return Vector3
     */
    public native Vector3 toVector3();

}
