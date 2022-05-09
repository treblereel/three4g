package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.MeshDepthMaterialParameters", namespace = JsPackage.GLOBAL)
public interface MeshDepthMaterialParameters extends MaterialParameters {
  @JsOverlay
  static MeshDepthMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  Texture getAlphaMap();

  @JsProperty
  double getDepthPacking();

  @JsProperty
  double getDisplacementBias();

  @JsProperty
  Texture getDisplacementMap();

  @JsProperty
  double getDisplacementScale();

  @JsProperty
  Texture getMap();

  @JsProperty
  double getWireframeLinewidth();

  @JsProperty
  boolean isWireframe();

  @JsProperty
  void setAlphaMap(Texture alphaMap);

  @JsProperty
  void setDepthPacking(double depthPacking);

  @JsProperty
  void setDisplacementBias(double displacementBias);

  @JsProperty
  void setDisplacementMap(Texture displacementMap);

  @JsProperty
  void setDisplacementScale(double displacementScale);

  @JsProperty
  void setMap(Texture map);

  @JsProperty
  void setWireframe(boolean wireframe);

  @JsProperty
  void setWireframeLinewidth(double wireframeLinewidth);
}
