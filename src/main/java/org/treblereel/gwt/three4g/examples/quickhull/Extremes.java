package org.treblereel.gwt.three4g.examples.quickhull;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Extremes {
    public VertexNode[]  min;
    public VertexNode[]  max;
}
