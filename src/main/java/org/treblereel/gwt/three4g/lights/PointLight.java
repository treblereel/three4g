package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.lights.shadows.LightShadow;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PointLight extends Light {


    /**
     * Used to check whether this or derived classes are PointLight. Default is true.
     */
    public boolean isPointLightt;

    /**
     * The distance from the light where the intensity is 0. When set to 0, then the light never stops. Default is 0.
     */
    public Number distance;

    /**
     * The amount the light dims along the distance of the light. Default is 1. For physically correct lighting, set this to 2.
     */
    public float decay;

    /**
     * A LightShadow used to calculate shadows for this light.
     * <p>
     * The lightShadow's camera is set to a PerspectiveCamera with fov of 90, aspect of 1, near clipping plane at 0.5 and	far clipping plane at 500.
     */
    public LightShadow shadow;

    /**
     * The light's power.
     * In physically correct mode, the luminous power of the light measured in lumens. Default is 4Math.PI.
     * <p>
     * This is directly related to the intensity in the ratio
     * power = intensity * 4π and changing this will also change the intensity.
     */
    public float power;

    /**
     * Creates a new PointLight.
     */
    @JsConstructor
    public PointLight() {

    }

    /**
     * Creates a new PointLight.
     *
     * @param color - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     */
    @JsConstructor
    public PointLight(int color) {

    }

    /**
     * Creates a new PointLight.
     *
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     */
    @JsConstructor
    public PointLight(int color, float intensity) {

    }

    /**
     * Creates a new PointLight.
     *
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - The distance from the light where the intensity is 0. When set to 0, then the light never stops. Default is 0.
     */
    @JsConstructor
    public PointLight(int color, float intensity, Number distance) {

    }

    /**
     * Creates a new PointLight.
     *
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - The distance from the light where the intensity is 0. When set to 0, then the light never stops. Default is 0.
     * @param decay     - The amount the light dims along the distance of the light. Default is 1. For physically correct lighting, set this to 2.
     */
    @JsConstructor
    public PointLight(int color, float intensity, Number distance, float decay) {

    }

    /**
     * Copies the value of color and intensity from the source light into this one.
     *
     * @param source
     * @return
     */
    public native Light copy(PointLight source);


}
