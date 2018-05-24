package org.treblereel.gwt.three4g.examples.controls;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Mouse;


/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/24/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class MouseButtons {

    public Mouse ORBIT; // LEFT
    public Mouse ZOOM; // MIDDLE
    public Mouse PAN; // RIGHT

}
