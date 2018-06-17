package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.AbstractGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/8/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Mesh extends Object3D {

    /**
     * Determines how the mesh triangles are constructed from the vertices. See the draw mode constants for all possible
     * values. Default is TrianglesDrawMode.
     */
    public int drawMode;

    /**
     * Used to check whether this or derived classes are meshes. Default is true.
     * <p>
     * You should not change this, as it is used internally for optimisation.
     */
    public boolean isMesh;

    /**
     * An instance of Geometry or BufferGeometry (or derived classes), defining the object's structure.
     * <p>
     * It's recommended to always use a BufferGeometry if possible for best performance.
     */
    public AbstractGeometry geometry;

    /**
     * An instance of material derived from the Material base class or an array of materials, defining the object's
     * appearance. Default is a MeshBasicMaterial with a random color.
     */
    public Material material;

    /**
     * An array of weights typically from 0-1 that specify how much of the morph is applied. Undefined by default,
     * but reset to a blank array by updateMorphTargets.
     */
    public Object[] morphTargetInfluences; //TODO

    /**
     * A dictionary of morphTargets based on the morphTarget.name property. Undefined by default, but rebuilt updateMorphTargets.
     */
    public Object[] morphTargetDictionary;

    @JsConstructor
    public Mesh() {

    }

    /**
     * @param geometry —  an instance of Geometry or BufferGeometry. Default is a new BufferGeometry.
     */
    @JsConstructor
    public Mesh(AbstractGeometry geometry) {

    }

    /**
     * @param geometry —  an instance of Geometry or BufferGeometry. Default is a new BufferGeometry.
     * @param material —   a single or an array of Material. Default is a new MeshBasicMaterial with a random color.
     */
    @JsConstructor
    public Mesh(AbstractGeometry geometry, Material... material) {

    }

    /**
     * Set the value of drawMode.
     * @param drawMode - drawMode
     */
    public native void setDrawMode(int drawMode);

    /**
     * Returns a clone of this Mesh object and its descendants.
     *
     * @return Mesh
     */
    public native Mesh clone();

    /**
     * Custom depth material to be used by this material when rendering to the depth map. When shadow-casting with
     * a DirectionalLight or SpotLight, if you are (a) modifying vertex positions in the vertex shader, (b) using
     * a displacement map, (c) using an alpha map with alphaTest, or (d) using a transparent texture with alphaTest,
     * you must specify a customDepthMaterial for proper shadows. Default is undefined.
     */
    public Material customDepthMaterial;

    /**
     * Same as customDepthMaterial, but used with PointLight. Default is undefined.
     */
    public Material customDistanceMaterial;

    /**
     * Updates the morphTargets to have no influence on the object. Resets the morphTargetInfluences
     * and morphTargetDictionary properties.
     */
    public native void updateMorphTargets();


}
