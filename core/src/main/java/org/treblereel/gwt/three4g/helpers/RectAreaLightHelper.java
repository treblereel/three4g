package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.lights.RectAreaLight;
import org.treblereel.gwt.three4g.math.Color;

/**
 * Creates a visual aid for a RectAreaLight.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.RectAreaLightHelper", namespace = JsPackage.GLOBAL)
public class RectAreaLightHelper extends RectAreaLight {


    /**
     * The RectAreaLight that is being visualized.
     */
    public RectAreaLight light;

    /**
     * The color parameter passed in the constructor. Default is undefined. If this is changed, the helper's color will update the next time update is called.
     */
    public Color color;

    /**
     * @param light -- The light being visualized.
     */
    public RectAreaLightHelper(RectAreaLight light) {

    }

    /**
     * @param light -- The light being visualized.
     * @param color -- if this is not the set the helper will take the color of the light.
     */
    public RectAreaLightHelper(RectAreaLight light, Color color) {

    }

    /**
     * Dispose of the RectAreaLightHelper.
     */
    public native void dispose();

    /**
     * Updates the helper to match the position and direction of the RectAreaLightHelper being visualized.
     */
    public native void update();
}
