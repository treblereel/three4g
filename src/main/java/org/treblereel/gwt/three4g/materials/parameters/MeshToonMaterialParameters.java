package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace= JsPackage.GLOBAL, name="Object")
public class MeshToonMaterialParameters extends MeshPhongMaterialParameters {

    /**
     * Gradient map for the toon shading. Default is null.
     */
    public Texture gradientMap;

    /**
     * An object of the form:
     * { 'TOON': '' };
     * This is used by the WebGLRenderer for selecting shaders.
     */
    public Object defines;

}
