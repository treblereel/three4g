package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.parameters.ExtrudeGeometryParameters;

/**
 * Creates extruded BufferGeometry from a path shape.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, name = "THREE.ExtrudeBufferGeometry", namespace = JsPackage.GLOBAL)
public class ExtrudeBufferGeometry extends BufferGeometry<ExtrudeBufferGeometry> {

    public ExtrudeGeometryParameters parameters;

    @JsConstructor
    public ExtrudeBufferGeometry(Shape shape, ExtrudeGeometryParameters options) {

    }

    @JsConstructor
    public ExtrudeBufferGeometry(Shape[] shapes, ExtrudeGeometryParameters options) {

    }
}
