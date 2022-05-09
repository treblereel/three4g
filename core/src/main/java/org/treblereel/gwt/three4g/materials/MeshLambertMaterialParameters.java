package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.MeshLambertMaterialParameters", namespace = JsPackage.GLOBAL)
public interface MeshLambertMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetColorUnionType {
    @JsOverlay
    static MeshLambertMaterialParameters.GetColorUnionType of(Object o) {
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
    static MeshLambertMaterialParameters.GetEmissiveUnionType of(Object o) {
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
  static MeshLambertMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Texture getAlphaMap();

  @JsProperty
  Texture getAoMap();

  @JsProperty
  double getAoMapIntensity();

  @JsProperty
  MeshLambertMaterialParameters.GetColorUnionType getColor();

  @JsProperty
  double getCombine();

  @JsProperty
  MeshLambertMaterialParameters.GetEmissiveUnionType getEmissive();

  @JsProperty
  double getEmissiveIntensity();

  @JsProperty
  Texture getEmissiveMap();

  @JsProperty
  Texture getEnvMap();

  @JsProperty
  Texture getLightMap();

  @JsProperty
  double getLightMapIntensity();

  @JsProperty
  Texture getMap();

  @JsProperty
  double getReflectivity();

  @JsProperty
  double getRefractionRatio();

  @JsProperty
  Texture getSpecularMap();

  @JsProperty
  String getWireframeLinecap();

  @JsProperty
  String getWireframeLinejoin();

  @JsProperty
  double getWireframeLinewidth();

  @JsProperty
  boolean isWireframe();

  @JsProperty
  void setAlphaMap(Texture alphaMap);

  @JsProperty
  void setAoMap(Texture aoMap);

  @JsProperty
  void setAoMapIntensity(double aoMapIntensity);

  @JsOverlay
  default void setColor(Color color) {
    setColor(Js.<MeshLambertMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setColor(MeshLambertMaterialParameters.GetColorUnionType color);

  @JsOverlay
  default void setColor(String color) {
    setColor(Js.<MeshLambertMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  default void setColor(double color) {
    setColor(Js.<MeshLambertMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setCombine(double combine);

  @JsOverlay
  default void setEmissive(Color emissive) {
    setEmissive(Js.<MeshLambertMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsProperty
  void setEmissive(MeshLambertMaterialParameters.GetEmissiveUnionType emissive);

  @JsOverlay
  default void setEmissive(String emissive) {
    setEmissive(Js.<MeshLambertMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsOverlay
  default void setEmissive(double emissive) {
    setEmissive(Js.<MeshLambertMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsProperty
  void setEmissiveIntensity(double emissiveIntensity);

  @JsProperty
  void setEmissiveMap(Texture emissiveMap);

  @JsProperty
  void setEnvMap(Texture envMap);

  @JsProperty
  void setLightMap(Texture lightMap);

  @JsProperty
  void setLightMapIntensity(double lightMapIntensity);

  @JsProperty
  void setMap(Texture map);

  @JsProperty
  void setReflectivity(double reflectivity);

  @JsProperty
  void setRefractionRatio(double refractionRatio);

  @JsProperty
  void setSpecularMap(Texture specularMap);

  @JsProperty
  void setWireframe(boolean wireframe);

  @JsProperty
  void setWireframeLinecap(String wireframeLinecap);

  @JsProperty
  void setWireframeLinejoin(String wireframeLinejoin);

  @JsProperty
  void setWireframeLinewidth(double wireframeLinewidth);
}
