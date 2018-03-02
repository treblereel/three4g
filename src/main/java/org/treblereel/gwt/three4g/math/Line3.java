package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Line3 {

    /**
     * Creates a new Line3.
     */
    @JsConstructor
    public Line3(){

    }

    /**
     * Creates a new Line3.
     *
     * @param start - Start of the line segment. Default is (0, 0, 0).
     * @param end - End of the line segment. Default is (0, 0, 0).
     */
    @JsConstructor
    public Line3(Vector3 start, Vector3 end){

    }
}
