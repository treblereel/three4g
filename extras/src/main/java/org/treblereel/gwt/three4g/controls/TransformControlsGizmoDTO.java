package org.treblereel.gwt.three4g.controls;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "TransformControlsGizmoDTO", namespace = JsPackage.GLOBAL)
public class TransformControlsGizmoDTO {

    public Object3D translate;
    public Object3D rotate;
    public Object3D scale;
}
