package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

@JsType(isNative = true, name = "THREE.AxesHelper", namespace = JsPackage.GLOBAL)
public class AxesHelper extends LineSegments {

  public String type;

  public AxesHelper() {}

  public AxesHelper(double size) {}

  public native void dispose();

  public native AxesHelper setColors(Color xAxisColor, Color yAxisColor, Color zAxisColor);
}
