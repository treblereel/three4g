package org.treblereel.gwt.three4g.geometries.parameters;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/9/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MorphNormal {

    public String name;

    public JsArray<Vector3> normals;
}
