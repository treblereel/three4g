package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.LineDashedMaterialParameters", namespace = JsPackage.GLOBAL)
public interface LineDashedMaterialParameters extends LineBasicMaterialParameters {
  @JsOverlay
  static LineDashedMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getDashSize();

  @JsProperty
  double getGapSize();

  @JsProperty
  double getScale();

  @JsProperty
  void setDashSize(double dashSize);

  @JsProperty
  void setGapSize(double gapSize);

  @JsProperty
  void setScale(double scale);
}
