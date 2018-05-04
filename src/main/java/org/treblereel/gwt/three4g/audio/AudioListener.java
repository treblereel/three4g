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
 * @author Dmitrii Tikhomirov <chani@me.com>
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
     * Return the gainNode.
     *
     * @return
     */
    public native GainNode getInput();

    /**
     * Set the filter property to null.
     */
    public native void removeFilter();

    /**
     * Returns the value of the filter property.
     *
     * @return
     */
    public native AudioNode getFilter();

    /**
     * Set the filter property to value.
     *
     * @param value
     */
    public native void setFilter(AudioNode value);

    /**
     * Return the volume.
     *
     * @return
     */
    public native Number getMasterVolume();

    /**
     * Set the volume.
     *
     * @param value
     */
    public native void setMasterVolume(Number value);
}
