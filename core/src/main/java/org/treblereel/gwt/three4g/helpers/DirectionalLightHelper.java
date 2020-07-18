package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.DirectionalLight;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.Line;

/**
 * Helper object to assist with visualizing a DirectionalLight's effect on the scene. This consists of plane and a line
 * representing the light's position and direction.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.DirectionalLightHelper", namespace = JsPackage.GLOBAL)
public class DirectionalLightHelper extends Object3D {

    /**
     * Contains the line mesh showing the location of the directional light.
     */
    public Line lightPlane;

    /**
     * Reference to the directionalLight being visualized.
     */
    public DirectionalLight light;

    /**
     * Reference to the light's matrixWorld.
     */
    public Matrix4 matrix;

    /**
     * See Object3D.matrixAutoUpdate. Set to false here as the helper is using the light's matrixWorld.
     */
    public boolean matrixAutoUpdate;

    /**
     * The color parameter passed in the constructor. Default is undefined. If this is changed, the helper's color will update the next time update is called.
     */
    public Number color;

    /**
     * @param light-- The light to be visualized.
     */
    public DirectionalLightHelper(DirectionalLight light) {

    }


    /**
     * @param light-- The light to be visualized.
     * @param size    -- (optional) dimensions of the plane. Default is 1.
     */
    public DirectionalLightHelper(DirectionalLight light, int size) {

    }

    /**
     * @param light-- The light to be visualized.
     * @param size    -- (optional) dimensions of the plane. Default is 1.
     * @param color   -- (optional) if this is not the set the helper will take the color of the light.
     */
    public DirectionalLightHelper(DirectionalLight light, int size, Number color) {

    }

    /**
     * Dispose of the directionalLightHelper.
     */
    public native void dispose();

    /**
     * Updates the helper to match the position and direction of the directionalLight being visualized.
     */
    public native void update();
}
