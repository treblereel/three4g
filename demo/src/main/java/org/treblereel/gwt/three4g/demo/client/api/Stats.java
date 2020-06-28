package org.treblereel.gwt.three4g.demo.client.api;

import elemental2.dom.HTMLCanvasElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/1/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Stats {

    public HTMLCanvasElement dom;

    public native void update();
}
