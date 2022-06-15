package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.ShadowMaterial", namespace = JsPackage.GLOBAL)
public class ShadowMaterial extends Material {
  public Color color;
  public boolean transparent;
  public String type;

  public ShadowMaterial() {}

  public ShadowMaterial(ShadowMaterialParameters parameters) {}
}
