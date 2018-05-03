package org.treblereel.gwt.three4g.geometries.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Shape;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ShapeGeometryParameters {

    public Shape[] shapes;
    public int curveSegments;
}
