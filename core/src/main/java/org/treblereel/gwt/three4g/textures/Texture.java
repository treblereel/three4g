package org.treblereel.gwt.three4g.textures;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLVideoElement;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.events.EventDispatcher;
import org.treblereel.gwt.three4g.math.Matrix3;
import org.treblereel.gwt.three4g.math.Vector2;

@JsType(isNative = true, name = "THREE.Texture", namespace = JsPackage.GLOBAL)
public class Texture extends EventDispatcher {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorImageUnionType {
    @JsOverlay
    static Texture.ConstructorImageUnionType of(Object o) {
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

  @JsFunction
  public interface OnUpdateFn {
    void onInvoke();
  }

  public static double DEFAULT_IMAGE;
  public static double DEFAULT_MAPPING;
  public double anisotropy;
  public Vector2 center;
  public double encoding;
  public boolean flipY;
  public double format;
  public boolean generateMipmaps;
  public double id;
  public HTMLCanvasElement image;
  public String internalFormat;
  public boolean isRenderTargetTexture;
  public boolean isTexture;
  public double magFilter;
  public double mapping;
  public Matrix3 matrix;
  public boolean matrixAutoUpdate;
  public double minFilter;
  public JsArray<JsObject> mipmaps;
  public String name;
  public boolean needsUpdate;
  public Vector2 offset;
  public Texture.OnUpdateFn onUpdate;
  public boolean premultiplyAlpha;
  public Vector2 repeat;
  public double rotation;
  public String sourceFile;
  public double type;
  public double unpackAlignment;
  public double userData;
  public String uuid;
  public double version;
  public double wrapS;
  public double wrapT;

  public Texture() {}

  public Texture(
      Texture.ConstructorImageUnionType image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy,
      double encoding) {}

  public Texture(
      Texture.ConstructorImageUnionType image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public Texture(
      Texture.ConstructorImageUnionType image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public Texture(
      Texture.ConstructorImageUnionType image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public Texture(
      Texture.ConstructorImageUnionType image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public Texture(
      Texture.ConstructorImageUnionType image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter) {}

  public Texture(
      Texture.ConstructorImageUnionType image, double mapping, double wrapS, double wrapT) {}

  public Texture(Texture.ConstructorImageUnionType image, double mapping, double wrapS) {}

  public Texture(Texture.ConstructorImageUnionType image, double mapping) {}

  public Texture(Texture.ConstructorImageUnionType image) {}

  public Texture(
      HTMLCanvasElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy,
      double encoding) {}

  public Texture(
      HTMLCanvasElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public Texture(
      HTMLCanvasElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public Texture(
      HTMLCanvasElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public Texture(
      HTMLCanvasElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public Texture(
      HTMLCanvasElement image, double mapping, double wrapS, double wrapT, double magFilter) {}

  public Texture(HTMLCanvasElement image, double mapping, double wrapS, double wrapT) {}

  public Texture(HTMLCanvasElement image, double mapping, double wrapS) {}

  public Texture(HTMLCanvasElement image, double mapping) {}

  public Texture(HTMLCanvasElement image) {}

  public Texture(
      HTMLImageElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy,
      double encoding) {}

  public Texture(
      HTMLImageElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public Texture(
      HTMLImageElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public Texture(
      HTMLImageElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public Texture(
      HTMLImageElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public Texture(
      HTMLImageElement image, double mapping, double wrapS, double wrapT, double magFilter) {}

  public Texture(HTMLImageElement image, double mapping, double wrapS, double wrapT) {}

  public Texture(HTMLImageElement image, double mapping, double wrapS) {}

  public Texture(HTMLImageElement image, double mapping) {}

  public Texture(HTMLImageElement image) {}

  public Texture(
      HTMLVideoElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy,
      double encoding) {}

  public Texture(
      HTMLVideoElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type,
      double anisotropy) {}

  public Texture(
      HTMLVideoElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format,
      double type) {}

  public Texture(
      HTMLVideoElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter,
      double format) {}

  public Texture(
      HTMLVideoElement image,
      double mapping,
      double wrapS,
      double wrapT,
      double magFilter,
      double minFilter) {}

  public Texture(
      HTMLVideoElement image, double mapping, double wrapS, double wrapT, double magFilter) {}

  public Texture(HTMLVideoElement image, double mapping, double wrapS, double wrapT) {}

  public Texture(HTMLVideoElement image, double mapping, double wrapS) {}

  public Texture(HTMLVideoElement image, double mapping) {}

  public Texture(HTMLVideoElement image) {}

  @JsMethod(name = "clone")
  public native Texture clone_();

  public native Texture copy(Texture source);

  public native void dispose();

  public native Object toJSON();

  public native Object toJSON(String key);

  public native Vector2 transformUv(Vector2 uv);

  public native void updateMatrix();
}
