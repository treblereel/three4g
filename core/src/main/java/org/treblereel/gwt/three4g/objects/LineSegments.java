package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.LineSegments", namespace = JsPackage.GLOBAL)
public class LineSegments<TGeometry, TMaterial> extends Line {
  public static double LinePieces;
  public static double LineStrip;
  public boolean isLineSegments;
  public String type;

  public LineSegments() {}

  public LineSegments(TGeometry geometry, TMaterial material) {}

  public LineSegments(TGeometry geometry) {}
}
