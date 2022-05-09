package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.Loader", namespace = JsPackage.GLOBAL)
public class Loader {
  @JsFunction
  public interface LoadAsyncOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public String crossOrigin;
  public LoadingManager manager;
  public String path;
  public JsPropertyMap<String> requestHeader;
  public String resourcePath;
  public boolean withCredentials;

  public Loader() {}

  public Loader(LoadingManager manager) {}

  public native Promise loadAsync(String url, Loader.LoadAsyncOnProgressFn onProgress);

  public native Promise loadAsync(String url);

  public native Loader setCrossOrigin(String crossOrigin);

  public native Loader setPath(String path);

  public native Loader setRequestHeader(JsPropertyMap<String> requestHeader);

  public native Loader setResourcePath(String resourcePath);

  public native Loader setWithCredentials(boolean value);
}
