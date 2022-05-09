package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsArray;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.animation.AnimationClip;

@JsType(isNative = true, name = "THREE.AnimationLoader", namespace = JsPackage.GLOBAL)
public class AnimationLoader extends Loader {
  @JsFunction
  public interface LoadAsyncOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  @JsFunction
  public interface LoadOnErrorFn {
    void onInvoke(ErrorEvent p0);
  }

  @JsFunction
  public interface LoadOnLoadFn {
    @JsOverlay
    default void onInvoke(AnimationClip[] p0) {
      onInvoke(Js.<JsArray<AnimationClip>>uncheckedCast(p0));
    }

    void onInvoke(JsArray<AnimationClip> p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public AnimationLoader() {}

  public AnimationLoader(LoadingManager manager) {}

  public native void load(
      String url,
      AnimationLoader.LoadOnLoadFn onLoad,
      AnimationLoader.LoadOnProgressFn onProgress,
      AnimationLoader.LoadOnErrorFn onError);

  public native void load(
      String url, AnimationLoader.LoadOnLoadFn onLoad, AnimationLoader.LoadOnProgressFn onProgress);

  public native void load(String url, AnimationLoader.LoadOnLoadFn onLoad);

  public native Promise<JsArray<AnimationClip>> loadAsync(
      String url, AnimationLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<JsArray<AnimationClip>> loadAsync(String url);

  public native JsArray<AnimationClip> parse(double json);
}
