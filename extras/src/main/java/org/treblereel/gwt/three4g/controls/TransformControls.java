package org.treblereel.gwt.three4g.controls;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.MOUSE;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;


@JsType(isNative = true, name = "THREE.TransformControls", namespace = JsPackage.GLOBAL)
public class TransformControls extends Object3D {


    public TransformControls(Camera camera) {

    }

    public TransformControls(Camera camera, HTMLElement domElement) {

    }

    public HTMLElement domElement;

    // API
    public Camera camera;
    public Object3D object;
    public boolean enabled;

    public String axis; // 'X' | 'Y' | 'Z' | 'E' | 'XY' | 'YZ' | 'XZ' | 'XYZ' | 'XYZE' | null;
    public String mode; // 'translate' | 'rotate' | 'scale';
    public double translationSnap;
    public double rotationSnap;
    public String space; //'world' | 'local';
    public double size;
    public boolean dragging;
    public boolean showX;
    public boolean showY;
    public boolean showZ;
    public boolean isTransformControls;

    public MOUSE mouseButtons;

    public native TransformControls attach(Object3D object);

    public native TransformControls detach();

    public native String getMode(); // 'translate' | 'rotate' | 'scale';

    public native Raycaster getRaycaster();

    public native void setMode(String mode);

    public native void setTranslationSnap(double translationSnap);

    public native void setRotationSnap(double rotationSnap);

    public native void setScaleSnap(double scaleSnap);

    public native void setSize(double size);

    public native void setSpace(String space);

    public native void reset();

    public native void dispose();
}
