package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * A lower level function to compile either a vertex or fragment shader.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/13/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebGLShader {

    /**
     * This will compile an individual shader, but won't link it to be a complete WebGLProgram. Note: this is a function
     * so the new operator should not be used.
     *
     * @param gl -- The current WebGL context
     * @param type -- The WebGL type, either gl.VERTEX_SHADER or gl.FRAGMENT_SHADER
     * @param source -- The source code for the shader
     */
    @JsConstructor
    public WebGLShader(WebGLRenderingContext gl, String type, String source){

    }
}
