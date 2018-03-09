package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Camera that uses perspective projection.
 * <p>
 * This projection mode is designed to mimic the way the human eye sees. It is the most common projection mode used for
 * rendering a 3D scene.
 * <p>
 * See the base @see {@link Camera} class for common properties.
 * Note that after making changes to most of these poperties you will have to call .updateProjectionMatrix for the changes
 * to take effect.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 12/6/17.
 */
@JsType(isNative = true, namespace = "THREE")
public class PerspectiveCamera extends Camera {

    /**
     * Camera frustum aspect ratio, usually the canvas width / canvas height. Default is 1 (square canvas).
     */
    public float aspect;

    /**
     * Camera frustum far plane. Default is 2000.
     * <p>
     * The valid range is between the current value of the near plane and infinity.
     */
    public float far;

    /**
     * Film size used for the larger axis. Default is 35 (millimeters). This parameter does not influence the projection
     * matrix unless .filmOffset is set to a nonzero value.
     */
    public float filmGauge;

    /**
     * Horizontal off-center offset in the same unit as .filmGauge. Default is 0.
     */
    public float filmOffset;

    /**
     * Object distance used for stereoscopy and depth-of-field effects. This parameter does not influence the projection
     * matrix unless a StereoCamera is being used. Default is 10.
     */
    public float focus;

    /**
     * Camera frustum vertical field of view, from bottom to top of view, in degrees. Default is 50.
     */
    public float fov;

    /**
     * Used to test whether this or derived classes are PerspectiveCameras. Default is true.
     * <p>
     * This should not be changed as it is used internally by the renderer for optimisation.
     */
    public boolean isPerspectiveCamera;

    /**
     * Camera frustum near plane. Default is 0.1.
     * <p>
     * The valid range is greater than 0 and less than the current value of the far plane. Note that, unlike for the
     * OrthographicCamera, 0 is not a valid value for a PerspectiveCamera's near plane.
     */
    public float near;

    /**
     * Frustum window specification or null. This is set using the .setViewOffset method and cleared using .clearViewOffset.
     */
    public Object view;

    /**
     * Gets or sets the zoom factor of the camera. Default is 1.
     */
    public float zoom;

    //public Vector3 position;


    /**
     * @param fov    — Camera frustum vertical field of view.
     * @param aspect — Camera frustum aspect ratio.
     * @param near   — Camera frustum near plane.
     * @param far    — Camera frustum far plane.
     * Together these define the camera's viewing frustum.
     */
    @JsConstructor
    public PerspectiveCamera(float fov, float aspect, float near, float far) {
    }

    /**
     * Removes any offset set by the .setViewOffset method.
     */
    public native void clearViewOffset();

    /**
     * Returns the current vertical field of view angle in degrees considering .zoom.
     */
    public native float getEffectiveFOV();

    /**
     * Returns the height of the image on the film. If .aspect is less than or equal to one (portrait format),
     * the result equals .filmGauge.
     */
    public native float getFilmHeight();

    /**
     * Returns the width of the image on the film. If .aspect is greater than or equal to one (landscape format),
     * the result equals .filmGauge.
     */
    public native float getFilmWidth();

    /**
     * Returns the focal length of the current .fov in respect to .filmGauge.
     */
    public native float getFocalLength();

    /**
     * Sets the FOV by focal length in respect to the current .filmGauge.
     * <p>
     * By default, the focal length is specified for a 35mm (full frame) camera.
     */
    public native void setFocalLength(float focalLength);

    /**
     * Sets an offset in a larger frustum. This is useful for multi-window or multi-monitor/multi-machine setups.
     * For example, if you have 3x2 monitors and each monitor is 1920x1080 and the monitors are in grid like this:
     * +---+---+---+
     * | A | B | C |
     * +---+---+---+
     * | D | E | F |
     * +---+---+---+
     * <p>
     * then for each monitor you would call it like this:
     * var w = 1920;
     * var h = 1080;
     * var fullWidth = w * 3;
     * var fullHeight = h * 2;
     * <p>
     * // A
     * camera.setViewOffset( fullWidth, fullHeight, w * 0, h * 0, w, h );
     * // B
     * camera.setViewOffset( fullWidth, fullHeight, w * 1, h * 0, w, h );
     * // C
     * camera.setViewOffset( fullWidth, fullHeight, w * 2, h * 0, w, h );
     * // D
     * camera.setViewOffset( fullWidth, fullHeight, w * 0, h * 1, w, h );
     * // E
     * camera.setViewOffset( fullWidth, fullHeight, w * 1, h * 1, w, h );
     * // F
     * camera.setViewOffset( fullWidth, fullHeight, w * 2, h * 1, w, h ); Note there is no reason monitors have to be the same size or in a grid.
     *
     * @param fullWidth  — full width of multiview setup
     * @param fullHeight — full height of multiview setup
     * @param x          — horizontal offset of subcamera
     * @param y          — vertical offset of subcamera
     * @param width      — width of subcamera
     * @param height     — height of subcamera
     */
    public native void setViewOffset(float fullWidth, float fullHeight, float x, float y, float width, float height );

    /**
     * Updates the camera projection matrix. Must be called after any change of parameters.
     */
    public native void updateProjectionMatrix();

    /**
     * Return camera data in JSON format.
     *
     * @return String
     */
    public native String toJSON();
}
