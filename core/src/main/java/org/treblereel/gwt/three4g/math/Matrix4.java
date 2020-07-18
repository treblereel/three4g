package org.treblereel.gwt.three4g.math;

import elemental2.core.Float32Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
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
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, name = "THREE.Matrix4", namespace = JsPackage.GLOBAL)
public class Matrix4 implements Matrix {

    /**
     * A column-major list of matrix values.
     */
    public float[] elements;

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
     * @return Object[]
     */
    public native Object[] applyToBufferAttribute(BufferAttribute attribute); //TODO

    /**
     * Creates a new Matrix4 with identical elements to this one.
     *
     * @return instance of Matrix4
     */
    public native Matrix4 clone();

    /**
     * Sets this matrix to the transformation composed of position, quaternion and scale. Internally this calls
     * makeRotationFromQuaternion( quaternion ) followed by scale( scale ), then finally setPosition( position ).
     *
     * @param position position
     * @param quaternion quaternion
     * @param scale scale
     * @return instance of Matrix4
     */
    public native Matrix4 compose(Vector3 position, Quaternion quaternion, Vector3 scale);

    /**
     * Copies the elements of matrix m into this matrix.
     *
     * @param m original Matrix4
     * @return instance of Matrix4
     */
    public native Matrix4 copy(Matrix4 m);

    /**
     * Copies the translation component of the supplied matrix m into this matrix's translation component.
     *
     * @param m position as a Matrix4
     * @return instance of Matrix4
     */
    public native Matrix4 copyPosition(Matrix4 m);

    /**
     * Decomposes this matrix into it's position, quaternion and scale components.
     *
     * @param position position
     * @param quaternion quaternion
     * @param scale scale
     */
    public native void decompose(Vector3 position, Quaternion quaternion, Vector3 scale);

    /**
     * Computes and returns the determinant of this matrix.
     *
     * @return the determinant
     */
    public native float determinant();

