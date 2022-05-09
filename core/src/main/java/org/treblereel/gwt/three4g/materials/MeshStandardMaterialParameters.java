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
    name = "THREE.MeshStandardMaterialParameters",
    namespace = JsPackage.GLOBAL)
public interface MeshStandardMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetColorUnionType {
    @JsOverlay
    static MeshStandardMaterialParameters.GetColorUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetEmissiveUnionType {
    @JsOverlay
    static MeshStandardMaterialParameters.GetEmissiveUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsOverlay
  static MeshStandardMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Texture getAlphaMap();

  @JsProperty
  Texture getAoMap();

  @JsProperty
  double getAoMapIntensity();

  @JsProperty
  Texture getBumpMap();

  @JsProperty
  double getBumpScale();

  @JsProperty
  MeshStandardMaterialParameters.GetColorUnionType getColor();

  @JsProperty
  double getDisplacementBias();

  @JsProperty
  Texture getDisplacementMap();

  @JsProperty
  double getDisplacementScale();

  @JsProperty
  MeshStandardMaterialParameters.GetEmissiveUnionType getEmissive();

  @JsProperty
  double getEmissiveIntensity();

  @JsProperty
  Texture getEmissiveMap();

  @JsProperty
  Texture getEnvMap();

  @JsProperty
  double getEnvMapIntensity();

  @JsProperty
  Texture getLightMap();

  @JsProperty
  double getLightMapIntensity();

  @JsProperty
  Texture getMap();

  @JsProperty
  double getMetalness();

  @JsProperty
  Texture getMetalnessMap();

  @JsProperty
  Texture getNormalMap();

  @JsProperty
  double getNormalMapType();

  @JsProperty
  Vector2 getNormalScale();

  @JsProperty
  double getRefractionRatio();

  @JsProperty
  double getRoughness();

  @JsProperty
  Texture getRoughnessMap();

  @JsProperty
  double getWireframeLinewidth();

  @JsProperty
  boolean isFlatShading();

  @JsProperty
  boolean isWireframe();

  @JsProperty
  void setAlphaMap(Texture alphaMap);

  @JsProperty
  void setAoMap(Texture aoMap);

  @JsProperty
  void setAoMapIntensity(double aoMapIntensity);

  @JsProperty
  void setBumpMap(Texture bumpMap);

  @JsProperty
  void setBumpScale(double bumpScale);

  @JsOverlay
  default void setColor(Color color) {
    setColor(Js.<MeshStandardMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setColor(MeshStandardMaterialParameters.GetColorUnionType color);

  @JsOverlay
  default void setColor(String color) {
    setColor(Js.<MeshStandardMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  default void setColor(double color) {
    setColor(Js.<MeshStandardMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setDisplacementBias(double displacementBias);

  @JsProperty
  void setDisplacementMap(Texture displacementMap);

  @JsProperty
  void setDisplacementScale(double displacementScale);

  @JsOverlay
  default void setEmissive(Color emissive) {
    setEmissive(Js.<MeshStandardMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsProperty
  void setEmissive(MeshStandardMaterialParameters.GetEmissiveUnionType emissive);

  @JsOverlay
  default void setEmissive(String emissive) {
    setEmissive(Js.<MeshStandardMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsOverlay
  default void setEmissive(double emissive) {
    setEmissive(Js.<MeshStandardMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsProperty
  void setEmissiveIntensity(double emissiveIntensity);

  @JsProperty
  void setEmissiveMap(Texture emissiveMap);

  @JsProperty
  void setEnvMap(Texture envMap);

  @JsProperty
  void setEnvMapIntensity(double envMapIntensity);

  @JsProperty
  void setFlatShading(boolean flatShading);

  @JsProperty
  void setLightMap(Texture lightMap);

  @JsProperty
  void setLightMapIntensity(double lightMapIntensity);

  @JsProperty
  void setMap(Texture map);

  @JsProperty
  void setMetalness(double metalness);

  @JsProperty
  void setMetalnessMap(Texture metalnessMap);

  @JsProperty
  void setNormalMap(Texture normalMap);

  @JsProperty
  void setNormalMapType(double normalMapType);

  @JsProperty
  void setNormalScale(Vector2 normalScale);

  @JsProperty
  void setRefractionRatio(double refractionRatio);

  @JsProperty
  void setRoughness(double roughness);

  @JsProperty
  void setRoughnessMap(Texture roughnessMap);

  @JsProperty
  void setWireframe(boolean wireframe);

  @JsProperty
  void setWireframeLinewidth(double wireframeLinewidth);
}
