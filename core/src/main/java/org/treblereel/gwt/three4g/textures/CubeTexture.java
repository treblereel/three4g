package org.treblereel.gwt.three4g.textures;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.CubeTexture", namespace = JsPackage.GLOBAL)
public class CubeTexture extends Texture {
  public boolean flipY;
  public double images;
  public boolean isCubeTexture;

  public CubeTexture() {}

  public CubeTexture(
      JsArray<JsObject> images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy,
      double encoding) {}

  public CubeTexture(
      JsArray<JsObject> images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CubeTexture(
      JsArray<JsObject> images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CubeTexture(
      JsArray<JsObject> images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CubeTexture(
      JsArray<JsObject> images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CubeTexture(
      JsArray<JsObject> images, double mapping, double wrapS, double wrapT, double magFilter) {}

  public CubeTexture(JsArray<JsObject> images, double mapping, double wrapS, double wrapT) {}

  public CubeTexture(JsArray<JsObject> images, double mapping, double wrapS) {}

  public CubeTexture(JsArray<JsObject> images, double mapping) {}

  public CubeTexture(JsArray<JsObject> images) {}

  public CubeTexture(
      JsObject[] images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy,
      double encoding) {}

  public CubeTexture(
      JsObject[] images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CubeTexture(
      JsObject[] images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CubeTexture(
      JsObject[] images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CubeTexture(
      JsObject[] images,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CubeTexture(
      JsObject[] images, double mapping, double wrapS, double wrapT, double magFilter) {}

  public CubeTexture(JsObject[] images, double mapping, double wrapS, double wrapT) {}

  public CubeTexture(JsObject[] images, double mapping, double wrapS) {}

  public CubeTexture(JsObject[] images, double mapping) {}

  public CubeTexture(JsObject[] images) {}
}
