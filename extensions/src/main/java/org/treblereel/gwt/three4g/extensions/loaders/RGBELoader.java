package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/7/18.
 */
@Three4gElement(paths = "js/loaders/RGBELoader.js")
@JsType(isNative = true, namespace = "THREE")
public class RGBELoader {

    public RGBELoader(){

    }

    public RGBELoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url — A string containing the path/URL of the .rgbe file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url    — A string containing the path/URL of the .rgbe file.
     * @param onLoad —  A function to be called after loading is successfully completed. The function receives the object having the following properties. geometryAtoms, geometryBonds and the JSON structure.
     */
    public native void load(String url, OnLoadCallback onLoad);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .rgbe file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the object having the following properties. geometryAtoms, geometryBonds and the JSON structure.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — A string containing the path/URL of the .rgbe file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the object having the following properties. geometryAtoms, geometryBonds and the JSON structure.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback onLoad, OnProgressCallback onProgress, OnErrorCallback onError);


}
