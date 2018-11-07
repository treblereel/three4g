package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a BufferGeometry. This uses the FileLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BufferGeometryLoader {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    @JsConstructor
    public BufferGeometryLoader() {

    }

    @JsConstructor
    public BufferGeometryLoader(LoadingManager manager) {

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
    public native void load(String url, OnLoadCallback<? extends BufferGeometry> onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<? extends BufferGeometry> onLoad, OnProgressCallback onProgress);


    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<? extends BufferGeometry> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Parse a JSON structure and return a BufferGeometry.
     *
     * @param json — The JSON structure to parse.
     * @return instance of BufferGeometry
     */
    public native BufferGeometry parse(String json);

    /**
     * Sets the base path or URL from which to load files. This can be useful if
     * 			you are loading many geometries from the same directory.
     *
     * @param path — Base path of the file to load.
     * @return instance of BufferGeometryLoader
     */
    public native BufferGeometryLoader setPath(String path);
}
