package org.treblereel.gwt.three4g.extensions.loaders;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.Three4gElement;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.Loader;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;

/** @author Dmitrii Tikhomirov Created by treblereel 12/14/18 */
@Three4gElement(paths = "js/loaders/AssimpLoader.js")
@JsType(isNative = true, namespace = "THREE")
public class AssimpLoader<T extends PropertyHolder> extends Loader<AssimpLoader, T> {

  /**
   * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to
   * starting the load. Default is anonymous.
   */
  public String crossOrigin;

  public AssimpLoader() {}

  public AssimpLoader(LoadingManager loadingManager) {}
}
