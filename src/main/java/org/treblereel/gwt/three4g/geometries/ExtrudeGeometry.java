package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.geometries.parameters.ExtrudeGeometryParameters;

/**
 * Creates extruded geometry from a path shape.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ExtrudeGeometry extends Geometry{

    public ExtrudeGeometryParameters parameters;

    @JsConstructor
    public ExtrudeGeometry(Shape shape, ExtrudeGeometryParameters options){

    }

    @JsConstructor
    public ExtrudeGeometry(Shape[] shapes, ExtrudeGeometryParameters options){

    }
}
