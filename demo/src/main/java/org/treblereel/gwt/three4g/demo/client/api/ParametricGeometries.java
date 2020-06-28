package org.treblereel.gwt.three4g.demo.client.api;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.geometries.ParametricGeometryFunction;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/27/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ParametricGeometries {

    public static ParametricGeometryFunction klein;

    public static ParametricGeometryFunction mobius;

    public native static ParametricGeometryFunction plane(int i, int i1);
}
