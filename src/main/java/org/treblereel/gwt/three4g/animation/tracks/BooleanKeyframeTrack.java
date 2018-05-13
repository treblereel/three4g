package org.treblereel.gwt.three4g.animation.tracks;

import elemental2.core.JsArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.KeyframeTrack;
import org.treblereel.gwt.three4g.math.interpolants.QuaternionLinearInterpolant;

/**
 * A Track of boolean keyframe values.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class BooleanKeyframeTrack extends KeyframeTrack {

    /**
     * The default interpolation type to use, InterpolateDiscrete.
     */
    public int DefaultInterpolation;

    /**
     * A normal Array (no Float32Array in this case, unlike ValueBufferType of KeyframeTrack).
     */
    public JsArray ValueBufferType;

    /**
     * String 'bool'.
     */
    public boolean ValueTypeName;

    /**
     * @param name  - the identifier for the KeyframeTrack.
     * @param times - an array of keyframe times, converted internally to a Float32Array.
     */
    @JsConstructor
    public BooleanKeyframeTrack(String name, JsArray times) {

    }

    /**
     * @param name   - the identifier for the KeyframeTrack.
     * @param times  - an array of keyframe times, converted internally to a Float32Array.
     * @param values - an array with the values related to the times array, converted internally to a Float32Array.
     */
    @JsConstructor
    public BooleanKeyframeTrack(String name, JsArray times, JsArray values) {

    }

}
