package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.materials.SpriteMaterial;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.Sprite", namespace = JsPackage.GLOBAL)
public class Sprite extends Object3D {
  public Vector2 center;
  public BufferGeometry geometry;
  public boolean isSprite;
  public SpriteMaterial material;
  public String type;

  public Sprite() {}

  public Sprite(SpriteMaterial material) {}
}
