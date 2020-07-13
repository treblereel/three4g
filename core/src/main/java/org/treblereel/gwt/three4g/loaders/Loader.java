package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/** @author Dmitrii Tikhomirov Created by treblereel on 10/9/18. */
@JsType(isNative = true, namespace = "THREE")
public abstract class Loader<L, V> {

  /**
   * The crossOrigin string to implement CORS for loading the url from a different domain that allows CORS. Default is anonymous.
   */
  public String crossOrigin ;

  /**
   * The loadingManager the loader is using. Default is DefaultLoadingManager.
   */
  public LoadingManager manager;

  /**
   * The base path from which the asset will be loaded. Default is the empty string.
   */
  public String path;

  /**
   * The request header used in HTTP request. See .setRequestHeader. Default is empty object.
   */
  public Object requestHeader;

  /**
   * The base path from which additional resources like textures will be loaded. Default is the empty string.
   */
  public String resourcePath;


  public Loader() {

  }

  public Loader(LoadingManager manager) {

  }

  /**
   * Begin loading from url and call onLoad with the response content.
   *
   * @param url — A string containing the path/URL of the file.
   */
  public native V load(String url);

  /**
   * Begin loading from url and call onLoad with the response content.
   *
   * @param url — A string containing the path/URL of the file.
   * @param onLoad — A function to be called after loading is successfully completed. The function
   *     receives the loaded SVGDocument as an argument.
   */
  public native V load(String url, OnLoadCallback<V> onLoad);

  /**
   * Begin loading from url and call onLoad with the response content.
   *
   * @param url — A string containing the path/URL of the file.
   * @param onLoad — A function to be called after loading is successfully completed. The function
   *     receives the loaded SVGDocument as an argument.
   * @param onProgress — A function to be called while the loading is in progress. The argument will
   *     be the XMLHttpRequest instance, which contains total and loaded bytes.
   */
  public native V load(String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress);

  /**
   * Begin loading from url and call onLoad with the response content.
   *
   * @param url — A string containing the path/URL of the file.
   * @param onLoad — A function to be called after loading is successfully completed. The function
   *     receives the loaded SVGDocument as an argument.
   * @param onProgress — A function to be called while the loading is in progress. The argument will
   *     be the XMLHttpRequest instance, which contains total and loaded bytes.
   * @param onError — A function to be called if an error occurs during loading. The function
   *     receives the error as an argument.
   */
  public native V load(
      String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

  /**
   * Set the crossOrigin attribute.
   *
   * @param origin crossOrigin attribute
   * @return instance of T
   */
  public native L setCrossOrigin(String origin);

  /**
   * Set the base path for additional resources.
   *
   * @param path — Base path for loading additional resources e.g. textures and .bin data.
   * @return instance of T
   */
  public native L setPath(String path);

  /**
   * Set base path for additional resources like textures. If set, this path will be used as the
   * base path.
   *
   * @param path — required
   * @return instance of T
   */
  public native L setResourcePath(String path);

  /**
   *
   * @param requestHeader - key: The name of the header whose value is to be set. value: The value to set as the body of the header.
   * @return instance of Loader
   */
  public native L setRequestHeader(Object requestHeader);
}
