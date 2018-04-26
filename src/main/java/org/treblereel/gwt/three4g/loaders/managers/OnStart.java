package org.treblereel.gwt.three4g.loaders.managers;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/26/18.
 */
@JsFunction
@FunctionalInterface
public interface OnStart {
    void onStart(String url, int itemsLoaded, int itemsTotal);
}
