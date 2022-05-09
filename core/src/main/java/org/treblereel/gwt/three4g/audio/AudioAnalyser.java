package org.treblereel.gwt.three4g.audio;

import elemental2.core.Uint8Array;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.AudioAnalyser", namespace = JsPackage.GLOBAL)
public class AudioAnalyser {
  public Object analyser;
  public Uint8Array data;

  public AudioAnalyser(Audio audio, double fftSize) {}

  public AudioAnalyser(Audio audio) {}

  public native double getAverageFrequency();

  @Deprecated
  public native double getData(double file);

  public native Uint8Array getFrequencyData();
}
