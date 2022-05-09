package org.treblereel.gwt.three4g.raycaster;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.Raycaster.Face", namespace = JsPackage.GLOBAL)
public interface Face {
  @JsOverlay
  static Face create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getA();

  @JsProperty
  double getB();

  @JsProperty
  double getC();

  @JsProperty
  double getMaterialIndex();

  @JsProperty
  Vector3 getNormal();

  @JsProperty
  void setA(double a);

  @JsProperty
  void setB(double b);

  @JsProperty
  void setC(double c);

  @JsProperty
  void setMaterialIndex(double materialIndex);

  @JsProperty
  void setNormal(Vector3 normal);
}
