package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.MeshLambertMaterial", namespace = JsPackage.GLOBAL)
public class MeshLambertMaterial extends Material {
  public Texture alphaMap;
  public Texture aoMap;
  public double aoMapIntensity;
  public Color color;
  public double combine;
  public Color emissive;
  public double emissiveIntensity;
  public Texture emissiveMap;
  public Texture envMap;
  public Texture lightMap;
  public double lightMapIntensity;
  public Texture map;
  public double reflectivity;
  public double refractionRatio;
  public Texture specularMap;
  public String type;
  public boolean wireframe;
  public String wireframeLinecap;
  public String wireframeLinejoin;
  public double wireframeLinewidth;

  public MeshLambertMaterial() {}

  public MeshLambertMaterial(MeshLambertMaterialParameters parameters) {}

  public native void setValues(MeshLambertMaterialParameters parameters);
}
