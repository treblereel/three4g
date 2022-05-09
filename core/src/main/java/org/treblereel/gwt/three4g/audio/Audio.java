package org.treblereel.gwt.three4g.audio;

import elemental2.core.JsArray;
import elemental2.dom.HTMLMediaElement;
import elemental2.dom.MediaStream;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.Audio", namespace = JsPackage.GLOBAL)
public class Audio extends Object3D {
  public boolean autoplay;
  public Object buffer;
  public Object context;
  public double detune;
  public double duration;
  public JsArray<Object> filters;
  public Object gain;
  public boolean hasPlaybackControl;
  public boolean isPlaying;
  public AudioListener listener;
  public boolean loop;
  public double loopEnd;
  public double loopStart;
  public double offset;
  public double playbackRate;
  public Object source;
  public String sourceType;
  public String type;

  public Audio(AudioListener listener) {}

  public native Audio connect();

  public native Audio disconnect();

  public native double getDetune();

  public native Object getFilter();

  public native JsArray<Object> getFilters();

  public native boolean getLoop();

  public native Object getOutput();

  public native double getPlaybackRate();

  public native double getVolume();

  @Deprecated
  public native Audio load(String file);

  public native void onEnded();

  public native Audio pause();

  public native Audio play();

  public native Audio play(double delay);

  public native Audio setBuffer(Object audioBuffer);

  public native Audio setDetune(double value);

  public native Audio setFilter(Object filter);

  public native Audio setFilters(JsArray<Object> value);

  @JsOverlay
  public final Audio setFilters(Object[] value) {
    return setFilters(Js.<JsArray<Object>>uncheckedCast(value));
  }

  public native Audio setLoop(boolean value);

  public native Audio setLoopEnd(double value);

  public native Audio setLoopStart(double value);

  public native Audio setMediaElementSource(HTMLMediaElement mediaElement);

  public native Audio setMediaStreamSource(MediaStream mediaStream);

  public native Audio setNodeSource(Object audioNode);

  public native Audio setPlaybackRate(double value);

  public native Audio setVolume(double value);

  public native Audio stop();
}
