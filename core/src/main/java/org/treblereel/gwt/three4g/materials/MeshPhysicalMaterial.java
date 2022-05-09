package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.MeshPhysicalMaterial", namespace = JsPackage.GLOBAL)
public class MeshPhysicalMaterial extends MeshStandardMaterial {
  public Color attenuationColor;
  public double attenuationDistance;
  public double clearcoat;
  public Texture clearcoatMap;
  public Texture clearcoatNormalMap;
  public Vector2 clearcoatNormalScale;
  public double clearcoatRoughness;
  public Texture clearcoatRoughnessMap;
  public JsPropertyMap<JsObject> defines;
  public double ior;
  public double reflectivity;
  public double sheen;
  public Color sheenColor;
  public Texture sheenColorMap;
  public double sheenRoughness;
  public Texture sheenRoughnessMap;
  public Color specularColor;
  public Texture specularColorMap;
  public double specularIntensity;
  public Texture specularIntensityMap;
  public double thickness;
  public Texture thicknessMap;
  public double transmission;
  public Texture transmissionMap;
  public String type;

  public MeshPhysicalMaterial() {}

  public MeshPhysicalMaterial(MeshPhysicalMaterialParameters parameters) {}
}
