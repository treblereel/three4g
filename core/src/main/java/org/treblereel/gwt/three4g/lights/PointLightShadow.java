package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.cameras.PerspectiveCamera;
import org.treblereel.gwt.three4g.lights.LightShadow;

@JsType(isNative = true, name = "THREE.PointLightShadow", namespace = JsPackage.GLOBAL)
public class PointLightShadow extends LightShadow {
  public PerspectiveCamera camera;

  public PointLightShadow() {
    // This super call is here only for the code to compile; it is never executed.
    super((Camera) null);
  }
}
