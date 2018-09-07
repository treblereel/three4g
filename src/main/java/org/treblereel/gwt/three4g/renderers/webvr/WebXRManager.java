package org.treblereel.gwt.three4g.renderers.webvr;

import elemental2.gamepad.Gamepad;
import elemental2.vr.VRDisplay;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.ArrayCamera;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.renderers.OnAnimate;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 7/9/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class WebXRManager {

    public boolean enabled;

    public boolean isPresenting;

    public String frameOfReferenceType;

    public WebXRManager(WebGLRenderer renderer){

    }

    public native Gamepad getController(String id);

    public native VRDisplay getDevice();

    public native void setDevice(VRDisplay device);

    public native void setSession(Object session);

    public native ArrayCamera getCamera();

    public native void dispose();

    public native void submitFrame();

    public native Matrix4 getStandingMatrix();

    public native void setFrameOfReferenceType(String frameOfReferenceType);

    /**
     * A build in function that can be used instead of requestAnimationFrame. For WebVR projects this function must be used.
     *
     * @param callback — The function will be called every available frame. If `null` is passed it will stop any already ongoing animation.
     */
    public native void setAnimationLoop(OnAnimate callback);
}
