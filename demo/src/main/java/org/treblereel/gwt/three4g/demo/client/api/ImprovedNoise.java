package org.treblereel.gwt.three4g.demo.client.api;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/28/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ImprovedNoise {
    public native int noise(double i, double i1, double z);
}
