package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/5/18.
 */
@JsFunction
@FunctionalInterface
public interface OnErrorCallback {
    void onError();
}
