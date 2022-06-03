package org.treblereel.gwt.three4g.bufferattribute;

import elemental2.core.ArrayBuffer;
import elemental2.core.JsIterable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;

@JsType(
    isNative = true,
    name = "THREE.BufferAttribute.Uint32BufferAttribute",
    namespace = JsPackage.GLOBAL)
public class Uint32BufferAttribute extends BufferAttribute {

  public Uint32BufferAttribute(ArrayBuffer array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Uint32BufferAttribute(ArrayBuffer array, double itemSize) {
    super(null, -1);
  }

  public Uint32BufferAttribute(JsIterable<Double> array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Uint32BufferAttribute(JsIterable<Double> array, double itemSize) {
    super(null, -1);
  }

  public Uint32BufferAttribute(Object array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Uint32BufferAttribute(Object array, double itemSize) {
    super(null, -1);
  }

  public Uint32BufferAttribute(double array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Uint32BufferAttribute(double array, double itemSize) {
    super(null, -1);
  }
}
