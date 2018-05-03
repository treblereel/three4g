package org.treblereel.gwt.three4g.animation.tracks;

import elemental2.core.JsArray;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.KeyframeTrack;

/**
 * A Track of vector keyframe values.
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/2/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class VectorKeyframeTrack extends KeyframeTrack {

    /**
     * @param name  - identifier for the KeyframeTrack.
     * @param times - array of keyframe times.
     */
    @JsConstructor
    public VectorKeyframeTrack(String name, JsArray times) {

    }

    /**
     * @param name   - identifier for the KeyframeTrack.
     * @param times  - array of keyframe times.
     * @param values - values for the keyframes at the times specified.
     */
    @JsConstructor
    public VectorKeyframeTrack(String name, JsArray times, JsArray values) {

    }

    /**
     * @param name          - identifier for the KeyframeTrack.
     * @param times         - array of keyframe times.
     * @param values        - values for the keyframes at the times specified.
     * @param interpolation - the type of interpolation to use. See Animation Constants for possible values. Default is InterpolateLinear.
     */
    @JsConstructor
    public VectorKeyframeTrack(String name, JsArray times, JsArray values, int interpolation) {

    }

    /**
     * Returns a new QuaternionLinearInterpolant based on the values, times and valueSize of the keyframes.
     */
    @JsMethod(name = "InterpolantFactoryMethodLinear")
    public native void interpolantFactoryMethodLinear();

    /**
     * The value of this method here is 'undefined', as it does not make sense for discrete properties.
     */
    @JsMethod(name = "InterpolantFactoryMethodSmooth")
    public native void interpolantFactoryMethodSmooth();

}