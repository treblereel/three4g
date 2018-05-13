package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * The GridHelper is an object to define grids. Grids are two-dimensional arrays of lines.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class GridHelper extends LineSegments {

    /**
     * If no material is supplied, a randomized line material will be created and assigned to the object.
     *
     * @param size            -- The size of the grid. Default is 10.
     * @param divisions       -- The number of divisions across the grid. Default is 10.
     */
    public GridHelper(int size, Number divisions) {

    }

    /**
     * If no material is supplied, a randomized line material will be created and assigned to the object.
     *
     * @param size            -- The size of the grid. Default is 10.
     * @param divisions       -- The number of divisions across the grid. Default is 10.
     * @param colorCenterLine -- The color of the centerline. This can be a Color, a hexadecimal value and an CSS-Color name. Default is 0x444444
     */
    public GridHelper(int size, Number divisions, Color colorCenterLine) {

    }

    /**
     * If no material is supplied, a randomized line material will be created and assigned to the object.
     *
     * @param size            -- The size of the grid. Default is 10.
     * @param divisions       -- The number of divisions across the grid. Default is 10.
     * @param colorCenterLine -- The color of the centerline. This can be a Color, a hexadecimal value and an CSS-Color name. Default is 0x444444
     * @param colorGrid       -- The color of the lines of the grid. This can be a Color, a hexadecimal value and an CSS-Color name. Default is 0x888888
     */
    public GridHelper(int size, Number divisions, Color colorCenterLine, Color colorGrid) {

    }
}
