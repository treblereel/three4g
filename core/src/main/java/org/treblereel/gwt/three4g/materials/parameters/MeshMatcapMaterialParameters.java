package org.treblereel.gwt.three4g.materials.parameters;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.textures.Texture;

/** @author Dmitrii Tikhomirov Created by treblereel 12/14/18 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MeshMatcapMaterialParameters {

  public Texture alphaMap;

  public Texture matcap;

  public Color color;

  public Texture map;

  public Texture bumpMap;

  public float bumpScale;

  public Texture normalMap;

  public int normalMapType; // could be THREE.TangentSpaceNormalMap

  public Vector2 normalScale;

  public Texture displacementMap;

  public float displacementScalee;

  public float displacementBias;

  public boolean skinning;

  public boolean morphTargets;

  public boolean morphNormals;
}
