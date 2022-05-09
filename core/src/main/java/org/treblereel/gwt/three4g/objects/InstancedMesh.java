package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.InstancedBufferAttribute;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.InstancedMesh", namespace = JsPackage.GLOBAL)
public class InstancedMesh<TGeometry, TMaterial> extends Mesh<TGeometry, TMaterial> {
  public double count;
  public InstancedBufferAttribute instanceColor;
  public InstancedBufferAttribute instanceMatrix;
  public boolean isInstancedMesh;

  public InstancedMesh(TGeometry geometry, TMaterial material, double count) {}

  public native void dispose();

  public native void getColorAt(double index, Color color);

  public native void getMatrixAt(double index, Matrix4 matrix);

  public native void setColorAt(double index, Color color);

  public native void setMatrixAt(double index, Matrix4 matrix);
}
