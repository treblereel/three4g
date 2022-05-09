package org.treblereel.gwt.three4g.textures;

import elemental2.core.ArrayBuffer;
import elemental2.core.ArrayBufferView;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.DataTexture3D", namespace = JsPackage.GLOBAL)
public class DataTexture3D extends Texture {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorDataUnionType {
    @JsOverlay
    static DataTexture3D.ConstructorDataUnionType of(Object o) {
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
  public boolean isDataTexture3D;
  public double magFilter;
  public double minFilter;
  public boolean wrapR;

  public DataTexture3D(ArrayBuffer data, double width, double height, double depth) {}

  public DataTexture3D(ArrayBufferView data, double width, double height, double depth) {}

  public DataTexture3D(
      DataTexture3D.ConstructorDataUnionType data, double width, double height, double depth) {}
}
