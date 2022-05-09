package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.MeshDepthMaterial", namespace = JsPackage.GLOBAL)
public class MeshDepthMaterial extends Material {
  public Texture alphaMap;
  public double depthPacking;
  public double displacementBias;
  public Texture displacementMap;
  public double displacementScale;
  public boolean fog;
  public Texture map;
  public String type;
  public boolean wireframe;
  public double wireframeLinewidth;

  public MeshDepthMaterial() {}

  public MeshDepthMaterial(MeshDepthMaterialParameters parameters) {}

  public native void setValues(MeshDepthMaterialParameters parameters);
}
