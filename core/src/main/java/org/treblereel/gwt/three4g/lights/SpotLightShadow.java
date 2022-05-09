package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.lights.LightShadow;

@JsType(isNative = true, name = "THREE.SpotLightShadow", namespace = JsPackage.GLOBAL)
public class SpotLightShadow extends LightShadow {
  public PerspectiveCamera camera;
  public double focus;
  public boolean isSpotLightShadow;

  public SpotLightShadow() {
    // This super call is here only for the code to compile; it is never executed.
    super((Camera) null);
  }
}
