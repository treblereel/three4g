package org.treblereel.gwt.three4g;

import jsinterop.annotations.JsEnum;
import jsinterop.annotations.JsPackage;

@JsEnum(isNative = true, name = "THREE.MOUSE", namespace = JsPackage.GLOBAL)
public enum MOUSE {
  DOLLY,
  LEFT,
  MIDDLE,
  PAN,
  RIGHT,
  ROTATE;
}
