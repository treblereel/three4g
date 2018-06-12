package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsFunction;
import org.treblereel.gwt.three4g.core.JsObject;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/5/18.
 */
@JsFunction
@FunctionalInterface
public interface OnErrorCallback {
    void onError(JsObject error);
}
