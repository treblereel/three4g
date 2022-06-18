package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsArray;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.textures.CubeTexture;

@JsType(isNative = true, name = "THREE.CubeTextureLoader", namespace = JsPackage.GLOBAL)
public class CubeTextureLoader extends Loader<CubeTextureLoader, CubeTexture> {
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
    void onInvoke(CubeTexture p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public CubeTextureLoader() {}

  public CubeTextureLoader(LoadingManager manager) {}

  public native CubeTexture load(
      JsArray<String> urls,
      CubeTextureLoader.LoadOnLoadFn onLoad,
      CubeTextureLoader.LoadOnProgressFn onProgress,
      CubeTextureLoader.LoadOnErrorFn onError);

  public native CubeTexture load(
      JsArray<String> urls,
      CubeTextureLoader.LoadOnLoadFn onLoad,
      CubeTextureLoader.LoadOnProgressFn onProgress);

  public native CubeTexture load(JsArray<String> urls, CubeTextureLoader.LoadOnLoadFn onLoad);

  public native CubeTexture load(JsArray<String> urls);

  @JsOverlay
  public final CubeTexture load(
      String[] urls,
      CubeTextureLoader.LoadOnLoadFn onLoad,
      CubeTextureLoader.LoadOnProgressFn onProgress,
      CubeTextureLoader.LoadOnErrorFn onError) {
    return load(Js.<JsArray<String>>uncheckedCast(urls), onLoad, onProgress, onError);
  }

  @JsOverlay
  public final CubeTexture load(
      String[] urls,
      CubeTextureLoader.LoadOnLoadFn onLoad,
      CubeTextureLoader.LoadOnProgressFn onProgress) {
    return load(Js.<JsArray<String>>uncheckedCast(urls), onLoad, onProgress);
  }

  @JsOverlay
  public final CubeTexture load(String[] urls, CubeTextureLoader.LoadOnLoadFn onLoad) {
    return load(Js.<JsArray<String>>uncheckedCast(urls), onLoad);
  }

  @JsOverlay
  public final CubeTexture load(String[] urls) {
    return load(Js.<JsArray<String>>uncheckedCast(urls));
  }

  public native Promise<CubeTexture> loadAsync(
      String url, CubeTextureLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<CubeTexture> loadAsync(String url);
}
