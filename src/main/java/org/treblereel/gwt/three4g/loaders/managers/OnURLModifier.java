package org.treblereel.gwt.three4g.loaders.managers;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsFunction
@FunctionalInterface
public interface OnURLModifier {
    void onURLModifier(String url);
}
