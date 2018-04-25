package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * This light globally illuminates all objects in the scene equally.
 * <p>
 * This light cannot be used to cast shadows as it does not have a direction.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class AmbientLight extends Light {

    /**
     * This is set to undefined in the constructor as ambient lights cannot cast shadows.
     */
    public boolean  castShadow;

    /**
     * Used to check whether this or derived classes are AmbientLight. Default is true.
     */
    public boolean isAmbientLight;

    /**
     * Creates a new AmbientLight.
     *
     * @param color Numeric value of the RGB component of the color.
     */
    @JsConstructor
    public AmbientLight(int color){

    }

    /**
     * Creates a new AmbientLight.
     *
     * @param intensity -- Numeric value of the light's strength/intensity.
     */
    @JsConstructor
    public AmbientLight(float intensity){

    }

    /**
     * Creates a new AmbientLight.
     *
     * @param color Numeric value of the RGB component of the color.
     * @param intensity -- Numeric value of the light's strength/intensity.
     */
    @JsConstructor
    public AmbientLight(int color, float intensity){

    }

}
