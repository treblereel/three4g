package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.MeshToonMaterialParameters;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * An extension of the MeshPhongMaterial with toon shading.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MeshToonMaterial extends MeshPhongMaterial {

    /**
     * Gradient map for the toon shading. Default is null.
     */
    public Texture gradientMap;

    /**
     * Used to check whether this or derived classes are mesh toon materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMeshToonMaterial;

    /**
     * An object of the form:
     * { 'TOON': '' };
     * This is used by the WebGLRenderer for selecting shaders.
     */
    public Object defines;


    public MeshToonMaterial() {

    }

    /**
     * @param parameters - (optional) an object with one or more properties defining the material's appearance. Any property
     *                   of the material (including any property inherited from Material and MeshStandardMaterial) can be passed in here.
     *                   <p>
     *                   The exception is the property color, which can be passed in as a hexadecimal string and is 0xffffff
     *                   (white) by default. Color.set( color ) is called internally.
     */
    public MeshToonMaterial(MeshToonMaterialParameters parameters) {

    }
}
