package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Dual PerspectiveCameras used for effects such as 3D Anaglyph or Parallax Barrier.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/19/18.
 */
@JsType(isNative = true, name = "THREE.StereoCamera", namespace = JsPackage.GLOBAL)
public class StereoCamera {

    /**
     *     Default is 1.
     */
    public float aspect;

    /**
     *     Default is 0.064.
     */
    public float eyeSep;

    /**
     *     Left camera. This is added to layer 1 - objects to be rendered by the left camera must also be added to this layer.
     */
    public PerspectiveCamera cameraL;

    /**
     *     Right camera.This is added to layer 2 - objects to be rendered by the right camera must also be added to this layer.
     */
    public PerspectiveCamera cameraR;

    @JsConstructor
    public StereoCamera(){

    }

    /**
     * Update the stereo cameras based on the camera passed in.
     * @param camera instance of camera
     */
    public native void update(Camera camera);
}
