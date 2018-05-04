package org.treblereel.gwt.three4g.audio;

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
 * @author Dmitrii Tikhomirov <chani@me.com>
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
     * Speed of playback. Default is 1.
     */
    public Number playbackRate;

    /**
     * Whether the audio is currently playing.
     */
    public boolean isPlaying;

    /**
     * The time at which the sound should begin to play. Same as the when paramter of AudioBufferSourceNode.start(). Default is 0.
     */
    public Number startTime;

    /**
     * An offset to the time within the audio buffer that playback should begin. Same as the offset paramter of AudioBufferSourceNode.start(). Default is 0.
     */
    public Number offset;

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

    protected Audio(){

    }

    /**
     * @param listener — (required) AudioListener instance.
     */
    public Audio(AudioListener listener) {

    }

    /**
     * Connect to the Audio.source. This is used internally on initialisation and when setting / removing filters.
     */
    public native void connect();

    /**
     * Disconnect from the Audio.source. This is used internally when setting / removing filters.
     */
    public native void disconnect();

    /**
     * Returns the first element of the filters array.
     *
     * @return
     */
    public native BiquadFilterNode getFilter();

    /**
     * Returns the filters array.
     *
     * @return
     */
    public native BiquadFilterNode[] getFilters();

    /**
     * Return the value of source.loop (whether playback should loop).
     *
     * @return
     */
    public native boolean getLoop();

    /**
     * Return the gainNode.
     * Cast to GainNode
     *
     * @return
     */
    public native AudioNode getOutput();

    /**
     * Return the value of playbackRate.
     *
     * @return
     */
    public native Number getPlaybackRate();

    /**
     * Return the current volume.
     *
     * @return
     */
    public native Number getVolume();

    /**
     * If hasPlaybackControl is true, starts playback.
     */
    public native void play();

    /**
     * If hasPlaybackControl is true, pauses playback.
     */
    public native void pause();

    /**
     * Setup the source to the audioBuffer, and sets sourceType to 'buffer'.
     * If autoplay, also starts playback.
     *
     * @param audioBuffer
     * @return
     */
    public native Audio setBuffer(AudioBuffer audioBuffer);

    /**
     * Applies a single BiquadFilterNode to the audio.
     *
     * @param filter
     */
    public native void setFilter(BiquadFilterNode filter);

    /**
     * Applies an array of BiquadFilterNodes to the audio.
     *
     * @param value - arrays of filters.
     */
    public native Audio setFilters(BiquadFilterNode[] value);

    /**
     * Set source.loop to value (whether playback should loop).
     *
     * @param value
     */
    public native void setLoop(boolean value);

    /**
     * Setup the source to the audioBuffer, and sets sourceType to 'audioNode'.
     * Also sets hasPlaybackControl to false.
     */
    public native void setNodeSource(AudioNode audioNode);

    /**
     * If hasPlaybackControl is enabled, set the playbackRate to value.
     *
     * @param value
     */
    public native void setPlaybackRate(Number value);

    /**
     * Set the volume.
     *
     * @param value
     */
    public native void setVolume(Number value);

    /**
     * If hasPlaybackControl is enabled, stops playback, resets startTime to 0 and sets isPlaying to false.
     */
    public native void stop();


}
