package org.treblereel.gwt.three4g.demo.client.local.examples.material;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.parameters.Uniforms;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/26/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SkinSimple {

    public Uniforms uniforms;

    public String fragmentShader, vertexShader;

}
