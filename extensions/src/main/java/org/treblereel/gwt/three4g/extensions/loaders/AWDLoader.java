package org.treblereel.gwt.three4g.extensions.loaders;

import elemental2.core.JsObject;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/18/19
 */
@Three4gElement(paths = {"js/loaders/AWDLoader.js"})
@JsType(isNative = true, namespace = "THREE")
public class AWDLoader {

  public AWDLoader() {}

  public AWDLoader(LoadingManager manager) {}

  /**
   * @param url — A string containing the path/URL of the .awd file.
   * @param onLoad — A function to be called after loading is successfully completed. The function
   *     receives loaded DataTexture as an argument.
   */
  public native void load(String url, OnLoadCallback<Object3D> onLoad);

  /**
   * @param url — A string containing the path/URL of the .awd file.
   * @param onLoad — A function to be called after loading is successfully completed. The function
   *     receives loaded DataTexture as an argument.
   * @param onProgress — A function to be called while the loading is in progress. The argument will
   *     be the XMLHttpRequest instance, which contains .total and .loaded bytes.
   */
  public native void load(
      String url, OnLoadCallback<Object3D> onLoad, OnProgressCallback onProgress);

  /**
   * @param url — A string containing the path/URL of the .awd file.
   * @param onLoad — A function to be called after loading is successfully completed. The function
   *     receives loaded DataTexture as an argument.
   * @param onProgress — A function to be called while the loading is in progress. The argument will
   *     be the XMLHttpRequest instance, which contains .total and .loaded bytes.
   * @param onError — A function to be called if an error occurs during loading. The function
   *     receives the error as an argument.
   */
  public native void load(
      String url,
      OnLoadCallback<Object3D> onLoad,
      OnProgressCallback onProgress,
      OnErrorCallback onError);

  /**
   * @param text — JsObject to parse.
   * @return instance of Object3D
   */
  public native Object3D parse(JsObject text);

  /**
   * Set the base path or URL from which to load files. This can be useful if you are loading many
   * models from the same directory.
   *
   * @param path base path or URL
   * @return instance of AWDLoader
   */
  public native AWDLoader setPath(String path);

}
