package org.treblereel.gwt.three4g.utils;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.BufferGeometryUtils", namespace = JsPackage.GLOBAL)
public class BufferGeometryUtils {
  @JsOverlay
  public static final BufferAttribute mergeBufferAttributes(BufferAttribute[] attributes) {
    return mergeBufferAttributes(Js.<JsArray<BufferAttribute>>uncheckedCast(attributes));
  }

  public static native BufferAttribute mergeBufferAttributes(JsArray<BufferAttribute> attributes);

  @JsOverlay
  public static final BufferGeometry mergeBufferGeometries(BufferGeometry[] geometries) {
    return mergeBufferGeometries(Js.<JsArray<BufferGeometry>>uncheckedCast(geometries));
  }

  public static native BufferGeometry mergeBufferGeometries(JsArray<BufferGeometry> geometries);
}
