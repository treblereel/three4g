package org.treblereel.gwt.three4g.audio;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.AudioListener", namespace = JsPackage.GLOBAL)
public class AudioListener extends Object3D {
  public Object context;
  public double filter;
  public Object gain;
  public double timeDelta;
  public String type;

  public native double getFilter();

  public native Object getInput();

  public native double getMasterVolume();

  public native AudioListener removeFilter();

  public native AudioListener setFilter(double value);

  public native AudioListener setMasterVolume(double value);

  public native void updateMatrixWorld();

  public native void updateMatrixWorld(boolean force);
}
