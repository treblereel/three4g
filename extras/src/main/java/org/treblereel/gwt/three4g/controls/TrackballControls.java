package org.treblereel.gwt.three4g.controls;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.events.EventDispatcher;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.TrackballControls", namespace = JsPackage.GLOBAL)
public class TrackballControls extends EventDispatcher {

    public TrackballControls(Camera object) {

    }

    public TrackballControls(Camera object, HTMLElement domElement) {

    }

    public Camera object;
    public HTMLElement domElement;

    // API
    public boolean enabled;
    public Object screen; //: { left: number; top: number; width: number; height: number };
    public double rotateSpeed;
    public double  zoomSpeed;
    public double  panSpeed;
    public boolean noRotate;
    public boolean noZoom;
    public boolean noPan;
    public boolean noRoll;
    public boolean staticMoving;
    public double  dynamicDampingFactor;
    public double  minDistance;
    public double  maxDistance;
    public String[] keys;
    public Object mouseButtons; //: { LEFT: MOUSE; MIDDLE: MOUSE; RIGHT: MOUSE };

    public Vector3 target;
    public Vector3 position0;
    public Vector3 target0;
    public Vector3 up0;

    public native void update();

    public native void reset();

    public native void  dispose();

    public native void checkDistances();

    public native void zoomCamera();

    public native void panCamera();

    public native void rotateCamera();

    public native void handleResize();
}
