package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Creates a tube that extrudes along a 3d curve.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/11/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TubeGeometry extends Geometry {

    /**
     * @param path            — Curve - A path that inherits from the Curve base class
     * @param tubularSegments — Integer - The number of segments that make up the tube, default is 64
     * @param radius          — Float - The radius of the tube, default is 1
     * @param radialSegments  — Integer - The number of segments that make up the cross-section, default is 8
     * @param closed          — Boolean Is the tube open or closed, default is false
     */
    @JsConstructor
    public TubeGeometry(Curve path, int tubularSegments, float radius, int radialSegments, boolean closed) {

    }

    /**
     * An object with all of the parameters that were used to generate the geometry
     * @return
     */
    public native JsPropertyMap parameters();

    /**
     * An array of Vector3 tangents
     *
     * @return
     */
    public native Vector3[] tangents();

    /**
     * An array of Vector3 normals
     */
    public native Vector3[] normals();

    /**
     * An array of Vector3 binormals
     *
     * @return
     */
    public native Vector3[] binormals();

}
