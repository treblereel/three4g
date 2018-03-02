package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Sphere {

    /**
     * Creates a new Sphere.
     */
    @JsConstructor
    public Sphere(){

    }

    /**
     *
     * Creates a new Sphere.
     *
     * @param center - center of the sphere. Default is a Vector3 at (0, 0, 0).
     * @param radius - radius of the sphere. Default is 0.
     */
    @JsConstructor
    public Sphere(Vector3 center, Vector3 radius){

    }
}
