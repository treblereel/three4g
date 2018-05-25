package org.treblereel.gwt.three4g.examples.loaders;

import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ColladaLoader {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is undefined.
     */
    public String crossOrigin;

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .dae file.
     * @param onLoad — A function to be called after the loading is successfully completed. The function receives the loaded JSON response returned from parse.
     */
    public native void load(String url, OnLoadCallback<JavaScriptObject> onLoad);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .dae file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded JSON response returned from parse.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     */
    public native void load(String url, OnLoadCallback<JavaScriptObject> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call the callback function with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .dae file.
     * @param onLoad     — A function to be called after the loading is successfully completed. The function receives the loaded JSON response returned from parse.
     * @param onProgress — A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, that contains .total and .loaded bytes.
     * @param onError    — A function to be called if an error occurs during loading. The function receives error as an argument.
     */
    public native void load(String url, OnLoadCallback<JavaScriptObject> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * Set the .crossOrigin attribute.
     *
     * @param origin crossOrigin attribute
     */
    public native void setCrossOrigin(String origin);
}
