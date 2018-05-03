package org.treblereel.gwt.three4g.geometries.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Font;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TextGeometryParameters {

    public Font font; // — an instance of THREE.Font.
    public float size; //  — Size of the text. Default is 100.
    public float height;// - Thickness to extrude text. Default is 50.
    public int curveSegments;// -  Number of points on the curves. Default is 12.
    public boolean bevelEnabled; // — Turn on bevel. Default is False.
    public float bevelThickness; // -  How deep into text bevel goes. Default is 10.
    public float bevelSize; // - How far from text outline is bevel. Default is 8.
    public int bevelSegments; // -  Number of bevel segments. Default is 3.
}
