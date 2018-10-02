package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.objects.Bone;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * A helper object to assist with visualizing a Skeleton. The helper is renderered using a LineBasicMaterial.
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class SkeletonHelper extends LineSegments {

    /**
     * The list of bones that the helper renders as Lines.
     */
    public Bone[] bones;

    /**
     * The object passed in the constructor.
     */
    public Object root;

    /**
     * @param object -- can be any object that has an array of Bones as a sub object.
     *               For example, a Skeleton or a SkinnedMesh.
     */
    public SkeletonHelper(Object object) {

    }
}
