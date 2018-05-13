package org.treblereel.gwt.three4g.geometries.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RingGeometryParameters {

    public float innerRadius;
    public float outerRadius;
    public int thetaSegments;
    public int phiSegments;
    public float thetaStart;
    public float thetaLength;
}
