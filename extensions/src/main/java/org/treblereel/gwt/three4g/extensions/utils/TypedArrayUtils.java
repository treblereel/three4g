package org.treblereel.gwt.three4g.extensions.utils;

import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 8/16/18.
 */
@JsType(isNative = true, namespace = "THREE")
@Three4gElement(paths = "js/utils/TypedArrayUtils.js")
public class TypedArrayUtils {

    @JsType(isNative = true, namespace = "THREE.TypedArrayUtils")
    public static class Kdtree {

        public Kdtree(Float32Array positions, DistanceFunction function, int size) {

        }

        /**
         * @param point:       array of size eleSize
         * @param maxNodes:    max amount of nodes to return
         * @param maxDistance: maximum distance to point result nodes should have
         *                     condition (not implemented): function to test node before it's added to the result list, e.g. test for view frustum
         * @return array of float
         */
        public native JsArray<JsArray> nearest(float[] point, int maxNodes, float maxDistance);

    }
}
