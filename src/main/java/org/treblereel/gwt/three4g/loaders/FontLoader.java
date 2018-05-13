package org.treblereel.gwt.three4g.loaders;

import com.google.gwt.json.client.JSONObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Font;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Class for loading a font in JSON format. Returns a Font, which is an array of Shapes representing the font. This uses the FileLoader internally for loading files.
 * <p>
 * You can convert fonts online using facetype.js
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class FontLoader {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The base path from which files will be loaded. See .setPath. Default is undefined.
     */
    public String path;


    @JsConstructor
    public FontLoader(){

    }

    @JsConstructor
    public FontLoader(LoadingManager manager){

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
    public native void load(String url, OnLoadCallback<Font> onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<Font> onLoad, OnProgressCallback onProgress);


    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<Font> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);


    public native Font parse (JSONObject json);
}
