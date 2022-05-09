package org.treblereel.gwt.three4g.textures;

import elemental2.core.JsArray;
import elemental2.dom.ImageData;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.CompressedTexture", namespace = JsPackage.GLOBAL)
public class CompressedTexture extends Texture {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ImageFieldType {
    @JsOverlay
    static CompressedTexture.ImageFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getHeight();

    @JsProperty
    double getWidth();

    @JsProperty
    void setHeight(double height);

    @JsProperty
    void setWidth(double width);
  }

  public boolean flipY;
  public boolean generateMipmaps;
  public CompressedTexture.ImageFieldType image;
  public boolean isCompressedTexture;
  public JsArray<ImageData> mipmaps;

  public CompressedTexture(
      ImageData[] mipmaps,
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

  public CompressedTexture(
      ImageData[] mipmaps,
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

  public CompressedTexture(
      ImageData[] mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CompressedTexture(
      ImageData[] mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public CompressedTexture(
      ImageData[] mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT) {}

  public CompressedTexture(
      ImageData[] mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS) {}

  public CompressedTexture(
      ImageData[] mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping) {}

  public CompressedTexture(
      ImageData[] mipmaps, double width, double height, double format, double type) {}

  public CompressedTexture(ImageData[] mipmaps, double width, double height, double format) {}

  public CompressedTexture(ImageData[] mipmaps, double width, double height) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
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

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
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

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS,
      double wrapT) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping,
      double wrapS) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps,
      double width,
      double height,
      double format,
      double type,
      double mapping) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps, double width, double height, double format, double type) {}

  public CompressedTexture(
      JsArray<ImageData> mipmaps, double width, double height, double format) {}

  public CompressedTexture(JsArray<ImageData> mipmaps, double width, double height) {}
}
