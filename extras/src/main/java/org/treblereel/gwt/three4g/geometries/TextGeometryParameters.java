package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.loaders.Font;

@JsType(isNative = true, name = "THREE.TextGeometryParameters", namespace = JsPackage.GLOBAL)
public interface TextGeometryParameters {

    @JsOverlay
    static TextGeometryParameters create() {
        return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    Font getFont();

    @JsProperty
    void setFont(Font font);

    @JsProperty
    double getSize();

    @JsProperty
    void setSize(double size);

    @JsProperty
    double getHeight();

    @JsProperty
    void setHeight(double height);

    @JsProperty
    double getCurveSegments();

    @JsProperty
    void setCurveSegments(double curveSegments);

    @JsProperty
    double getBevelEnabled();

    @JsProperty
    void setBevelEnabled(boolean bevelEnabled);

    @JsProperty
    double getBevelThickness();

    @JsProperty
    void setBevelThickness(double bevelThickness);

    @JsProperty
    double getBevelSize();

    @JsProperty
    void setBevelSize(double bevelSize);

    @JsProperty
    double getBevelOffset();

    @JsProperty
    void setBevelOffset(double bevelOffset);

    @JsProperty
    double getBevelSegments();

    @JsProperty
    void setBevelSegments(double bevelSegments);
}
