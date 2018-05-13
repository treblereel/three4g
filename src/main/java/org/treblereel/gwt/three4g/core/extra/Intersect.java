package org.treblereel.gwt.three4g.core.extra;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Face3;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/13/18.
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class Intersect {

    /**
     * distance between the origin of the ray and the intersection
     */
    public int distance;

    /**
     * – point of intersection, in world coordinates
     */
    public Vector3 point;

    /**
     * – intersected face
     */
    public Face3 face;

    /**
     * index of the intersected face
     */
    public int faceIndex;

    /**
     * the intersected object
     */
    public Mesh object;

    /**
     * U,V coordinates at point of intersection
     */
    public Vector2 uv;
}
