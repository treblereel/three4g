package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Box3;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

@JsType(isNative = true, name = "THREE.Box3Helper", namespace = JsPackage.GLOBAL)
public class Box3Helper extends LineSegments {
  public Box3 box;
  public String type;

  public Box3Helper(Box3 box, Color color) {}

  public Box3Helper(Box3 box) {}
}
