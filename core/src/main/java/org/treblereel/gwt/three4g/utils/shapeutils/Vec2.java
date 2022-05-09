package org.treblereel.gwt.three4g.utils.shapeutils;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.ShapeUtils.Vec2", namespace = JsPackage.GLOBAL)
public interface Vec2 {
  @JsOverlay
  static Vec2 create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getX();

  @JsProperty
  double getY();

  @JsProperty
  void setX(double x);

  @JsProperty
  void setY(double y);
}
