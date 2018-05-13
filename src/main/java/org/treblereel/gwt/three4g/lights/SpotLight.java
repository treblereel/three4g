package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.shadows.SpotLightShadow;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * This light gets emitted from a single point in one direction, along a cone that increases in size the further from the light it gets.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SpotLight extends Light {

    /**
     * Maximum extent of the spotlight, in radians, from its direction. Should be no more than Math.PI/2. The default is Math.PI/3.
     */
    public float angle;

    /**
     * If set to true light will cast dynamic shadows. Warning: This is expensive and requires tweaking to get shadows
     * looking right. See the SpotLightShadow for details. The default is false.
     */
    public boolean castShadow;

    /**
     * The amount the light dims along the distance of the light.
     * In physically correct mode, decay = 2 leads to physically realistic light falloff. The default is 1.
     */
    public float decay;

    /**
     * If non-zero, light will attenuate linearly from maximum intensity at the light's position down to zero at this distance from the light. Default is 0.0.
     */
    public float distance;

    /**
     * Used to check whether this or derived classes are spot lights. Default is true.
     */
    public boolean isSpotLight;

    /**
     * Percent of the spotlight cone that is attenuated due to penumbra. Takes values between zero and 1. The default is 0.0.
     */
    public float penumbra;

    /**
     * This is set equal to Object3D.DefaultUp (0, 1, 0), so that the light shines from the top down.
     */
    public Vector3 position;

    /**
     * The light's power.
     * In physically correct mode, the luminous power of the light measured in lumens. Default is 4Math.PI.
     * <p>
     * This is directly related to the intensity in the ratio
     * power = intensity * π and changing this will also change the intensity.
     */
    public float power;

    /**
     * A SpotLightShadow used to calculate shadows for this light.
     */
    public SpotLightShadow shadow;

    /**
     * The Spotlight points from its position to target.position. The default position of the target is (0, 0, 0).
     * Note: For the target's position to be changed to anything other than the default, it must be added to the scene using
     * scene.add( light.target ); This is so that the target's matrixWorld gets automatically updated each frame.
     * <p>
     * It is also possible to set the target to be another object in the scene (anything with a position property), like so:
     * var targetObject = new THREE.Object3D();
     * scene.add(targetObject);
     * <p>
     * light.target = targetObject; The spotlight will now track the target object.
     */
    public Object3D target;

    /**
     * Creates a new SpotLight.
     */
    @JsConstructor
    public SpotLight() {

    }

    /**
     * @param color - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     */
    @JsConstructor
    public SpotLight(int color) {

    }

    /**
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     */
    @JsConstructor
    public SpotLight(int color, float intensity) {

    }

    /**
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - Maximum distance from origin where light will shine whose intensity is attenuated linearly based on distance from origin.
     */
    @JsConstructor
    public SpotLight(int color, float intensity, float distance) {

    }

    /**
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - Maximum distance from origin where light will shine whose intensity is attenuated linearly based on distance from origin.
     * @param angle     - Maximum angle of light dispersion from its direction whose upper bound is Math.PI/2.
     */
    @JsConstructor
    public SpotLight(int color, float intensity, float distance, float angle) {

    }

    /**
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - Maximum distance from origin where light will shine whose intensity is attenuated linearly based on distance from origin.
     * @param angle     - Maximum angle of light dispersion from its direction whose upper bound is Math.PI/2.
     * @param penumbra  - Percent of the spotlight cone that is attenuated due to penumbra. Takes values between zero
     */
    @JsConstructor
    public SpotLight(int color, float intensity, float distance, float angle, float penumbra) {

    }

    /**
     * @param color     - (optional) hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     * @param distance  - Maximum distance from origin where light will shine whose intensity is attenuated linearly based on distance from origin.
     * @param angle     - Maximum angle of light dispersion from its direction whose upper bound is Math.PI/2.
     * @param penumbra  - Percent of the spotlight cone that is attenuated due to penumbra. Takes values between zero
     * @param decay     - The amount the light dims along the distance of the light.
     */
    @JsConstructor
    public SpotLight(int color, float intensity, float distance, float angle, float penumbra, float decay) {

    }

    /**
     * Copies value of all the properties from the source to this SpotLight.
     *
     * @param source instance of SpotLight
     * @return instance of SpotLight
     */
    public native SpotLight copy(SpotLight source);

}
