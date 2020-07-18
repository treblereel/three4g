package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.lights.shadows.LightShadow;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, name = "THREE.PointLight", namespace = JsPackage.GLOBAL)
public class PointLight extends Light {


    /**
     * Used to check whether this or derived classes are PointLight. Default is true.
     */
    public boolean isPointLightt;

    /**
     * The amount the light dims along the distance of the light. Default is 1. For physically correct lighting, set this to 2.
     */
    public float decay;

    /**
     * Default mode — When distance is zero, light does not attenuate. When distance is non-zero, light will attenuate
     * linearly from maximum intensity at the light's position down to zero at this distance from the light.
     * <p>
     * Physically correct mode — When distance is zero, light will attenuate according to inverse-square law to infinite distance. When distance is non-zero, light will attenuate according to inverse-square law until near the distance cutoff, where it will then attenuate quickly and smoothly to 0. Inherently, cutoffs are not physically correct.
     * <p>
     * Default is 0.0.
     */
    public float distance;

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
     * @param distance  - Maximum range of the light. Default is 0 (no limit).
     */
    @JsConstructor
    public PointLight(int color, float intensity, float distance) {

    }

    /**
     * Creates a new PointLight.
     *
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - Maximum range of the light. Default is 0 (no limit).
     * @param decay     - The amount the light dims along the distance of the light. Default is 1. For physically correct lighting, set this to 2.
     */
    @JsConstructor
    public PointLight(int color, float intensity, float distance, float decay) {

    }

    /**
     * Copies the value of color and intensity from the source light into this one.
     *
     * @param source instance of PointLight
     * @return instance of PointLight
     */
    public native PointLight copy(PointLight source);


}
