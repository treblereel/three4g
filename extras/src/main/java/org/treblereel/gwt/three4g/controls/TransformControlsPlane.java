package org.treblereel.gwt.three4g.controls;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.objects.Mesh;

@JsType(isNative = true, name = "THREE.TransformControlsGizmo", namespace = JsPackage.GLOBAL)
public class TransformControlsPlane extends Mesh {

    public String type;
    public boolean isTransformControlsPlane;
    public String mode;
    public String axis;
    public String space;
    public Vector3 eye;
    public Vector3  worldPosition;
    public Quaternion worldQuaternion;
}
