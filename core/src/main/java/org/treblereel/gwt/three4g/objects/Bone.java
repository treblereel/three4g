package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.Bone", namespace = JsPackage.GLOBAL)
public class Bone extends Object3D {
  public boolean isBone;
  public String type;
}
