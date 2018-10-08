package org.treblereel.gwt.three4g.utils;

import jsinterop.annotations.JsType;

import static jsinterop.annotations.JsPackage.GLOBAL;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 12/7/17.
 */
@JsType(isNative = true, namespace = GLOBAL)
public class JSON {

    public native static String stringify(Object obj);

    public native static Object parse(String obj);

}

