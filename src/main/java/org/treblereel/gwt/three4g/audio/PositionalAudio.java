package org.treblereel.gwt.three4g.audio;

import elemental2.media.PannerNode;
import jsinterop.annotations.JsType;

/**
 * Create a positional audio object.
 * <p>
 * This uses the Web Audio API.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
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
    public native Number getRefDistance();

    /**
     * Sets the value of panner.refDistance.
     *
     * @param value refDistance
     * @return PannerNode
     */
    public native PannerNode setRefDistance(Number value);

    /**
     * Returns the value of panner.rolloffFactor.
     *
     * @return PannerNode
     */
    public native PannerNode getRolloffFactor();

    /**
     * Sets the value of panner.rolloffFactor.
     *
     * @param value rolloffFactor
     * @return PannerNode
     */
    public native PannerNode setRolloffFactor(Number value);

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
     * @return String distanceModel
     */
    public native String setDistanceModel(String value);

    /**
     * Returns the value of panner.maxDistance.
     *
     * @return PannerNode
     */
    public native PannerNode getMaxDistance();

    /**
     * Sets the value of panner.maxDistance.
     *
     * @param value maxDistance
     * @return PannerNode
     */
    public native PannerNode PannerNodesetMaxDistance(Number value);

}
