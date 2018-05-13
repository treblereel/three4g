package org.treblereel.gwt.three4g.geometries.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Curve;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TubeGeometryParameters {

    public Curve path;
    public int tubularSegments;
    public float radius;
    public int radialSegments;
    public boolean closed;
}
