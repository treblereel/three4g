package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Matrix4 implements Matrix {



    public native Matrix4 makeTranslation(float x, float y, float z);
}
