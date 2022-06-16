package org.treblereel.gwt.three4g.effects;


import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "AsciiEffectOptions", namespace = JsPackage.GLOBAL)
public interface AsciiEffectOptions {

    @JsOverlay
    static AsciiEffectOptions create() {
        return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getResolution();

    @JsProperty
    void setResolution(double rez);

    @JsProperty
    double getScale();

    @JsProperty
    void setScale(double scale);

    @JsProperty
    boolean getColor();

    @JsProperty
    void setColor(boolean color);

    @JsProperty
    boolean getAlpha();

    @JsProperty
    void setAlpha(boolean alpha);

    @JsProperty
    boolean getBlock();

    @JsProperty
    void setBlock(boolean block);

    @JsProperty
    boolean getInvert();

    @JsProperty
    void setInvert(boolean invert);
}
