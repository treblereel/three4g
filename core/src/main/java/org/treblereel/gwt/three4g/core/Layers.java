package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Layers", namespace = JsPackage.GLOBAL)
public class Layers {
  public double mask;

  public native void disable(double channel);

  public native void disableAll();

  public native void enable(double channel);

  public native void enableAll();

  public native void set(double channel);

  public native boolean test(Layers layers);

  public native void toggle(double channel);
}
