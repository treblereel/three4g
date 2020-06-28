package org.treblereel.gwt.three4g.demo.client.api.dom;


import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/15/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Window")
public class Window extends elemental2.dom.Window {

    public double devicePixelRatio;

    @JsFunction
    public interface VRDisplayEvent {
        void onEvent(elemental2.vr.VRDisplayEvent event);
    }

}
