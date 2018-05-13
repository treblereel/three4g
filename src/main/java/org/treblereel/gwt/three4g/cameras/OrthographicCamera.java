package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Camera that uses orthographic projection.
 * <p>
 * In this projection mode, an object's size in the rendered image stays constant regardless of its distance from the camera.
 * <p>
 * This can be useful for rendering 2D scenes and UI elements, amongst other things.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/18/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class OrthographicCamera extends Camera {


    /**
     * Camera frustum bottom plane.
     */
    public float bottom;

    /**
     * Camera frustum far plane. Default is 2000.
     */
    public float far;

    /**
     * The valid range is between the current value of the near plane and infinity.
     * Used to test whether this or derived classes are OrthographicCameras. Default is true.
     * <p>
     * This should not be changed as it is used internally by the renderer for optimisation.
     */
    public boolean isOrthographicCamera;

    /**
     * Camera frustum left plane.
     */
    public float left;

    /**
     * Camera frustum near plane. Default is 0.1.
     * <p>
     * The valid range is between 0 and the current value of the far plane. Note that, unlike for the PerspectiveCamera, 0 is a valid value for an OrthographicCamera's near plane.
     */
    public float near;

    /**
     * Camera frustum right plane.
     */
    public float right;

    /**
     * Camera frustum top plane.
     */
    public float top;

    /**
     * Set by setViewOffset. Default is null.
     */
    public float view;

    /**
     * Gets or sets the zoom factor of the camera. Default is 1.
     */
    public float zoom;

    /**
     * Together these define the camera's viewing frustum.
     *
     * @param left   — Camera frustum left plane.
     * @param right  — Camera frustum right plane.
     * @param top    — Camera frustum top plane.
     * @param bottom — Camera frustum bottom plane.
     * @param near   — Camera frustum near plane.
     * @param far    — Camera frustum far plane.
     */
    @JsConstructor
    public OrthographicCamera(Number left, Number right, Number top, Number bottom, Number near, Number far) {

    }

    /**
     * Sets an offset in a larger viewing frustum. This is useful for multi-window or multi-monitor/multi-machine setups. For an example on how to use it see PerspectiveCamera.
     *
     * @param fullWidth  — full width of multiview setup
     * @param fullHeight — full height of multiview setup
     * @param x          — horizontal offset of subcamera
     * @param y          — vertical offset of subcamera
     * @param width      — width of subcamera
     * @param height     — height of subcamera
     */
    public native void setViewOffset(float fullWidth, float fullHeight, float x, float y, float width, float height);

    /**
     * Removes any offset set by the .setViewOffset method.
     */
    public native void clearViewOffset();

    /**
     * Updates the camera projection matrix. Must be called after any change of parameters.
     */
    public native void updateProjectionMatrix();

    /**
     * @return the camera's data in JSON format.
     */
    public native String toJSON();

}
