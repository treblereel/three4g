package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.SkinnedMesh", namespace = JsPackage.GLOBAL)
public class SkinnedMesh<TGeometry, TMaterial> extends Mesh<TGeometry, TMaterial> {
  public Matrix4 bindMatrix;
  public Matrix4 bindMatrixInverse;
  public String bindMode;
  public boolean isSkinnedMesh;
  public Skeleton skeleton;

  public SkinnedMesh() {}

  public SkinnedMesh(TGeometry geometry, TMaterial material, boolean useVertexTexture) {}

  public SkinnedMesh(TGeometry geometry, TMaterial material) {}

  public SkinnedMesh(TGeometry geometry) {}

  public native void bind(Skeleton skeleton, Matrix4 bindMatrix);

  public native void bind(Skeleton skeleton);

  public native Vector3 boneTransform(double index, Vector3 target);

  public native void normalizeSkinWeights();

  public native void pose();

  public native void updateMatrixWorld();

  public native void updateMatrixWorld(boolean force);
}
