package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.InstancedInterleavedBuffer", namespace = JsPackage.GLOBAL)
public class InstancedInterleavedBuffer extends InterleavedBuffer {
  public double meshPerAttribute;

  public InstancedInterleavedBuffer(Object array, double stride, double meshPerAttribute) {
    // This super call is here only for the code to compile; it is never executed.
    super((Object) null, 0);
  }

  public InstancedInterleavedBuffer(Object array, double stride) {
    // This super call is here only for the code to compile; it is never executed.
    super((Object) null, 0);
  }
}
