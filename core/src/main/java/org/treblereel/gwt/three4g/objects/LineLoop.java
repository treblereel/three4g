package org.treblereel.gwt.three4g.objects;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.LineLoop", namespace = JsPackage.GLOBAL)
public class LineLoop<TGeometry, TMaterial> extends Line {
  public boolean isLineLoop;
  public String type;

  public LineLoop() {}

  public LineLoop(TGeometry geometry, TMaterial material) {}

  public LineLoop(TGeometry geometry) {}
}
