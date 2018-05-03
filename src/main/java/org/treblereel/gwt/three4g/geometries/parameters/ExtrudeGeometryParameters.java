package org.treblereel.gwt.three4g.geometries.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/3/18.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ExtrudeGeometryParameters {

    public int curveSegments; // Number of points on the curves. Default is 12.
    public int steps; // Number of points used for subdividing segments along the depth of the extruded spline. Default is 1.
    public int amount; // Depth to extrude the shape. Default is 100.
    public boolean bevelEnabled; // Apply beveling to the shape. Default is true.
    public float bevelThickness; // How deep into the original shape the bevel goes. Default is 6.
    public float bevelSize; // Distance from the shape outline that the bevel extends. Default is bevelThickness - 2.
    public int bevelSegments; // Number of bevel layers. Default is 3.
    public int  extrudePath; // THREE.CurvePath. A 3D spline path along which the shape should be extruded.
    public Object UVGenerator; // — Object. object that provides UV generator functions
}
