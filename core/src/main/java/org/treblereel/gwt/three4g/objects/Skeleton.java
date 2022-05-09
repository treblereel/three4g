package org.treblereel.gwt.three4g.objects;

import elemental2.core.Float32Array;
import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Matrix4;
import org.treblereel.gwt.three4g.textures.DataTexture;

@JsType(isNative = true, name = "THREE.Skeleton", namespace = JsPackage.GLOBAL)
public class Skeleton {
  public JsArray<Matrix4> boneInverses;
  public Float32Array boneMatrices;
  public DataTexture boneTexture;
  public double boneTextureSize;
  public JsArray<Bone> bones;
  public double frame;
  public boolean useVertexTexture;
  public String uuid;

  public Skeleton(Bone[] bones, Matrix4[] boneInverses) {}

  public Skeleton(Bone[] bones) {}

  public Skeleton(JsArray<Bone> bones, JsArray<Matrix4> boneInverses) {}

  public Skeleton(JsArray<Bone> bones) {}

  public native void calculateInverses();

  @JsMethod(name = "clone")
  public native Skeleton clone_();

  public native Skeleton computeBoneTexture();

  public native void dispose();

  public native Bone getBoneByName(String name);

  public native void init();

  public native void pose();

  public native void update();
}
