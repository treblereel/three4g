package org.treblereel.gwt.three4g.extras.core;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Vector2;

@JsType(isNative = true, name = "THREE.Path", namespace = JsPackage.GLOBAL)
public class Path<T extends Path> extends CurvePath {
  public Vector2 currentPoint;
  public String type;

  public Path() {}

  public Path(JsArray<Vector2> points) {}

  public Path(Vector2[] points) {}

  public native T absarc(
      double aX,
      double aY,
      double aRadius,
      double aStartAngle,
      double aEndAngle,
      boolean aClockwise);

  public native T absellipse(
          double aX,
          double aY,
          double xRadius,
          double yRadius,
          double aStartAngle,
          double aEndAngle,
          boolean aClockwise);

  public native T absellipse(
      double aX,
      double aY,
      double xRadius,
      double yRadius,
      double aStartAngle,
      double aEndAngle,
      boolean aClockwise,
      double aRotation);

  public native T arc(
      double aX,
      double aY,
      double aRadius,
      double aStartAngle,
      double aEndAngle,
      boolean aClockwise);

  public native T bezierCurveTo(
      double aCP1x, double aCP1y, double aCP2x, double aCP2y, double aX, double aY);

  public native T ellipse(
      double aX,
      double aY,
      double xRadius,
      double yRadius,
      double aStartAngle,
      double aEndAngle,
      boolean aClockwise,
      double aRotation);

  @Deprecated
  public native T fromPoints(JsArray<Vector2> vectors);

  @JsOverlay
  @Deprecated
  public final T fromPoints(Vector2[] vectors) {
    return fromPoints(Js.<JsArray<Vector2>>uncheckedCast(vectors));
  }

  public native T lineTo(double x, double y);

  public native T moveTo(double x, double y);

  public native T quadraticCurveTo(double aCPx, double aCPy, double aX, double aY);

  public native T setFromPoints(JsArray<Vector2> vectors);

  @JsOverlay
  public final T setFromPoints(Vector2[] vectors) {
    return setFromPoints(Js.<JsArray<Vector2>>uncheckedCast(vectors));
  }

  public native T splineThru(JsArray<Vector2> pts);

  @JsOverlay
  public final T splineThru(Vector2[] pts) {
    return splineThru(Js.<JsArray<Vector2>>uncheckedCast(pts));
  }
}
