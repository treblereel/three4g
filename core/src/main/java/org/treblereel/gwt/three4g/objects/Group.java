package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.Group", namespace = JsPackage.GLOBAL)
public class Group extends Object3D {
  public boolean isGroup;
  public String type;
}
