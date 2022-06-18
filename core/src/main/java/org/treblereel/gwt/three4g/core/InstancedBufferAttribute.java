package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

@JsType(isNative = true, name = "THREE.InstancedBufferAttribute", namespace = JsPackage.GLOBAL)
public class InstancedBufferAttribute extends BufferAttribute {
  public double meshPerAttribute;

  public InstancedBufferAttribute(
      Object array, double itemSize, boolean normalized, double meshPerAttribute) {
    // This super call is here only for the code to compile; it is never executed.
    super((JsArrayLike) null, 0, false);
  }

  public InstancedBufferAttribute(Object array, double itemSize, boolean normalized) {
    // This super call is here only for the code to compile; it is never executed.
    super((JsArrayLike) null, 0, false);
  }

  public InstancedBufferAttribute(Object array, double itemSize) {
    // This super call is here only for the code to compile; it is never executed.
    super((JsArrayLike) null, 0, false);
  }
}
