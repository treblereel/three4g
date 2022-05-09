package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.TetrahedronGeometry", namespace = JsPackage.GLOBAL)
public class TetrahedronGeometry extends PolyhedronGeometry {
  public static native TetrahedronGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final TetrahedronGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public String type;

  public TetrahedronGeometry() {}

  public TetrahedronGeometry(double radius, double detail) {}

  public TetrahedronGeometry(double radius) {}
}
