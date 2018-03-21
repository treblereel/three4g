package org.treblereel.gwt.three4g.lights;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.lights.shadows.LightShadow;

/**
 * This is used internally by DirectionalLights for calculating shadows.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 3/21/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class DirectionalLightShadow extends LightShadow {

    /**
     * The light's view of the world. This is used to generate a depth map of the scene; objects behind other objects
     * from the light's perspective will be in shadow.
     * <p>
     * The default is an OrthographicCamera with left and bottom set to -5, right and top set to 5, the near clipping
     * plane at 0.5 and the far clipping plane at 500.
     */
    public Camera camera;

    @JsConstructor
    DirectionalLightShadow() {

    }

}
