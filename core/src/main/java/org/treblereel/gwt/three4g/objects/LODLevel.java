package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class LODLevel {

    public Object3D object;
    public float distance;
}
