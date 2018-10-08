package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 2/27/18.
 */
@JsFunction
@FunctionalInterface
public interface TraverseCallback {
    void onEvent(Object3D object);
}
