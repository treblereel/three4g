package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsObject;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.textures.DataTexture;

@JsType(isNative = true, name = "THREE.DataTextureLoader", namespace = JsPackage.GLOBAL)
public class DataTextureLoader extends Loader {
  @JsFunction
  public interface LoadAsyncOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  @JsFunction
  public interface LoadOnErrorFn {
    void onInvoke(ErrorEvent p0);
  }

  @JsFunction
  public interface LoadOnLoadFn {
    void onInvoke(DataTexture p0, JsObject p1);

    @JsOverlay
    default void onInvoke(DataTexture p0, Object p1) {
      onInvoke(p0, Js.<JsObject>uncheckedCast(p1));
    }
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public DataTextureLoader() {}

  public DataTextureLoader(LoadingManager manager) {}

  public native DataTexture load(
      String url,
      DataTextureLoader.LoadOnLoadFn onLoad,
      DataTextureLoader.LoadOnProgressFn onProgress,
      DataTextureLoader.LoadOnErrorFn onError);

  public native DataTexture load(
      String url,
      DataTextureLoader.LoadOnLoadFn onLoad,
      DataTextureLoader.LoadOnProgressFn onProgress);

  public native DataTexture load(String url, DataTextureLoader.LoadOnLoadFn onLoad);

  public native Promise<DataTexture> loadAsync(
      String url, DataTextureLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<DataTexture> loadAsync(String url);
}
