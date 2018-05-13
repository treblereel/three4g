package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * A point's cylindrical coordinates.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/1/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Cylindrical {

    public float radius;

    public float theta;

    public float y;

    @JsConstructor
    public Cylindrical(float radius, float theta, float y) {

    }

    /**
     * Returns a new cylindrical with the same radius, theta and y properties as this one.
     *
     * @return Cylindrical
     */
    public native Cylindrical clone();

    /**
     * Copies the values of the passed Cylindrical's radius, theta and y properties to this cylindrical.
     *
     * @param other Cylindrical
     * @return Cylindrical
     */
    public native Cylindrical copy(Cylindrical other);

    /**
     * Sets values of this cylindrical's radius, theta and y properties.
     *
     * @param radius - radius
     * @param phi -   phi
     * @param theta - theta
     * @return Cylindrical
     */
    public native Cylindrical set(float radius, float phi, float theta);

    /**
     * Sets values of this cylindrical's radius, theta and y properties from the Vector3.
     * The radius is set the vector's distance from the origin as measured along the the x-z plane, while theta is set from its direction on the the x-z plane and y is set from the vector's y component.
     *
     * @param vec3 Vector3
     * @return Cylindrical
     */
    public native Cylindrical setFromVector3(Vector3 vec3);
}
