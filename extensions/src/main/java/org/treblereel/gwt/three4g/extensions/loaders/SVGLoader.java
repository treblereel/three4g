package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.OnErrorCallback;
import org.treblereel.gwt.three4g.loaders.OnLoadCallback;
import org.treblereel.gwt.three4g.loaders.OnProgressCallback;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/**
 * A loader for loading a .svg resource.
 * Scalabe Vector Graphics is an XML-based vector image format for two-dimensional graphics with support for interactivity and animation.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@Three4gElement(paths = "js/loaders/SVGLoader.js")
@JsType(isNative = true, namespace = "THREE")
public class SVGLoader {

    public SVGLoader() {

    }

    public SVGLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url — A string containing the path/URL of the .svg file.
     */
    public native void load(String url);

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url    — A string containing the path/URL of the .svg file.
     * @param onLoad —  A function to be called after loading is successfully completed. The function receives the loaded SVGDocument as an argument.
     */
    public native void load(String url, OnLoadCallback<? extends PropertyHolder> onLoad);

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url        — A string containing the path/URL of the .svg file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the loaded SVGDocument as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     */
    public native void load(String url, OnLoadCallback<? extends PropertyHolder> onLoad, OnProgressCallback onProgress);

    /**
     * Begin loading from url and call onLoad with the response content.
     *
     * @param url        — A string containing the path/URL of the .svg file.
     * @param onLoad     —  A function to be called after loading is successfully completed. The function receives the loaded SVGDocument as an argument.
     * @param onProgress —  A function to be called while the loading is in progress. The argument will be the XMLHttpRequest instance, which contains total and loaded bytes.
     * @param onError    —  A function to be called if an error occurs during loading. The function receives the error as an argument.
     */
    public native void load(String url, OnLoadCallback<? extends PropertyHolder> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * @param text — String to parse.
     * @return instance of JavaScriptObject
     */
    public native <T extends PropertyHolder> T parse(String text);

    /**
     * Set the base path or URL from which to load files. This can be useful if you are loading many models from the same directory.
     *
     * @param path base path or URL
     * @return instance of TDSLoader
     */
    public native SVGLoader setPath(String path);
}
