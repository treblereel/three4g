package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;

@JsType(isNative = true, name = "THREE.DecalGeometry", namespace = JsPackage.GLOBAL)
public class DecalGeometry extends BufferGeometry {

    public DecalGeometry(Mesh mesh, Vector3 position, Euler orientation, Vector3 size){

    }
}
