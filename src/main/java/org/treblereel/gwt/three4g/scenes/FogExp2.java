package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/9/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class FogExp2 extends Fog {

    /**
     * Defines how fast the fog will grow dense.
     * Default is 0.00025.
     */
    public float density;

    /**
     * The color parameter is passed to the Color constructor to set the color property. Color can be a hexadecimal integer or a CSS-style string.
     *
     * @param color   instance of Color
     * @param density as float value
     */
    public FogExp2(Color color, float density) {

    }

    /**
     * The color parameter is passed to the Color constructor to set the color property. Color can be a hexadecimal integer or a CSS-style string.
     *
     * @param color   instance of Color
     * @param density as float value
     */
    public FogExp2(int color, float density) {

    }

    /**
     * Returns a new FogExp2 instance with the same parameters as this one.
     *
     * @return instance of FogExp2
     */
    public native FogExp2 clone();

    /**
     * Return FogExp2 data in JSON format.
     *
     * @return JSON String
     */
    public native String toJSON();
}
