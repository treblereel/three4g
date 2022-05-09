package org.treblereel.gwt.three4g.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.ShaderMaterial;
import org.treblereel.gwt.three4g.materials.ShaderMaterialParameters;

@JsType(isNative = true, name = "THREE.RawShaderMaterial", namespace = JsPackage.GLOBAL)
public class RawShaderMaterial extends ShaderMaterial {
  public RawShaderMaterial() {}

  public RawShaderMaterial(ShaderMaterialParameters parameters) {}
}
