package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.lights.PointLight;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * This displays a helper object consisting of a spherical Mesh for visualizing a PointLight.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class PointLightHelper extends Mesh {

    /**
     * The PointLight that is being visualized.
     */
    public PointLight light;

    /**
     * Reference to the pointLight's matrixWorld.
     */
    public Matrix4 matrix;

    /**
     * See Object3D.matrixAutoUpdate. Set to false here as the helper is using the pointLight's matrixWorld.
     */
    public boolean matrixAutoUpdate;

    /**
     * The color parameter passed in the constructor. Default is undefined. If this is changed, the helper's color will update the next time update is called.
     */
    public Color color;

    /**
     * @param light -- The light to be visualized.
     */
    public PointLightHelper(PointLight light) {

    }

    /**
     * @param light      -- The light to be visualized.
     * @param sphereSize -- The size of the sphere helper. Default is 1.
     */
    public PointLightHelper(PointLight light, float sphereSize) {

    }

    /**
     * @param light      -- The light to be visualized.
     * @param sphereSize -- The size of the sphere helper. Default is 1.
     * @param color      -- if this is not the set the helper will take the color of the light.
     */
    public PointLightHelper(PointLight light, float sphereSize, Color color) {

    }

    /**
     * Dispose of the PointLightHelper.
     */
    public native void dispose();

    /**
     * Updates the helper to match the position and direction of the PointLightHelper being visualized.
     */
    public native void update();

}
