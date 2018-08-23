package org.treblereel.gwt.three4g.audio;

import elemental2.media.AudioNode;
import elemental2.media.GainNode;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * The AudioListener represents a virtual listener of the all positional and non-positional audio effects in the scene.
 * A three.js application usually creates a single instance of AudioListener. It is a mandatory construtor parameter for audios entities like Audio and PositionalAudio.
 * In most cases, the listener object is a child of the camera. So the 3D transformation of the camera represents the 3D transformation of the listener.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AudioListener extends Object3D {

    /**
     * The AudioContext of the listener given in the constructor.
     */
    public AudioContext context;

    /**
     * A GainNode created using AudioContext.createGain().
     */
    public GainNode gain;

    /**
     * Default is null.
     */
    public AudioNode filter;

    /**
     * Create a new AudioListener.
     */
    public AudioListener() {

    }

    /**
     * @return the gainNode.
     */
    public native GainNode getInput();

    /**
     * Set the filter property to null.
     *
     * @return instance of AudioListener
     */
    public native AudioListener removeFilter();

    /**
     * @return the value of the filter property.
     */
    public native AudioNode getFilter();

    /**
     * Set the filter property to value.
     *
     * @param value - filter
     * @return instance of AudioListener
     */
    public native AudioListener setFilter(AudioNode value);

    /**
     * @return the volume.
     */
    public native float getMasterVolume();

    /**
     * @param value Set the volume.
     * @return instance of AudioListener
     */
    public native AudioListener setMasterVolume(float value);
}
