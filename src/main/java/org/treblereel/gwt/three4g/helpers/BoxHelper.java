package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * Helper object to show the world-axis-aligned bounding box around an object. Note that the object must have a Geometry
 * or BufferGeometry for this to work, so it won't work with Sprites.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class BoxHelper extends LineSegments {

    /**
     * Creates a new wireframe box that bounds the passed object. Internally this uses Box3.setFromObject to calculate the dimensions. Note that this includes any children.
     */
    public BoxHelper() {

    }

    /**
     * Creates a new wireframe box that bounds the passed object. Internally this uses Box3.setFromObject to calculate the dimensions. Note that this includes any children.
     *
     * @param object -- the object3D to show the world-axis-aligned boundingbox.
     */
    public BoxHelper(Object3D object) {

    }

    /**
     * Creates a new wireframe box that bounds the passed object. Internally this uses Box3.setFromObject to calculate the dimensions. Note that this includes any children.
     *
     * @param color -- hexadecimal value that defines the box's color. Default is 0xffff00.
     */
    public BoxHelper(Color color) {

    }

    /**
     * Creates a new wireframe box that bounds the passed object. Internally this uses Box3.setFromObject to calculate the dimensions. Note that this includes any children.
     *
     * @param object -- the object3D to show the world-axis-aligned boundingbox.
     * @param color  -- hexadecimal value that defines the box's color. Default is 0xffff00.
     */
    public BoxHelper(Object3D object, Color color) {

    }

    /**
     * Updates the helper's geometry to match the dimensions of the object, including any children. See Box3.setFromObject.
     */
    public native void update();

    /**
     * Updates the wireframe box for the passed object.
     *
     * @param object - Object3D to create the helper of.
     * @return BoxHelper
     */
    public native BoxHelper setFromObject(Object3D object);

}
