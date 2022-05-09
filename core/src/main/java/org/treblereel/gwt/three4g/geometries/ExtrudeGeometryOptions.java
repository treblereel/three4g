package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.extras.core.Curve;

@JsType(isNative = true, name = "THREE.ExtrudeGeometryOptions", namespace = JsPackage.GLOBAL)
public interface ExtrudeGeometryOptions {
  @JsOverlay
  static ExtrudeGeometryOptions create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getBevelOffset();

  @JsProperty
  double getBevelSegments();

  @JsProperty
  double getBevelSize();

  @JsProperty
  double getBevelThickness();

  @JsProperty
  double getCurveSegments();

  @JsProperty
  double getDepth();

  @JsProperty
  Curve getExtrudePath();

  @JsProperty
  double getSteps();

  @JsProperty
  boolean isBevelEnabled();

  @JsProperty
  void setBevelEnabled(boolean bevelEnabled);

  @JsProperty
  void setBevelOffset(double bevelOffset);

  @JsProperty
  void setBevelSegments(double bevelSegments);

  @JsProperty
  void setBevelSize(double bevelSize);

  @JsProperty
  void setBevelThickness(double bevelThickness);

  @JsProperty
  void setCurveSegments(double curveSegments);

  @JsProperty
  void setDepth(double depth);

  @JsProperty
  void setExtrudePath(Curve extrudePath);

  @JsProperty
  void setSteps(double steps);
}
