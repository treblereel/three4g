package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.j2cl.processors.annotations.ES6Module;

@ES6Module
@JsType(isNative = true, namespace = "org.treblereel.gwt.three4g.cameras")
public class PerspectiveCamera extends Object3D {

    public int aspect;

    public PerspectiveCamera(double fov, double aspect, double near, double far) {

    }

    public native void updateProjectionMatrix();
}
