package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Clock", namespace = JsPackage.GLOBAL)
public class Clock {
  public boolean autoStart;
  public double elapsedTime;
  public double oldTime;
  public boolean running;
  public double startTime;

  public Clock() {}

  public Clock(boolean autoStart) {}

  public native double getDelta();

  public native double getElapsedTime();

  public native void start();

  public native void stop();
}
