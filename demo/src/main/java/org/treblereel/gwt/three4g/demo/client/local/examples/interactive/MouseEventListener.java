package org.treblereel.gwt.three4g.demo.client.local.examples.interactive;

import elemental2.dom.MouseEvent;
import jsinterop.annotations.JsFunction;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/7/18.
 */
@JsFunction
@FunctionalInterface
public interface MouseEventListener {

    void onEvent(MouseEvent event);
}
