package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.ConvexGeometry", namespace = JsPackage.GLOBAL)
public class ConvexGeometry extends BufferGeometry {

    public ConvexGeometry(Vector3[] points) {

    }

    public ConvexGeometry(JsArray<Vector3> points) {

    }

}
