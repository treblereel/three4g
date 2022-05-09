package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.cameras.OrthographicCamera;

@JsType(isNative = true, name = "THREE.DirectionalLightShadow", namespace = JsPackage.GLOBAL)
public class DirectionalLightShadow extends LightShadow {
  public OrthographicCamera camera;
  public boolean isDirectionalLightShadow;

  public DirectionalLightShadow() {
    // This super call is here only for the code to compile; it is never executed.
    super((Camera) null);
  }
}
