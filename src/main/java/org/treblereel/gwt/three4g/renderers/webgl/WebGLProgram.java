package org.treblereel.gwt.three4g.renderers.webgl;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.renderers.parameters.WebGLRendererParameters;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/12/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebGLProgram {

    public String id;

    public String code;

    public int usedTimes;

    public Object program;

    public WebGLShader vertexShader;

    public WebGLShader fragmentShader;

    @JsConstructor
    public WebGLProgram(WebGLRenderer renderer, Object code, Material material, WebGLRendererParameters parameters) {

    }

    /**
     * Returns a name-value mapping of all active uniform locations.
     *
     * @return JsPropertyMap
     */
    public native JsPropertyMap getUniforms();

    /**
     * Returns a name-value mapping of all active vertex attribute locations.
     *
     * @return get all attrs
     */
    public native JsPropertyMap getAttributes();
}
