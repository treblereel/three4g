package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Represents a third-order spherical harmonics (SH). Light probes use this class to encode lighting information.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/28/20
 */
@JsType(isNative = true, name = "THREE.SphericalHarmonics3", namespace = JsPackage.GLOBAL)
public class SphericalHarmonics3 {

    /**
     * An array holding the (9) SH coefficients. A single coefficient is represented as an instance of Vector3.
     */
    public Vector[] coefficients;

    /**
     * @param normal - The normal vector (assumed to be unit length).
     * @param shBasis - The resulting SH basis.
     */
    public native static void getBasisAt(Vector3 normal, Vector3[] shBasis);

    /**
     * Adds the given SH to this instance.
     * @param sh - The SH to add.
     */
    public native void add(SphericalHarmonics3 sh);

    /**
     * A convenience method for performing .add() and .scale() at once.
     * @param sh - The SH to add.
     * @param scale - The scale factor.
     */
    public native void addScaledSH(SphericalHarmonics3 sh, float scale);

    /**
     * @return Returns a new instance of SphericalHarmonics3 with equal coefficients.
     */
    public native SphericalHarmonics3 clone();

    /**
     * @param sh - The SH to copy.
     * @return Copies the given SH to this instance.
     */
    public native SphericalHarmonics3 copy(SphericalHarmonics3 sh);

    /**
     * @param sh - The SH to compare with.
     * @return Returns true if the given SH and this instance have equal coefficients.
     */
    public native SphericalHarmonics3 equals(SphericalHarmonics3 sh);

    /**
     * @param array - The array holding the numbers of the SH coefficients.
     * @param offset - (optional) The array offset.
     * @return Sets the coefficients of this instance from the given array.
     */
    public native SphericalHarmonics3 fromArray(Vector3[] array, int offset);

    /**
     * @param normal - The normal vector (assumed to be unit length).
     * @param target - The result vector.
     * @return Returns the radiance in the direction of the given normal.
     */
    public native Vector3 getAt(Vector3 normal, Vector3 target);

    /**
     * @param normal - The normal vector (assumed to be unit length).
     * @param target - The result vector.
     * @return Returns the irradiance (radiance convolved with cosine lobe) in the direction of the given normal.
     */
    public native Vector3 getIrradianceAt(Vector3 normal, Vector3 target);

    /**
     * @param sh - The SH to interpolate with.
     * @param alpha - The alpha factor.
     * @return Linear interpolates between the given SH and this instance by the given alpha factor.
     */
    public native SphericalHarmonics3 lerp(SphericalHarmonics3 sh, float alpha);

    /**
     * Scales this SH by the given scale factor.
     * @param scale - The scale factor.
     * @return instance of SphericalHarmonics3.
     */
    public native SphericalHarmonics3 scale(float scale);

    /**
     * @param coefficients - An array of SH coefficients.
     * @return instance of SphericalHarmonics3.
     */
    public native SphericalHarmonics3 set(Vector3[] coefficients);

    /**
     * Returns an array with the coefficients, or copies them into the provided array. The coefficients are represented as numbers.
     * @return instance of Vector3[]
     */
    public native Vector3[] toArray();

    /**
     * Returns an array with the coefficients, or copies them into the provided array. The coefficients are represented as numbers.
     * @param array - (optional) The target array.
     * @return instance of Vector3[]
     */
    public native Vector3[] toArray(Vector3[] array);

    /**
     * Returns an array with the coefficients, or copies them into the provided array. The coefficients are represented as numbers.
     * @param array - (optional) The target array.
     * @param offset - (optional) The array offset.
     * @return instance of Vector3[]
     */
    public native Vector3[] toArray(Vector3[] array, int offset);

    /**
     * Sets all SH coefficients to 0.
     * @return instance of SphericalHarmonics3.
     */
    public native SphericalHarmonics3 zero();
}
