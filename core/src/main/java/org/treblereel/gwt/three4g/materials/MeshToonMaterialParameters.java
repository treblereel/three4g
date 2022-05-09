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

@JsType(isNative = true, name = "THREE.MeshToonMaterialParameters", namespace = JsPackage.GLOBAL)
public interface MeshToonMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetColorUnionType {
    @JsOverlay
    static MeshToonMaterialParameters.GetColorUnionType of(Object o) {
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
    static MeshToonMaterialParameters.GetEmissiveUnionType of(Object o) {
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
  static MeshToonMaterialParameters create() {
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
  MeshToonMaterialParameters.GetColorUnionType getColor();

  @JsProperty
  double getDisplacementBias();

  @JsProperty
  Texture getDisplacementMap();

  @JsProperty
  double getDisplacementScale();

  @JsProperty
  MeshToonMaterialParameters.GetEmissiveUnionType getEmissive();

  @JsProperty
  double getEmissiveIntensity();

  @JsProperty
  Texture getEmissiveMap();

  @JsProperty
  Texture getGradientMap();

  @JsProperty
  Texture getLightMap();

  @JsProperty
  double getLightMapIntensity();

  @JsProperty
  Texture getMap();

  @JsProperty
  Texture getNormalMap();

  @JsProperty
  double getNormalMapType();

  @JsProperty
  Vector2 getNormalScale();

  @JsProperty
  double getOpacity();

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

  @JsProperty
  void setBumpMap(Texture bumpMap);

  @JsProperty
  void setBumpScale(double bumpScale);

  @JsOverlay
  default void setColor(Color color) {
    setColor(Js.<MeshToonMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setColor(MeshToonMaterialParameters.GetColorUnionType color);

  @JsOverlay
  default void setColor(String color) {
    setColor(Js.<MeshToonMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  default void setColor(double color) {
    setColor(Js.<MeshToonMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setDisplacementBias(double displacementBias);

  @JsProperty
  void setDisplacementMap(Texture displacementMap);

  @JsProperty
  void setDisplacementScale(double displacementScale);

  @JsOverlay
  default void setEmissive(Color emissive) {
    setEmissive(Js.<MeshToonMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsProperty
  void setEmissive(MeshToonMaterialParameters.GetEmissiveUnionType emissive);

  @JsOverlay
  default void setEmissive(String emissive) {
    setEmissive(Js.<MeshToonMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsOverlay
  default void setEmissive(double emissive) {
    setEmissive(Js.<MeshToonMaterialParameters.GetEmissiveUnionType>uncheckedCast(emissive));
  }

  @JsProperty
  void setEmissiveIntensity(double emissiveIntensity);

  @JsProperty
  void setEmissiveMap(Texture emissiveMap);

  @JsProperty
  void setGradientMap(Texture gradientMap);

  @JsProperty
  void setLightMap(Texture lightMap);

  @JsProperty
  void setLightMapIntensity(double lightMapIntensity);

  @JsProperty
  void setMap(Texture map);

  @JsProperty
  void setNormalMap(Texture normalMap);

  @JsProperty
  void setNormalMapType(double normalMapType);

  @JsProperty
  void setNormalScale(Vector2 normalScale);

  @JsProperty
  void setOpacity(double opacity);

  @JsProperty
  void setWireframe(boolean wireframe);

  @JsProperty
  void setWireframeLinecap(String wireframeLinecap);

  @JsProperty
  void setWireframeLinejoin(String wireframeLinejoin);

  @JsProperty
  void setWireframeLinewidth(double wireframeLinewidth);
}
