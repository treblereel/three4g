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
    name = "THREE.BufferAttribute.Float64BufferAttribute",
    namespace = JsPackage.GLOBAL)
public class Float64BufferAttribute extends BufferAttribute {
  public Float64BufferAttribute(ArrayBuffer array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float64BufferAttribute(ArrayBuffer array, double itemSize) {
    super(null, -1);
  }

  public Float64BufferAttribute(JsIterable<Double> array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float64BufferAttribute(JsIterable<Double> array, double itemSize) {
    super(null, -1);
  }

  public Float64BufferAttribute(Object array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float64BufferAttribute(Object array, double itemSize) {
    super(null, -1);
  }

  public Float64BufferAttribute(double array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float64BufferAttribute(double array, double itemSize) {
    super(null, -1);
  }
}
