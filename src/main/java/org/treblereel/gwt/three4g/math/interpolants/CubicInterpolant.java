package org.treblereel.gwt.three4g.math.interpolants;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Interpolant;

/**
 * CubicInterpolant
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/13/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class CubicInterpolant extends Interpolant {
    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public CubicInterpolant(float[] parameterPositions, float[] sampleValues, int sampleSize, float resultBuffer) {

    }

    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public CubicInterpolant(Float[] parameterPositions, Float[] sampleValues, int sampleSize, float resultBuffer) {

    }
}