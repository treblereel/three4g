package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/8/18.
 */
@JsFunction
@FunctionalInterface
public interface OnLoadCallbackPair<T,V> {
    void onLoad(T object, V object2);
}
