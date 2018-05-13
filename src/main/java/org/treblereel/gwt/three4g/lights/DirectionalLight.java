package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.shadows.DirectionalLightShadow;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * A light that gets emitted in a specific direction. This light will behave as though it is infinitely far away and the
 * rays produced from it are all parallel. The common use case for this is to simulate daylight; the sun is far enough
 * away that its position can be considered to be infinite, and all light rays coming from it are parallel.
 * <p>
 * This light can cast shadows - see the DirectionalLightShadow page for details.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/21/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DirectionalLight extends Light {


    /**
     * If set to true light will cast dynamic shadows. Warning: This is expensive and requires tweaking to get shadows
     * looking right. See the DirectionalLightShadow for details. The default is false.
     */
    public boolean castShadow;

    /**
     * Used to check whether this or derived classes are directional lights. Default is true.
     * You should not change this, as it is used internally for optimisation.
     */
    public boolean isDirectionalLight;

    /**
     * This is set equal to Object3D.DefaultUp (0, 1, 0), so that the light shines from the top down.
     */
    public Vector3 position;

    /**
     * A DirectionalLightShadow used to calculate shadows for this light.
     */
    public DirectionalLightShadow shadow;

    /**
     * The DirectionalLight points from its position to target.position. The default position of the target is (0, 0, 0).
     * Note: For the target's position to be changed to anything other than the default, it must be added to the scene using
     * scene.add( light.target ); This is so that the target's matrixWorld gets automatically updated each frame.
     * <p>
     * It is also possible to set the target to be another object in the scene (anything with a position property), like so:
     * var targetObject = new THREE.Object3D();
     * scene.add(targetObject);
     * <p>
     * light.target = targetObject; The directionalLight will now track the target object.
     */
    public Object3D target;


    @JsConstructor
    public DirectionalLight() {

    }

    /**
     * Creates a new DirectionalLight.
     *
     * @param color - hexadecimal color of the light. Default is 0xffffff (white).
     */
    @JsConstructor
    public DirectionalLight(int color) {

    }

    /**
     * Creates a new DirectionalLight.
     *
     * @param color     - hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - (optional) numeric value of the light's strength/intensity. Default is 1.
     */
    @JsConstructor
    public DirectionalLight(int color, float intensity) {

    }

    /**
     * Copies value of all the properties from the source to this DirectionalLight.
     * @param source instance of DirectionalLight
     * @return instance of DirectionalLight
     */
    public native DirectionalLight copy(DirectionalLight source);

}
