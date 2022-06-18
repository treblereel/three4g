package org.treblereel.gwt.three4g.utils;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.GeometryUtils", namespace = JsPackage.GLOBAL)
public class GeometryUtils {

    public static native JsArray<Vector3> hilbert2D(
            Vector3 center,
            int size,
            int iterations,
            double v0,
            double v1,
            double v2,
            double v3
            );

    public static native JsArray<Vector3> hilbert3D(
            Vector3 center,
            int size,
            int iterations,
            double v0,
            double v1,
            double v2,
            double v3,
            double v4,
            double v5,
            double v6,
            double v7
    );


    public static native JsArray<Double> gosper(int size);
}
