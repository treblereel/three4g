package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.MeshNormalMaterialParameters;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class MeshNormalMaterial {

    /**
     * Whether the material is affected by fog. Default is false.
     */
    public boolean fog;

    /**
     * Used to check whether this or derived classes are mesh normal materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isMeshNormalMaterial;

    /**
     * Whether the material is affected by lights. Default is false.
     */
    public boolean lights;

    /**
     * Define whether the material uses morphTargets. Default is false.
     */
    public boolean morphTargets;

    /**
     * Render geometry as wireframe. Default is false (i.e. render as smooth shaded).
     */
    public boolean wireframe;

    /**
     * Controls wireframe thickness. Default is 1.
     * Due to limitations in the ANGLE layer, on Windows platforms linewidth will always be 1 regardless of the set value.
     */
    public float wireframeLinewidth;

    @JsConstructor
    public MeshNormalMaterial(MeshNormalMaterialParameters meshNormalMaterialParameters) {

    }
}
