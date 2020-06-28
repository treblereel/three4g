package org.treblereel.gwt.three4g.demo.client.api.dom;

import elemental2.promise.Promise;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/15/18.
 */

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Navigator")
public class Navigator extends elemental2.dom.Navigator {

    /**
     * The activeVRDisplays read-only property of the Navigator interface returns an array containing every VRDisplay object that is currently presenting (VRDisplay.ispresenting is true).
     *
     * @return An array of VRDisplay objects.
     */
    public native static elemental2.vr.VRDisplay[] activeVRDisplays();


    /**
     * The getVRDisplays() method of the Navigator interface returns a promise that resolves to an array of VRDisplay objects representing any available VR displays connected to the computer.
     *
     * @return A promise that resolves to an array of VRDisplay objects.
     */
    public native static Promise<elemental2.vr.VRDisplay[]> getVRDisplays();
}
