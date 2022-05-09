package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.OctahedronGeometry", namespace = JsPackage.GLOBAL)
public class OctahedronGeometry {
  public static native OctahedronGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final OctahedronGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public String type;

  public OctahedronGeometry() {}

  public OctahedronGeometry(double radius, double detail) {}

  public OctahedronGeometry(double radius) {}
}
