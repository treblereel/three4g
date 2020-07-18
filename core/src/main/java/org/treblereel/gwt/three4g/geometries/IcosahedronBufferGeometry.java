package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.geometries.parameters.IcosahedronGeometryParameters;

/**
 * A class for generating an icosahedron geometry.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, name = "THREE.IcosahedronBufferGeometry", namespace = JsPackage.GLOBAL)
public class IcosahedronBufferGeometry extends BufferGeometry<IcosahedronBufferGeometry> {

    public IcosahedronGeometryParameters parameters;

    /**
     * @param radius — Default is 1.
     * @param detail — Default is 0. Setting this to a value greater than 0 adds more vertices making it no longer an
     *               icosahedron. When detail is greater than 1, it's effectively a sphere.
     */
    public IcosahedronBufferGeometry(float radius, int detail) {

    }

}
