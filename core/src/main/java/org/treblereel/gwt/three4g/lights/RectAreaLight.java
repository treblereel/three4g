package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * RectAreaLight emits light uniformly across the face a rectangular plane. This light type can be used to simulate light sources such as bright windows or strip lighting.
 * <p>
 * Important Notes:
 * <p>
 * There is no shadow support.
 * Only MeshStandardMaterial and MeshPhysicalMaterial are supported.
 * You have to include RectAreaLightUniformsLib into your scene.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, name = "THREE.RectAreaLight", namespace = JsPackage.GLOBAL)
public class RectAreaLight extends Light {

    /**
     * Used to check whether this or derived classes are RectAreaLights. Default is true.
     */
    public boolean isRectAreaLight;

    /**
     * Creates a new RectAreaLight.     * @param intensity - the light's intensity, or brightness. Default is 1.
     */
    @JsConstructor
    public RectAreaLight() {

    }

    /**
     * @param color - hexadecimal color of the light. Default is 0xffffff (white).
     */
    @JsConstructor
    public RectAreaLight(int color) {

    }

    /**
     * @param color     - hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - the light's intensity, or brightness. Default is 1.
     */
    @JsConstructor
    public RectAreaLight(int color, float intensity) {

    }

    /**
     * @param color     - hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - the light's intensity, or brightness. Default is 1.
     * @param width     - width of the light. Default is 10.
     */
    @JsConstructor
    public RectAreaLight(int color, float intensity, float width) {

    }

    /**
     * @param color     - hexadecimal color of the light. Default is 0xffffff (white).
     * @param intensity - the light's intensity, or brightness. Default is 1.
     * @param width     - width of the light. Default is 10.
     * @param height    - height of the light. Default is 10.
     */
    @JsConstructor
    public RectAreaLight(int color, float intensity, float width, float height) {

    }

    /**
     * Copies value of all the properties from the source to this RectAreaLight.
     *
     * @param source RectAreaLight
     * @return RectAreaLight
     */
    public native RectAreaLight copy(RectAreaLight source);

}
