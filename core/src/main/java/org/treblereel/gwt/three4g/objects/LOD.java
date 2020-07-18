package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.Raycaster;

/**
 * Level of Detail - show meshes with more or less geometry based on distance from the camera.
 * <p>
 * Every level is associated with an object, and rendering can be switched between them at the distances specified. Typically you would create, say, three meshes, one for far away (low detail), one for mid range (medium detail) and one for close up (high detail).
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, name = "THREE.LOD", namespace = JsPackage.GLOBAL)
public class LOD extends Object3D {

    /**
     * An array of level objects
     * <p>
     * Each level is an object with two properties:
     * object - The Object3D to display at this level.
     * distance - The distance at which to display this level of detail.
     */
    public LODLevel[] levels;

    /**
     * Whether the LOD object is updated automatically by the renderer per frame or not. If set to false, you have to call LOD.update() in the render loop by yourself. Default is true.
     */
    public boolean autoUpdate;

    @JsConstructor
    public LOD() {

    }

    /**
     * Adds a mesh that will display at a certain distance and greater. Typically the further away the distance, the lower the detail on the mesh.
     *
     * @param object   - The Object3D to display at this level.
     * @param distance - The distance at which to display this level of detail.
     * @return instance of LOD
     */
    public native LOD addLevel(Object3D object, float distance);

    /**
     * Returns a clone of this LOD object and its associated distance specific objects.
     *
     * @return instance of LOD
     */
    public native LOD clone();

    /**
     * Get a reference to the first Object3D (mesh) that is greater than distance.
     *
     * @param distance as float value
     * @return instance of Object3D
     */
    public native Object3D getObjectForDistance(float distance);

    /**
     * Get intersections between a casted Ray and this LOD. Raycaster.intersectObject will call this method.
     *
     * @param raycaster instance of Raycaster
     * @param intersects objects to check
     * @return array of intersects objects
     */
    public native Object[] raycast(Raycaster raycaster, Object[] intersects); //TODO fix method signature

    /**
     * Create a JSON structure with details of this LOD object.
     *
     * @return JSON String
     */
    public native String toJSON();

    /**
     * Set the visibility of each level's object based on distance from the camera. This needs to be called in the render loop for levels of detail to be updated dynamically.
     *
     * @param camera instance of a Camera
     */
    public native void update(Camera camera);

    /**
     *
     * @return true if is LOD
     */
    public native boolean isLOD();
}
