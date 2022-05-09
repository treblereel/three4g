package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.LineDashedMaterial", namespace = JsPackage.GLOBAL)
public class LineDashedMaterial extends LineBasicMaterial {
  public double dashSize;
  public double gapSize;
  public boolean isLineDashedMaterial;
  public double scale;
  public String type;

  public LineDashedMaterial() {}

  public LineDashedMaterial(LineDashedMaterialParameters parameters) {}

  public native void setValues(LineDashedMaterialParameters parameters);
}
