package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class UpdateRange {

    /**
     * Default is 0. Position at whcih to start update.
     */
    public int offset;

    /**
     * Default is -1, which means don't use update ranges.
     */
    public int count;


}
