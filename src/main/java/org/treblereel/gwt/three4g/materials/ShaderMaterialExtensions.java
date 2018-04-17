package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/12/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ShaderMaterialExtensions {

    /**
     * set to use derivatives
     */
    public boolean derivatives;

    /**
     * set to use fragment depth values
     */
    public boolean fragDepth;

    /**
     * set to use draw buffers
     */
    public boolean drawBuffers;

    /**
     * set to use shader texture LOD
     */
    public boolean shaderTextureLOD;

}
