package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
@JsType(isNative = true)
public abstract class AbstractLoader<T, V> {

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url — A string containing the path/URL of the file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url    — A string containing the path/URL of the file.
     * @param onLoad —  A function to be called after loading is successfully completed. The function receives the loaded SVGDocument as an argument.
     */
    public native void load(String url, OnLoadCallback<V> onLoad);

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url        — A string containing the path/URL of the file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the loaded SVGDocument as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url        — A string containing the path/URL of the file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the loaded SVGDocument as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback<V> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the crossOrigin attribute.
     *
     * @param origin crossOrigin attribute
     * @return instance of T
     */
    public native T setCrossOrigin(String origin);

    /**
     * Set the base path for additional resources.
     *
     * @param path — Base path for loading additional resources e.g. textures and .bin data.
     * @return instance of T
     */
    public native T setPath(String path);

    /**
     * Set base path for additional resources like textures. If set, this path will be used as the base path.
     *
     * @param path — required
     * @return instance of T
     */
    public native T setResourcePath(String path);
}
