package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

/**
 * Wrapper for the ThreeJs PerspectiveCamera class
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 *         Created by treblereel on 12/6/17.
 */
@JsType(isNative=true, namespace="THREE")
public class PerspectiveCamera extends Camera{

    public Vector3 position;


    /**
     * @param fov — Camera frustum vertical field of view.
     * @param aspect — Camera frustum aspect ratio.
     * @param near — Camera frustum near plane.
     * @param far — Camera frustum far plane.
     Together these define the camera's viewing frustum.
     */
    public PerspectiveCamera( int fov, double aspect, double near, int far ){

    }
}
