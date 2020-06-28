package org.treblereel.gwt.three4g.demo.client.api.dom;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/17/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Document extends elemental2.dom.Document {


    /**
     * The pointerLockElement property provides the element set as the target for mouse events while the pointer is locked. It is null if lock is pending, pointer is unlocked, or the target is in another document.
     */
    public HTMLElement pointerLockElement;

    /**
     * The exitPointerLock asynchronously releases a pointer lock previously requested through Element.requestPointerLock.
     */
    public native void exitPointerLock();
}
