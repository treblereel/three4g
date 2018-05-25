package org.treblereel.gwt.three4g.examples.plugins;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

/**
 * Represents a lookup table for colormaps. It is used to determine the color values from a range of data values.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Lut {

    /**
     * The minimum value to be represented with the lookup table. Default is 0.
     */
    public float minV;

    /**
     * The maximum value to be represented with the lookup table. Default is 1.
     */
    public float maxV;

    public Legend legend;


    public Lut() {

    }

    /**
     * @param colormap - argument that sets a colormap from predefined colormaps. Available colormaps are : "rainbow", "cooltowarm", "blackbody"
     */
    public Lut(String colormap) {

    }

    /**
     * @param colormap       - argument that sets a colormap from predefined colormaps. Available colormaps are : "rainbow", "cooltowarm", "blackbody"
     * @param numberOfColors - argument that sets the number of colors used to represent the data array.
     */
    public Lut(String colormap, int numberOfColors) {

    }

    /**
     * Copies given lut.
     *
     * @param lut — Lut to copy.
     * @return instance of Lut
     */
    public native Lut copy(Lut lut);

    /**
     * Sets this Lut with the legend on.
     *
     * @param legend where:
     *               <p>
     *               parameters - { layout: value, position: { x: value, y: value, z: value }, dimensions: { width: value, height: value } } layout — Horizontal or vertical layout. Default is vertical.
     *               position — The position x,y,z of the legend.
     *               dimensions — The dimensions (width and height) of the legend.
     */
    public native void setLegendOn(Legend legend);

    /**
     * Sets this Lut with the legend off.
     */
    public native void setLegendOff();

    /**
     * @param value -- the data value to be displayed as a color.
     * @return a Color
     */
    public native Color getColor(int value);

    /**
     * Sets this Lut with the minimum value to be represented.
     *
     * @param minV — The minimum value to be represented with the lookup table.
     * @return instance of Lut
     */
    public native Lut setMin(float minV);

    /**
     * Sets this Lut with the maximum value to be represented.
     *
     * @param maxV — The maximum value to be represented with the lookup table.
     * @return instance of Lut
     */
    public native Lut setMax(float maxV);

    /**
     * Sets this Lut with the number of colors to be used.
     *
     * @param numberOfColors — The number of colors to be used to represent the data array.
     * @return instance of Lut
     */
    public native Lut changeNumberOfColors(float numberOfColors);

    /**
     * Sets this Lut with the colormap to be used.
     *
     * @param colorMap — The name of the color map to be used to represent the data array.
     * @return instance of Lut
     */
    public native Lut changeColorMap(float colorMap);

    /**
     * Insert a new color map into the set of available color maps.
     *
     * @param colorMapName — The name of the color map to be used to represent the data array.
     * @param arrayOfColors - array of colors
     * @return instance of Lut
     */
    public native Lut addColorMap(String colorMapName, Object[] arrayOfColors); //TODO
}
