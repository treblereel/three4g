package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.math.Vector2;

@JsType(isNative = true, name = "THREE.MeshNormalMaterialParameters", namespace = JsPackage.GLOBAL)
public interface MeshNormalMaterialParameters extends MaterialParameters {
  @JsOverlay
  static MeshNormalMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Texture getBumpMap();

  @JsProperty
  double getBumpScale();

  @JsProperty
  double getDisplacementBias();

  @JsProperty
  Texture getDisplacementMap();

  @JsProperty
  double getDisplacementScale();

  @JsProperty
  Texture getNormalMap();

  @JsProperty
  double getNormalMapType();

  @JsProperty
  Vector2 getNormalScale();

  @JsProperty
  double getWireframeLinewidth();

  @JsProperty
  boolean isFlatShading();

  @JsProperty
  boolean isWireframe();

  @JsProperty
  void setBumpMap(Texture bumpMap);

  @JsProperty
  void setBumpScale(double bumpScale);

  @JsProperty
  void setDisplacementBias(double displacementBias);

  @JsProperty
  void setDisplacementMap(Texture displacementMap);

  @JsProperty
  void setDisplacementScale(double displacementScale);

  @JsProperty
  void setFlatShading(boolean flatShading);

  @JsProperty
  void setNormalMap(Texture normalMap);

  @JsProperty
  void setNormalMapType(double normalMapType);

  @JsProperty
  void setNormalScale(Vector2 normalScale);

  @JsProperty
  void setWireframe(boolean wireframe);

  @JsProperty
  void setWireframeLinewidth(double wireframeLinewidth);
}
