package org.treblereel.gwt.three4g.demo.client.api;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.extensions.vr.vive.ViveController;
import org.treblereel.gwt.three4g.math.Color;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/5/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PaintViveController extends ViveController {

    public PaintViveController(int value) {
        super(value);
    }

    public native Color getColor();

    public native int getSize();

}
