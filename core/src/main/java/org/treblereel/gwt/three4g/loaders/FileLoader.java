package org.treblereel.gwt.three4g.loaders;

import elemental2.core.ArrayBuffer;
import elemental2.dom.ErrorEvent;
import elemental2.dom.EventTarget;
import elemental2.dom.MimeType;
import elemental2.dom.ProgressEvent;
import elemental2.promise.Promise;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.FileLoader", namespace = JsPackage.GLOBAL)
public class FileLoader extends Loader {
  @JsFunction
  public interface LoadAsyncOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface LoadAsyncPromiseTypeParameterUnionType {
    @JsOverlay
    static FileLoader.LoadAsyncPromiseTypeParameterUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default ArrayBuffer asArrayBuffer() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isArrayBuffer() {
      return (Object) this instanceof ArrayBuffer;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsFunction
  public interface LoadOnErrorFn {
    void onInvoke(ErrorEvent p0);
  }

  @JsFunction
  public interface LoadOnLoadFn {
    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface P0UnionType {
      @JsOverlay
      static FileLoader.LoadOnLoadFn.P0UnionType of(Object o) {
        return Js.cast(o);
      }

      @JsOverlay
      default ArrayBuffer asArrayBuffer() {
        return Js.cast(this);
      }

      @JsOverlay
      default String asString() {
        return Js.asString(this);
      }

      @JsOverlay
      default boolean isArrayBuffer() {
        return (Object) this instanceof ArrayBuffer;
      }

      @JsOverlay
      default boolean isString() {
        return (Object) this instanceof String;
      }
    }

    @JsOverlay
    default void onInvoke(ArrayBuffer p0) {
      onInvoke(Js.<FileLoader.LoadOnLoadFn.P0UnionType>uncheckedCast(p0));
    }

    void onInvoke(FileLoader.LoadOnLoadFn.P0UnionType p0);

    @JsOverlay
    default void onInvoke(String p0) {
      onInvoke(Js.<FileLoader.LoadOnLoadFn.P0UnionType>uncheckedCast(p0));
    }
  }

  @JsFunction
  public interface LoadOnProgressFn {
    void onInvoke(ProgressEvent<EventTarget> p0);
  }

  public MimeType mimeType;
  public String responseType;

  public FileLoader() {}

  public FileLoader(LoadingManager manager) {}

  public native double load(
      String url,
      FileLoader.LoadOnLoadFn onLoad,
      FileLoader.LoadOnProgressFn onProgress,
      FileLoader.LoadOnErrorFn onError);

  public native double load(
      String url, FileLoader.LoadOnLoadFn onLoad, FileLoader.LoadOnProgressFn onProgress);

  public native double load(String url, FileLoader.LoadOnLoadFn onLoad);

  public native double load(String url);

  public native Promise<FileLoader.LoadAsyncPromiseTypeParameterUnionType> loadAsync(
      String url, FileLoader.LoadAsyncOnProgressFn onProgress);

  public native Promise<FileLoader.LoadAsyncPromiseTypeParameterUnionType> loadAsync(String url);

  public native FileLoader setMimeType(MimeType mimeType);

  public native FileLoader setResponseType(String responseType);
}
