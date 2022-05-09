package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.BufferGeometryLoader", namespace = JsPackage.GLOBAL)
public class BufferGeometryLoader extends Loader {
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
    void onInvoke(BufferGeometry p0);
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public BufferGeometryLoader() {}

  public BufferGeometryLoader(LoadingManager manager) {}

  public native void load(
      String url,
      BufferGeometryLoader.LoadOnLoadFn onLoad,
      BufferGeometryLoader.LoadOnProgressFn onProgress,
      BufferGeometryLoader.LoadOnErrorFn onError);

  public native void load(
      String url,
      BufferGeometryLoader.LoadOnLoadFn onLoad,
      BufferGeometryLoader.LoadOnProgressFn onProgress);

  public native void load(String url, BufferGeometryLoader.LoadOnLoadFn onLoad);

  public native Promise<BufferGeometry> loadAsync(
      String url, BufferGeometryLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<BufferGeometry> loadAsync(String url);

  public native BufferGeometry parse(double json);
}
