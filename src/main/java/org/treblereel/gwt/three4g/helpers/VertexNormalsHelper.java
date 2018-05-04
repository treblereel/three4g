package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * Renders arrows to visualize an object's vertex normal vectors. Requires that normals have been specified in a custom attribute or have been calculated using computeVertexNormals.
 * <p>
 * Unlike FaceNormalsHelper, this works with BufferGeometry.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class VertexNormalsHelper extends LineSegments {

    /**
     * See Object3D.matrixAutoUpdate. Set to false here as the helper is using the camera's matrixWorld.
     */
    public boolean matrixAutoUpdate;

    /**
     * The object for which the face normals are being visualized.
     */
    public Object3D object;

    /**
     * Length of the arrows. Default is 1.
     */
    public int size;

    /**
     * @param object -- object for which to render vertex normals.
     */
    public VertexNormalsHelper(Object3D object) {

    }

    /**
     * @param object -- object for which to render vertex normals.
     * @param size   -- length of the arrows. Default is 1.
     */
    public VertexNormalsHelper(Object3D object, int size) {

    }

    /**
     * @param object -- object for which to render vertex normals.
     * @param size   -- length of the arrows. Default is 1.
     * @param color  -- hex color of the arrows. Default is 0xff0000.
     */
    public VertexNormalsHelper(Object3D object, int size, Color color) {

    }

    /**
     * @param object    -- object for which to render vertex normals.
     * @param size      -- length of the arrows. Default is 1.
     * @param color     -- hex color of the arrows. Default is 0xff0000.
     * @param linewidth -- width of the arrow lines. Default is 1.
     */
    public VertexNormalsHelper(Object3D object, int size, Color color, Number linewidth) {

    }

    /**
     * Updates the face normal preview based on movement of the object.
     */
    public native void update();
}
