package org.treblereel.gwt.three4g.audio;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.PositionalAudio", namespace = JsPackage.GLOBAL)
public class PositionalAudio extends Audio {
  public Object panner;

  public PositionalAudio(AudioListener listener) {
    // This super call is here only for the code to compile; it is never executed.
    super((AudioListener) null);
  }

  public native String getDistanceModel();

  public native double getMaxDistance();

  public native Object getOutput();

  public native double getRefDistance();

  public native double getRolloffFactor();

  public native PositionalAudio setDirectionalCone(
      double coneInnerAngle, double coneOuterAngle, double coneOuterGain);

  public native PositionalAudio setDistanceModel(String value);

  public native PositionalAudio setMaxDistance(double value);

  public native PositionalAudio setRefDistance(double value);

  public native PositionalAudio setRolloffFactor(double value);

  public native void updateMatrixWorld();

  public native void updateMatrixWorld(boolean force);
}
