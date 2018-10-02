package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/27/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LineBasicMaterialParameters extends MaterialParameters {
    /**
     * Color of the material, by default set to white (0xffffff).
     */
    public Color color;

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
     * Define appearance of line ends. Possible values are 'butt', 'round' and 'square'. Default is 'round'.
     * This corresponds to the 2D Canvas lineCap property and it is ignored by the WebGL renderer.
     */
    public String linecap;

    /**
     * Define appearance of line joints. Possible values are 'round', 'bevel' and 'miter'. Default is 'round'.
     * <p>
     * This corresponds to the 2D Canvas lineJoin property and it is ignored by the WebGL renderer.
     */
    public String linejoin;
}
