package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.Camera", namespace = JsPackage.GLOBAL)
public class Camera extends Object3D {
  public boolean isCamera;
  public Matrix4 matrixWorldInverse;
  public Matrix4 projectionMatrix;
  public Matrix4 projectionMatrixInverse;

  public native Vector3 getWorldDirection(Vector3 target);

  public native void updateMatrixWorld();

  public native void updateMatrixWorld(boolean force);
}
