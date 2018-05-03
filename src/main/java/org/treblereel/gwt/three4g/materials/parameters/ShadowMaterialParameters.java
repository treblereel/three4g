package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ShadowMaterialParameters extends MaterialParameters {

    /**
     * Whether the material is affected by lights. Default is true.
     */
    public boolean lights;

    /**
     * Defines whether this material is transparent. Default is true.
     */
    public boolean transparent;

}
