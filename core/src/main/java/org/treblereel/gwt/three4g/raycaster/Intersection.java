package org.treblereel.gwt.three4g.raycaster;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Vector2;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.Raycaster.Intersection", namespace = JsPackage.GLOBAL)
public interface Intersection<TIntersected> {
  @JsOverlay
  static Intersection create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getDistance();

  @JsProperty
  double getDistanceToRay();

  @JsProperty
  Face getFace();

  @JsProperty
  double getFaceIndex();

  @JsProperty
  double getIndex();

  @JsProperty
  double getInstanceId();

  @JsProperty
  TIntersected getObject();

  @JsProperty
  Vector3 getPoint();

  @JsProperty
  Vector2 getUv();

  @JsProperty
  void setDistance(double distance);

  @JsProperty
  void setDistanceToRay(double distanceToRay);

  @JsProperty
  void setFace(Face face);

  @JsProperty
  void setFaceIndex(double faceIndex);

  @JsProperty
  void setIndex(double index);

  @JsProperty
  void setInstanceId(double instanceId);

  @JsProperty
  void setObject(TIntersected object);

  @JsProperty
  void setPoint(Vector3 point);

  @JsProperty
  void setUv(Vector2 uv);
}
