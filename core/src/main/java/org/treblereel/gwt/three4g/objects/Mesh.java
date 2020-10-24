package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.geometries.BoxBufferGeometry;
import org.treblereel.gwt.three4g.materials.MeshBasicMaterial;
import org.treblereel.j2cl.processors.annotations.ES6Module;

@ES6Module
@JsType(isNative = true, namespace = "org.treblereel.gwt.three4g.objects")
public class Mesh extends Object3D {

    public Mesh(BoxBufferGeometry geometry, MeshBasicMaterial material) {
    }
}
