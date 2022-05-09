package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.OrthographicCamera", namespace = JsPackage.GLOBAL)
public class OrthographicCamera extends Camera {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ViewFieldType {
    @JsOverlay
    static OrthographicCamera.ViewFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getFullHeight();

    @JsProperty
    double getFullWidth();

    @JsProperty
    double getHeight();

    @JsProperty
    double getOffsetX();

    @JsProperty
    double getOffsetY();

    @JsProperty
    double getWidth();

    @JsProperty
    boolean isEnabled();

    @JsProperty
    void setEnabled(boolean enabled);

    @JsProperty
    void setFullHeight(double fullHeight);

    @JsProperty
    void setFullWidth(double fullWidth);

    @JsProperty
    void setHeight(double height);

    @JsProperty
    void setOffsetX(double offsetX);

    @JsProperty
    void setOffsetY(double offsetY);

    @JsProperty
    void setWidth(double width);
  }

  public double bottom;
  public double far;
  public boolean isOrthographicCamera;
  public double left;
  public double near;
  public double right;
  public double top;
  public String type;
  public OrthographicCamera.ViewFieldType view;
  public double zoom;

  public OrthographicCamera(
      double left, double right, double top, double bottom, double near, double far) {}

  public OrthographicCamera(double left, double right, double top, double bottom, double near) {}

  public OrthographicCamera(double left, double right, double top, double bottom) {}

  public native void clearViewOffset();

  public native void setViewOffset(
      double fullWidth,
      double fullHeight,
      double offsetX,
      double offsetY,
      double width,
      double height);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native void updateProjectionMatrix();
}
