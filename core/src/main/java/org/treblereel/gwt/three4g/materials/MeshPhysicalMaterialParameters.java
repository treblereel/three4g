package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Color;

@JsType(
    isNative = true,
    name = "THREE.MeshPhysicalMaterialParameters",
    namespace = JsPackage.GLOBAL)
public interface MeshPhysicalMaterialParameters extends MeshStandardMaterialParameters {
  @JsOverlay
  static MeshPhysicalMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Color getAttenuationColor();

  @JsProperty
  double getAttenuationDistance();

  @JsProperty
  double getClearcoat();

  @JsProperty
  Texture getClearcoatMap();

  @JsProperty
  Texture getClearcoatNormalMap();

  @JsProperty
  Vector2 getClearcoatNormalScale();

  @JsProperty
  double getClearcoatRoughness();

  @JsProperty
  Texture getClearcoatRoughnessMap();

  @JsProperty
  double getIor();

  @JsProperty
  double getReflectivity();

  @JsProperty
  double getSheen();

  @JsProperty
  Color getSheenColor();

  @JsProperty
  double getSheenRoughness();

  @JsProperty
  Color getSpecularColor();

  @JsProperty
  Texture getSpecularColorMap();

  @JsProperty
  double getSpecularIntensity();

  @JsProperty
  Texture getSpecularIntensityMap();

  @JsProperty
  double getTransmission();

  @JsProperty
  Texture getTransmissionMap();

  @JsProperty
  void setAttenuationColor(Color attenuationColor);

  @JsProperty
  void setAttenuationDistance(double attenuationDistance);

  @JsProperty
  void setClearcoat(double clearcoat);

  @JsProperty
  void setClearcoatMap(Texture clearcoatMap);

  @JsProperty
  void setClearcoatNormalMap(Texture clearcoatNormalMap);

  @JsProperty
  void setClearcoatNormalScale(Vector2 clearcoatNormalScale);

  @JsProperty
  void setClearcoatRoughness(double clearcoatRoughness);

  @JsProperty
  void setClearcoatRoughnessMap(Texture clearcoatRoughnessMap);

  @JsProperty
  void setIor(double ior);

  @JsProperty
  void setReflectivity(double reflectivity);

  @JsProperty
  void setSheen(double sheen);

  @JsProperty
  void setSheenColor(Color sheenColor);

  @JsProperty
  void setSheenRoughness(double sheenRoughness);

  @JsProperty
  void setSpecularColor(Color specularColor);

  @JsProperty
  void setSpecularColorMap(Texture specularColorMap);

  @JsProperty
  void setSpecularIntensity(double specularIntensity);

  @JsProperty
  void setSpecularIntensityMap(Texture specularIntensityMap);

  @JsProperty
  void setTransmission(double transmission);

  @JsProperty
  void setTransmissionMap(Texture transmissionMap);
}
