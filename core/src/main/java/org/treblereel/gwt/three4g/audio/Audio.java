package org.treblereel.gwt.three4g.audio;

import elemental2.dom.HTMLMediaElement;
import elemental2.media.AudioBuffer;
import elemental2.media.AudioNode;
import elemental2.media.BiquadFilterNode;
import elemental2.media.GainNode;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * Create a non-positional ( global ) audio object.
 * <p>
 * This uses the Web Audio API.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Audio extends Object3D {

    /**
     * Whether to start playback automatically. Default is false.
     */
    public boolean autoplay;

    /**
     * The AudioContext of the listener given in the constructor.
     */
    public AudioContext context;

    /**
     * Modify pitch, measured in cents. +/- 100 is a semitone. +/- 1200 is an octave. Default is 0.
     */
    public float detune;

    /**
     * Represents an array of BiquadFilterNodes. Can be used to apply a variety of low-order filters to create more complex sound effects. Filters are set via Audio.setFilter or Audio.setFilters.
     */
    public BiquadFilterNode[] filters;


    /**
     * A GainNode created using AudioContext.createGain().
     */
    public GainNode gain;

    /**
     * Whether playback can be controlled using the play(), pause() etc. methods. Default is true.
     */
    public boolean hasPlaybackControl;

    /**
     * Whether the audio is currently playing.
     */
    public boolean isPlaying;

    /**
     * A reference to the listener object of this audio.
     */
    public AudioListener listener;

    /**
     * Speed of playback. Default is 1.
     */
    public float playbackRate;

    /**
     * The time at which the sound should begin to play. Same as the when paramter of AudioBufferSourceNode.start(). Default is 0.
     */
    public float startTime;

    /**
     * An offset to the time within the audio buffer that playback should begin. Same as the offset paramter of AudioBufferSourceNode.start(). Default is 0.
     */
    public float offset;

    /**
     * An AudioBufferSourceNode created using AudioContext.createBufferSource().
     */
    public String source;

    /**
     * Type of the audio source. Default is string 'empty'.
     */
    public String sourceType;

    /**
     * String denoting the type, set to 'Audio'.
     */
    public String type;

    protected Audio() {

    }

    /**
     * @param listener — AudioListener instance.
     */
    public Audio(AudioListener listener) {

    }

    /**
     * Connect to the Audio.source. This is used internally on initialisation and when setting / removing filters.
     *
     * @return instance of Audio
     */
    public native Audio connect();

    /**
     * Disconnect from the Audio.source. This is used internally when setting / removing filters.
     *
     * @return instance of Audio
     */
    public native Audio disconnect();

    /**
     * Returns the first element of the filters array.
     *
     * @return BiquadFilterNode
     */
    public native BiquadFilterNode getFilter();

    /**
     * Applies a single BiquadFilterNode to the audio.
     *
     * @param filter BiquadFilterNode
     * @return instance of Audio
     */
    public native Audio setFilter(BiquadFilterNode filter);

    /**
     * Returns the filters array.
     *
     * @return array of BiquadFilterNode
     */
    public native BiquadFilterNode[] getFilters();

    /**
     * Applies an array of BiquadFilterNodes to the audio.
     *
     * @param value - arrays of filters.
     * @return this Audio instance
     */
    public native Audio setFilters(BiquadFilterNode[] value);

    /**
     * Return the value of source.loop (whether playback should loop).
     *
     * @return isLoop
     */
    public native boolean getLoop();

    /**
     * Set source.loop to value (whether playback should loop).
     *
     * @param value boolean
     * @return this Audio instance
     */
    public native Audio setLoop(boolean value);

    /**
     * Return the gainNode.
     *
     * @return GainNode
     */
    public native AudioNode getOutput();

    /**
     * Return the value of playbackRate.
     *
     * @return playback rate
     */
    public native float getPlaybackRate();

    /**
     * If hasPlaybackControl is enabled, set the playbackRate to value.
     *
     * @param value playback rate
     * @return instance of Audio
     */
    public native Audio setPlaybackRate(float value);

    /**
     * Return the current volume.
     *
     * @return current volume
     */
    public native float getVolume();

    /**
     * Set the volume.
     *
     * @param value volume rate
     * @return instance of Audio
     */
    public native Audio setVolume(float value);

    /**
     * If hasPlaybackControl is true, starts playback.
     *
     * @return instance of Audio
     */
    public native Audio play();

    /**
     * If hasPlaybackControl is true, pauses playback.
     */
    public native void pause();

    /**
     * Setup the source to the audioBuffer, and sets sourceType to 'buffer'.
     * If autoplay, also starts playback.
     *
     * @param audioBuffer source to the audioBuffer
     * @return insatnce of Audio
     */
    public native Audio setBuffer(AudioBuffer audioBuffer);

    /**
     * Applies the given object of type HTMLMediaElement as the source of this audio.
     * Also sets hasPlaybackControl to false.
     *
     * @param mediaElement of type HTMLMediaElement
     * @return instance of Audio
     */
    public native Audio setMediaElementSource(HTMLMediaElement mediaElement);

    /**
     * Setup the source to the audioBuffer, and sets sourceType to 'audioNode'.
     * Also sets hasPlaybackControl to false.
     *
     * @param audioNode AudioNode
     * @return instance of Audio
     */
    public native Audio setNodeSource(AudioNode audioNode);

    /**
     * If hasPlaybackControl is enabled, stops playback, resets startTime to 0 and sets isPlaying to false.
     *
     * @return instance of Audio
     */
    public native Audio stop();

    /**
     * Return the detune.
     *
     * @return as float value
     */
    public native float getDetune();

    /**
     * Set the detune.
     *
     * @param value detune rate
     * @return instance of Audio
     */
    public native Audio setDetune(float value);

}
