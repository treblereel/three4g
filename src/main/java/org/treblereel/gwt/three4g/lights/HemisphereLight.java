package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * A light source positioned directly above the scene, with color fading from the sky color to the ground color.
 * <p>
 * This light cannot be used to cast shadows.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class HemisphereLight extends Light {

    /**
     * This is set to undefined in the constructor as hemisphere lights cannot cast shadows.
     */
    public boolean castShadow;

    /**
     * The light's sky color, as passed in the constructor. Default is a new Color set to white (0xffffff).
     */
    public int color;

    /**
     * The light's ground color, as passed in the constructor. Default is a new Color set to white (0xffffff).
     */
    public int groundColor;

    /**
     * Used to check whether this or derived classes are hemisphere lights. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isHemisphereLight;

    /**
     * This is set equal to Object3D.DefaultUp (0, 1, 0), so that the light shines from the top down.
     */
    public Vector3 position;

    /**
     * Creates a new HemisphereLight.
     */
    @JsConstructor
    public HemisphereLight() {

    }

    /**
     * @param skyColor - hexadecimal color of the sky. Default is 0xffffff.
     */
    @JsConstructor
    public HemisphereLight(float skyColor) {

    }

    /**
     * @param skyColor    - hexadecimal color of the sky. Default is 0xffffff.
     * @param groundColor - hexadecimal color of the ground. Default is 0xffffff.
     */
    @JsConstructor
    public HemisphereLight(int skyColor, float groundColor) {

    }

    /**
     * @param skyColor    - hexadecimal color of the sky. Default is 0xffffff.
     * @param groundColor - hexadecimal color of the ground. Default is 0xffffff.
     * @param intensity   - numeric value of the light's strength/intensity. Default is 1.
     */
    @JsConstructor
    public HemisphereLight(int skyColor, int groundColor, float intensity) {

    }

    /**
     * Copies the value of color, intensity and groundColor from the source light into this one.
     *
     * @param source
     * @return
     */
    public native HemisphereLight copy(HemisphereLight source);
}
