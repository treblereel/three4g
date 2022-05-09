package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsError;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.textures.Texture;
import org.treblereel.gwt.three4g.materials.Material;

@JsType(isNative = true, name = "THREE.MaterialLoader", namespace = JsPackage.GLOBAL)
public class MaterialLoader extends Loader {
  @JsFunction
  public interface LoadAsyncOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  @JsFunction
  public interface LoadOnErrorFn {
    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface P0UnionType {
      @JsOverlay
      static MaterialLoader.LoadOnErrorFn.P0UnionType of(Object o) {
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
      onInvoke(Js.<MaterialLoader.LoadOnErrorFn.P0UnionType>uncheckedCast(p0));
    }

    @JsOverlay
    default void onInvoke(JsError p0) {
      onInvoke(Js.<MaterialLoader.LoadOnErrorFn.P0UnionType>uncheckedCast(p0));
    }

    void onInvoke(MaterialLoader.LoadOnErrorFn.P0UnionType p0);
  }

  @JsFunction
  public interface LoadOnLoadFn {
    void onInvoke(Material p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public JsPropertyMap<Texture> textures;

  public MaterialLoader() {}

  public MaterialLoader(LoadingManager manager) {}

  public native void load(
      String url,
      MaterialLoader.LoadOnLoadFn onLoad,
      MaterialLoader.LoadOnProgressFn onProgress,
      MaterialLoader.LoadOnErrorFn onError);

  public native void load(
      String url, MaterialLoader.LoadOnLoadFn onLoad, MaterialLoader.LoadOnProgressFn onProgress);

  public native void load(String url, MaterialLoader.LoadOnLoadFn onLoad);

  public native Promise<Material> loadAsync(
      String url, MaterialLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<Material> loadAsync(String url);

  public native Material parse(double json);

  public native MaterialLoader setTextures(JsPropertyMap<Texture> textures);
}
