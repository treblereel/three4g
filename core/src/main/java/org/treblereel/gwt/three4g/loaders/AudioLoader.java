package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.AudioLoader", namespace = JsPackage.GLOBAL)
public class AudioLoader extends Loader {
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
    void onInvoke(Object p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public AudioLoader() {}

  public AudioLoader(LoadingManager manager) {}

  public native void load(
      String url,
      AudioLoader.LoadOnLoadFn onLoad,
      AudioLoader.LoadOnProgressFn onProgress,
      AudioLoader.LoadOnErrorFn onError);

  public native void load(
      String url, AudioLoader.LoadOnLoadFn onLoad, AudioLoader.LoadOnProgressFn onProgress);

  public native void load(String url, AudioLoader.LoadOnLoadFn onLoad);

  public native Promise<Object> loadAsync(String url, AudioLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<Object> loadAsync(String url);
}
