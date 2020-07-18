package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * This helps with visualizing what a camera contains in its frustum.
 * It visualizes the frustum of a camera using a LineSegments.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/19/18.
 */
@JsType(isNative = true, name = "THREE.CameraHelper", namespace = JsPackage.GLOBAL)
public class CameraHelper extends LineSegments {

    /**
     * The camera being visualized.
     */
    public Camera camera;

    /**
     * This contains the points used to visualize the camera.
     */
    public Object pointMap; //TODO

    /**
     * Reference to the camera.matrixWorld.
     */
    public Object matrix; //TODO


    /**
     * See Object3D.matrixAutoUpdate. Set to false here as the helper is using the camera's matrixWorld.
     */
    public boolean matrixAutoUpdate;

    /**
     * This create a new CameraHelper for the specified camera.

     * @param camera -- The camera to visualize.
     */
    @JsConstructor
    public CameraHelper(Camera camera){

    }

    /**
     * Updates the helper based on the projectionMatrix of the camera.
     */
    public native void update();

}
