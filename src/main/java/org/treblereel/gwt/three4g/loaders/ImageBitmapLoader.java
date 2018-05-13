package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.ImageBitmap;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading an Image as an ImageBitmap. An ImageBitmap provides an asynchronous and resource efficient pathway
 * to prepare textures for rendering in WebGL.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ImageBitmapLoader {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     */
    public String path;

    /**
     * An optional object that sets options for the internally used createImageBitmap factory method. Default is undefined.
     */
    public String options;

    @JsConstructor
    public ImageBitmapLoader() {

    }

    @JsConstructor
    public ImageBitmapLoader(LoadingManager manager) {

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
    public native void load(String url, OnLoadCallback<ImageBitmap> onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<ImageBitmap> onLoad, OnProgressCallback onProgress);


    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<ImageBitmap> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the .crossOrigin attribute.
     *
     * @param origin attribute
     * @return instance of ImageBitmapLoader
     */
    public native ImageBitmapLoader setCrossOrigin(String origin);

    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many textures from the same directory.
     * @param path base path or URL
     * @return instance of ImageBitmapLoader
     */
    public native ImageBitmapLoader setPath(String path);

    /**
     * Sets the options object for createImageBitmap.
     *
     * @param options object
     * @return instance of ImageBitmapLoader
     */
    public native ImageBitmapLoader setOptions(String options);


}
