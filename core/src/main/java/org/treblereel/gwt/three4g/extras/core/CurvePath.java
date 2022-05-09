package org.treblereel.gwt.three4g.extras.core;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.CurvePath", namespace = JsPackage.GLOBAL)
public class CurvePath extends Curve {
  public boolean autoClose;
  public JsArray<Curve> curves;
  public String type;

  public native void add(Curve curve);

  public native void closePath();

  public native JsArray<Double> getCurveLengths();
}
