package org.treblereel.gwt.three4g.loaders;

import com.google.gwt.json.client.JSONObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * Class for loading AnimationClips in JSON format. This uses the FileLoader internally for loading files.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AnimationLoader {

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    @JsConstructor
    public AnimationLoader() {

    }

    @JsConstructor
    public AnimationLoader(LoadingManager manager) {

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
    public native void load(String url, OnLoadCallback<AnimationClip> onLoad);

    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     */
    public native void load(String url, OnLoadCallback<AnimationClip> onLoad, OnProgressCallback onProgress);


    /**
     * Load the URL and pass the response to the onLoad function.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when loading completes. The argument will be the loaded response.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest
     * @param onError    — Will be called if an error occurs.
     */
    public native void load(String url, OnLoadCallback<AnimationClip> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);


    /**
     * Parse the JSON object and pass the result to onLoad. Individual clips in the object will be parsed with AnimationClip.parse.
     *
     * @param json   — required
     * @param onLoad — Will be called when parsing completes.
     */
    public native void parse(JSONObject json, OnLoadCallback<AnimationClip> onLoad); //TODO checkit

    /**
     * Sets the base path or URL from which to load files. This can be useful if
     * 			you are loading many animations from the same directory.
     *
     * @param path — Base path of the file to load.
     * @return instance of AnimationLoader
     */
    public native AnimationLoader setPath(String path);
}
