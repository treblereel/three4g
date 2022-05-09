package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.PlaneGeometry", namespace = JsPackage.GLOBAL)
public class PlaneGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static PlaneGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getHeight();

    @JsProperty
    double getHeightSegments();

    @JsProperty
    double getWidth();

    @JsProperty
    double getWidthSegments();

    @JsProperty
    void setHeight(double height);

    @JsProperty
    void setHeightSegments(double heightSegments);

    @JsProperty
    void setWidth(double width);

    @JsProperty
    void setWidthSegments(double widthSegments);
  }

  public static native PlaneGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final PlaneGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public PlaneGeometry.ParametersFieldType parameters;
  public String type;

  public PlaneGeometry() {}

  public PlaneGeometry(double width, double height, double widthSegments, double heightSegments) {}

  public PlaneGeometry(double width, double height, double widthSegments) {}

  public PlaneGeometry(double width, double height) {}

  public PlaneGeometry(double width) {}
}
