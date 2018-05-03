package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.core.Geometry;

/**
 * This can be used as a helper object to view the edges of a Geometry object.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/2/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class EdgesGeometry extends Geometry {

    /**
     * @param geometry — Any geometry object.
     */
    @JsConstructor
    public EdgesGeometry(AbstractGeometry geometry) {

    }

    /**
     * @param geometry       — Any geometry object.
     * @param thresholdAngle — An edge is only rendered if the angle (in degrees) between the face normals of the adjoining faces exceeds this value. default = 1 degree.
     */
    @JsConstructor
    public EdgesGeometry(AbstractGeometry geometry, int thresholdAngle) {

    }
}
