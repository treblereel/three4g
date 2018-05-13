package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.SpotLight;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * This displays a cone shaped helper object for a SpotLight.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SpotLightHelper extends Object3D {

    /**
     * LineSegments used to visualize the light.
     */
    public LineSegments cone;

    /**
     * Reference to the SpotLight being visualized.
     */
    public SpotLight light;

    /**
     * Reference to the spotLight's matrixWorld.
     */
    public Matrix4 matrix;

    /**
     * See Object3D.matrixAutoUpdate. Set to false here as the helper is using the spotLight's matrixWorld.
     */
    public boolean matrixAutoUpdate;

    /**
     * The color parameter passed in the constructor. Default is undefined. If this is changed, the helper's color will update the next time update is called.
     */
    public Color color;


    /**
     * @param light -- The SpotLight to be visualized.
     */
    public SpotLightHelper(SpotLight light) {

    }

    /**
     * @param light -- The SpotLight to be visualized.
     * @param color -- if this is not the set the helper will take the color of the light.
     */
    public SpotLightHelper(SpotLight light, Color color) {

    }

    /**
     * Dispose of the SpotLightHelper.
     */
    public native void dispose();

    /**
     * Updates the helper to match the position and direction of the SpotLightHelper being visualized.
     */
    public native void update();
}
