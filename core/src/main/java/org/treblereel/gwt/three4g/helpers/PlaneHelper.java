package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * Helper object to visualize a Plane.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.PlaneHelper", namespace = JsPackage.GLOBAL)
public class PlaneHelper extends LineSegments {

    /**
     * The plane being visualized.
     */
    public Plane plane;

    /**
     * The side lengths of plane helper.
     */
    public float size;

    /**
     * Creates a new wireframe representation of the passed plane.
     *
     * @param plane -- the plane to visualize.
     */
    public PlaneHelper(Plane plane) {

    }

    /**
     * Creates a new wireframe representation of the passed plane.
     *
     * @param plane -- the plane to visualize.
     * @param size  --  side length of plane helper. Default is 1.
     */
    public PlaneHelper(Plane plane, float size) {

    }

    /**
     * Creates a new wireframe representation of the passed plane.
     *
     * @param plane -- the plane to visualize.
     * @param size  --  side length of plane helper. Default is 1.
     * @param color --  the color of the helper. Default is 0xffff00.
     */
    public PlaneHelper(Plane plane, float size, Color color) {

    }

    /**
     * This overrides the method in the base Object3D class so that it also updates the wireframe box to the extent of the .box property.
     */
    public native void updateMatrixWorld(boolean force);
}
