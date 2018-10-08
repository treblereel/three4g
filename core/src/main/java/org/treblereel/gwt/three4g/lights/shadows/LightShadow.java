package org.treblereel.gwt.three4g.lights.shadows;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.renderers.WebGLRenderTarget;

/**
 * This is used internally by PointLights for calculating shadows, and also serves as a base class for the other shadow classes.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LightShadow {

    /**
     * The light's view of the world. This is used to generate a depth map of the scene; objects behind other objects
     * from the light's perspective will be in shadow.
     */
    public Camera camera;

    /**
     * Shadow map bias, how much to add or subtract from the normalized depth when deciding whether a surface is in shadow.
     * The default is 0. Very tiny adjustments here (in the order of 0.0001) may help reduce artefacts in shadows
     */
    public float bias;

    /**
     * The depth map generated using the internal camera; a location beyond a pixel's depth is in shadow. Computed
     * internally during rendering.
     */
    public WebGLRenderTarget map;

    /**
     * A Vector2 defining the width and height of the shadow map.
     * <p>
     * Higher values give better quality shadows at the cost of computation time. Values must be powers of 2, up to the
     * WebGLRenderer.capabilities.maxTextureSize for a given device, although the width and height don't have to be the
     * same (so, for example, (512, 1024) is valid). The default is ( 512, 512 ).
     */
    public Vector2 mapSize;

    /**
     * Model to shadow camera space, to compute location and depth in shadow map. Stored in a Matrix4. This is computed
     * internally during rendering.
     */
    public Matrix4 matrix;

    /**
     * Setting this to values greater than 1 will blur the edges of the shadow.
     * High values will cause unwanted banding effects in the shadows - a greater mapSize will allow for a higher value
     * to be used here before these effects become visible.
     * <p>
     * Note that this has no effect if the WebGLRenderer.shadowMap.type is set to BasicShadowMap.
     */
    public float radius;


    @JsConstructor
    protected LightShadow() {

    }

    /**
     * Copies value of all the properties from the source to this SpotLight.
     *
     * @param source instance of LightShadow
     * @return instance of LightShadow
     */
    public native LightShadow copy(LightShadow source);

    /**
     * Creates a new LightShadow with the same properties as this one.
     *
     * @return instance of LightShadow
     */
    public native LightShadow clone();

    /**
     * Serialize this LightShadow.
     *
     * @return JSON String
     */
    public native String toJSON();
}
