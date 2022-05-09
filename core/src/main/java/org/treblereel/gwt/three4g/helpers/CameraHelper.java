package org.treblereel.gwt.three4g.helpers;

import elemental2.core.JsArray;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.objects.LineSegments;

@JsType(isNative = true, name = "THREE.CameraHelper", namespace = JsPackage.GLOBAL)
public class CameraHelper extends LineSegments {
  public Camera camera;
  public JsPropertyMap<JsArray<Double>> pointMap;
  public String type;

  public CameraHelper(Camera camera) {}

  public native void dispose();

  public native void update();
}
