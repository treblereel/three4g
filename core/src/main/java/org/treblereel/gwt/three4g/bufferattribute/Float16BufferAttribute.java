package org.treblereel.gwt.three4g.bufferattribute;

import elemental2.core.ArrayBuffer;
import elemental2.core.JsIterable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;

@JsType(
    isNative = true,
    name = "THREE.BufferAttribute.Float16BufferAttribute",
    namespace = JsPackage.GLOBAL)
public class Float16BufferAttribute  extends BufferAttribute {
  public Float16BufferAttribute(ArrayBuffer array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float16BufferAttribute(ArrayBuffer array, double itemSize) {
    super(null, -1);
  }

  public Float16BufferAttribute(JsIterable<Double> array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float16BufferAttribute(JsIterable<Double> array, double itemSize) {
    super(null, -1);
  }

  public Float16BufferAttribute(Object array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float16BufferAttribute(Object array, double itemSize) {
    super(null, -1);
  }

  public Float16BufferAttribute(double array, double itemSize, boolean normalized) {
    super(null, -1);
  }

  public Float16BufferAttribute(double array, double itemSize) {
    super(null, -1);
  }
}
