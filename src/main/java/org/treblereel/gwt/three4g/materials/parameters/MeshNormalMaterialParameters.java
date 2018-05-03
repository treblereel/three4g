package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class MeshNormalMaterialParameters extends MaterialParameters {

    /**
     * Whether the material is affected by fog. Default is false.
     */
    public boolean fog;

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
}
