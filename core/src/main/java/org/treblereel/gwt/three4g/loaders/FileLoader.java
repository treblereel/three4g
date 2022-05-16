package org.treblereel.gwt.three4g.loaders;

import elemental2.dom.File;
import elemental2.dom.MimeType;
import elemental2.promise.Promise;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.FileLoader", namespace = JsPackage.GLOBAL)
public class FileLoader extends Loader<FileLoader, File> {

  public MimeType mimeType;
  public String responseType;

  public FileLoader() {}

  public FileLoader(LoadingManager manager) {}

  public native Promise<File> loadAsync(
      String url, OnProgressCallback onProgress);

  public native Promise<File> loadAsync(String url);

  public native FileLoader setMimeType(MimeType mimeType);

  public native FileLoader setResponseType(String responseType);
}
