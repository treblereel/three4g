package org.treblereel.gwt.three4g.examples.plugins;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Position {
    public Number x,y,z;
}
