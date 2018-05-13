package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsFunction
@FunctionalInterface
public interface OnUploadCallback {
    void OnUpload();
}
