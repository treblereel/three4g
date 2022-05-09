package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsArray;
import elemental2.core.JsError;
import elemental2.core.JsObject;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;

@JsType(isNative = true, name = "THREE.ObjectLoader", namespace = JsPackage.GLOBAL)
public class ObjectLoader extends Loader {
  @JsFunction
  public interface LoadOnErrorFn {
    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface P0UnionType {
      @JsOverlay
      static ObjectLoader.LoadOnErrorFn.P0UnionType of(Object o) {
        return Js.cast(o);
      }

      @JsOverlay
      default ErrorEvent asErrorEvent() {
        return Js.cast(this);
      }

      @JsOverlay
      default JsError asJsError() {
        return Js.cast(this);
      }

      @JsOverlay
      default boolean isErrorEvent() {
        return (Object) this instanceof ErrorEvent;
      }

      @JsOverlay
      default boolean isJsError() {
        return (Object) this instanceof JsError;
      }
    }

    @JsOverlay
    default void onInvoke(ErrorEvent p0) {
      onInvoke(Js.<ObjectLoader.LoadOnErrorFn.P0UnionType>uncheckedCast(p0));
    }

    @JsOverlay
    default void onInvoke(JsError p0) {
      onInvoke(Js.<ObjectLoader.LoadOnErrorFn.P0UnionType>uncheckedCast(p0));
    }

    void onInvoke(ObjectLoader.LoadOnErrorFn.P0UnionType p0);
  }

  @JsFunction
  public interface LoadOnLoadFn {
    void onInvoke(JsObject p0);

    @JsOverlay
    default void onInvoke(Object p0) {
      onInvoke(Js.<JsObject>uncheckedCast(p0));
    }
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  @JsFunction
  public interface ParseImagesOnLoadFn {
    void onInvoke();
  }

  @JsFunction
  public interface ParseOnLoadFn {
    void onInvoke(Object3D p0);
  }

  public ObjectLoader() {}

  public ObjectLoader(LoadingManager manager) {}

  public native void load(
      String url,
      ObjectLoader.LoadOnLoadFn onLoad,
      ObjectLoader.LoadOnProgressFn onProgress,
      ObjectLoader.LoadOnErrorFn onError);

  public native void load(
      String url, ObjectLoader.LoadOnLoadFn onLoad, ObjectLoader.LoadOnProgressFn onProgress);

  public native void load(String url, ObjectLoader.LoadOnLoadFn onLoad);

  public native void load(String url);

  public native <T> T parse(double json, ObjectLoader.ParseOnLoadFn onLoad);

  public native <T> T parse(double json);

  public native JsArray<AnimationClip> parseAnimations(double json);

  public native <T> Promise<T> parseAsync(double json);

  public native JsPropertyMap<BufferGeometry> parseGeometries(double json);

  public native JsPropertyMap<HTMLImageElement> parseImages(
      double json, ObjectLoader.ParseImagesOnLoadFn onLoad);

  public native Promise<JsPropertyMap<HTMLImageElement>> parseImagesAsync(double json);

  public native JsArray<Material> parseMaterials(double json, JsArray<Texture> textures);

  @JsOverlay
  public final JsArray<Material> parseMaterials(double json, Texture[] textures) {
    return parseMaterials(json, Js.<JsArray<Texture>>uncheckedCast(textures));
  }

  public native <T> T parseObject(
      double data,
      JsArray<JsObject> geometries,
      JsArray<Material> materials,
      JsArray<AnimationClip> animations);

  @JsOverlay
  public final <T> T parseObject(
      double data, JsObject[] geometries, Material[] materials, AnimationClip[] animations) {
    return parseObject(
        data,
        Js.<JsArray<JsObject>>uncheckedCast(geometries),
        Js.<JsArray<Material>>uncheckedCast(materials),
        Js.<JsArray<AnimationClip>>uncheckedCast(animations));
  }

  public native JsArray<Texture> parseTextures(double json, double images);
}
