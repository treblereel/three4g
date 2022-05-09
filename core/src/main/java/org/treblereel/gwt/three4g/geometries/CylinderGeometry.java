package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.CylinderGeometry", namespace = JsPackage.GLOBAL)
public class CylinderGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static CylinderGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getHeight();

    @JsProperty
    double getHeightSegments();

    @JsProperty
    double getRadialSegments();

    @JsProperty
    double getRadiusBottom();

    @JsProperty
    double getRadiusTop();

    @JsProperty
    double getThetaLength();

    @JsProperty
    double getThetaStart();

    @JsProperty
    boolean isOpenEnded();

    @JsProperty
    void setHeight(double height);

    @JsProperty
    void setHeightSegments(double heightSegments);

    @JsProperty
    void setOpenEnded(boolean openEnded);

    @JsProperty
    void setRadialSegments(double radialSegments);

    @JsProperty
    void setRadiusBottom(double radiusBottom);

    @JsProperty
    void setRadiusTop(double radiusTop);

    @JsProperty
    void setThetaLength(double thetaLength);

    @JsProperty
    void setThetaStart(double thetaStart);
  }

  public static native CylinderGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final CylinderGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public CylinderGeometry.ParametersFieldType parameters;
  public String type;

  public CylinderGeometry() {}

  public CylinderGeometry(
      double radiusTop,
      double radiusBottom,
      double height,
      double radialSegments,
      double heightSegments,
      boolean openEnded,
      double thetaStart,
      double thetaLength) {}

  public CylinderGeometry(
      double radiusTop,
      double radiusBottom,
      double height,
      double radialSegments,
      double heightSegments,
      boolean openEnded,
      double thetaStart) {}

  public CylinderGeometry(
      double radiusTop,
      double radiusBottom,
      double height,
      double radialSegments,
      double heightSegments,
      boolean openEnded) {}

  public CylinderGeometry(
      double radiusTop,
      double radiusBottom,
      double height,
      double radialSegments,
      double heightSegments) {}

  public CylinderGeometry(
      double radiusTop, double radiusBottom, double height, double radialSegments) {}

  public CylinderGeometry(double radiusTop, double radiusBottom, double height) {}

  public CylinderGeometry(double radiusTop, double radiusBottom) {}

  public CylinderGeometry(double radiusTop) {}
}
