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
public class ObjectLoader extends Loader<ObjectLoader, Object3D> {
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
  public interface ParseImagesOnLoadFn {
    void onInvoke();
  }

  @JsFunction
  public interface ParseOnLoadFn {
    void onInvoke(Object3D p0);
  }

  public ObjectLoader() {}

  public ObjectLoader(LoadingManager manager) {}

  public native <T> T parse(Object json, ObjectLoader.ParseOnLoadFn onLoad);

  public native <T> T parse(Object json);

  public native JsArray<AnimationClip> parseAnimations(Object json);

  public native <T> Promise<T> parseAsync(Object json);

  public native JsPropertyMap<BufferGeometry> parseGeometries(Object json);

  public native JsPropertyMap<HTMLImageElement> parseImages(
      double json, ObjectLoader.ParseImagesOnLoadFn onLoad);

  public native Promise<JsPropertyMap<HTMLImageElement>> parseImagesAsync(Object json);

  public native JsArray<Material> parseMaterials(Object json, JsArray<Texture> textures);

  @JsOverlay
  public final JsArray<Material> parseMaterials(Object json, Texture[] textures) {
    return parseMaterials(json, Js.<JsArray<Texture>>uncheckedCast(textures));
  }

  public native <T> T parseObject(
          Object data,
      JsArray<JsObject> geometries,
      JsArray<Material> materials,
      JsArray<AnimationClip> animations);

  @JsOverlay
  public final <T> T parseObject(
          Object data, Object3D[] geometries, Material[] materials, AnimationClip[] animations) {
    return parseObject(
        data,
        Js.uncheckedCast(geometries),
        Js.uncheckedCast(materials),
        Js.<JsArray<AnimationClip>>uncheckedCast(animations));
  }

  public native JsArray<Texture> parseTextures(Object json, double images);
}
