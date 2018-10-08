package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.RawShaderMaterialParameters;

/**
 * This class works just like ShaderMaterial, except that definitions of built-in uniforms and attributes are not automatically prepended to the GLSL shader code.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class RawShaderMaterial extends ShaderMaterial {

    /**
     * Used to check whether this or derived classes are raw shader materials. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isRawShaderMaterial;

    public RawShaderMaterial() {

    }

    /**
     * @param parameters - an object with one or more properties defining the material's appearance. Any property of the
     *                   material (including any property inherited from Material and ShaderMaterial) can be passed in here.
     */
    public RawShaderMaterial(RawShaderMaterialParameters parameters) {

    }

}
