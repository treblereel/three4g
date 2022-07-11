package org.treblereel.gwt.three4g.controls;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.TransformControlsGizmo", namespace = JsPackage.GLOBAL)
public class TransformControlsGizmo extends Object3D {

    public String type;
    public boolean isTransformControlsGizmo;

    public TransformControlsGizmoDTO gizmo;
    public TransformControlsGizmoDTO helper;
    public TransformControlsGizmoDTO picker;

}
