package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * An array of Cameras
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/21/18.
 */
@JsType(name = "THREE.ArrayCamera", isNative = true, namespace = JsPackage.GLOBAL)
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
