package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.TextGeometry", namespace = JsPackage.GLOBAL)
public class TextGeometry extends ExtrudeGeometry {

    public String type;

    public TextGeometry(String text, TextGeometryParameters params) {

    }
}
