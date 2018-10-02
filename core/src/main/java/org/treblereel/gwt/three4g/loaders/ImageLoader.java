package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.Image;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading an Image. This uses the FileLoader internally for loading files, and is used internally by the
 * CubeTextureLoader, ObjectLoader and TextureLoader.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ImageLoader {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is anonymous.
     */
    public String crossOrigin;

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     */
    public String path;

    @JsConstructor
    public ImageLoader(){

    }

    @JsConstructor
    public ImageLoader(LoadingManager manager){

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
    public native void load(String url, OnLoadCallback<Image> onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<Image> onLoad, OnProgressCallback onProgress);


    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<Image> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the .crossOrigin attribute.
     * @param origin crossOrigin attribute.
     */
    public native void setCrossOrigin(String origin);

    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many textures from the same directory.
     * @param path base path or URL
     * @return instance of FileLoader
     */
    public native FileLoader setPath(String path);

}
