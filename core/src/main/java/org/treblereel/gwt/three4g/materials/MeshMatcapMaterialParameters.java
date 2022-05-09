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

@JsType(isNative = true, name = "THREE.MeshMatcapMaterialParameters", namespace = JsPackage.GLOBAL)
public interface MeshMatcapMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetColorUnionType {
    @JsOverlay
    static MeshMatcapMaterialParameters.GetColorUnionType of(Object o) {
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
  static MeshMatcapMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Texture getAlphaMap();

  @JsProperty
  Texture getBumpMap();

  @JsProperty
  double getBumpScale();

  @JsProperty
  MeshMatcapMaterialParameters.GetColorUnionType getColor();

  @JsProperty
  double getDisplacementBias();

  @JsProperty
  Texture getDisplacementMap();

  @JsProperty
  double getDisplacementScale();

  @JsProperty
  Texture getMap();

  @JsProperty
  Texture getMatcap();

  @JsProperty
  Texture getNormalMap();

  @JsProperty
  double getNormalMapType();

  @JsProperty
  Vector2 getNormalScale();

  @JsProperty
  boolean isFlatShading();

  @JsProperty
  void setAlphaMap(Texture alphaMap);

  @JsProperty
  void setBumpMap(Texture bumpMap);

  @JsProperty
  void setBumpScale(double bumpScale);

  @JsOverlay
  default void setColor(Color color) {
    setColor(Js.<MeshMatcapMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setColor(MeshMatcapMaterialParameters.GetColorUnionType color);

  @JsOverlay
  default void setColor(String color) {
    setColor(Js.<MeshMatcapMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  default void setColor(double color) {
    setColor(Js.<MeshMatcapMaterialParameters.GetColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  void setDisplacementBias(double displacementBias);

  @JsProperty
  void setDisplacementMap(Texture displacementMap);

  @JsProperty
  void setDisplacementScale(double displacementScale);

  @JsProperty
  void setFlatShading(boolean flatShading);

  @JsProperty
  void setMap(Texture map);

  @JsProperty
  void setMatcap(Texture matcap);

  @JsProperty
  void setNormalMap(Texture normalMap);

  @JsProperty
  void setNormalMapType(double normalMapType);

  @JsProperty
  void setNormalScale(Vector2 normalScale);
}
