package org.treblereel.gwt.three4g.animation;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.events.EventDispatcher;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.AnimationMixer", namespace = JsPackage.GLOBAL)
public class AnimationMixer extends EventDispatcher {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ClipActionRootUnionType {
    @JsOverlay
    static AnimationMixer.ClipActionRootUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default AnimationObjectGroup asAnimationObjectGroup() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object3D asObject3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isAnimationObjectGroup() {
      return (Object) this instanceof AnimationObjectGroup;
    }

    @JsOverlay
    default boolean isObject3D() {
      return (Object) this instanceof Object3D;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorRootUnionType {
    @JsOverlay
    static AnimationMixer.ConstructorRootUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default AnimationObjectGroup asAnimationObjectGroup() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object3D asObject3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isAnimationObjectGroup() {
      return (Object) this instanceof AnimationObjectGroup;
    }

    @JsOverlay
    default boolean isObject3D() {
      return (Object) this instanceof Object3D;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ExistingActionRootUnionType {
    @JsOverlay
    static AnimationMixer.ExistingActionRootUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default AnimationObjectGroup asAnimationObjectGroup() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object3D asObject3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isAnimationObjectGroup() {
      return (Object) this instanceof AnimationObjectGroup;
    }

    @JsOverlay
    default boolean isObject3D() {
      return (Object) this instanceof Object3D;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetRootUnionType {
    @JsOverlay
    static AnimationMixer.GetRootUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default AnimationObjectGroup asAnimationObjectGroup() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object3D asObject3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isAnimationObjectGroup() {
      return (Object) this instanceof AnimationObjectGroup;
    }

    @JsOverlay
    default boolean isObject3D() {
      return (Object) this instanceof Object3D;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UncacheActionRootUnionType {
    @JsOverlay
    static AnimationMixer.UncacheActionRootUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default AnimationObjectGroup asAnimationObjectGroup() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object3D asObject3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isAnimationObjectGroup() {
      return (Object) this instanceof AnimationObjectGroup;
    }

    @JsOverlay
    default boolean isObject3D() {
      return (Object) this instanceof Object3D;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UncacheRootRootUnionType {
    @JsOverlay
    static AnimationMixer.UncacheRootRootUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default AnimationObjectGroup asAnimationObjectGroup() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object3D asObject3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isAnimationObjectGroup() {
      return (Object) this instanceof AnimationObjectGroup;
    }

    @JsOverlay
    default boolean isObject3D() {
      return (Object) this instanceof Object3D;
    }
  }

  public double time;
  public double timeScale;

  public AnimationMixer(AnimationObjectGroup root) {}

  public AnimationMixer(AnimationMixer.ConstructorRootUnionType root) {}

  public AnimationMixer(Object3D root) {}

  @JsOverlay
  public final AnimationAction clipAction(
      AnimationClip clip, AnimationObjectGroup root, double blendMode) {
    return clipAction(
        clip, Js.<AnimationMixer.ClipActionRootUnionType>uncheckedCast(root), blendMode);
  }

  @JsOverlay
  public final AnimationAction clipAction(AnimationClip clip, AnimationObjectGroup root) {
    return clipAction(clip, Js.<AnimationMixer.ClipActionRootUnionType>uncheckedCast(root));
  }

  public native AnimationAction clipAction(
      AnimationClip clip, AnimationMixer.ClipActionRootUnionType root, double blendMode);

  public native AnimationAction clipAction(
      AnimationClip clip, AnimationMixer.ClipActionRootUnionType root);

  @JsOverlay
  public final AnimationAction clipAction(AnimationClip clip, Object3D root, double blendMode) {
    return clipAction(
        clip, Js.<AnimationMixer.ClipActionRootUnionType>uncheckedCast(root), blendMode);
  }

  @JsOverlay
  public final AnimationAction clipAction(AnimationClip clip, Object3D root) {
    return clipAction(clip, Js.<AnimationMixer.ClipActionRootUnionType>uncheckedCast(root));
  }

  public native AnimationAction clipAction(AnimationClip clip);

  @JsOverlay
  public final AnimationAction existingAction(AnimationClip clip, AnimationObjectGroup root) {
    return existingAction(clip, Js.<AnimationMixer.ExistingActionRootUnionType>uncheckedCast(root));
  }

  public native AnimationAction existingAction(
      AnimationClip clip, AnimationMixer.ExistingActionRootUnionType root);

  @JsOverlay
  public final AnimationAction existingAction(AnimationClip clip, Object3D root) {
    return existingAction(clip, Js.<AnimationMixer.ExistingActionRootUnionType>uncheckedCast(root));
  }

  public native AnimationAction existingAction(AnimationClip clip);

  public native AnimationMixer.GetRootUnionType getRoot();

  public native AnimationMixer setTime(double timeInSeconds);

  public native AnimationMixer stopAllAction();

  @JsOverlay
  public final void uncacheAction(AnimationClip clip, AnimationObjectGroup root) {
    uncacheAction(clip, Js.<AnimationMixer.UncacheActionRootUnionType>uncheckedCast(root));
  }

  @JsOverlay
  public final void uncacheAction(AnimationClip clip, Object3D root) {
    uncacheAction(clip, Js.<AnimationMixer.UncacheActionRootUnionType>uncheckedCast(root));
  }

  public native void uncacheAction(
      AnimationClip clip, AnimationMixer.UncacheActionRootUnionType root);

  public native void uncacheAction(AnimationClip clip);

  public native void uncacheClip(AnimationClip clip);

  @JsOverlay
  public final void uncacheRoot(AnimationObjectGroup root) {
    uncacheRoot(Js.<AnimationMixer.UncacheRootRootUnionType>uncheckedCast(root));
  }

  @JsOverlay
  public final void uncacheRoot(Object3D root) {
    uncacheRoot(Js.<AnimationMixer.UncacheRootRootUnionType>uncheckedCast(root));
  }

  public native void uncacheRoot(AnimationMixer.UncacheRootRootUnionType root);

  public native AnimationMixer update(double deltaTime);
}
