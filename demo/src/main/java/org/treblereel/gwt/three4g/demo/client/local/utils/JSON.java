package org.treblereel.gwt.three4g.demo.client.local.utils;

import static jsinterop.annotations.JsPackage.GLOBAL;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/7/17.
 */
@JsType(isNative = true, namespace = GLOBAL)
public class JSON {

    public native static String stringify(Object obj);

    public native static Object parse(String obj);

}

