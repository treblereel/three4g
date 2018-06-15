package org.treblereel.gwt.three4g.core.events;

import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/15/18.
 */
@JsFunction
public interface EventListener {
    void call(Event event);
}
