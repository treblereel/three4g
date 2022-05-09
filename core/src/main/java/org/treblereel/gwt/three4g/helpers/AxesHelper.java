package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.AxesHelper", namespace = JsPackage.GLOBAL)
public class AxesHelper {
  public String type;

  public AxesHelper() {}

  public AxesHelper(double size) {}

  public native void dispose();

  public native AxesHelper setColors(Color xAxisColor, Color yAxisColor, Color zAxisColor);
}
