package org.treblereel.gwt.three4g.cameras.params;


import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 11/2/18
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CubeCameraOptions {

    public int format; //default THREE4G.RGBFormat
    public int magFilter; //default THREE4G.LinearFilter
    public int minFilter; //default THREE4G.LinearFilter
}
