package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * A class for displaying points. The points are rendered by the WebGLRenderer using gl.POINTS.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/19/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Points extends Object3D {

    /**
     * An instance of Geometry or BufferGeometry (or derived classes), defining the object's structure.
     * <p>
     * Its recommended to always use a BufferGeometry if possible for best performance.
     */
    public AbstractGeometry geometry;

    /**
     * Used to check whether this or derived classes are points. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isPoints;

    /**
     * An instance of Material, defining the object's appearance. Default is a PointsMaterial with a random color.
     */
    public Material material;


    @JsConstructor
    public Points() {

    }

    /**
     * @param geometry — an instance of Geometry or BufferGeometry. Default is a new BufferGeometry.
     */
    @JsConstructor
    public Points(AbstractGeometry geometry) {

    }

    /**
     * @param material — a Material. Default is a new PointsMaterial with a random color.
     */
    @JsConstructor
    public Points(Material material) {

    }

    /**
     * @param geometry — an instance of Geometry or BufferGeometry. Default is a new BufferGeometry.
     * @param material — a Material. Default is a new PointsMaterial with a random color.
     */
    @JsConstructor
    public Points(AbstractGeometry geometry, Material material) {

    }

    /**
     * Get intersections between a casted Ray and this Line. Raycaster.intersectObject will call this method.
     *
     * @param raycaster
     * @param intersects
     * @return
     */
    public native void raycast(Raycaster raycaster, Object intersects);

    /**
     * Returns a clone of this Points object and its descendant
     * @return Points
     */
    public native Points clone();
}
