package org.treblereel.gwt.three4g.loaders;

import elemental2.core.JsObject;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ImageBitmap;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.ImageBitmapLoader", namespace = JsPackage.GLOBAL)
public class ImageBitmapLoader extends Loader {
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
    void onInvoke(ImageBitmap p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public boolean isImageBitmapLoader;
  public JsObject options;

  public ImageBitmapLoader() {}

  public ImageBitmapLoader(LoadingManager manager) {}

  public native double load(
      String url,
      ImageBitmapLoader.LoadOnLoadFn onLoad,
      ImageBitmapLoader.LoadOnProgressFn onProgress,
      ImageBitmapLoader.LoadOnErrorFn onError);

  public native double load(
      String url,
      ImageBitmapLoader.LoadOnLoadFn onLoad,
      ImageBitmapLoader.LoadOnProgressFn onProgress);

  public native double load(String url, ImageBitmapLoader.LoadOnLoadFn onLoad);

  public native double load(String url);

  public native Promise<ImageBitmap> loadAsync(
      String url, ImageBitmapLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<ImageBitmap> loadAsync(String url);

  public native ImageBitmapLoader setOptions(JsObject options);

  @JsOverlay
  public final ImageBitmapLoader setOptions(Object options) {
    return setOptions(Js.<JsObject>uncheckedCast(options));
  }
}
