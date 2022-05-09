package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.BooleanKeyframeTrack", namespace = JsPackage.GLOBAL)
public class BooleanKeyframeTrack extends KeyframeTrack {
  public String ValueTypeName;

  public BooleanKeyframeTrack(String name, JsArray<JsObject> times, JsArray<JsObject> values) {
    // This super call is here only for the code to compile; it is never executed.
    super((String) null, (Object) null, (Object) null, 0);
  }

  public BooleanKeyframeTrack(String name, JsObject[] times, JsObject[] values) {
    // This super call is here only for the code to compile; it is never executed.
    super((String) null, (Object) null, (Object) null, 0);
  }
}
