package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * An object with several math utility functions.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/19/18.
 */
@JsType(isNative = true, name = "THREE.Math", namespace = JsPackage.GLOBAL)
public class Math {

    public static float DEG2RAD, RAD2DEG;

    /**
     * Clamps the value to be between min and max.
     *
     * @param value — Value to be clamped.
     * @param min   — Minimum value.
     * @param max   — Maximum value.
     * @return float
     */
    public static native float clamp(float value, float min, float max);

    /**
     * Converts degrees to radians.
     *
     * @param degrees - degrees
     * @return float Rad
     */
    public static native float degToRad(float degrees);

    /**
     * Computes the Euclidean modulo of m % n, that is:
     * ( ( n % m ) + m ) % m
     *
     * @param n - Integers
     * @param m - Integers
     * @return euclidean modulo
     */
    public static native int euclideanModulo(int n, int m);

    /**
     * Generate a UUID (universally unique identifier).
     *
     * @return UUID
     */
    public static native String generateUUID();

    /**
     * Return true if n is a power of 2.
     * @param n - candidate
     * @return boolean
     */
    public static native boolean isPowerOfTwo(Number n);

    /**
     * Returns a value linearly interpolated from two known points based on the given interval - t = 0 will return x and t = 1 will return y.
     *
     * @param x - Start point.
     * @param y - End point.
     * @param t - interpolation factor in the closed interval [0, 1].
     * @return float
     */
    public static native float lerp(float x, float y, float t);

    /**
     * Linear mapping of x from range [a1, a2] to range [b1, b2].
     *
     * @param x  — Value to be mapped.
     * @param a1 — Minimum value for range A.
     * @param a2 — Maximum value for range A.
     * @param b1 — Minimum value for range B.
     * @param b2 — Maximum value for range B.
     * @return float
     */
    public static native float mapLinear(float x, float a1, float a2, float b1, float b2);

    /**
     * Returns the smallest power of 2 that is greater than or equal to n.
     *
     * @param n Number
     * @return int ceilPowerOfTwo
     */
    public static native int ceilPowerOfTwo(Number n);

    /**
     * Returns the largest power of 2 that is less than or equal to n.
     *
     * @param n Number
     * @return int
     */
    public static native int floorPowerOfTwo(Number n);

    /**
     * Converts radians to degrees.
     *
     * @param n float
     * @return int
     */
    public static native int radToDeg(float n);

    /**
     * Random float in the interval low to high.
     * @param low float low
     * @param high high low
     * @return float
     */
    public static native float randFloat(float low,float high);

    /**
     * Random float in the interval *- range / 2* to *range / 2*.
     * @param range float range
     * @return float
     */
    public static native float randFloatSpread (float range);

    /**
     * Random integer in the interval low to high.
     * @param low int low
     * @param high int high
     * @return int
     */
    public static native int randInt(int low, int high);

    /**
     *
     * @param x - The value to evaluate based on its position between min and max.
     * @param min - Any x value below min will be 0.
     * @param max - Any x value above max will be 1.
     * @return a value between 0-1 that represents the percentage that x has moved between min and max, but smoothed or
     * slowed down the closer X is to the min and max.
     */
    public static native float smoothstep(float x, float min, float max);

    /**
     *
     * @param x - The value to evaluate based on its position between min and max.
     * @param min - Any x value below min will be 0.
     * @param max - Any x value above max will be 1.
     * @return Returns a value between 0-1. A variation on smoothstep that has zero 1st and 2nd order derivatives at x=0 and x=1.
     */
    public static native float  smootherstep(float x, float min, float max);

}
