package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.BoxGeometry", namespace = JsPackage.GLOBAL)
public class BoxGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static BoxGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getDepth();

    @JsProperty
    double getDepthSegments();

    @JsProperty
    double getHeight();

    @JsProperty
    double getHeightSegments();

    @JsProperty
    double getWidth();

    @JsProperty
    double getWidthSegments();

    @JsProperty
    void setDepth(double depth);

    @JsProperty
    void setDepthSegments(double depthSegments);

    @JsProperty
    void setHeight(double height);

    @JsProperty
    void setHeightSegments(double heightSegments);

    @JsProperty
    void setWidth(double width);

    @JsProperty
    void setWidthSegments(double widthSegments);
  }

  public static native BoxGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final BoxGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public BoxGeometry.ParametersFieldType parameters;
  public String type;

  public BoxGeometry() {}

  public BoxGeometry(
      double width,
      double height,
      double depth,
      double widthSegments,
      double heightSegments,
      double depthSegments) {}

  public BoxGeometry(
      double width, double height, double depth, double widthSegments, double heightSegments) {}

  public BoxGeometry(double width, double height, double depth, double widthSegments) {}

  public BoxGeometry(double width, double height, double depth) {}

  public BoxGeometry(double width, double height) {}

  public BoxGeometry(double width) {}
}
