package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.MeshMatcapMaterial", namespace = JsPackage.GLOBAL)
public class MeshMatcapMaterial extends Material {
  public Texture alphaMap;
  public Texture bumpMap;
  public double bumpScale;
  public Color color;
  public JsPropertyMap<JsObject> defines;
  public double displacementBias;
  public Texture displacementMap;
  public double displacementScale;
  public boolean flatShading;
  public Texture map;
  public Texture matcap;
  public Texture normalMap;
  public double normalMapType;
  public Vector2 normalScale;
  public String type;

  public MeshMatcapMaterial() {}

  public MeshMatcapMaterial(MeshMatcapMaterialParameters parameters) {}

  public native void setValues(MeshMatcapMaterialParameters parameters);
}
