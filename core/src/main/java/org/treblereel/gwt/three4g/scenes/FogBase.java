package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.FogBase", namespace = JsPackage.GLOBAL)
public interface FogBase {
  @JsMethod(name = "clone")
  FogBase clone_();

  @JsProperty
  Color getColor();

  @JsProperty
  String getName();

  @JsProperty
  void setColor(Color color);

  @JsProperty
  void setName(String name);

  Object toJSON();

  Object toJSON(String key);
}
