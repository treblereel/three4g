package org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/12/18.
 */
@JsType(isNative = true, namespace = "THREE", name = "ParametricGeometries.SphereGeometry")
public class SphereGeometry extends Geometry {

    @JsConstructor
    public SphereGeometry(int size, int u, int v) {

    }

}
