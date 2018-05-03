package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * A continuous line.
 * <p>
 * This is nearly the same as LineSegments; the only difference is that it is rendered using gl.LINE_STRIP instead of gl.LINES
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Line extends Object3D {

    /**
     * Used to check whether this or derived classes are Line. Default is true.
     */
    public boolean isLine;

    /**
     * vertices representing the line segment(s). Default is a new BufferGeometry.
     */
    public AbstractGeometry geometry;

    /**
     * material for the line. Default is a new LineBasicMaterial with random color.
     */
    public Material material;

    @JsConstructor
    public Line() {

    }

    /**
     * If no material is supplied, a randomized line material will be created and assigned to the object.
     *
     * @param geometry — vertices representing the line segment(s). Default is a new BufferGeometry.
     * @param material — material for the line. Default is a new LineBasicMaterial with random color.
     */
    @JsConstructor
    public Line(AbstractGeometry geometry, Material material) {

    }

    /**
     * Computes an array of distance values which are necessary for LineDashedMaterial. For each vertex in the geometry, the method calculates the cumulative length from the current point to the very beginning of the line.
     * @return float
     */
    public native float computeLineDistances();

    /**
     * Get intersections between a casted Ray and this Line. Raycaster.intersectObject will call this method.
     *
     * @param raycaster
     * @param intersects
     * @return
     */
    public native void raycast(Raycaster raycaster, Object intersects);

    /**
     * Returns a clone of this Line object and its descendants.
     *
     * @return
     */
    public native Line clone();
}
