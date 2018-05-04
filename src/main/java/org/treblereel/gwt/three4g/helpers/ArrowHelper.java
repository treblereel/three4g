package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * An 3D arrow object for visualizing directions.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ArrowHelper extends Object3D {

    /**
     * Contains the line part of the arrowHelper.
     */
    public Line line;

    /**
     * Contains the cone part of the arrowHelper.
     */
    public Mesh cone;

    /**
     * @param dir        -- direction from origin. Must be a unit vector.
     * @param origin     -- Point at which the arrow starts.
     * @param length     -- length of the arrow. Default is 1.
     * @param hex        -- hexadecimal value to define color. Default is 0xffff00.
     * @param headLength -- The length of the head of the arrow. Default is 0.2 * length.
     * @param headWidth  -- The length of the width of the arrow. Default is 0.2 * headLength.
     */
    public ArrowHelper(Vector3 dir, Vector3 origin, Number length, Number hex, Number headLength, Number headWidth) {

    }

    /**
     * @param hex -- The hexadecimal value of the color.
     *            Sets the color of the arrowHelper.
     */
    public native void setColor(Number hex);


    /**
     * Sets the length of the arrowhelper.
     *
     * @param length     -- The desired length.
     * @param headLength -- The length of the head of the arrow.
     * @param headWidth  -- The length of the width of the arrow.
     */
    public native void setLength(Number length, Number headLength, Number headWidth);

    /**
     * Sets the direction of the arrowhelper.
     *
     * @param dir -- The desired direction. Must be a unit vector.
     */
    public native void setDirection(Vector3 dir);

}
