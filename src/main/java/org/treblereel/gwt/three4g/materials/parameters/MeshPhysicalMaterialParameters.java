package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MeshPhysicalMaterialParameters extends MeshStandardMaterialParameters {

    /**
     * ClearCoat level, from 0.0 to 1.0. Default is 0.0.
     */
    public float clearCoat;

    /**
     * How rough the clearCoat appears, from 0.0 to 1.0. Default is 0.0.
     */
    public float clearCoatRoughness;

    /**
     * An object of the form:
     * { 'PHYSICAL': '' };
     * This is used by the WebGLRenderer for selecting shaders.
     */
    public Object defines;

    /**
     * Degree of reflectivity, from 0.0 to 1.0. Default is 0.5.
     * This models the reflectivity of non-metallic materials. It has no effect when metalness is 1.0
     */
    public float reflectivity;
}
