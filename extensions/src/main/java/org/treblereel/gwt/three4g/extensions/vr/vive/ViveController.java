package org.treblereel.gwt.three4g.extensions.vr.vive;

import elemental2.gamepad.Gamepad;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Matrix4;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 6/4/18.
 */
@Three4gElement(paths = "js/vr/vive/ViveController.js")
@JsType(isNative = true, namespace = "THREE")
public class ViveController extends Object3D {

    public Matrix4 standingMatrix;

    public boolean matrixAutoUpdate;

    public ViveController(int value) {

    }

    public native void update();

    public native Gamepad getGamepad();

    public native Gamepad findGamepad(int id);

    public native boolean getButtonState(String button);

}
