package org.treblereel.gwt.three4g.bufferattribute;

import elemental2.core.ArrayBuffer;
import elemental2.core.JsIterable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(
    isNative = true,
    name = "THREE.BufferAttribute.Uint8BufferAttribute",
    namespace = JsPackage.GLOBAL)
public class Uint8BufferAttribute {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorArrayUnionType {
    @JsOverlay
    static Uint8BufferAttribute.ConstructorArrayUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default ArrayBuffer asArrayBuffer() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default JsIterable<Double> asJsIterable() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isArrayBuffer() {
      return (Object) this instanceof ArrayBuffer;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }
  }

  public Uint8BufferAttribute(ArrayBuffer array, double itemSize, boolean normalized) {}

  public Uint8BufferAttribute(ArrayBuffer array, double itemSize) {}

  public Uint8BufferAttribute(
      Uint8BufferAttribute.ConstructorArrayUnionType array, double itemSize, boolean normalized) {}

  public Uint8BufferAttribute(
      Uint8BufferAttribute.ConstructorArrayUnionType array, double itemSize) {}

  public Uint8BufferAttribute(JsIterable<Double> array, double itemSize, boolean normalized) {}

  public Uint8BufferAttribute(JsIterable<Double> array, double itemSize) {}

  public Uint8BufferAttribute(Object array, double itemSize, boolean normalized) {}

  public Uint8BufferAttribute(Object array, double itemSize) {}

  public Uint8BufferAttribute(double array, double itemSize, boolean normalized) {}

  public Uint8BufferAttribute(double array, double itemSize) {}
}
