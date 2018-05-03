package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.geometries.parameters.TextGeometryParameters;

/**
 * A class for generating text as a single geometry. It is constructed by providing a string of text, and a hash of
 * parameters consisting of a loaded Font and settings for the geometry's parent ExtrudeGeometry. See the Font, FontLoader
 * and Creating_Text pages for additional details.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class TextGeometry extends Geometry {

    public TextGeometryParameters parameters;

    /**
     * @param text       — The text that needs to be shown.
     * @param parameters — Object that can contains the following parameters.
     */
    public TextGeometry(String text, TextGeometryParameters parameters) {

    }
}
