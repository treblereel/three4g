package org.treblereel.gwt.three4g.renderers.shaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Webgl Shader Library for three.js
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 7/31/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "THREE.ShaderLib")
public class ShaderLib {
    public static Shader basic, lambert, phong, standard, points, dashed, depth, normal, sprite, cube, equirect, distanceRGBA, shadow;
}
