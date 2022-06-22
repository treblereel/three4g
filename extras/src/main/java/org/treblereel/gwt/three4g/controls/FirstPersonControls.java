package org.treblereel.gwt.three4g.controls;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.FirstPersonControls", namespace = JsPackage.GLOBAL)
public class FirstPersonControls {

    public FirstPersonControls(Camera object) {

    }

    public FirstPersonControls(Camera object, HTMLElement domElement) {

    }

    public Camera object;
    public HTMLElement domElement;

    public boolean enabled;
    public double movementSpeed;
    public double lookSpeed;
    public boolean lookVertical;
    public boolean autoForward;
    public boolean activeLook;
    public boolean heightSpeed;
    public double heightCoef;
    public double heightMin;
    public double heightMax;
    public boolean constrainVertical;
    public double verticalMin;
    public double verticalMax;
    public boolean mouseDragOn;

    public native void handleResize();

    public native FirstPersonControls lookAt(double x, double y, double z);

    public native FirstPersonControls lookAt(Vector3 x, double y, double z);

    public native FirstPersonControls update(double delta);

    public native void dispose();
}
