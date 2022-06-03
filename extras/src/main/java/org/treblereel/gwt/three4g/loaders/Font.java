package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extras.core.Shape;

@JsType(isNative = true, name = "THREE.Font", namespace = JsPackage.GLOBAL)
public class Font {

    public String type, data;

    public native Shape[] generateShapes(String text, int size);
}
