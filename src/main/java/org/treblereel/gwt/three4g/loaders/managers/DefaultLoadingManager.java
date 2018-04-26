package org.treblereel.gwt.three4g.loaders.managers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * A global instance of the LoadingManager, used by most loaders when no custom manager has been specified.
 * <p>
 * This will be sufficient for most purposes, however there may be times when you desire seperate loading managers for say, textures and models.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DefaultLoadingManager extends LoadingManager {

    @JsConstructor
    public DefaultLoadingManager() {

    }

    @JsConstructor
    public DefaultLoadingManager(OnLoad onLoad) {

    }

    @JsConstructor
    public DefaultLoadingManager(OnLoad onLoad, OnProgress onProgress) {

    }

    @JsConstructor
    public DefaultLoadingManager(OnLoad onLoad, OnProgress onProgress, OnError onError) {

    }
}
