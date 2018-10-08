package org.treblereel.gwt.three4g.extensions.vr.daydream;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.Object3D;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/28/18.
 */
@Three4gElement(paths = "js/vr/daydream/DaydreamController.js")
@JsType(isNative = true, namespace = "THREE")
@Deprecated
public class DaydreamController extends Object3D {

    /**
     * default false
     */
    public boolean matrixAutoUpdate;

    public native void update();

    public native boolean getTouchpadState();


}
