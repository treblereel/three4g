package org.treblereel.gwt.three4g.utils;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.helpers.SkeletonHelper;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.objects.Bone;
import org.treblereel.gwt.three4g.objects.Skeleton;

@JsType(isNative = true, name = "THREE.SkeletonUtils", namespace = JsPackage.GLOBAL)
public class SkeletonUtils {

    public native static void retarget(Object3D target, Object3D source, Object options);

    public native static void retarget(Skeleton target, Skeleton source, Object options);

    public native static void retarget(Object3D target, Skeleton source, Object options);

    public native static void retarget(Skeleton target, Object3D source, Object options);

    public native static AnimationClip retargetClip(Object3D target, Object3D source, AnimationClip clip, Object options);

    public native static AnimationClip retargetClip(Skeleton target, Skeleton source, AnimationClip clip, Object options);

    public native static AnimationClip retargetClip(Object3D target, Skeleton source, AnimationClip clip, Object options);

    public native static AnimationClip retargetClip(Skeleton target, Object3D source, AnimationClip clip, Object options);

    public native static SkeletonHelper getHelperFromSkeleton(Skeleton skeleton);

    public native static Matrix4[] getSkeletonOffsets(Object3D target, Object3D source, Object options);

    public native static Matrix4[] getSkeletonOffsets(Skeleton target, Skeleton source, Object options);

    public native static Matrix4[] getSkeletonOffsets(Object3D target, Skeleton source, Object options);

    public native static Matrix4[] getSkeletonOffsets(Skeleton target, Object3D source, Object options);

    public native static Object renameBones(Skeleton skeleton, Object names);

    public native static Bone[] getBones(Skeleton skeleton);

    public native static Bone[] getBones(Bone[] skeleton);

    public native static Bone getBoneByName(String name, Skeleton skeleton);

    public native static Bone getNearestBone(Bone bone, Object names);

    public native static Object getNearestBone(Bone bone, Object[] tracks);

    public native static String[] getNearestBone(Skeleton skeleton, Skeleton targetSkeleton);

    public native static Object3D clone(Object3D source);

}
