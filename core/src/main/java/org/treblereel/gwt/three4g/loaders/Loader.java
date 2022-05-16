package org.treblereel.gwt.three4g.loaders;

import elemental2.promise.Promise;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.Loader", namespace = JsPackage.GLOBAL)
public class Loader<L, V> {

  public String crossOrigin;
  public LoadingManager manager;
  public String path;
  public JsPropertyMap<String> requestHeader;
  public String resourcePath;
  public boolean withCredentials;

  public Loader() {}

  public Loader(LoadingManager manager) {}


  public native V load(
          String url);

  public native V load(
          String url, OnLoadCallback<V> onLoad);

  public native V load(
          String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress);

  public native V load(
          String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

  public native Promise loadAsync(String url, OnProgressCallback onProgress);

  public native Promise loadAsync(String url);

  public native Loader setCrossOrigin(String crossOrigin);

  public native Loader setPath(String path);

  public native Loader setRequestHeader(JsPropertyMap<String> requestHeader);

  public native Loader setResourcePath(String resourcePath);

  public native Loader setWithCredentials(boolean value);
}
