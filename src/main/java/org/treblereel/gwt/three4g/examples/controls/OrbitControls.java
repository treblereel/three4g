package org.treblereel.gwt.three4g.examples.controls;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.EventDispatcher;
import org.treblereel.gwt.three4g.core.Keys;
import org.treblereel.gwt.three4g.core.Mouse;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Orbit controls allow the camera to orbit around a target.
 * To use this, as with all files in the /examples directory, you will have to include the file seperately in your HTML.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/13/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class OrbitControls extends EventDispatcher {

    /**
     * Set to true to automatically rotate around the target.
     * Note that if this is enabled, you must call .update () in your animation loop.
     */
    public boolean autoRotate;

    /**
     * How fast to rotate around the target if # .autoRotate : Booleanis true. Default is 2.0, which equates to 30 seconds per rotation at 60fps.
     * Note that if # .autoRotate : Booleanis enabled, you must call .update () in your animation loop.
     */
    public float autoRotateSpeed;

    /**
     * The damping inertia used if # .enableDamping : Booleanis set to true.
     * Note that for this to work, you must call .update () in your animation loop.
     */
    public float dampingFactor;

    /**
     * The HTMLDOMElement used to listen for mouse / touch events. This must be passed in the constructor; changing it here will not set up new event listeners. Default is the whole document.
     */
    public HTMLElement domElement;

    /**
     * Whether or not the controls are enabled.
     */
    public boolean nabled;

    /**
     * Set to true to enable damping (inertia), which can be used to give a sense of weight to the controls. Default is false.
     * Note that if this is enabled, you must call .update () in your animation loop.
     */
    public boolean enableDamping;

    /**
     * Enable or disable the use of keyboard controls.
     */
    public boolean enableKeys;

    /**
     * Enable or disable camera panning. Default is true.
     */
    public boolean enablePan;

    /**
     * Enable or disable horizontal and vertical rotation of the camera. Default is true.
     * Note that it is possible to disable a single axis by setting the min and max of the polar angle or azimuth angle to the same value, which will cause the vertical or horizontal rotation to be fixed at that value.
     */
    public boolean enableRotate;

    /**
     * Enable or disable zooming (dollying) of the camera.
     */
    public boolean enableZoom;

    /**
     * How fast to pan the camera when the keyboard is used. Default is 7.0 pixels per keypress.
     */
    public float keyPanSpeed;

    /**
     * This object contains references to the keycodes for controlling camera panning. Default is the 4 arrow keys.
     * controls.keys = {
     * LEFT: 37, //left arrow
     * UP: 38, // up arrow
     * RIGHT: 39, // right arrow
     * BOTTOM: 40 // down arrow
     * }
     */
    public Keys keys;

    /**
     * How far you can orbit horizontally, upper limit. Range is - Math.PI to Math.PI ( or Infinity for no limit ) and default is Infinity;
     */
    public float maxAzimuthAngle;

    /**
     * How far you can dolly out ( PerspectiveCamera only ). Default is Infinity.
     */
    public float maxDistance;

    /**
     * How far you can orbit vertically, upper limit. Range is 0 to Math.PI radians, and default is Math.PI.
     */
    public float maxPolarAngle;

    /**
     * How far you can zoom out ( OrthographicCamera only ). Default is Infinity.
     */
    public float maxZoom;

    /**
     * How far you can orbit horizontally, lower limit. Range is - Math.PI to Math.PI ( or - Infinity for no limit ) and default is - Infinity;
     */
    public float minAzimuthAngle;

    /**
     * How far you can dolly in ( PerspectiveCamera only ). Default is 0.
     */
    public float minDistance;

    /**
     * How far you can orbit vertically, lower limit. Range is 0 to Math.PI radians, and default is 0.
     */
    public float minPolarAngle;

    /**
     * How far you can zoom in ( OrthographicCamera only ). Default is 0.
     */
    public float minZoom;

    /**
     * This object contains references to the mouse buttons used for the controls.
     * controls.mouseButtons = {
     * ORBIT: THREE.MOUSE.LEFT,
     * ZOOM: THREE.MOUSE.MIDDLE,
     * PAN: THREE.MOUSE.RIGHT
     * }
     */
    public MouseButtons mouseButtons;

    /**
     * The camera being controlled.
     */
    public Camera camera;

    /**
     * Speed of panning. Default is 1.
     */
    public float panSpeed;

    /**
     * Speed of rotation. Default is 1.
     */
    public float rotateSpeed;

    /**
     * Defines how the camera's position is translated when panning. If true, the camera pans in screen space. Otherwise, the camera pans in the plane orthogonal to the camera's up direction. Default is false.
     */
    public boolean screenSpacePanning;

    /**
     * The focus point of the controls, the .object orbits around this. It can be updated manually at any point to change the focus of the controls.
     */
    public Vector3 target;

    /**
     * Speed of zooming / dollying. Default is 1.
     */
    public float zoomSpeed;

    /**
     * @param camera The camera to be controlled.
     */
    @JsConstructor
    public OrbitControls(Camera camera) {

    }

    /**
     * @param camera      The camera to be controlled.
     * @param domElement: (optional) The HTML element used for event listeners. By default this is the whole document, however if you only want to the controls to work over a specific element (e.g. the canvas) you can specify that here.
     */
    @JsConstructor
    public OrbitControls(Camera camera, HTMLElement domElement) {

    }

    /**
     * Remove all the event listeners.
     */
    public native void dispose();

    /**
     * @return Get the current horizontal rotation, in radians.
     */
    public native float getAzimuthalAngle();

    /**
     * Get the current vertical rotation, in radians.
     *
     * @return current vertical rotation
     */
    public native float getPolarAngle();

    /**
     * Reset the controls to their state from either the last time the .saveState was called, or the initial state.
     */
    public native void reset();

    /**
     * Save the current state of the controls. This can later be recovered with .reset.
     */
    public native void saveState();

    /**
     * Update the controls. Must be called after any manual changes to the camera's transform, or in the update loop if .autoRotate or .enableDamping are set.
     */
    public native void update();

}
