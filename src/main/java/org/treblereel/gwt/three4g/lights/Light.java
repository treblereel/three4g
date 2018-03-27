package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * Abstract base class for lights - all other light types inherit the properties and methods described here.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Light extends Object3D {

    /**
     * Used to check whether this or derived classes are lights. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isLight;

    /**
     * hexadecimal color of the light. Default is 0xffffff (white)
     */
    public int color;

    /**
     * numeric value of the light's strength/intensity. Default is 1.
     */
    public float intensity;


    /**
     * Creates a new Light. Note that this is not intended to be called directly (use one of derived classes instead).
     */
    @JsConstructor
    public Light() {

    }

    /**
     * Creates a new Light. Note that this is not intended to be called directly (use one of derived classes instead).
     *
     * @param color - hexadecimal color of the light. Default is 0xffffff (white).
     */
    @JsConstructor
    public Light(int color) {

    }

    /**
     * Creates a new Light. Note that this is not intended to be called directly (use one of derived classes instead).
     *
     * @param intensity - numeric value of the light's strength/intensity. Default is 1.
     */
    @JsConstructor
    public Light(float intensity) {

    }

    /**
     * Creates a new Light. Note that this is not intended to be called directly (use one of derived classes instead).
     *
     * @param color     - hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - numeric value of the light's strength/intensity. Default is 1.
     */
    @JsConstructor
    public Light(int color, float intensity) {

    }

    /**
     * Copies the value of color and intensity from the source light into this one.
     *
     * @param source
     * @return
     */
    public native Light copy(Light source);

    /**
     * Return Light data in JSON format.
     *
     * @return
     */
    public native String toJSON();


}
