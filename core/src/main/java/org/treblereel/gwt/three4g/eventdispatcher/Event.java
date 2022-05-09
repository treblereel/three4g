package org.treblereel.gwt.three4g.eventdispatcher;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.EventDispatcher.Event", namespace = JsPackage.GLOBAL)
public interface Event {
  @JsOverlay
  static Event create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  JsObject getTarget();

  @JsProperty
  void setTarget(JsObject target);

  @JsOverlay
  default void setTarget(Object target) {
    setTarget(Js.<JsObject>uncheckedCast(target));
  }
}
