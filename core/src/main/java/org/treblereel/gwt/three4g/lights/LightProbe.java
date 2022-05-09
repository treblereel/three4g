package org.treblereel.gwt.three4g.lights;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.SphericalHarmonics3;

@JsType(isNative = true, name = "THREE.LightProbe", namespace = JsPackage.GLOBAL)
public class LightProbe extends Light {
  public boolean isLightProbe;
  public SphericalHarmonics3 sh;
  public String type;

  public LightProbe() {}

  public LightProbe(SphericalHarmonics3 sh, double intensity) {}

  public LightProbe(SphericalHarmonics3 sh) {}

  public native LightProbe fromJSON(JsObject json);

  @JsOverlay
  public final LightProbe fromJSON(Object json) {
    return fromJSON(Js.<JsObject>uncheckedCast(json));
  }
}
