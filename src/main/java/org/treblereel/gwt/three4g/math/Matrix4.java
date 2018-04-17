package org.treblereel.gwt.three4g.math;

import elemental2.core.Float32Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * A class representing a 4x4 matrix.
 * <p>
 * The most common use of a 4x4 matrix in 3D computer graphics is as a Transformation Matrix. For an introduction to transformation matrices as used in WebGL, check out this tutorial.
 * <p>
 * This allows a Vector3 representing a point in 3D space to undergo transformations such as translation, rotation, shear, scale, reflection, orthogonal or perspective projection and so on, by being multiplied by the matrix. This is known as	applying the matrix to the vector.
 * <p>
 * Every Object3D has three associated Matrix4s:
 * Object3D.matrix: This stores the local transform of the object. This is the object's transformation relative to its parent.
 * Object3D.matrixWorld: The global or world transform of the object. If the object has no parent, then this is identical to the local transform stored in matrix.
 * Object3D.modelViewMatrix: This represents the object's transformation relative to the camera's coordinate system. An object's modelViewMatrix is the object's matrixWorld pre-multiplied by the camera's matrixWorldInverse.
 * Cameras have two additional Matrix4s:
 * Camera.matrixWorldInverse: The view matrix - the inverse of the Camera's matrixWorld.
 * Camera.projectionMatrix: Represents the information how to project the scene to clip space.
 * Note: Object3D.normalMatrix is not a Matrix4, but a Matrix3.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Matrix4 implements Matrix {

    /**
     * A column-major list of matrix values.
     */
    public Float32Array elements;

    /**
     * Used to check whether this or derived classes are Matrix4s. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMatrix4;

    @JsConstructor
    public Matrix4(){
    }

    /**
     * Multiplies (applies) this matrix to every 3D vector in the attribute.
     *
     * @param attribute - An attribute of floats that represent 3D vectors.
     * @return
     */
    public native Object[] applyToBufferAttribute(BufferAttribute attribute); //TODO

    /**
     * Creates a new Matrix4 with identical elements to this one.
     *
     * @return
     */
    public native Matrix4 clone();

    /**
     * Sets this matrix to the transformation composed of position, quaternion and scale. Internally this calls makeRotationFromQuaternion( quaternion ) followed by scale( scale ), then finally setPosition( position ).
     *
     * @param position
     * @param quaternion
     * @param scale
     * @return
     */
    public native Matrix4 compose(Vector3 position, Quaternion quaternion, Vector3 scale);

    /**
     * Copies the elements of matrix m into this matrix.
     *
     * @param m
     * @return Matrix4
     */
    public native Matrix4 copy(Matrix4 m);

    /**
     * Copies the translation component of the supplied matrix m into this matrix's translation component.
     *
     * @param m
     * @return
     */
    public native Matrix4 copyPosition(Matrix4 m);

    /**
     * Decomposes this matrix into it's position, quaternion and scale components.
     *
     * @param position
     * @param quaternion
     * @param scale
     */
    public native void decompose(Vector3 position, Quaternion quaternion, Vector3 scale);

    /**
     * Computes and returns the determinant of this matrix.
     *
     * @return
     */
    public native float determinant();

    /**
     * Return true if this matrix and m are equal.
     *
     * @param m
     * @return
     */
    public native boolean equals(Matrix4 m);

    /**
     * Extracts the basis of this matrix into the three axis vectors provided. If this matrix is:
     * a, b, c, d,
     * e, f, g, h,
     * i, j, k, l,
     * m, n, o, p then the xAxis, yAxis, zAxis will be set to:
     * xAxis = (a, e, i)
     * yAxis = (b, f, j)
     * zAxis = (c, g, k)
     *
     * @param xAxis
     * @param yAxis
     * @param zAxis
     * @return
     */
    public native Matrix4 extractBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);

    /**
     * Extracts the rotation component of the supplied matrix m into this matrix's rotation component.
     *
     * @param m
     * @return
     */
    public native Matrix4 extractRotation(Matrix4 m);


    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array - the array to read the elements from.
     * @return
     */
    public native Matrix4 fromArray(float[] array);

    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array  - the array to read the elements from.
     * @param offset - offset into the array. Default is 0.
     * @return
     */
    public native Matrix4 fromArray(float[] array, float offset);

    /**
     * Set this matrix to the inverse of the passed matrix m, using the method outlined here. If throwOnDegenerate is not
     * set and the matrix is not invertible, set this to the 4x4 identity matrix.
     *
     * @param m - the matrix to take the inverse of.
     * @return
     */
    public native Matrix4 getInverse(Matrix4 m);

    /**
     * Set this matrix to the inverse of the passed matrix m, using the method outlined here. If throwOnDegenerate is not
     * set and the matrix is not invertible, set this to the 4x4 identity matrix.
     *
     * @param m                 - the matrix to take the inverse of.
     * @param throwOnDegenerate - If true, throw an error if the matrix is degenerate (not invertible).
     * @return
     */
    public native Matrix4 getInverse(Matrix4 m, boolean throwOnDegenerate);

    /**
     * Gets the maximum scale value of the 3 axes.
     *
     * @return
     */
    public native float getMaxScaleOnAxis();

    /**
     * Resets this matrix to the identity matrix.
     *
     * @return
     */
    public native Matrix4 identity();

    /**
     * Constructs a rotation matrix, looking from eye towards center oriented by the up vector.
     *
     * @param eye
     * @param center
     * @param up
     * @return
     */
    public native Matrix4 lookAt(Vector3 eye, Vector3 center, Vector3 up);

    /**
     * Sets this matrix as rotation transform around axis by theta radians.
     * This is a somewhat controversial but mathematically sound alternative to rotating via Quaternions. See the discussion here.
     *
     * @param axis  — Rotation axis, should be normalized.
     * @param theta — Rotation angle in radians.
     * @return
     */
    public native Matrix4 makeRotationAxis(Vector3 axis, float theta);

    /**
     * Set this to the basis matrix consisting of the three provided basis vectors:
     * xAxis.x, yAxis.x, zAxis.x, 0,
     * xAxis.y, yAxis.y, zAxis.y, 0,
     * xAxis.z, yAxis.z, zAxis.z, 0,
     * 0,       0,       0,       1
     *
     * @param xAxis
     * @param yAxis
     * @param zAxis
     * @return
     */
    public native Matrix4 makeBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);


    /**
     * Creates a perspective projection matrix. This is used internally by PerspectiveCamera.updateProjectionMatrix()
     *
     * @param left
     * @param right
     * @param top
     * @param bottom
     * @param near
     * @param far
     * @return
     */
    public native Matrix4 makePerspective(float left, float right, float top, float bottom, float near, float far);

    /**
     * Creates an orthographic projection matrix. This is used internally by OrthographicCamera.updateProjectionMatrix().
     *
     * @param left
     * @param right
     * @param top
     * @param bottom
     * @param near
     * @param far
     * @return
     */
    public native Matrix4 makeOrthographic(float left, float right, float top, float bottom, float near, float far);


    /**
     * Sets the rotation component (the upper left 3x3 matrix) of this matrix to the rotation specified by the given Euler Angle. The rest of the matrix is set to the identity. Depending on the order of the euler, there are six possible outcomes. See this page for a complete list.
     *
     * @param euler
     * @return
     */
    public native Matrix4 makeRotationFromEuler(Euler euler);

    /**
     * Sets the rotation component of this matrix to the rotation specified by q, as outlined here. The rest of the matrix is set to the identity. So, given q = w + xi + yj + zk, the resulting matrix will be:
     * 1-2y²-2z²    2xy-2zw    2xz+2yw    0
     * 2xy+2zw      1-2x²-2z²  2yz-2xw    0
     * 2xz-2yw      2yz+2xw    1-2x²-2y²  0
     * 0            0          0          1
     *
     * @param q
     * @return
     */
    public native Matrix4 makeRotationFromQuaternion(Quaternion q);


    /**
     * Sets this matrix as a rotational transformation around the X axis by theta (θ) radians. The resulting matrix will be:
     * 1 0      0        0
     * 0 cos(θ) -sin(θ)  0
     * 0 sin(θ) cos(θ)   0
     * 0 0      0        1
     *
     * @param theta — Rotation angle in radians.
     * @return
     */
    public native Matrix4 makeRotationX(float theta);

    /**
     * Sets this matrix as a rotational transformation around the Y axis by theta (θ) radians. The resulting matrix will be:
     * cos(θ)  0 sin(θ) 0
     * 0       1 0      0
     * -sin(θ) 0 cos(θ) 0
     * 0       0 0      1
     *
     * @param theta — Rotation angle in radians.
     * @return
     */
    public native Matrix4 makeRotationY(float theta);


    /**
     * Sets this matrix as a rotational transformation around the Z axis by theta (θ) radians. The resulting matrix will be:
     * cos(θ) -sin(θ) 0 0
     * sin(θ) cos(θ)  0 0
     * 0      0       1 0
     * 0      0       0 1
     *
     * @param theta — Rotation angle in radians.
     * @return
     */
    public native Matrix4 makeRotationZ(float theta);

    /**
     * Sets this matrix as scale transform:
     * x, 0, 0, 0,
     * 0, y, 0, 0,
     * 0, 0, z, 0,
     * 0, 0, 0, 1
     *
     * @param x - the amount to scale in the X axis.
     * @param y - the amount to scale in the Y axis.
     * @param z - the amount to scale in the Z axis.
     * @return
     */
    public native Matrix4 makeScale(float x, float y, float z);

    /**
     * Sets this matrix as a shear transform:
     * 1, y, z, 0,
     * x, 1, z, 0,
     * x, y, 1, 0,
     * 0, 0, 0, 1
     *
     * @param x - the amount to shear in the X axis.
     * @param y - the amount to shear in the Y axis.
     * @param z - the amount to shear in the Z axis.
     * @return
     */
    public native Matrix4 makeShear(float x, float y, float z);

    /**
     * Sets this matrix as a translation transform:
     * 1, 0, 0, x,
     * 0, 1, 0, y,
     * 0, 0, 1, z,
     * 0, 0, 0, 1
     *
     * @param x - the amount to translate in the X axis.
     * @param y - the amount to translate in the Y axis.
     * @param z - the amount to translate in the Z axis.
     * @return
     */
    public native Matrix4 makeTranslation(float x, float y, float z);

    /**
     * Post-multiplies this matrix by m.
     *
     * @param m
     * @return
     */
    public native Matrix4 multiply(Matrix4 m);

    /**
     * Sets this matrix to a x b.
     *
     * @param a
     * @param b
     * @return
     */
    public native Matrix4 multiplyMatrices(Matrix4 a, Matrix4 b);

    /**
     * Multiplies every component of the matrix by a scalar value s.
     *
     * @param s
     * @return
     */
    public native Matrix4 multiplyScalar(float s);

    /**
     * Pre-multiplies this matrix by m.
     *
     * @param m
     * @return
     */
    public native Matrix4 premultiply(Matrix4 m);

    /**
     * Multiplies the columns of this matrix by vector v.
     *
     * @param v
     * @return
     */
    public native Matrix4 scale(Vector3 v);

    /**
     * Set the elements of this matrix to the supplied row-major values n11, n12, ... n44.
     */
    public native void set(float n11, float n12, float n13, float n14, float n21, float n22, float n23, float n24, float n31, float n32, float n33, float n34, float n41, float n42, float n43, float n44);

    /**
     * Sets the position component for this matrix from vector v, without affecting the rest of the matrix - i.e. if the matrix is currently:
     * a, b, c, d,
     * e, f, g, h,
     * i, j, k, l,
     * m, n, o, p
     * <p>
     * This becomes:
     * <p>
     * a, b, c, v.x,
     * e, f, g, v.y,
     * i, j, k, v.z,
     * m, n, o, p
     *
     * @param v
     * @return
     */
    public native Matrix4 setPosition(Vector3 v);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @return float[]
     */
    public native float[] toArray();

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array - (optional) array to store the resulting vector in.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array  - (optional) array to store the resulting vector in.
     * @param offset - (optional) offset in the array at which to put the result.
     * @return float[]
     */
    public native float[] toArray(float[] array, int offset);

    /**
     * Transposes this matrix.
     *
     * @return
     */
    public native Matrix4 transpose();
}

