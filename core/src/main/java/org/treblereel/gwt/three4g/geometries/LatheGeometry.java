package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Vector2;

@JsType(isNative = true, name = "THREE.LatheGeometry", namespace = JsPackage.GLOBAL)
public class LatheGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static LatheGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getPhiLength();

    @JsProperty
    double getPhiStart();

    @JsProperty
    JsArray<Vector2> getPoints();

    @JsProperty
    double getSegments();

    @JsProperty
    void setPhiLength(double phiLength);

    @JsProperty
    void setPhiStart(double phiStart);

    @JsProperty
    void setPoints(JsArray<Vector2> points);

    @JsOverlay
    default void setPoints(Vector2[] points) {
      setPoints(Js.<JsArray<Vector2>>uncheckedCast(points));
    }

    @JsProperty
    void setSegments(double segments);
  }

  public static native LatheGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final LatheGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public LatheGeometry.ParametersFieldType parameters;
  public String type;

  public LatheGeometry() {}

  public LatheGeometry(
      JsArray<Vector2> points, double segments, double phiStart, double phiLength) {}

  public LatheGeometry(JsArray<Vector2> points, double segments, double phiStart) {}

  public LatheGeometry(JsArray<Vector2> points, double segments) {}

  public LatheGeometry(JsArray<Vector2> points) {}

  public LatheGeometry(Vector2[] points, double segments, double phiStart, double phiLength) {}

  public LatheGeometry(Vector2[] points, double segments, double phiStart) {}

  public LatheGeometry(Vector2[] points, double segments) {}

  public LatheGeometry(Vector2[] points) {}
}
