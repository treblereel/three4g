package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.ImageLoader", namespace = JsPackage.GLOBAL)
public class ImageLoader extends Loader {
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
    void onInvoke(HTMLImageElement p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public ImageLoader() {}

  public ImageLoader(LoadingManager manager) {}

  public native HTMLImageElement load(
      String url,
      ImageLoader.LoadOnLoadFn onLoad,
      ImageLoader.LoadOnProgressFn onProgress,
      ImageLoader.LoadOnErrorFn onError);

  public native HTMLImageElement load(
      String url, ImageLoader.LoadOnLoadFn onLoad, ImageLoader.LoadOnProgressFn onProgress);

  public native HTMLImageElement load(String url, ImageLoader.LoadOnLoadFn onLoad);

  public native HTMLImageElement load(String url);

  public native Promise<HTMLImageElement> loadAsync(
      String url, ImageLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<HTMLImageElement> loadAsync(String url);
}