    /**
     * Return true if this matrix and m are equal.
     *
     * @param m Matrix4
     * @return is equal
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
     * @param xAxis x Vector3
     * @param yAxis x Vector3
     * @param zAxis z Vector3
     * @return instance of Matrix4
     */
    public native Matrix4 extractBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);

    /**
     * Extracts the rotation component of the supplied matrix m into this matrix's rotation component.
     *
     * @param m matrix4 as rotation component
     * @return instance of Matrix4
     */
    public native Matrix4 extractRotation(Matrix4 m);


    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array - the array to read the elements from.
     * @return instance of Matrix4
     */
    public native Matrix4 fromArray(float[] array);

    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array - the array to read the elements from.
     * @return instance of Matrix4
     */
    public native Matrix4 fromArray(Float32Array array);

    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array  - the array to read the elements from.
     * @param offset - offset into the array. Default is 0.
     * @return instance of Matrix4
     */
    public native Matrix4 fromArray(float[] array, int offset);

    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array  - the array to read the elements from.
     * @param offset - offset into the array. Default is 0.
     * @return instance of Matrix4
     */
    public native Matrix4 fromArray(Float32Array array, int offset);

    /**
     * Set this matrix to the inverse of the passed matrix m, using the method outlined here. If throwOnDegenerate is not
     * set and the matrix is not invertible, set this to the 4x4 identity matrix.
     *
     * @param m - the matrix to take the inverse of.
     * @return instance of Matrix4
     */
    public native Matrix4 getInverse(Matrix4 m);

    /**
     * Set this matrix to the inverse of the passed matrix m, using the method outlined here. If throwOnDegenerate is not
     * set and the matrix is not invertible, set this to the 4x4 identity matrix.
     *
     * @param m                 - the matrix to take the inverse of.
     * @param throwOnDegenerate - If true, throw an error if the matrix is degenerate (not invertible).
     * @return instance of Matrix4
     */
    public native Matrix4 getInverse(Matrix4 m, boolean throwOnDegenerate);

    /**
     * Gets the maximum scale value of the 3 axes.
     *
     * @return float scale value
     */
    public native float getMaxScaleOnAxis();

    /**
     * Resets this matrix to the identity matrix.
     *
     * @return instance of Matrix4
     */
    public native Matrix4 identity();

    /**
     * Constructs a rotation matrix, looking from eye towards center oriented by the up vector.
     *
     * @param eye Vector3 eye
     * @param center Vector3 center
     * @param up Vector3 up
     * @return instance of Matrix4
     */
    public native Matrix4 lookAt(Vector3 eye, Vector3 center, Vector3 up);

    /**
     * Sets this matrix as rotation transform around axis by theta radians.
     * This is a somewhat controversial but mathematically sound alternative to rotating via Quaternions. See the discussion here.
     *
     * @param axis  — Rotation axis, should be normalized.
     * @param theta — Rotation angle in radians.
     * @return instance of Matrix4
     */
    public native Matrix4 makeRotationAxis(Vector3 axis, float theta);

    /**
     * Set this to the basis matrix consisting of the three provided basis vectors:
     * xAxis.x, yAxis.x, zAxis.x, 0,
     * xAxis.y, yAxis.y, zAxis.y, 0,
     * xAxis.z, yAxis.z, zAxis.z, 0,
     * 0,       0,       0,       1
     *
     * @param xAxis Vector3
     * @param yAxis Vector3
     * @param zAxis Vector3
     * @return instance of Matrix4
     */
    public native Matrix4 makeBasis(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis);


    /**
     * Creates a perspective projection matrix. This is used internally by PerspectiveCamera.updateProjectionMatrix()
     *
     * @param left float
     * @param right float
     * @param top float
     * @param bottom float
     * @param near float
     * @param far float
     * @return instance of Matrix4
     */
    public native Matrix4 makePerspective(float left, float right, float top, float bottom, float near, float far);

    /**
     * Creates an orthographic projection matrix. This is used internally by OrthographicCamera.updateProjectionMatrix().
     *
     * @param left float
     * @param right float
     * @param top float
     * @param bottom float
     * @param near float
     * @param far float
     * @return instance of Matrix4
     */
    public native Matrix4 makeOrthographic(float left, float right, float top, float bottom, float near, float far);


    /**
     * Sets the rotation component (the upper left 3x3 matrix) of this matrix to the rotation specified by the given Euler Angle. The rest of the matrix is set to the identity. Depending on the order of the euler, there are six possible outcomes. See this page for a complete list.
     *
     * @param euler given Euler Angle
     * @return instance of Matrix4
     */
    public native Matrix4 makeRotationFromEuler(Euler euler);

    /**
     * Sets the rotation component of this matrix to the rotation specified by q, as outlined here.
     * The rest of the matrix is set to the identity. So, given q = w + xi + yj + zk, the resulting matrix will be:
     *
     * 1-2y²-2z²    2xy-2zw    2xz+2yw    0
     * 2xy+2zw      1-2x²-2z²  2yz-2xw    0
     * 2xz-2yw      2yz+2xw    1-2x²-2y²  0
     * 0            0          0          1
     *
     * @param q Quaternion
     * @return instance of Matrix4
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
     * @return instance of Matrix4
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
     * @return instance of Matrix4
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
     * @return instance of Matrix4
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
     * @return instance of Matrix4
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
     * @return instance of Matrix4
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
     * @return instance of Matrix4
     */
    public native Matrix4 makeTranslation(float x, float y, float z);

    /**
     * Post-multiplies this matrix by m.
     *
     * @param m given Matrix4
     * @return instance of Matrix4
     */
    public native Matrix4 multiply(Matrix4 m);

    /**
     * Sets this matrix to a x b.
     *
     * @param a given Matrix4
     * @param b given Matrix4
     * @return instance of Matrix4
     */
    public native Matrix4 multiplyMatrices(Matrix4 a, Matrix4 b);

    /**
     * Multiplies every component of the matrix by a scalar value s.
     *
     * @param s scalar
     * @return instance of Matrix4
     */
    public native Matrix4 multiplyScalar(float s);

    /**
     * Pre-multiplies this matrix by m.
     *
     * @param m Matrix4s
     * @return instance of Matrix4
     */
    public native Matrix4 premultiply(Matrix4 m);

    /**
     * Multiplies the columns of this matrix by vector v.
     *
     * @param v Vector3
     * @return instance of Matrix4
     */
    public native Matrix4 scale(Vector3 v);

    /**
     * Set the elements of this matrix to the supplied row-major values n11, n12, ... n44.
     *
     * @param n11 float value
     * @param n12 float value
     * @param n13 float value
     * @param n14 float value
     * @param n21 float value
     * @param n22 float value
     * @param n23 float value
     * @param n24 float value
     * @param n31 float value
     * @param n32 float value
     * @param n33 float value
     * @param n34 float value
     * @param n41 float value
     * @param n42 float value
     * @param n43 float value
     * @param n44 float value
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
     * @param v Vector3
     * @return instance of Matrix4
     */
    public native Matrix4 setPosition(Vector3 v);

    /**
     * Sets the position component for this matrix from vector v, without affecting the rest of the matrix - i.e. if the matrix is currently:
     * a, b, c, d,
     * e, f, g, h,
     * i, j, k, l,
     * m, n, o, p
     *
     * This becomes:
     * a, b, c, v.x,
     * e, f, g, v.y,
     * i, j, k, v.z,
     * m, n, o, p
     *
     * @param x float value
     * @param y float value
     * @param z float value
     * @return instance of Matrix4
     */
    public native Matrix4 setPosition(float x, float y, float z);


    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @return float[]
     */
    public native float[] toArray();

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array - array to store the resulting vector in.
     * @return float[]
     */
    public native float[] toArray(float[] array);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array - array to store the resulting vector in.
     * @return float[]
     */
    public native float[] toArray(Float32Array array);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array  - array to store the resulting vector in.
     * @param offset - offset in the array at which to put the result.
     * @return float[]
     */
    public native float[] toArray(float[] array, int offset);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array  - array to store the resulting vector in.
     * @param offset - offset in the array at which to put the result.
     * @return float[]
     */
    public native float[] toArray(Float32Array array, int offset);

    /**
     * Transposes this matrix.
     *
     * @return instance of Matrix4
     */
    public native Matrix4 transpose();
}

