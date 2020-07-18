package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

/**
 * A class representing a 3x3 matrix.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, name = "THREE.Matrix3", namespace = JsPackage.GLOBAL)
public class Matrix3 implements Matrix {

    /**
     * A column-major list of matrix values.
     */
    public float[] elements;

    /**
     * Used to check whether this or derived classes are Matrix3s. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMatrix3;

    @JsConstructor
    public Matrix3() {

    }

    /**
     * Multiplies (applies) this matrix to every 3D vector in the attribute.
     *
     * @param attribute - An attribute of floats that represent 3D vectors.
     * @return todo
     */
    public native Object[] applyToBufferAttribute(BufferAttribute attribute); //TODO

    /**
     * Creates a new Matrix3 with identical elements to this one.
     *
     * @return clone of this Matrix
     */
    public native Matrix3 clone();

    /**
     * Copies the elements of matrix m into this matrix.
     *
     * @param m original matrix
     * @return Matrix3
     */
    public native Matrix3 copy(Matrix3 m);

    /**
     * Computes and returns the determinant of this matrix.
     *
     * @return determinant of this matrix
     */
    public native float determinant();

    /**
     * Return true if this matrix and m are equal.
     *
     * @param m - matrix to compare
     * @return is equal
     */
    public native boolean equals(Matrix3 m);

    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array - the array to read the elements from.
     * @return instance of Matrix3
     */
    public native Matrix3 fromArray(float[] array);

    /**
     * Sets the elements of this matrix based on an array in column-major format.
     *
     * @param array  - the array to read the elements from.
     * @param offset - offset into the array. Default is 0.
     * @return instance of Matrix3
     */
    public native Matrix3 fromArray(float[] array, float offset);

    /**
     * Set this matrix to the inverse of the passed matrix m, using the analytic method. If throwOnDegenerate is not set
     * and the matrix is not invertible, set this to the 3x3 identity matrix.
     *
     * @param m - the matrix to take the inverse of.
     * @return instance of Matrix3
     */
    public native Matrix3 getInverse(Matrix3 m);

    /**
     * Set this matrix to the inverse of the passed matrix m, using the analytic method. If throwOnDegenerate is not set
     * and the matrix is not invertible, set this to the 3x3 identity matrix.
     *
     * @param m                 - the matrix to take the inverse of.
     * @param throwOnDegenerate - If true, throw an error if the matrix is degenerate (not invertible).
     * @return instance of Matrix3
     */
    public native Matrix3 getInverse(Matrix3 m, boolean throwOnDegenerate);


    /**
     * Sets this matrix as the upper left 3x3 of the normal matrix of the passed matrix4. The normal matrix is the
     * inverse transpose of the matrix m.
     *
     * @param m - Matrix4
     * @return instance of Matrix3
     */
    public native Matrix3 getNormalMatrix(Matrix4 m);

    /**
     * Resets this matrix to the identity matrix:
     * 1, 0, 0
     * 0, 1, 0
     * 0, 0, 1
     *
     * @return instance of Matrix3
     */
    public native Matrix3 identity();

    /**
     * Post-multiplies this matrix by m.
     *
     * @param m instance of Matrix3
     * @return instance of Matrix3
     */
    public native Matrix3 multiply(Matrix3 m);

    /**
     * Sets this matrix to a x b.
     *
     * @param a instance of Matrix3
     * @param b instance of Matrix3
     * @return instance of Matrix3
     */
    public native Matrix3 multiplyMatrices(Matrix3 a, Matrix3 b);

    /**
     * Multiplies every component of the matrix by a scalar value s.
     *
     * @param s scalar
     * @return instance of Matrix3
     */
    public native Matrix3 multiplyScalar(float s);

    /**
     * Sets the 3x3 matrix values to the given row-major sequence of values.
     *
     * @param n11 float value
     * @param n12 float value
     * @param n13 float value
     * @param n21 float value
     * @param n22 float value
     * @param n23 float value
     * @param n31 float value
     * @param n32 float value
     * @param n33 float value
     * @return instance of Matrix3
     */
    public native Matrix3 set(float n11, float n12, float n13, float n21, float n22, float n23, float n31, float n32, float n33);

    /**
     * Pre-multiplies this matrix by m.
     *
     * @param m instance of Matrix3
     * @return instance of Matrix3
     */
    public native Matrix3 premultiply(Matrix3 m);

    /**
     * Set this matrix to the upper 3x3 matrix of the Matrix4 m.
     *
     * @param m instance of Matrix4
     * @return instance of Matrix3
     */
    public native Matrix3 setFromMatrix4(Matrix4 m);

    /**
     * Sets the UV transform matrix from offset, repeat, rotation, and center.
     *
     * @param tx       - offset x
     * @param ty       - offset y
     * @param sx       - repeat x
     * @param sy       - repeat y
     * @param rotation - rotation (in radians)
     * @param cx       - center x of rotation
     * @param cy       - center y of rotation
     * @return instance of Matrix3
     */
    public native Matrix3 setUvTransform(float tx, float ty, float sx, float sy, float rotation, float cx, float cy);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @return array of a float[] representing this instance of Matrix3
     */
    public native float[] toArray();

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array - array to store the resulting vector in.
     * @return array of a float[] representing this instance of Matrix3
     */
    public native float[] toArray(float[] array);

    /**
     * Writes the elements of this matrix to an array in column-major format.
     *
     * @param array  - array to store the resulting vector in.
     * @param offset - offset in the array at which to put the result.
     * @return array of a float[] representing this instance of Matrix3
     */
    public native float[] toArray(float[] array, int offset);

    /**
     * Transposes this matrix.
     *
     * @return instance of Matrix3
     */
    public native Matrix3 transpose();

    /**
     * Transposes this matrix into the supplied array, and returns itself unchanged.
     * @param array - array to store the resulting vector in.
     * @return instance of Matrix3
     */
    public native Matrix3 transposeIntoArray (float[] array);

}
