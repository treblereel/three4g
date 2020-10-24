package org.treblereel.gwt.three4g.core;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Euler;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.j2cl.processors.annotations.ES6Module;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/22/21
 */
@ES6Module
@JsType(isNative = true, namespace = "org.treblereel.gwt.three4g.core")
public class Object3D {

    public Vector3 position;
    public Euler rotation;

    public native void add(Object3D mesh);
}
