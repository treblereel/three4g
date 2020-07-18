package org.treblereel.gwt.three4g.audio;

import elemental2.media.PannerNode;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Create a positional audio object.
 * <p>
 * This uses the Web Audio API.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.PositionalAudio", namespace = JsPackage.GLOBAL)
public class PositionalAudio extends Audio {

    /**
     * The PositionalAudio's PannerNode.
     */
    public PannerNode panner;

    /**
     * @param listener — (required) AudioListener instance.
     */
    public PositionalAudio(AudioListener listener) {
    }

    /**
     * Returns the panner.
     *
     * @return PannerNode
     */
    public native PannerNode getOutput();

    /**
     * Returns the value of panner.refDistance.
     *
     * @return refDistance
     */
    public native float getRefDistance();

    /**
     * Sets the value of panner.refDistance.
     *
     * @param value refDistance
     * @return instance of PositionalAudio
     */
    public native PositionalAudio setRefDistance(float value);

    /**
     * Returns the value of panner.rolloffFactor.
     *
     * @return PannerNode
     */
    public native float getRolloffFactor();

    /**
     * Sets the value of panner.rolloffFactor.
     *
     * @param value rolloffFactor
     * @return instance of PositionalAudio
     */
    public native PositionalAudio setRolloffFactor(float value);

    /**
     * Returns the value of panner.distanceModel.
     *
     * @return String distanceModel
     */
    public native String getDistanceModel();

    /**
     * Sets the value of panner.distanceModel.
     *
     * @param value the value of panner.distanceModel
     * @return instance of PositionalAudio
     */
    public native PositionalAudio setDistanceModel(String value);

    /**
     * Returns the value of panner.maxDistance.
     *
     * @return float value
     */
    public native float getMaxDistance();

    /**
     * This method can be used in order to transform an omnidirectional sound into a directional sound.
     *
     * @param coneInnerAngle float value
     * @param coneOuterAngle float value
     * @param coneOuterGain  float value
     * @return instance of PositionalAudio
     */
    public native PositionalAudio setMaxDistance(float coneInnerAngle, float coneOuterAngle, float coneOuterGain);

    /**
     * Sets the value of panner.maxDistance.
     *
     * @param value maxDistance
     * @return instance of PositionalAudio
     */
    public native PositionalAudio setMaxDistance(float value);

    /**
     *
     * @param coneInnerAngle float
     * @param coneOuterAngle float
     * @param coneOuterGain float
     * @return instance of PositionalAudio
     */
    public native PositionalAudio setDirectionalCone(float coneInnerAngle, float coneOuterAngle, float coneOuterGain);

}
