package org.treblereel.gwt.three4g.math.interpolants;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Interpolant;

/**
 * QuaternionLinearInterpolant
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/13/18.
 */
@JsType(isNative = true, name = "THREE.QuaternionLinearInterpolant", namespace = JsPackage.GLOBAL)
public class QuaternionLinearInterpolant extends Interpolant {
    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public QuaternionLinearInterpolant(float[] parameterPositions, float[] sampleValues, int sampleSize, float[] resultBuffer) {

    }

    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public QuaternionLinearInterpolant(Float[] parameterPositions, Float[] sampleValues, int sampleSize, Float[] resultBuffer) {

    }
}
