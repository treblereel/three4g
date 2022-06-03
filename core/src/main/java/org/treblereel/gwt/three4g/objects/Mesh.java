package org.treblereel.gwt.three4g.objects;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;

@JsType(isNative = true, name = "THREE.Mesh", namespace = JsPackage.GLOBAL)
public class Mesh<TGeometry extends BufferGeometry, TMaterial extends Material> extends Object3D {
  public TGeometry geometry;
  public boolean isMesh;
  public TMaterial material;
  public JsPropertyMap<String> morphTargetDictionary;
  public JsArray<Double> morphTargetInfluences;
  public String type;

  public Mesh() {}

  public Mesh(TGeometry geometry, TMaterial material) {}

  public Mesh(TGeometry geometry) {}

  public native void updateMorphTargets();
}
