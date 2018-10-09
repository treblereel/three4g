package org.treblereel.gwt.three4g.extensions.controls;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.events.EventDispatcher;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/9/18.
 */
@Three4gElement(paths = "js/controls/PointerLockControls.js")
@JsType(isNative = true, namespace = "THREE")
public class PointerLockControls extends EventDispatcher {

    /**
     * The HTMLDOMElement used to listen for mouse / touch events. This must be passed in the constructor; changing it here will not set up new event listeners. Default is the whole document.
     */
    public HTMLElement domElement;

    public boolean isLocked;

    /**
     * @param camera The camera to be controlled.
     */
    public PointerLockControls(Camera camera) {

    }

    /**
     * @param camera     The camera to be controlled.
     * @param domElement The HTML element used for event listeners. By default this is the whole document, however if you only want to the controls to work over a specific element (e.g. the canvas) you can specify that here.
     */
    public PointerLockControls(Camera camera, HTMLElement domElement) {

    }

    public native void connect();

    public native void disconnect();

    public native void dispose();

    public native void lock();

    public native void unlock();


    public native Object3D getObject();

    public native Vector3 getDirection();
}
