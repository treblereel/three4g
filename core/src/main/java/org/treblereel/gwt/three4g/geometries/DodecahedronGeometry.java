package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.DodecahedronGeometry", namespace = JsPackage.GLOBAL)
public class DodecahedronGeometry extends PolyhedronGeometry {
  public static native DodecahedronGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final DodecahedronGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public String type;

  public DodecahedronGeometry() {}

  public DodecahedronGeometry(double radius, double detail) {}

  public DodecahedronGeometry(double radius) {}
}
