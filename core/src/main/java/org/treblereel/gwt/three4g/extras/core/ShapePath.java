package org.treblereel.gwt.three4g.extras.core;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Color;

@JsType(isNative = true, name = "THREE.ShapePath", namespace = JsPackage.GLOBAL)
public class ShapePath {
  public Color color;
  public double currentPath;
  public JsArray<JsObject> subPaths;
  public String type;

  public native ShapePath bezierCurveTo(
      double aCP1x, double aCP1y, double aCP2x, double aCP2y, double aX, double aY);

  public native ShapePath lineTo(double x, double y);

  public native ShapePath moveTo(double x, double y);

  public native ShapePath quadraticCurveTo(double aCPx, double aCPy, double aX, double aY);

  public native ShapePath splineThru(JsArray<Vector2> pts);

  @JsOverlay
  public final ShapePath splineThru(Vector2[] pts) {
    return splineThru(Js.<JsArray<Vector2>>uncheckedCast(pts));
  }

  public native JsArray<Shape> toShapes(boolean isCCW, boolean noHoles);

  public native JsArray<Shape> toShapes(boolean isCCW);
}
