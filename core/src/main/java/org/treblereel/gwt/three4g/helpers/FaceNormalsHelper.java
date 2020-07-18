package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * Renders arrows to visualize an object's face normals. Requires that face normals have been specified on all faces or calculated with computeFaceNormals.
 * <p>
 * Note that this only works with the objects whose geometry is an instance of Geometry. For BufferGeometry use a VertexNormalsHelper instead.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, name = "THREE.FaceNormalsHelper", namespace = JsPackage.GLOBAL)
public class FaceNormalsHelper extends LineSegments {

    /**
     * See Object3D.matrixAutoUpdate. Set to false here as the helper is using the objects's matrixWorld.
     */
    public Matrix4 matrixAutoUpdate;

    /**
     * The object for which the face normals are being visualized.
     */
    public Object3D object;

    /**
     * Length of the arrows. Default is 1.
     */
    public int size;

    /**
     * @param object -- object for which to render face normals.
     */
    public FaceNormalsHelper(Object3D object) {

    }

    /**
     * @param object -- object for which to render face normals.
     * @param size   -- length of the arrows. Default is 1.
     */
    public FaceNormalsHelper(Object3D object, int size) {

    }

    /**
     * @param object -- object for which to render face normals.
     * @param size   --  length of the arrows. Default is 1.
     * @param color  -- hex color of the arrows. Default is 0xffff00.
     */
    public FaceNormalsHelper(Object3D object, int size, Color color) {

    }

    /**
     * @param object    -- object for which to render face normals.
     * @param size      -- length of the arrows. Default is 1.
     * @param color     -- hex color of the arrows. Default is 0xffff00.
     * @param linewidth -- width of the arrow lines. Default is 1.
     */
    public FaceNormalsHelper(Object3D object, int size, Color color, Number linewidth) {

    }

    /**
     * Updates the face normal preview based on movement of the object.
     */
    public native void update();
}
