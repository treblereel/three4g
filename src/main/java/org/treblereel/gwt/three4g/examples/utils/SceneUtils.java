package org.treblereel.gwt.three4g.examples.utils;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.objects.Group;

/**
 * A class containing useful utility functions for scene manipulation.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/24/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SceneUtils {

    /**
     * Creates a new Group that contains a new mesh for each material defined in materials. Beware that this is not the same as an array of materials which defines multiple materials for 1 mesh.
     * This is mostly useful for objects that need both a material and a wireframe implementation.
     *
     * @param geometry  -- The geometry for the set of materials.
     * @param materials -- The materials for the object.
     * @return instance of Group
     */
    public native static Group createMultiMaterialObject(Geometry geometry, Material... materials);

    /**
     * Attaches the object to the parent without the moving the object in the worldspace. Beware that to do this the matrixWorld needs to be updated, this can be done by calling the updateMatrixWorld method on the parent object.
     *
     * @param child  -- The object to add to the parent
     * @param scene  -- The scene to detach the object on.
     * @param parent -- The parent to attach the object from.
     */
    public native static void attach(Object3D child, Object3D scene, Object3D parent);

    /**
     * Detaches the object from the parent and adds it back to the scene without moving in worldspace. Beware that to do this the matrixWorld needs to be updated, this can be done by calling the updateMatrixWorld method on the parent object.
     *
     * @param child  -- The object to remove from the parent
     * @param scene  -- The scene to attach the object on.
     * @param parent -- The parent to detach the object from.
     */
    public native static void detach(Object3D child, Object3D parent, Object3D scene);


}
