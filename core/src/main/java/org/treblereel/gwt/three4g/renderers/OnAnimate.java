package org.treblereel.gwt.three4g.renderers;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/28/18.
 */
@JsFunction
@FunctionalInterface
public interface OnAnimate {
    void animate();
}
