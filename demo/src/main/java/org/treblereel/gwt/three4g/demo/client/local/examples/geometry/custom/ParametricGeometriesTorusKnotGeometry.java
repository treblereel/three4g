package org.treblereel.gwt.three4g.demo.client.local.examples.geometry.custom;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/11/18.
 */
@JsType(isNative = true, namespace = "THREE", name = "ParametricGeometries.TorusKnotGeometry")
public class ParametricGeometriesTorusKnotGeometry extends Geometry {

    @JsConstructor
    public ParametricGeometriesTorusKnotGeometry(int radius, int tube, int segmentsT, int segmentsR, int p, int q) {

    }
}
