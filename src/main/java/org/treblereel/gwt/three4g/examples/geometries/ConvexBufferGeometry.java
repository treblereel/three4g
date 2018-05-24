package org.treblereel.gwt.three4g.examples.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * ConvexBufferGeometry can be used to generate a convex hull for a given array of 3D points. The average time complexity for this task is considered to be O(nlog(n)).
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/24/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ConvexBufferGeometry extends BufferGeometry {

    /**
     * @param points — Array of Vector3s that the resulting convex hull will contain.
     */
    public ConvexBufferGeometry(Vector3... points){

    }
}
