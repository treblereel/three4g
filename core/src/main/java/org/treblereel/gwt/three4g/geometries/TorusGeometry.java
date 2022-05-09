package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.TorusGeometry", namespace = JsPackage.GLOBAL)
public class TorusGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static TorusGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getArc();

    @JsProperty
    double getRadialSegments();

    @JsProperty
    double getRadius();

    @JsProperty
    double getTube();

    @JsProperty
    double getTubularSegments();

    @JsProperty
    void setArc(double arc);

    @JsProperty
    void setRadialSegments(double radialSegments);

    @JsProperty
    void setRadius(double radius);

    @JsProperty
    void setTube(double tube);

    @JsProperty
    void setTubularSegments(double tubularSegments);
  }

  public static native TorusGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final TorusGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public TorusGeometry.ParametersFieldType parameters;
  public String type;

  public TorusGeometry() {}

  public TorusGeometry(
      double radius, double tube, double radialSegments, double tubularSegments, double arc) {}

  public TorusGeometry(double radius, double tube, double radialSegments, double tubularSegments) {}

  public TorusGeometry(double radius, double tube, double radialSegments) {}

  public TorusGeometry(double radius, double tube) {}

  public TorusGeometry(double radius) {}
}
