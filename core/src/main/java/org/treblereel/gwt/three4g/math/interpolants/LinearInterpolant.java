package org.treblereel.gwt.three4g.math.interpolants;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Interpolant;

/**
 * LinearInterpolant
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/13/18.
 */
@JsType(isNative = true, name = "THREE.LinearInterpolant", namespace = JsPackage.GLOBAL)
public class LinearInterpolant extends Interpolant {
    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public LinearInterpolant(float[] parameterPositions, float[] sampleValues, int sampleSize, float[] resultBuffer) {

    }

    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public LinearInterpolant(Float[] parameterPositions, Float[] sampleValues, int sampleSize, Float[] resultBuffer) {

    }
}
