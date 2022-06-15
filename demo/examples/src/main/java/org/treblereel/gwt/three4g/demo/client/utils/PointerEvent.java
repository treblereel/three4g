package org.treblereel.gwt.three4g.demo.client.utils;

import elemental2.dom.MouseEvent;
import elemental2.dom.MouseEventInit;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "PointerEvent", namespace = JsPackage.GLOBAL)
public class PointerEvent extends MouseEvent {

    @JsOverlay
    public static PointerEvent of(MouseEvent e) {
        return Js.uncheckedCast(e);
    }

    public PointerEvent(String type, MouseEventInit eventInitDict) {
        super(type, eventInitDict);
    }

    public int pointerId;

    public double width;

    public double height;

    public double pressure;

    public double tiltX;

    public double tiltY;

    public String pointerType;

    public boolean isPrimary;

}
