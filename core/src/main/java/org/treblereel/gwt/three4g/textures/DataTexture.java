package org.treblereel.gwt.three4g.textures;

import elemental2.core.ArrayBuffer;
import elemental2.core.ArrayBufferView;
import elemental2.dom.ImageData;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.DataTexture", namespace = JsPackage.GLOBAL)
public class DataTexture extends Texture {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorDataUnionType {
    @JsOverlay
    static DataTexture.ConstructorDataUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default ArrayBuffer asArrayBuffer() {
      return Js.cast(this);
    }

    @JsOverlay
    default ArrayBufferView asArrayBufferView() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isArrayBuffer() {
      return (Object) this instanceof ArrayBuffer;
    }

    @JsOverlay
    default boolean isArrayBufferView() {
      return (Object) this instanceof ArrayBufferView;
    }
  }

  public boolean flipY;
  public double format;
  public boolean generateMipmaps;
  public ImageData image;
  public boolean isDataTexture;
  public double unpackAlignment;

  public DataTexture() {}

  public DataTexture(
      ArrayBuffer data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy,
      double encoding) {}

  public DataTexture(
      ArrayBuffer data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy) {}

  public DataTexture(
      ArrayBuffer data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public DataTexture(
      ArrayBuffer data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public DataTexture(
      ArrayBuffer data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT) {}

  public DataTexture(
      ArrayBuffer data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS) {}

  public DataTexture(
      ArrayBuffer data, double width, double height, double format, double type, double mapping) {}

  public DataTexture(ArrayBuffer data, double width, double height, double format, double type) {}

  public DataTexture(ArrayBuffer data, double width, double height, double format) {}

  public DataTexture(ArrayBuffer data, double width, double height) {}

  public DataTexture(ArrayBuffer data, double width) {}

  public DataTexture(ArrayBuffer data) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy,
      double encoding) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS) {}

  public DataTexture(
      ArrayBufferView data,
      double width,
      double height,
      double format,
      double type,
      double mapping) {}

  public DataTexture(
      ArrayBufferView data, double width, double height, double format, double type) {}

  public DataTexture(ArrayBufferView data, double width, double height, double format) {}

  public DataTexture(ArrayBufferView data, double width, double height) {}

  public DataTexture(ArrayBufferView data, double width) {}

  public DataTexture(ArrayBufferView data) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy,
      double encoding) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type,
      double mapping) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data,
      double width,
      double height,
      double format,
      double type) {}

  public DataTexture(
      DataTexture.ConstructorDataUnionType data, double width, double height, double format) {}

  public DataTexture(DataTexture.ConstructorDataUnionType data, double width, double height) {}

  public DataTexture(DataTexture.ConstructorDataUnionType data, double width) {}

  public DataTexture(DataTexture.ConstructorDataUnionType data) {}
}
