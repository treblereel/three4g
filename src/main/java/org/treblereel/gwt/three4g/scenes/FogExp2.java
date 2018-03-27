package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Color;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/9/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class FogExp2 extends Fog{

    /**
     * Defines how fast the fog will grow dense.
     * Default is 0.00025.
     */
    public float density;

    /**
     * The color parameter is passed to the Color constructor to set the color property. Color can be a hexadecimal integer or a CSS-style string.
     *
     * @param color
     * @param density
     */
    @JsConstructor
    public FogExp2(Color color, float density) {

    }

    /**
     * Returns a new FogExp2 instance with the same parameters as this one.
     *
     * @return
     */
    public native FogExp2 clone();

    /**
     * Return FogExp2 data in JSON format.
     *
     * @return
     */
    public native  String toJSON();
}
