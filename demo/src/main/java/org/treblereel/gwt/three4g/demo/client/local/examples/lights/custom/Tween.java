package org.treblereel.gwt.three4g.demo.client.local.examples.lights.custom;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
@JsType(isNative = true, namespace = "TWEEN")
public class Tween {

    public Tween(Object obj) {

    }

    public native Tween to(Object... args);

    public native Tween easing(Object... args);

    public native void start() ;
}
