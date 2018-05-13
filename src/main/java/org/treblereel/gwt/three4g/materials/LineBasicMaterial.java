package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.LineBasicMaterialParameters;
import org.treblereel.gwt.three4g.math.Color;

/**
 * A material for drawing wireframe-style geometries.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/27/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class LineBasicMaterial extends Material {

    /**
     * Color of the material, by default set to white (0xffffff).
     */
    public Color color;

    /**
     * Used to check whether this or derived classes are line basic materials. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isLineBasicMaterial;

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

    @JsConstructor
    public LineBasicMaterial() {

    }

    /**
     * @param parameters - an object with one or more properties defining the material's appearance. Any property of the
     *                   material (including any property inherited from Material) can be passed in here. The exception is the property
     *                   color, which can be passed in as a hexadecimal string and is 0xffffff (white) by default. Color.set( color ) is
     *                   called internally.
     */
    @JsConstructor
    public LineBasicMaterial(LineBasicMaterialParameters parameters) {

    }


}
