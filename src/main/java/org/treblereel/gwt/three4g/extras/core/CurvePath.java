package org.treblereel.gwt.three4g.extras.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * An abstract base class extending Curve. A CurvePath is simply an array of connected curves, but retains the api of a curve.
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/11/18.
 */
@JsType(isNative = true, namespace = "THREE")
public abstract class CurvePath extends Curve {

    /**
     * The array of Curves.
     */
    public Curve[] curves;

    /**
     *  Whether or not to automatically close the path.
     */
    public boolean autoClose;

    @JsConstructor
    public CurvePath(){

    }

    /**
     * Add a curve to the .curves array
     * @param curve
     */
    public native void add(Curve curve);

    /**
     * Adds a lineCurve to close the path
     */
    public native void closePath();

    /**
     * Adds together the lengths of the curves in the .curves array.
     */
    public native float getCurveLengths();

}
