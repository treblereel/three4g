package org.treblereel.gwt.three4g.renderers.shaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 7/31/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Shader {

    public Uniforms uniforms;

    public String vertexShader, fragmentShader;
}
