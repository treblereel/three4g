package org.treblereel.gwt.three4g.animation;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.AnimationObjectGroup", namespace = JsPackage.GLOBAL)
public class AnimationObjectGroup {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface StatsFieldType {
    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface ObjectsFieldType {
      @JsOverlay
      static AnimationObjectGroup.StatsFieldType.ObjectsFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      double getInUse();

      @JsProperty
      double getTotal();

      @JsProperty
      void setInUse(double inUse);

      @JsProperty
      void setTotal(double total);
    }

    @JsOverlay
    static AnimationObjectGroup.StatsFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getBindingsPerObject();

    @JsProperty
    AnimationObjectGroup.StatsFieldType.ObjectsFieldType getObjects();

    @JsProperty
    void setBindingsPerObject(double bindingsPerObject);

    @JsProperty
    void setObjects(AnimationObjectGroup.StatsFieldType.ObjectsFieldType objects);
  }

  public boolean isAnimationObjectGroup;
  public AnimationObjectGroup.StatsFieldType stats;
  public String uuid;

  public AnimationObjectGroup(JsObject... args) {}

  public AnimationObjectGroup(Object... args) {}

  public native void add(JsObject... args);

  @JsOverlay
  public final void add(Object... args) {
    add(Js.<JsObject[]>uncheckedCast(args));
  }

  public native void remove(JsObject... args);

  @JsOverlay
  public final void remove(Object... args) {
    remove(Js.<JsObject[]>uncheckedCast(args));
  }

  public native void uncache(JsObject... args);

  @JsOverlay
  public final void uncache(Object... args) {
    uncache(Js.<JsObject[]>uncheckedCast(args));
  }
}
