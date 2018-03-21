package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * An array of Cameras
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/21/18.
 */
@JsType(namespace = "THREE", isNative = true)
public class ArrayCamera extends PerspectiveCamera{

    /**
     * Used to test whether this or derived classes are ArrayCamera. Default is true.
     * <p>
     * This should not be changed as it is used internally by the renderer for optimisation.
     */
    public boolean isArrayCamera;

    @JsConstructor
    public ArrayCamera(PerspectiveCamera[] cameras) {

    }


}
