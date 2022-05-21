package org.treblereel.gwt.three4g.core.events;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.EventDispatcher", namespace = JsPackage.GLOBAL)
public class EventDispatcher<E> {

  public native void addEventListener(String type, EventListener listener);

  public native void dispatchEvent(E event);

  public native boolean hasEventListener(String type, EventListener listener);

  public native void removeEventListener(String type, EventListener listener);
}
