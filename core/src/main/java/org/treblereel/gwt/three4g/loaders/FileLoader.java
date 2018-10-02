package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A low level class for loading resources with XMLHttpRequest, used internaly by most loaders. It can also be used directly
 * to load any file type that does not have a loader.
 * <p>
 * Note: The cache must be enabled using
 * Cache.enabled = true; This is a global property and only needs to be set once to be used by all loaders that use
 * FileLoader internally. Cache is a cache module that holds the response from each request made through this loader,
 * so each file is requested once.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class FileLoader {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The expected mimeType. See .setMimeType. Default is undefined.
     */
    public String mimeType;

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     */
    public String path;

    /**
     * The request header used in HTTP request. See .setRequestHeader. Default is undefined.
     */
    public Object requestHeader;

    /**
     * The expected response type. See .setResponseType. Default is undefined.
     */
    public String responseType;

    /**
     * Whether the XMLHttpRequest uses credentials. See .setWithCredentials. Default is undefined.
     */
    public String withCredentials;

    @JsConstructor
    public FileLoader() {

    }

    @JsConstructor
    public FileLoader(LoadingManager loadingManager) {

    }

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url — the path or URL to the file. This can also be a Data URI.
     */
    public native void load(String url);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url    — the path or URL to the file. This can also be a Data URI.
     * @param onLoad — Will be called when loading completes. The argument will be the loaded response.
     */
    public native void load(String url, OnLoadCallback<Object> onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<Object> onLoad, OnProgressCallback onProgress);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<Object> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the expected mimeType of the file being loaded. Note that in many cases this will be determined automatically, so by default it is undefined.
     *
     * @param mimeType as String value
     * @return instance of FileLoader
     */
    public native FileLoader setMimeType(String mimeType);

    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many models from the same directory.
     *
     * @param path base path or URL
     * @return instance of FileLoader
     */
    public native FileLoader setPath(String path);

    /**
     * Set the request header used in HTTP request.
     *
     * @param requestHeader - key: The name of the header whose value is to be set. value: The value to set as the body of the header.
     * @return instance of FileLoader
     */
    public native FileLoader setRequestHeader(Object requestHeader);

    /**
     * Change the response type. Valid values are:
     * text or empty string (default) - returns the data as string.
     * arraybuffer - loads the data into a ArrayBuffer and returns that.
     * blob - returns the data as a Blob.
     * document - parses the file using the DOMParser.
     * json - parses the file using JSON.parse.
     *
     * @param responseType type of type
     * @return instance of FileLoader
     */
    public native FileLoader setResponseType(String responseType);

    /**
     * Whether the XMLHttpRequest uses credentials such as cookies, authorization headers or TLS client certificates. See XMLHttpRequest.withCredentials.
     * Note that this has no effect if you are loading files locally or from the same domain.
     *
     * @param value if true, use credentials
     * @return instance of FileLoader
     */
    public native FileLoader setWithCredentials(boolean value);


}
