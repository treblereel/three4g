package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.TorusKnotGeometry", namespace = JsPackage.GLOBAL)
public class TorusKnotGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static TorusKnotGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getP();

    @JsProperty
    double getQ();

    @JsProperty
    double getRadialSegments();

    @JsProperty
    double getRadius();

    @JsProperty
    double getTube();

    @JsProperty
    double getTubularSegments();

    @JsProperty
    void setP(double p);

    @JsProperty
    void setQ(double q);

    @JsProperty
    void setRadialSegments(double radialSegments);

    @JsProperty
    void setRadius(double radius);

    @JsProperty
    void setTube(double tube);

    @JsProperty
    void setTubularSegments(double tubularSegments);
  }

  public static native TorusKnotGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final TorusKnotGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public TorusKnotGeometry.ParametersFieldType parameters;
  public String type;

  public TorusKnotGeometry() {}

  public TorusKnotGeometry(
      double radius,
      double tube,
      double tubularSegments,
      double radialSegments,
      double p,
      double q) {}

  public TorusKnotGeometry(
      double radius, double tube, double tubularSegments, double radialSegments, double p) {}

  public TorusKnotGeometry(
      double radius, double tube, double tubularSegments, double radialSegments) {}

  public TorusKnotGeometry(double radius, double tube, double tubularSegments) {}

  public TorusKnotGeometry(double radius, double tube) {}

  public TorusKnotGeometry(double radius) {}
}
