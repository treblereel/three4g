package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.StereoCamera", namespace = JsPackage.GLOBAL)
public class StereoCamera extends Camera {
  public double aspect;
  public PerspectiveCamera cameraL;
  public PerspectiveCamera cameraR;
  public double eyeSep;
  public String type;

  public native void update(PerspectiveCamera camera);
}
