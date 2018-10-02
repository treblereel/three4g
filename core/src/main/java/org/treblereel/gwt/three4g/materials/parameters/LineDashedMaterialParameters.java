package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LineDashedMaterialParameters extends MaterialParameters {
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
}
