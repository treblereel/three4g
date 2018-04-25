package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Color;

/**
 * A material for drawing wireframe-style geometries with dashed lines.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LineDashedMaterial extends Material {

    /**
     * Color of the material, by default set to white (0xffffff).
     */
    public Color color;

    /**
     * The size of the dash. This is both the gap with the stroke. Default is 3.
     */
    public int dashSize;

    /**
     * The size of the gap. Default is 1.
     */
    public int gapSize;

    /**
     * Used to check whether this or derived classes are line dashed materials. Default is true.
     */
    public boolean isLineDashedMaterial;

    /**
     * Whether the material is affected by lights. Default is false.
     */
    public boolean lights;

    /**
     * Controls line thickness. Default is 1.
     * Due to limitations in the ANGLE layer, with the WebGL renderer on Windows platforms linewidth will always be 1 regardless of the set value.
     */
    public float linewidth;

    /**
     * The scale of the dashed part of a line. Default is 1.
     */
    public float scale;

    @JsConstructor
    public LineDashedMaterial(LineDashedMaterialParameters lineDashedMaterialParameters) {

    }


}
