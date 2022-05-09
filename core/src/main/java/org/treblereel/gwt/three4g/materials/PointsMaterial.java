package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.PointsMaterial", namespace = JsPackage.GLOBAL)
public class PointsMaterial extends Material {
  public Texture alphaMap;
  public Color color;
  public Texture map;
  public double size;
  public boolean sizeAttenuation;
  public String type;

  public PointsMaterial() {}

  public PointsMaterial(PointsMaterialParameters parameters) {}

  public native void setValues(PointsMaterialParameters parameters);
}
