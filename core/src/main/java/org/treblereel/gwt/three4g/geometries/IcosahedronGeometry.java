package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.IcosahedronGeometry", namespace = JsPackage.GLOBAL)
public class IcosahedronGeometry extends PolyhedronGeometry {
  public static native IcosahedronGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final IcosahedronGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public String type;

  public IcosahedronGeometry() {}

  public IcosahedronGeometry(double radius, double detail) {}

  public IcosahedronGeometry(double radius) {}
}
