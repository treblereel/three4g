package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.ShadowMaterialParameters;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ShadowMaterial extends Material {

    /**
     * Used to check whether this or derived classes are shadow materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isShadowMaterial;

    /**
     * Whether the material is affected by lights. Default is true.
     */
    public boolean lights;

    /**
     * Defines whether this material is transparent. Default is true.
     */
    public boolean transparent;

    public ShadowMaterial() {

    }

    public ShadowMaterial(ShadowMaterialParameters parameters) {

    }
}
