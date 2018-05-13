package org.treblereel.gwt.three4g.math.interpolants;

import elemental2.core.Float32Array;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Interpolant;

/**
 * QuaternionLinearInterpolant
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/13/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class QuaternionLinearInterpolant extends Interpolant {
    /**
     * @param parameterPositions -- array of positions
     * @param sampleValues       -- array of samples
     * @param sampleSize         -- number of samples
     * @param resultBuffer       -- buffer to store the interpolation results.
     */
    public QuaternionLinearInterpolant(Float32Array parameterPositions, Float32Array sampleValues, Float32Array sampleSize, Float32Array resultBuffer) {

    }
}
