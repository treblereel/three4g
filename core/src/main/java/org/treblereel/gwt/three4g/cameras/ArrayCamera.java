package org.treblereel.gwt.three4g.cameras;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.ArrayCamera", namespace = JsPackage.GLOBAL)
public class ArrayCamera extends PerspectiveCamera {
  public JsArray<PerspectiveCamera> cameras;
  public boolean isArrayCamera;

  public ArrayCamera() {}

  public ArrayCamera(JsArray<PerspectiveCamera> cameras) {}

  public ArrayCamera(PerspectiveCamera[] cameras) {}
}
