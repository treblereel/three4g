package org.treblereel.gwt.three4g.loaders;

import elemental2.core.ArrayBuffer;
import elemental2.core.ArrayBufferView;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.LoaderUtils", namespace = JsPackage.GLOBAL)
public interface LoaderUtils {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface DecodeTextArrayUnionType {
    @JsOverlay
    static LoaderUtils.DecodeTextArrayUnionType of(Object o) {
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

  @JsOverlay
  default String decodeText(ArrayBuffer array) {
    return decodeText(Js.<LoaderUtils.DecodeTextArrayUnionType>uncheckedCast(array));
  }

  @JsOverlay
  default String decodeText(ArrayBufferView array) {
    return decodeText(Js.<LoaderUtils.DecodeTextArrayUnionType>uncheckedCast(array));
  }

  String decodeText(LoaderUtils.DecodeTextArrayUnionType array);

  String extractUrlBase(String url);

  String resolveURL(String url, String path);
}
