package org.treblereel.gwt.three4g.propertybinding;

import elemental2.core.JsObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.PropertyBinding.Composite", namespace = JsPackage.GLOBAL)
public class Composite {
  public Composite(double targetGroup, double path, JsObject parsedPath) {}

  public Composite(double targetGroup, double path, Object parsedPath) {}

  public Composite(double targetGroup, double path) {}

  public native void bind();

  public native double getValue(double array, double offset);

  public native void setValue(double array, double offset);

  public native void unbind();
}
