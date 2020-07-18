package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * A continuous line that connects back to the start.
 * <p>
 * This is nearly the same	as Line; the only difference is that it is rendered using gl.LINE_LOOP instead of gl.LINE_STRIP,
 * which draws a straight line to the next vertex, and connects the last vertex back to the first.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, name = "THREE.LineLoop", namespace = JsPackage.GLOBAL)
public class LineLoop extends Line {

    /**
     * Used to check whether this or derived classes are line loops. Default is true.
     * <p>
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isLineLoop;

    /**
     * If no material is supplied, a randomized line material will be created and assigned to the object.
     *
     * @param geometry — List of vertices representing points on the line loop.
     * @param material — Material for the line. Default is LineBasicMaterial.
     */
    @JsConstructor
    public LineLoop(AbstractGeometry geometry, Material material) {

    }
}
