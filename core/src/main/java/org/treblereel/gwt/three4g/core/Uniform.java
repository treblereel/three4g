package org.treblereel.gwt.three4g.core;

import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Uniform", namespace = JsPackage.GLOBAL)
@Deprecated
public class Uniform {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorValue_or_typeUnionType {
    @JsOverlay
    static Uniform.ConstructorValue_or_typeUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsFunction
  public interface OnUpdateCallbackFn {
    void onInvoke();
  }

  @JsFunction
  public interface OnUpdateCallbackFn0 {
    void onInvoke();
  }

  public boolean dynamic;
  public Uniform.OnUpdateCallbackFn0 onUpdateCallback;
  public String type;
  public double value;

  public Uniform(Uniform.ConstructorValue_or_typeUnionType value_or_type, JsObject value) {}

  public Uniform(Uniform.ConstructorValue_or_typeUnionType value_or_type, Object value) {}

  public Uniform(Uniform.ConstructorValue_or_typeUnionType value_or_type) {}

  public Uniform(JsObject value_or_type, JsObject value) {}

  public Uniform(JsObject value_or_type) {}

  public Uniform(Object value_or_type, Object value) {}

  public Uniform(Object value_or_type) {}

  public Uniform(String value_or_type, JsObject value) {}

  public Uniform(String value_or_type, Object value) {}

  public Uniform(String value_or_type) {}

  @Deprecated
  public native Uniform onUpdate(Uniform.OnUpdateCallbackFn callback);
}
