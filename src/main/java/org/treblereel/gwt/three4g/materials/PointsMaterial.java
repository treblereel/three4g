package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.PointsMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * The default material used by Points.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/19/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PointsMaterial extends Material{

    /**
     * Color of the material, by default set to white (0xffffff).
     */
    public Color color;

    /**
     * Used to check whether this or derived classes are points materials. Default is true.
     *
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isPointsMaterial;

    /**
     * Whether the material is affected by lights. Default is false.
     */
    public boolean lights;

    /**
     * Sets the color of the points using data from a Texture.
     */
    public Texture map;

    /**
     * Define whether the material uses morphTargets. Default is false.
     */
    public boolean morphTargets;

    /**
     * Sets the size of the points. Default is 1.0.
     */
    public float size;

    /**
     * Specify whether points' size will get smaller with the distance. Default is true.
     */
    public boolean sizeAttenuation;


    @JsConstructor
    public PointsMaterial(){

    }

    @JsConstructor
    public PointsMaterial(PointsMaterialParameters params){

    }


}
