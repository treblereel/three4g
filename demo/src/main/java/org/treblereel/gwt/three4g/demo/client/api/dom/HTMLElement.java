package org.treblereel.gwt.three4g.demo.client.api.dom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/17/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class HTMLElement extends elemental2.dom.HTMLElement {

    public native void requestPointerLock();
}
