package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.Line;

/**
 * The PolarGridHelper is an object to define polar grids. Grids are two-dimensional arrays of lines.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PolarGridHelper extends Line {


    /**
     * @param radius    -- The radius of the polar grid. This can be any positive number. Default is 10.
     * @param radials   -- The number of radial lines. This can be any positive integer. Default is 16.
     * @param circles   -- The number of circles. This can be any positive integer. Default is 8.
     * @param divisions -- The number of line segments used for each circle. This can be any positive integer that is 3 or greater. Default is 64.
     */
    public PolarGridHelper(Number radius, Number radials, Number circles, Number divisions) {

    }

    /**
     * @param radius    -- The radius of the polar grid. This can be any positive number. Default is 10.
     * @param radials   -- The number of radial lines. This can be any positive integer. Default is 16.
     * @param circles   -- The number of circles. This can be any positive integer. Default is 8.
     * @param divisions -- The number of line segments used for each circle. This can be any positive integer that is 3 or greater. Default is 64.
     * @param color1    -- The first color used for grid elements. This can be a Color, a hexadecimal value and an CSS-Color name. Default is 0x444444
     * @param color2    -- The second color used for grid elements. This can be a Color, a hexadecimal value and an CSS-Color name. Default is 0x888888
     */
    public PolarGridHelper(Number radius, Number radials, Number circles, Number divisions, Color color1, Number color2) {

    }



}
