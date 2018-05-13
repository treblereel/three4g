package org.treblereel.gwt.three4g.geometries.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BoxGeometryParameters {

    public float width;

    public float height;

    public float depth;

    public int widthSegments;

    public int heightSegments;

    public int depthSegments;

}
