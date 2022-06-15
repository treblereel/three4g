package org.treblereel.gwt.three4g.textures;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.DepthTexture", namespace = JsPackage.GLOBAL)
public class DepthTexture extends Texture {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ImageFieldType {
    @JsOverlay
    static DepthTexture.ImageFieldType create() {
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
  public DepthTexture.ImageFieldType image;
  public boolean isDepthTexture;

  public DepthTexture(
      double width,
      double height,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double anisotropy) {}

  public DepthTexture(
      double width,
      double height,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public DepthTexture(
      double width,
      double height,
      double type,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public DepthTexture(
      double width, double height, double type, double mapping, double wrapS, double wrapT) {}

  public DepthTexture(double width, double height, double type, double mapping, double wrapS) {}

  public DepthTexture(double width, double height, double type, double mapping) {}

  public DepthTexture(double width, double height, double type) {}

  public DepthTexture(double width, double height) {}
  public DepthTexture() {}
}
