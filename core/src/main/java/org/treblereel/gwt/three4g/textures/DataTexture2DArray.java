package org.treblereel.gwt.three4g.textures;

import elemental2.core.ArrayBuffer;
import elemental2.core.ArrayBufferView;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.DataTexture2DArray", namespace = JsPackage.GLOBAL)
public class DataTexture2DArray extends Texture {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorDataUnionType {
    @JsOverlay
    static DataTexture2DArray.ConstructorDataUnionType of(Object o) {
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
  public boolean generateMipmaps;
  public boolean isDataTexture2DArray;
  public double magFilter;
  public double minFilter;
  public boolean wrapR;

  public DataTexture2DArray() {}

  public DataTexture2DArray(ArrayBuffer data, double width, double height, double depth) {}

  public DataTexture2DArray(ArrayBuffer data, double width, double height) {}

  public DataTexture2DArray(ArrayBuffer data, double width) {}

  public DataTexture2DArray(ArrayBuffer data) {}

  public DataTexture2DArray(ArrayBufferView data, double width, double height, double depth) {}

  public DataTexture2DArray(ArrayBufferView data, double width, double height) {}

  public DataTexture2DArray(ArrayBufferView data, double width) {}

  public DataTexture2DArray(ArrayBufferView data) {}

  public DataTexture2DArray(
      DataTexture2DArray.ConstructorDataUnionType data,
      double width,
      double height,
      double depth) {}

  public DataTexture2DArray(
      DataTexture2DArray.ConstructorDataUnionType data, double width, double height) {}

  public DataTexture2DArray(DataTexture2DArray.ConstructorDataUnionType data, double width) {}

  public DataTexture2DArray(DataTexture2DArray.ConstructorDataUnionType data) {}
}
