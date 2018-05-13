package org.treblereel.gwt.three4g.extras.core;

import com.google.gwt.json.client.JSONObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Create a set of Shapes representing a font loaded in JSON format.
 * <p>
 * This is used internally by the FontLoader.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/26/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Font {

    /**
     * Used to check whether this or derived classes are fonts. Default is true.
     * <p>
     * You should not change this, as it used internally by the renderer for optimisation.
     */
    public boolean isFont;

    /**
     * The JSON data passed in the constructor.
     */
    public JSONObject data;

    /**
     * This constructor creates a new Font, which is an array of Shapes.
     * @param data as JSONObject
     */
    @JsConstructor
    public Font(JSONObject data) {

    }

    /**
     * Creates an array of Shapes representing the text in the font.
     *
     * @param text      -- string of text.
     * @param size      -- (optional) scale for the Shapes. Default is 100.
     * @param divisions -- (optional) fineness of the Shapes. Default is 4.
     */
    public native void generateShapes(String text, float size, int divisions);
}
