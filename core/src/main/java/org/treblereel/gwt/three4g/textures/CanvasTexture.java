package org.treblereel.gwt.three4g.textures;

import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLVideoElement;
import elemental2.dom.ImageBitmap;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.CanvasTexture", namespace = JsPackage.GLOBAL)
public class CanvasTexture extends Texture {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorCanvasUnionType {
    @JsOverlay
    static CanvasTexture.ConstructorCanvasUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default HTMLCanvasElement asHTMLCanvasElement() {
      return Js.cast(this);
    }

    @JsOverlay
    default HTMLImageElement asHTMLImageElement() {
      return Js.cast(this);
    }

    @JsOverlay
    default HTMLVideoElement asHTMLVideoElement() {
      return Js.cast(this);
    }

    @JsOverlay
    default ImageBitmap asImageBitmap() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isHTMLCanvasElement() {
      return (Object) this instanceof HTMLCanvasElement;
    }

    @JsOverlay
    default boolean isHTMLImageElement() {
      return (Object) this instanceof HTMLImageElement;
    }

    @JsOverlay
    default boolean isHTMLVideoElement() {
      return (Object) this instanceof HTMLVideoElement;
    }
  }

  public boolean isCanvasTexture;

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas,
      double mapping,
      double wrapS,
      double wrapT) {}

  public CanvasTexture(
      CanvasTexture.ConstructorCanvasUnionType canvas, double mapping, double wrapS) {}

  public CanvasTexture(CanvasTexture.ConstructorCanvasUnionType canvas, double mapping) {}

  public CanvasTexture(CanvasTexture.ConstructorCanvasUnionType canvas) {}

  public CanvasTexture(
      HTMLCanvasElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CanvasTexture(
      HTMLCanvasElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CanvasTexture(
      HTMLCanvasElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CanvasTexture(
      HTMLCanvasElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CanvasTexture(
      HTMLCanvasElement canvas, double mapping, double wrapS, double wrapT, double magFilter) {}

  public CanvasTexture(HTMLCanvasElement canvas, double mapping, double wrapS, double wrapT) {}

  public CanvasTexture(HTMLCanvasElement canvas, double mapping, double wrapS) {}

  public CanvasTexture(HTMLCanvasElement canvas, double mapping) {}

  public CanvasTexture(HTMLCanvasElement canvas) {}

  public CanvasTexture(
      HTMLImageElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CanvasTexture(
      HTMLImageElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CanvasTexture(
      HTMLImageElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CanvasTexture(
      HTMLImageElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CanvasTexture(
      HTMLImageElement canvas, double mapping, double wrapS, double wrapT, double magFilter) {}

  public CanvasTexture(HTMLImageElement canvas, double mapping, double wrapS, double wrapT) {}

  public CanvasTexture(HTMLImageElement canvas, double mapping, double wrapS) {}

  public CanvasTexture(HTMLImageElement canvas, double mapping) {}

  public CanvasTexture(HTMLImageElement canvas) {}

  public CanvasTexture(
      HTMLVideoElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CanvasTexture(
      HTMLVideoElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CanvasTexture(
      HTMLVideoElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CanvasTexture(
      HTMLVideoElement canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CanvasTexture(
      HTMLVideoElement canvas, double mapping, double wrapS, double wrapT, double magFilter) {}

  public CanvasTexture(HTMLVideoElement canvas, double mapping, double wrapS, double wrapT) {}

  public CanvasTexture(HTMLVideoElement canvas, double mapping, double wrapS) {}

  public CanvasTexture(HTMLVideoElement canvas, double mapping) {}

  public CanvasTexture(HTMLVideoElement canvas) {}

  public CanvasTexture(
      ImageBitmap canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public CanvasTexture(
      ImageBitmap canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public CanvasTexture(
      ImageBitmap canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public CanvasTexture(
      ImageBitmap canvas,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public CanvasTexture(
      ImageBitmap canvas, double mapping, double wrapS, double wrapT, double magFilter) {}

  public CanvasTexture(ImageBitmap canvas, double mapping, double wrapS, double wrapT) {}

  public CanvasTexture(ImageBitmap canvas, double mapping, double wrapS) {}

  public CanvasTexture(ImageBitmap canvas, double mapping) {}

  public CanvasTexture(ImageBitmap canvas) {}
}
