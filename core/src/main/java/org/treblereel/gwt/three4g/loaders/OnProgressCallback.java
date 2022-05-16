package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/5/18.
 */
@JsFunction
@FunctionalInterface
public interface OnProgressCallback {
    void onProgress(ProgressEvent<EventTarget> request);
}
