package org.treblereel.gwt.three4g.audio;

import elemental2.media.PannerNode;
import jsinterop.annotations.JsType;

/**
 * Create a positional audio object.
 * <p>
 * This uses the Web Audio API.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
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
     * @return
     */
    public native PannerNode getOutput();

    /**
     * Returns the value of panner.refDistance.
     *
     * @return
     */
    public native Number getRefDistance();

    /**
     * Sets the value of panner.refDistance.
     *
     * @param value
     * @return
     */
    public native PannerNode setRefDistance(Number value);

    /**
     * Returns the value of panner.rolloffFactor.
     *
     * @return
     */
    public native PannerNode getRolloffFactor();

    /**
     * Sets the value of panner.rolloffFactor.
     *
     * @param value
     * @return
     */
    public native PannerNode setRolloffFactor(Number value);

    /**
     * Returns the value of panner.distanceModel.
     *
     * @return
     */
    public native String getDistanceModel();

    /**
     * Sets the value of panner.distanceModel.
     *
     * @param value
     * @return
     */
    public native String setDistanceModel(String value);

    /**
     * Returns the value of panner.maxDistance.
     *
     * @return
     */
    public native PannerNode getMaxDistance();

    /**
     * Sets the value of panner.maxDistance.
     *
     * @param value
     * @return
     */
    public native PannerNode PannerNodesetMaxDistance(Number value);

}
