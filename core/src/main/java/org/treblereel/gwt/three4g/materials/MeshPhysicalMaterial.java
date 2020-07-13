package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.MeshPhysicalMaterialParameters;

/**
 * An extension of the MeshStandardMaterial that allows for greater control over reflectivity.
 * <p>
 * Note that for best results you should always specify an environment map when using this material.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MeshPhysicalMaterial extends MeshStandardMaterial {

    /**
     * ClearCoat level, from 0.0 to 1.0. Default is 0.0.
     */
    public float clearcoat;

    /**
     * How rough the clearCoat appears, from 0.0 to 1.0. Default is 0.0.
     */
    public float clearcoatRoughness;

    /**
     * Used to check whether this or derived classes are mesh physical materials. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMeshPhysicalMaterial;

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


    public MeshPhysicalMaterial() {

    }

    /**
     * @param parameters - (optional) an object with one or more properties defining the material's appearance. Any property
     *                   of the material (including any property inherited from Material and MeshStandardMaterial) can be passed in here.
     *                   <p>
     *                   The exception is the property color, which can be passed in as a hexadecimal string and is 0xffffff (white) by default. Color.set( color ) is called internally.
     */
    public MeshPhysicalMaterial(MeshPhysicalMaterialParameters parameters) {

    }
}
