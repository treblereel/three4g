package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.MeshPhongMaterial", namespace = JsPackage.GLOBAL)
public class MeshPhongMaterial extends Material {
  public Texture alphaMap;
  public Texture aoMap;
  public double aoMapIntensity;
  public Texture bumpMap;
  public double bumpScale;
  public Color color;
  public double combine;
  public double displacementBias;
  public Texture displacementMap;
  public double displacementScale;
  public Color emissive;
  public double emissiveIntensity;
  public Texture emissiveMap;
  public Texture envMap;
  public boolean flatShading;
  public Texture lightMap;
  public double lightMapIntensity;
  public Texture map;
  public boolean metal;
  public Texture normalMap;
  public double normalMapType;
  public Vector2 normalScale;
  public double reflectivity;
  public double refractionRatio;
  public double shininess;
  public Color specular;
  public Texture specularMap;
  public String type;
  public boolean wireframe;
  public String wireframeLinecap;
  public String wireframeLinejoin;
  public double wireframeLinewidth;

  public MeshPhongMaterial() {}

  public MeshPhongMaterial(MeshPhongMaterialParameters parameters) {}

  public native void setValues(MeshPhongMaterialParameters parameters);
}
