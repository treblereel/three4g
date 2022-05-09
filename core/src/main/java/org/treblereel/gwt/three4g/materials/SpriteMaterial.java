package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.SpriteMaterial", namespace = JsPackage.GLOBAL)
public class SpriteMaterial extends Material {
  public Texture alphaMap;
  public Color color;
  public boolean isSpriteMaterial;
  public Texture map;
  public double rotation;
  public boolean sizeAttenuation;
  public boolean transparent;
  public String type;

  public SpriteMaterial() {}

  public SpriteMaterial(SpriteMaterialParameters parameters) {}

  public native SpriteMaterial copy(SpriteMaterial source);

  public native void setValues(SpriteMaterialParameters parameters);
}
