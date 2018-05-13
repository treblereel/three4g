package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Box3 implements Box {

    @JsConstructor
    public Box3(){

    }

    @JsConstructor
    public Box3(Vector3 min, Vector3 max){

    }

}
