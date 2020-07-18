package org.treblereel.gwt.three4g.scenes;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.math.Color;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 2/27/18.
 */
@JsType(isNative = true, name = "THREE.Fog", namespace = JsPackage.GLOBAL)
public class Fog extends PropertyHolder {

    /**
     * Optional name of the object (doesn't need to be unique). Default is an empty string.
     */
    public String name;

    /**
     * Fog color. Example: If set to black, far away objects will be rendered black.
     */
    public Color color;

    /**
     * The minimum distance to start applying fog. Objects that are less than 'near' units from the active camera won't be affected by fog.
     * Default is 1.
     */
    public float near;

    /**
     * The maximum distance at which fog stops being calculated and applied. Objects that are more than 'far' units away from the active camera won't be affected by fog.
     * Default is 1000.
     */
    public float far;

    public Fog() {

    }

    /**
     * The color parameter is passed to the Color constructor to set the color property. Color can be a hexadecimal integer or a CSS-style string.
     *
     * @param color color code
     */
    public Fog(int color) {

    }

    /**
     * The color parameter is passed to the Color constructor to set the color property. Color can be a hexadecimal integer or a CSS-style string.
     *
     * @param color color code
     * @param near  as float value
     */
    public Fog(int color, float near) {

    }

    /**
     * The color parameter is passed to the Color constructor to set the color property. Color can be a hexadecimal integer or a CSS-style string.
     *
     * @param color color code
     * @param near  as float value
     * @param far   as float value
     */
    public Fog(int color, float near, float far) {

    }

    /**
     * Returns a new fog instance with the same parameters as this one.
     *
     * @return instance of Fog
     */
    public native Fog clone();

    /**
     * Convert the fog to three.js JSON format.
     *
     * @return JSON String
     */
    public native Object toJSON();
}
