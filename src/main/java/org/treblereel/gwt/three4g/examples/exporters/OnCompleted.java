package org.treblereel.gwt.three4g.examples.exporters;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsFunction
@FunctionalInterface
public interface OnCompleted {
    void onCompleted(Object object);
}
