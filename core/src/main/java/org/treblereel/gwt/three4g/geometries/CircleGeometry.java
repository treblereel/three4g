package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.CircleGeometry", namespace = JsPackage.GLOBAL)
public class CircleGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static CircleGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getRadius();

    @JsProperty
    double getSegments();

    @JsProperty
    double getThetaLength();

    @JsProperty
    double getThetaStart();

    @JsProperty
    void setRadius(double radius);

    @JsProperty
    void setSegments(double segments);

    @JsProperty
    void setThetaLength(double thetaLength);

    @JsProperty
    void setThetaStart(double thetaStart);
  }

  public static native CircleGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final CircleGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public CircleGeometry.ParametersFieldType parameters;
  public String type;

  public CircleGeometry() {}

  public CircleGeometry(double radius, double segments, double thetaStart, double thetaLength) {}

  public CircleGeometry(double radius, double segments, double thetaStart) {}

  public CircleGeometry(double radius, double segments) {}

  public CircleGeometry(double radius) {}
}
