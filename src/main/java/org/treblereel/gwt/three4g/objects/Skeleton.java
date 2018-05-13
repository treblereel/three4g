package org.treblereel.gwt.three4g.objects;

import elemental2.core.Float32Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.textures.DataTexture;

/**
 * Use an array of bones to create a skeleton that can be used by a SkinnedMesh.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 4/30/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Skeleton {

    /**
     * The array of bones. Note this is a copy of the original array, not a reference, so you can modify the original array without effecting this one.
     */
    public Bone[] bones;

    /**
     * An array of Matrix4s that represent the inverse of the matrixWorld of the individual bones.
     */
    public Matrix4[] boneInverses;

    /**
     * The array buffer holding the bone data when using a vertex texture.
     */
    public Float32Array boneMatrices;

    /**
     * The DataTexture holding the bone data when using a vertex texture.
     */
    public DataTexture boneTexture;

    @JsConstructor
    public Skeleton(Bone[] bones) {

    }

    @JsConstructor
    public Skeleton(Bone[] bones, Matrix4 boneInverses) {

    }

    /**
     * Returns a clone of this Skeleton object.
     *
     * @return instance of Skeleton
     */
    public native Skeleton clone();

    /**
     * Generates the boneInverses array if not provided in the constructor.
     */
    public native void calculateInverses();

    /**
     * Returns the skeleton to the base pose.
     */
    public native void pose();

    /**
     * Updates the boneMatrices and boneTexture after changing the bones. This is called automatically by the WebGLRenderer if the skeleton is used with a SkinnedMesh.
     */
    public native void update();

    /**
     * Searches through the skeleton's bone array and returns the first with a matching name.
     *
     * @param name -- String to match to the Bone's .name property.
     * @return instance of Bone
     */
    public native Bone getBoneByName(String name);
}
