package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.LineBasicMaterial", namespace = JsPackage.GLOBAL)
public class LineBasicMaterial extends Material {
  public Color color;
  public String linecap;
  public String linejoin;
  public double linewidth;
  public String type;

  public LineBasicMaterial() {}

  public LineBasicMaterial(LineBasicMaterialParameters parameters) {}

  public native void setValues(LineBasicMaterialParameters parameters);
}
