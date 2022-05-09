package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.RingGeometry", namespace = JsPackage.GLOBAL)
public class RingGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static RingGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getInnerRadius();

    @JsProperty
    double getOuterRadius();

    @JsProperty
    double getPhiSegments();

    @JsProperty
    double getThetaLength();

    @JsProperty
    double getThetaSegments();

    @JsProperty
    double getThetaStart();

    @JsProperty
    void setInnerRadius(double innerRadius);

    @JsProperty
    void setOuterRadius(double outerRadius);

    @JsProperty
    void setPhiSegments(double phiSegments);

    @JsProperty
    void setThetaLength(double thetaLength);

    @JsProperty
    void setThetaSegments(double thetaSegments);

    @JsProperty
    void setThetaStart(double thetaStart);
  }

  public static native RingGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final RingGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public RingGeometry.ParametersFieldType parameters;
  public String type;

  public RingGeometry() {}

  public RingGeometry(
      double innerRadius,
      double outerRadius,
      double thetaSegments,
      double phiSegments,
      double thetaStart,
      double thetaLength) {}

  public RingGeometry(
      double innerRadius,
      double outerRadius,
      double thetaSegments,
      double phiSegments,
      double thetaStart) {}

  public RingGeometry(
      double innerRadius, double outerRadius, double thetaSegments, double phiSegments) {}

  public RingGeometry(double innerRadius, double outerRadius, double thetaSegments) {}

  public RingGeometry(double innerRadius, double outerRadius) {}

  public RingGeometry(double innerRadius) {}
}
