package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.SphereGeometry", namespace = JsPackage.GLOBAL)
public class SphereGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static SphereGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getHeightSegments();

    @JsProperty
    double getPhiLength();

    @JsProperty
    double getPhiStart();

    @JsProperty
    double getRadius();

    @JsProperty
    double getThetaLength();

    @JsProperty
    double getThetaStart();

    @JsProperty
    double getWidthSegments();

    @JsProperty
    void setHeightSegments(double heightSegments);

    @JsProperty
    void setPhiLength(double phiLength);

    @JsProperty
    void setPhiStart(double phiStart);

    @JsProperty
    void setRadius(double radius);

    @JsProperty
    void setThetaLength(double thetaLength);

    @JsProperty
    void setThetaStart(double thetaStart);

    @JsProperty
    void setWidthSegments(double widthSegments);
  }

  public static native SphereGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final SphereGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public SphereGeometry.ParametersFieldType parameters;
  public String type;

  public SphereGeometry() {}

  public SphereGeometry(
      double radius,
      double widthSegments,
      double heightSegments,
      double phiStart,
      double phiLength,
      double thetaStart,
      double thetaLength) {}

  public SphereGeometry(
      double radius,
      double widthSegments,
      double heightSegments,
      double phiStart,
      double phiLength,
      double thetaStart) {}

  public SphereGeometry(
      double radius,
      double widthSegments,
      double heightSegments,
      double phiStart,
      double phiLength) {}

  public SphereGeometry(
      double radius, double widthSegments, double heightSegments, double phiStart) {}

  public SphereGeometry(double radius, double widthSegments, double heightSegments) {}

  public SphereGeometry(double radius, double widthSegments) {}

  public SphereGeometry(double radius) {}
}
