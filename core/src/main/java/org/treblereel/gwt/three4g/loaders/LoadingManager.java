package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsRegExp;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.LoadingManager", namespace = JsPackage.GLOBAL)
public class LoadingManager {
  @JsFunction
  public interface LoadingManagerOnErrorFn {
    void onInvoke(String p0);
  }

  @JsFunction
  public interface LoadingManagerOnLoadFn {
    void onInvoke();
  }

  @JsFunction
  public interface LoadingManagerOnProgressFn {
    void onInvoke(String p0, double p1, double p2);
  }

  @JsFunction
  public interface OnErrorFn {
    void onInvoke(String p0);
  }

  @JsFunction
  public interface OnLoadFn {
    void onInvoke();
  }

  @JsFunction
  public interface OnProgressFn {
    void onInvoke(String p0, double p1, double p2);
  }

  @JsFunction
  public interface OnStartFn {
    void onInvoke(String p0, double p1, double p2);
  }

  @JsFunction
  public interface SetURLModifierCallbackFn {
    String onInvoke(String p0);
  }

  public static LoadingManager DefaultLoadingManager;
  public LoadingManager.OnErrorFn onError;
  public LoadingManager.OnLoadFn onLoad;
  public LoadingManager.OnProgressFn onProgress;
  public LoadingManager.OnStartFn onStart;

  public LoadingManager() {}

  public LoadingManager(
      LoadingManager.LoadingManagerOnLoadFn onLoad,
      LoadingManager.LoadingManagerOnProgressFn onProgress,
      LoadingManager.LoadingManagerOnErrorFn onError) {}

  public LoadingManager(
      LoadingManager.LoadingManagerOnLoadFn onLoad,
      LoadingManager.LoadingManagerOnProgressFn onProgress) {}

  public LoadingManager(LoadingManager.LoadingManagerOnLoadFn onLoad) {}

  public native LoadingManager addHandler(JsRegExp regex, Loader loader);

  public native Loader getHandler(String file);

  public native void itemEnd(String url);

  public native void itemError(String url);

  public native void itemStart(String url);

  public native LoadingManager removeHandler(JsRegExp regex);

  public native String resolveURL(String url);

  public native LoadingManager setURLModifier();

  public native LoadingManager setURLModifier(LoadingManager.SetURLModifierCallbackFn callback);
}
