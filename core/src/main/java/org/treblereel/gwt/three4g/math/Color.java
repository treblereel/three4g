package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;
import org.treblereel.gwt.three4g.core.PropertyHolder;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 2/28/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Color extends PropertyHolder {

    /**
     * Used to check whether this or derived classes are Colors. Default is true.
     * You should not change this, as it used internally for optimisation.
     */
    public boolean isColor;

    /**
     * Red channel value between 0 and 1. Default is 1.
     */
    public float r;

    /**
     * Green channel value between 0 and 1. Default is 1.
     */
    public float g;

    /**
     * Blue channel value between 0 and 1. Default is 1.
     */
    public float b;


    /**
     * r - (optional) If arguments g and b are defined, the red component of the color. If they are not defined, it can be a hexadecimal triplet (recommended), a CSS-style string, or another Color instance.
     * g - (optional) If it is defined, the green component of the color.
     * b - (optional) If it is defined, the blue component of the color.
     * <p>
     * Note that standard method of specifying color in three.js is with a hexadecimal triplet, and that method is used throughout the rest of the documentation.
     * <p>
     * When all arguments are defined then r is the red component, g is the green component and b is the blue component of the color.
     * When only r is defined:
     * It can be a hexadecimal triplet representing the color (recommended).
     * It can be an another Color instance.
     * It can be a CSS-style string. For example:
     * 'rgb(250, 0,0)'
     * 'rgb(100%,0%,0%)'
     * 'hsl(0, 100%, 50%)'
     * '#ff0000'
     * '#f00'
     * 'red'
     */
    @JsConstructor
    public Color() {

    }

    @JsConstructor
    public Color(float r) {

    }

    @JsConstructor
    public Color(String color) {

    }


    @JsConstructor
    public Color(float r, float g, float b) {

    }

    /**
     * Adds the RGB values of color to the RGB values of this color.
     *
     * @param color Color
     * @return Color
     */
    public native Color add(Color color);

    /**
     * Sets this color's RGB values to the sum of the RGB values of color1 and color2.
     *
     * @param color1 Color1
     * @param color2 Color2
     * @return Color
     */
    public native Color adds(Color color1, Color color2);

    /**
     * Adds s to the RGB values of this color.
     *
     * @param s float
     * @return Color
     */
    public native Color addScalar(float s);

    /**
     * Returns a new Color with the same r, g and b values as this one.
     *
     * @return Color
     */
    public native Color clone();

    /**
     * Copies the r, g and b parameters from color in to this color.
     *
     * @param color Color
     * @return Color
     */
    public native Color copy(Color color);

    /**
     * Converts this color from gamma to linear space by squaring the values of r, g and b ).
     *
     * @return Color
     */
    public native Color convertGammaToLinear();

    /**
     * Converts this color from gamma to linear space by squaring the values of r, g and b ).
     *
     * @param gammaFactor - Default is 2.0.
     * @return Color
     */
    public native Color convertGammaToLinear(float gammaFactor);


    /**
     * Converts this color from linear to gamma space by taking the square root of r, g and b).
     *
     * @return Color
     */
    public native Color convertLinearToGamma();

    /**
     * Converts this color from gamma to linear space by taking r, g and b to the power of gammaFactor.
     *
     * @param gammaFactor - Default is 2.0.
     * @return Color
     */
    public native Color convertLinearToGamma(float gammaFactor);


    /**
     * Converts this color from linear space to sRGB space.
     *
     * @return Color
     */
    public native Color convertLinearToSRGB();

    /**
     * Converts this color from sRGB space to linear space.
     *
     * @return Color
     */
    public native Color convertSRGBToLinear();


    /**
     * Copies the given color into this color, and then converts this color from gamma space to linear space by taking r, g and b to the power of gammaFactor.
     *
     * @param color — Color to copy.
     * @return Color
     */
    public native Color copyGammaToLinear(Color color);


    /**
     * Copies the given color into this color, and then converts this color from gamma space to linear space by taking r, g and b to the power of gammaFactor.
     *
     * @param color       — Color to copy.
     * @param gammaFactor - Default is 2.0.
     * @return Color
     */
    public native Color copyGammaToLinear(Color color, float gammaFactor);

    /**
     * Copies the given color into this color while converting it from linear to gamma space by taking r, g and b to the power of 1 / gammaFactor.
     *
     * @param color — Color to copy.
     * @return Color
     */
    public native Color copyLinearToGamma(Color color);

    /**
     * Copies the given color into this color while converting it from linear to gamma space by taking r, g and b to the power of 1 / gammaFactor.
     *
     * @param color       — Color to copy.
     * @param gammaFactor - Default is 2.0.
     * @return Color
     */
    public native Color copyLinearToGamma(Color color, float gammaFactor);

    /**
     * Copies the given color into this color, and then converts this color from linear space to sRGB space.
     *
     * @param color — Color to copy.
     * @return Color
     */
    public native Color copyLinearToSRGB(Color color);

    /**
     * Copies the given color into this color, and then converts this color from sRGB space to linear space.
     *
     * @param color — Color to copy.
     * @return Color
     */
    public native Color copySRGBToLinear(Color color);

    /**
     * Compares the RGB values of color with those of this object. Returns true if they are the same, false otherwise.
     *
     * @param color Colot to compare
     * @return boolean
     */
    public native boolean equals(Color color);

    /**
     * Sets this color's components based on an array formatted like [ r, g, b ].
     *
     * @param array - Array of floats in the form [ r, g, b ].
     * @return Color
     */
    public native Color fromArray(float[] array);

    /**
     * Sets this color's components based on an array formatted like [ r, g, b ].
     *
     * @param array  - Array of floats in the form [ r, g, b ].
     * @param offset - An optional offset into the array.
     * @return Color
     */
    public native Color fromArray(float[] array, int offset);

    /**
     * Returns the hexadecimal value of this color
     *
     * @return int
     */
    public native int getHex();

    /**
     * Returns the hexadecimal value of this color as a string (for example, 'FFFFFF').
     *
     * @return int
     */
    public native String getHexString();

    /**
     * Convert this Color's r, g and b values to HSL format and returns an object of the form:
     * { h: 0, s: 0, l: 0 }
     *
     * @param obj Object
     * @return Object
     */
    public native Object getHSL(Object obj); //TODO

    /**
     * Returns the value of this color as a CSS style string. Example: 'rgb(255,0,0)'.
     *
     * @return CSS style string
     */
    public native String getStyle();


    /**
     * Linearly interpolates this color's RGB values toward the RGB values of the passed argument.
     * The alpha argument can be thought of as the ratio between the two colors, where 0.0 is this color
     * and 1.0 is the first argument.
     *
     * @param color - color to converge on.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Color
     */
    public native Color lerp(Color color, float alpha);

    /**
     * Linearly interpolates this color's HSL values toward the HSL values of the passed argument.
     * It differs from the classic .lerp by not interpolating straight from one color to the other,
     * but instead going through all the hues in between those two colors. The alpha argument can
     * be thought of as the ratio between the two colors, where 0.0 is this color and 1.0 is the first argument.
     *
     * @param color - color to converge on.
     * @param alpha - interpolation factor in the closed interval [0, 1].
     * @return Color
     */
    public native Color lerpHSL(Color color, float alpha);

    /**
     * Multiplies this color's RGB values by the given color's RGB values.
     *
     * @param color Color
     * @return Color
     */
    public native Color multiply(Color color);

    /**
     * Multiplies this color's RGB values by s.
     *
     * @param scalar Scalar
     * @return Color
     */
    public native Color multiplyScalar(float scalar);

    /**
     * Adds the given h, s, and l to this color's values. Internally, this converts the color's r, g and b values to
     * HSL, adds h, s, and l, and then converts the color back to RGB.
     *
     * @param h hue
     * @param s saturation
     * @param l lightness
     * @return Color
     */
    public native Color offsetHSL(float h, float s, float l);

    /**
     * Color, Hex or String
     * <p>
     * See the Constructor above for full details of what value can be. Delegates to .copy,
     * .setStyle, or .setHex depending on input type.
     *
     * @param value - Value to set this color to.
     * @return Color
     */
    public native Color set(Object value);

    /**
     * Sets this color from a hexadecimal value.
     *
     * @param hex — hexadecimal triplet format.
     * @return Color
     */
    public native Color setHex(int hex);

    /**
     * Sets color from HSL values.
     *
     * @param h hue
     * @param s saturation
     * @param l lightness
     * @return Color
     */
    public native Color setHSL(float h, float s, float l);

    /**
     * Sets this color from RGB values.
     *
     * @param r — Red channel value between 0.0 and 1.0.
     * @param g — Green channel value between 0.0 and 1.0.
     * @param b — Blue channel value between 0.0 and 1.0.
     * @return Color
     */
    public native Color setRGB(float r, float g, float b);

    /**
     * Sets this color from a CSS-style string. For example, "rgb(250, 0,0)", "rgb(100%, 0%, 0%)", "hsl(0, 100%, 50%)", "#ff0000", "#f00", or "red" ( or any X11 color name - all 140 color names are supported ).
     * Translucent colors such as "rgba(255, 0, 0, 0.5)" and "hsla(0, 100%, 50%, 0.5)" are also accepted, but the alpha-channel coordinate will be discarded.
     * <p>
     * Note that for X11 color names, multiple words such as Dark Orange become the string 'darkorange' (all lowercase).
     *
     * @param style — color as a CSS-style string.
     * @return Color
     */
    public native Color setStyle(String style);

    /**
     * Subtracts the RGB components of the given color from the RGB components of this color. If this results in a negative component, that component is set to zero.
     *
     * @param color input Color
     * @return Color
     */
    public native Color sub(Color color);

    /**
     * Returns an array of the form [ r, g, b ].
     *
     * @return Color
     */
    public native float[] toArray();

    /**
     * Returns an array of the form [ r, g, b ].
     *
     * @param array - An array to store the color to.
     * @return Color
     */
    public native float[] toArray(float[] array);

    /**
     * Returns an array of the form [ r, g, b ].
     *
     * @param array  - An array to store the color to.
     * @param offset - An offset into the array.
     * @return Color
     */
    public native float[] toArray(float[] array, int offset);

    /**
     * Returns an array of the form [ r, g, b ].
     *
     * @param array - An array to store the color to.
     * @return Color
     */
    public native float[] toArray(JsArrayLike array);

    /**
     * Returns an array of the form [ r, g, b ].
     *
     * @param array  - An array to store the color to.
     * @param offset - An offset into the array.
     * @return Color
     */
    public native float[] toArray(JsArrayLike array, int offset);

}
