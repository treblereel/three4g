package org.treblereel.gwt.three4g.utils;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.GeometryUtils", namespace = JsPackage.GLOBAL)
public class GeometryUtils {
  @Deprecated
  public static native double center(double geometry);

  @Deprecated
  public static native double merge(
      double geometry1, double geometry2, JsObject materialIndexOffset);

  @JsOverlay
  @Deprecated
  public static final double merge(double geometry1, double geometry2, Object materialIndexOffset) {
    return merge(geometry1, geometry2, Js.<JsObject>uncheckedCast(materialIndexOffset));
  }

  @Deprecated
  public static native double merge(double geometry1, double geometry2);
}
