package org.treblereel.gwt.three4g.loaders.managers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Handles and keeps track of loaded and pending data. A default global instance of this class is created and used by loaders if not supplied manually - see DefaultLoadingManager.
 * <p>
 * In general that should be sufficient, however there are times when it can be useful to have seperate loaders - for example if you want to show seperate loading bars for objects and textures.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/7/18.
 */
@JsType(isNative = true, name = "THREE.LoadingManager", namespace = JsPackage.GLOBAL)
public class LoadingManager {

    /**
     * This function will be called when all loading is completed. By default this is undefined, unless passed in the constructor.
     */
    public OnLoad onLoad;

    /**
     * This function will be called when an item is complete. The arguments are:
     * url — The url of the item just loaded.
     * itemsLoaded — the number of items already loaded so far.
     * itemsTotal — the total amount of items to be loaded.
     */
    public OnProgress onProgress;

    /**
     * This function will be called when any item errors, with the argument:
     * url — The url of the item that errored.
     */
    public OnError onError;

    @JsConstructor
    public LoadingManager() {

    }

    @JsConstructor
    public LoadingManager(OnLoad onLoad) {

    }

    @JsConstructor
    public LoadingManager(OnLoad onLoad, OnProgress onProgress) {

    }

    @JsConstructor
    public LoadingManager(OnLoad onLoad, OnProgress onProgress, OnError onError) {

    }

    /**
     * If provided, the callback will be passed each resource URL before a request is sent. The callback may return the
     * original URL, or a new URL to override loading behavior. This behavior can be used to load assets from .ZIP files, drag-and-drop APIs, and Data URIs.
     *
     * @param callback — URL modifier callback. Called with url argument, and must return resolvedURL.
     */
    public native void setURLModifier(OnURLModifier callback);

    /**
     * Given a URL, uses the URL modifier callback (if any) and returns a resolved URL. If no URL modifier is set, returns
     * the original URL.
     *
     * @param url — the url to load
     * @return resulting url
     */
    public native String resolveURL(String url);
}
