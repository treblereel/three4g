package org.treblereel.gwt.three4g.extensions.utils;

import elemental2.core.JsMap;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.helpers.SkeletonHelper;
import org.treblereel.gwt.three4g.objects.Bone;
import org.treblereel.gwt.three4g.objects.Skeleton;

/**
 * Utility functions for Skeleton, SkinnedMesh, and Bone manipulation.
 * @author Dmitrii Tikhomirov
 * Created by treblereel 10/21/19
 */
@Three4gElement(paths = "js/utils/SkeletonUtils.js")
@JsType(isNative = true, namespace = "THREE")
public class SkeletonUtils {

    SkeletonUtils() {

    }

    /**
     * Clones the given object and its descendants, ensuring that any SkinnedMesh instances are correctly associated with their bones. Bones are also cloned, and must be descendants of the object passed to this method. Other data, like geometries and materials, are reused by reference.
     * @param object3D
     * @return
     */
    public native static Object3D clone(Object3D object3D);

    public native static <T> T findBoneTrackData(String name, Object[] tracks);

    public native static Bone getBoneByName(String name, Skeleton skeleton);

    public native static Bone[] getBones(Skeleton skeleton);

    public native static Bone[] getEqualsBonesNames(Skeleton skeleton, Skeleton targetSkeleton);

    public native static SkeletonHelper getHelperFromSkeleton(Skeleton skeleton);

    public native static Bone getNearestBone(Bone bone, Object[] names);

    public native static <T> T getSkeletonOffsets(SkeletonHelper target, SkeletonHelper source);

    public native static <T> T getSkeletonOffsets(SkeletonHelper target, SkeletonHelper source, Option option);

    public native static <T> SkeletonUtils renameBones(SkeletonHelper skeleton, T[] names);

    public native static AnimationClip retarget(SkeletonHelper target, SkeletonHelper source);

    public native static AnimationClip retarget(SkeletonHelper target, SkeletonHelper source, Option option);

    public native static AnimationClip retargetClip(SkeletonHelper target, SkeletonHelper source, AnimationClip clip);

    public native static AnimationClip retargetClip(SkeletonHelper target, SkeletonHelper source, AnimationClip clip, Option option);

    @JsType(isNative = true, namespace = "THREE", name = "Object")
    public static class Option {

        public JsMap<String, Object> names;

        public JsMap<String, Object> offsets;

        public int fps;

        public boolean useFirstFramePosition;

        public boolean preserveMatrix;

        public boolean useTargetMatrix;

        public boolean preserveHipPosition;

        public String hip;
    }
}
