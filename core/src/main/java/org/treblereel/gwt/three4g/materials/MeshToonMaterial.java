package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.MeshToonMaterial", namespace = JsPackage.GLOBAL)
public class MeshToonMaterial extends Material {
  public Texture alphaMap;
  public Texture aoMap;
  public double aoMapIntensity;
  public Texture bumpMap;
  public double bumpScale;
  public Color color;
  public JsPropertyMap<JsObject> defines;
  public double displacementBias;
  public Texture displacementMap;
  public double displacementScale;
  public Color emissive;
  public double emissiveIntensity;
  public Texture emissiveMap;
  public Texture gradientMap;
  public Texture lightMap;
  public double lightMapIntensity;
  public Texture map;
  public Texture normalMap;
  public double normalMapType;
  public Vector2 normalScale;
  public String type;
  public boolean wireframe;
  public String wireframeLinecap;
  public String wireframeLinejoin;
  public double wireframeLinewidth;

  public MeshToonMaterial() {}

  public MeshToonMaterial(MeshToonMaterialParameters parameters) {}

  public native void setValues(MeshToonMaterialParameters parameters);
}
