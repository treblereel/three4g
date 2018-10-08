package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.lights.HemisphereLight;
import org.treblereel.gwt.three4g.math.Matrix4;

/**
 * Creates a visual aid consisting of a spherical Mesh for a HemisphereLight.
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/25/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class HemisphereLightHelper extends Object3D {

    /**
     *  Reference to the HemisphereLight being visualized.
     */
    public HemisphereLight light;

    /**
     *     Reference to the hemisphereLight's matrixWorld.
     */
    public Matrix4 matrix;

    /**
     *     The color parameter passed in the constructor. Default is undefined. If this is changed, the helper's color will update the next time update is called.
     */
    public int hex;

    /**
     * @param light -- The light being visualized.
     * @param sphereSize -- The size of the mesh used to visualize the light.
     */
    @JsConstructor
    public HemisphereLightHelper(HemisphereLight light, int sphereSize){

    }

    /**
     * @param light -- The light being visualized.
     * @param sphereSize -- The size of the mesh used to visualize the light.
     * @param hex -- if this is not the set the helper will take the color of the light.
     */
    @JsConstructor
    public HemisphereLightHelper(HemisphereLight light, int sphereSize, int hex){  //TODO check color is color

    }

    /**
     * Dispose of the hemisphereLightHelper.
     */
    public native void dispose();

    /**
     * Updates the helper to match the position and direction of the .light.
     */
    public native void update();

}
