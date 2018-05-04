package org.treblereel.gwt.three4g.audio;

import elemental2.core.Uint8Array;
import elemental2.media.AnalyserNode;
import jsinterop.annotations.JsType;

/**
 * Create a AudioAnalyser object, which uses an AnalyserNode to analyse audio data.
 * <p>
 * This uses the Web Audio API.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AudioAnalyser {

    /**
     * An AnalyserNode used to analyze audio.
     */
    public AnalyserNode analyser;

    /**
     * A non-zero power of two up to 2048, representing the size of the FFT (Fast Fourier Transform) to be used to determine the frequency domain. See this page for details.
     */
    public int fftSize;

    /**
     * A Uint8Array with size determined by analyser.frequencyBinCount used to hold analysis data.
     */
    public Uint8Array data;

    /**
     * Create a new AudioAnalyser.
     *
     * @param audio
     * @param fftSize
     */
    public AudioAnalyser(Audio audio, int fftSize) {

    }

    /**
     * Uses the Web Audio's getByteFrequencyData method. See that page.
     *
     * @return
     */
    public native Uint8Array getFrequencyData();

    /**
     * Get the average of the frequencies returned by the getFrequencyData method.
     *
     * @return
     */
    public native Number getAverageFrequency();
}
