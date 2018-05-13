package org.treblereel.gwt.three4g.lights.shadows;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.lights.SpotLight;

/**
 * Used to check whether this or derived classes are spot light shadows. Default is true.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SpotLightShadow extends LightShadow {

    /**
     * The light's view of the world. This is used to generate a depth map of the scene; objects behind other objects from
     * the light's perspective will be in shadow.
     * <p>
     * The default is a PerspectiveCamera with near clipping plane at 0.5. The fov will track the angle property of the
     * owning SpotLight via the update method. Similarly, the aspect property will track the aspect of the mapSize. If
     * the distance property of the light is set, the far clipping plane will track that, otherwise it defaults to 500.
     */
    public Camera camera;

    /**
     * Used to check whether this or derived classes are spot light shadows. Default is true.
     */
    public boolean isSpotLightShadow;

    /**
     * Updates the internal perspective camera based on the passed in light.
     * @param light instance of SpotLight
     * @return instance of SpotLightShadow
     */
    public native SpotLightShadow update(SpotLight light);
}
