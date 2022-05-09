package org.treblereel.gwt.three4g;

import jsinterop.annotations.JsEnum;
import jsinterop.annotations.JsPackage;

@JsEnum(isNative = true, name = "THREE.TOUCH", namespace = JsPackage.GLOBAL)
public enum TOUCH {
  DOLLY_PAN,
  DOLLY_ROTATE,
  PAN,
  ROTATE;
}
