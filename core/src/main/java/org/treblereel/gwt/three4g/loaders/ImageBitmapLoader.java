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
public class ImageBitmapLoader extends Loader<ImageBitmapLoader, ImageBitmap> {

  public boolean isImageBitmapLoader;
  public JsObject options;

  public ImageBitmapLoader() {}

  public ImageBitmapLoader(LoadingManager manager) {}

  public native Promise<ImageBitmap> loadAsync(String url);

  public native ImageBitmapLoader setOptions(JsObject options);

  @JsOverlay
  public final ImageBitmapLoader setOptions(Object options) {
    return setOptions(Js.<JsObject>uncheckedCast(options));
  }
}
