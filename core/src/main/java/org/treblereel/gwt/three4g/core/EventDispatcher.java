package org.treblereel.gwt.three4g.core;

import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.EventDispatcher", namespace = JsPackage.GLOBAL)
public class EventDispatcher<E> {
  @JsFunction
  public interface AddEventListenerListenerFn {
    void onInvoke(JsObject p0);

    @JsOverlay
    default void onInvoke(Object p0) {
      onInvoke(Js.<JsObject>uncheckedCast(p0));
    }
  }

  @JsFunction
  public interface EventListenerFn {
    void onInvoke(JsObject p0);

    @JsOverlay
    default void onInvoke(Object p0) {
      onInvoke(Js.<JsObject>uncheckedCast(p0));
    }
  }

  @JsFunction
  public interface HasEventListenerListenerFn {
    void onInvoke(JsObject p0);

    @JsOverlay
    default void onInvoke(Object p0) {
      onInvoke(Js.<JsObject>uncheckedCast(p0));
    }
  }

  @JsFunction
  public interface RemoveEventListenerListenerFn {
    void onInvoke(JsObject p0);

    @JsOverlay
    default void onInvoke(Object p0) {
      onInvoke(Js.<JsObject>uncheckedCast(p0));
    }
  }

  public static EventDispatcher.EventListenerFn EventListener;

  public native <T> void addEventListener(
      T type, EventDispatcher.AddEventListenerListenerFn listener);

  public native void dispatchEvent(E event);

  public native <T> boolean hasEventListener(
      T type, EventDispatcher.HasEventListenerListenerFn listener);

  public native <T> void removeEventListener(
      T type, EventDispatcher.RemoveEventListenerListenerFn listener);
}
