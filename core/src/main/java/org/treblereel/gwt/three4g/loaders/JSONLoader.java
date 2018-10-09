package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading objects in JSON format. This uses the FileLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class JSONLoader extends AbstractLoader<JSONLoader, PropertyHolder> {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is "anonymous".
     */
    public String crossOrigin;

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * Whether the XMLHttpRequest uses credentials. See .setWithCredentials. Default is undefined.
     */
    public String withCredentials;

    @JsConstructor
    public JSONLoader() {

    }

    @JsConstructor
    public JSONLoader(LoadingManager manager) {

    }

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url    — the path or URL to the file. This can also be a Data URI.
     * @param onLoad — Will be called when loading completes. The argument will be the loaded response.
     */
    public native void load(String url, OnLoadCallback onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url    — the path or URL to the file. This can also be a Data URI.
     * @param onLoad — Will be called when loading completes. The argument will be the loaded response.
     */
    public native void load(String url, OnLoadCallbackPair onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback onLoad, OnProgressCallback onProgress);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallbackPair onLoad, OnProgressCallback onProgress);


    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallbackPair onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the crossOrigin attribute.
     *
     * @param value crossOrigin
     * @return instance of JSONLoader
     */
    public native JSONLoader setCrossOrigin(String value);


    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many files from the same directory.
     *
     * @param texturePath base path or URL
     * @return instance of JSONLoader
     */
    public native JSONLoader setTexturePath(String texturePath);

    /**
     * Parse a JSON structure and return an object containing the parsed geometry and materials.
     *
     * @param json        — JSON object to parse.
     * @param texturePath — Base path for textures.
     * @return instance of Object3D
     */
    public native Object3D parse(String json, String texturePath);

    /**
     * Set the base path for the original file.
     *
     * @param path base path or URL
     * @return instance of FileLoader
     */
    public native JSONLoader setPath(String path);

    /**
     * Set the base path for dependent resources like textures.
     *
     * @param path the base
     * @return instance of FileLoader
     */
    public native JSONLoader setResourcePath(String path);
}
