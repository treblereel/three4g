package org.treblereel.gwt.three4g.demo.client.local.examples.lights.custom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "TWEEN")
public class TWEEN {
    public static native void update();
}
