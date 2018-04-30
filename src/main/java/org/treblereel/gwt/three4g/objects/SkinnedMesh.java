package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Geometry;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.Matrix4;

/**
 * A mesh that has a Skeleton with bones that can then be used to animate the vertices of the geometry.
 *
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SkinnedMesh extends Mesh {

    /**
     * Either "attached" or "detached". "attached" uses the SkinnedMesh.matrixWorld property for the base transform	matrix of the bones. "detached" uses the SkinnedMesh.bindMatrix. Default is "attached".
     */
    public String bindMode;

    /**
     * The base matrix that is used for the bound bone transforms.
     */
    public Matrix4 bindMatrix;

    /**
     * The base matrix that is used for resetting the bound bone transforms.
     */
    public Matrix4 bindMatrixInverse;

    /**
     * Used to check whether this or derived classes are skinned meshes. Default is true.
     */
    public boolean isSkinnedMesh;

    /**
     * Skeleton created from the bones of the Geometry passed in the constructor.
     */
    public Skeleton skeleton;


    /**
     * @param geometry - an instance of Geometry or BufferGeometry (recommended). skinIndices and skinWeights should be set to true on the geometry.
     * @param material - (optional) an instance of Material. Default is a new MeshBasicMaterial.
     */
    @JsConstructor
    public SkinnedMesh(Geometry geometry, Material material) {

    }

    /**
     * Bind a skeleton to the skinned mesh. The bindMatrix gets saved to .bindMatrix property and the .bindMatrixInverse gets calculated. This is called automatically in the constructor, and the skeleton is created from the bones of the Geometry passed in the constructor.
     *
     * @param skeleton   - Skeleton created from a Bones tree.
     * @param bindMatrix - Matrix4 that represents the base transform of the skeleton.
     */
    public native void bind(Skeleton skeleton, Matrix4 bindMatrix);

    /**
     * Returns a clone of this SkinnedMesh object and any descendants.
     *
     * @return
     */
    public native SkinnedMesh clone();

    /**
     * Normalizes the Geometry.skinWeights vectors. Does not affect BufferGeometry.
     */
    public native void normalizeSkinWeights();

    /**
     * This method sets the skinned mesh in the rest pose (resets the pose).
     */
    public native void pose();

    /**
     * Updates the MatrixWorld.
     */
    public native void updateMatrixWorld();

    /**
     * Updates the MatrixWorld.
     */
    public native void updateMatrixWorld(boolean force);

    /**
     * Creates an array of hierarchical bones objects from the internal geometry.
     */
    public native void initBones();

}
