package org.treblereel.gwt.three4g.color;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.Color.HSL", namespace = JsPackage.GLOBAL)
public interface HSL {
  @JsOverlay
  static HSL create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getH();

  @JsProperty
  double getL();

  @JsProperty
  double getS();

  @JsProperty
  void setH(double h);

  @JsProperty
  void setL(double l);

  @JsProperty
  void setS(double s);
}
