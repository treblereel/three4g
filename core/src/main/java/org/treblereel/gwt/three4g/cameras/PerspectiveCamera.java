package org.treblereel.gwt.three4g.cameras;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Vector4;

@JsType(isNative = true, name = "THREE.PerspectiveCamera", namespace = JsPackage.GLOBAL)
public class PerspectiveCamera extends Camera {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ViewFieldType {
    @JsOverlay
    static PerspectiveCamera.ViewFieldType create() {
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

  public double aspect;
  public double far;
  public double filmGauge;
  public double filmOffset;
  public double focus;
  public double fov;
  public boolean isPerspectiveCamera;
  public double near;
  public String type;
  public PerspectiveCamera.ViewFieldType view;
  public double zoom;
  public Vector4 viewport;

  public PerspectiveCamera() {}

  public PerspectiveCamera(double fov, double aspect, double near, double far) {}

  public PerspectiveCamera(double fov, double aspect, double near) {}

  public PerspectiveCamera(double fov, double aspect) {}

  public PerspectiveCamera(double fov) {}

  public native void clearViewOffset();

  public native double getEffectiveFOV();

  public native double getFilmHeight();

  public native double getFilmWidth();

  public native double getFocalLength();

  public native void setFocalLength(double focalLength);

  @Deprecated
  public native void setLens(double focalLength);

  @Deprecated
  public native void setLens(double focalLength, double frameHeight);

  public native void setViewOffset(
      double fullWidth, double fullHeight, double x, double y, double width, double height);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native void updateProjectionMatrix();
}
