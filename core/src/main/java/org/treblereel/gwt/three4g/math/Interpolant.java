package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Abstract base class of interpolants over parametric samples.
 * <p>
 * The parameter domain is one dimensional, typically the time or a path along a curve defined by the data.
 * <p>
 * The sample values can have any dimensionality and derived classes may apply special interpretations to the data.
 * <p>
 * This class provides the interval seek in a Template Method, deferring the actual interpolation to derived classes.
 * <p>
 * Time complexity is O(1) for linear access crossing at most two points and O(log N) for random access, where N is the number of positions.
 * <p>
 * References:	http://www.oodesign.com/template-method-pattern.html
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/13/18.
 */
@JsType(isNative = true, name = "THREE.Interpolant", namespace = JsPackage.GLOBAL)
public abstract class Interpolant {

    public float[] parameterPositions;
    public float[] sampleValues;
    public int valueSize;
    public float[] resultBuffer;

    protected Interpolant() {

    }

    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    protected Interpolant(float[] parameterPositions, float[] sampleValues, int sampleSize, float[] resultBuffer) {
    }

    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    protected Interpolant(Float[] parameterPositions, Float[] sampleValues, int sampleSize, Float[] resultBuffer) {
    }

    /**
     * @param t Evaluate the interpolant at position t.
     */
    public native void evaluate(float t);
}
