package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.ConeGeometry", namespace = JsPackage.GLOBAL)
public class ConeGeometry extends CylinderGeometry {
  public String type;

  public ConeGeometry() {}

  public ConeGeometry(
      double radius,
      double height,
      double radialSegments,
      double heightSegments,
      boolean openEnded,
      double thetaStart,
      double thetaLength) {}

  public ConeGeometry(
      double radius,
      double height,
      double radialSegments,
      double heightSegments,
      boolean openEnded,
      double thetaStart) {}

  public ConeGeometry(
      double radius,
      double height,
      double radialSegments,
      double heightSegments,
      boolean openEnded) {}

  public ConeGeometry(double radius, double height, double radialSegments, double heightSegments) {}

  public ConeGeometry(double radius, double height, double radialSegments) {}

  public ConeGeometry(double radius, double height) {}

  public ConeGeometry(double radius) {}
}
