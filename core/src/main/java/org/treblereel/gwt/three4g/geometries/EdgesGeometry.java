package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.EdgesGeometry", namespace = JsPackage.GLOBAL)
public class EdgesGeometry<TBufferGeometry> extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType<TBufferGeometry> {
    @JsOverlay
    static EdgesGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    TBufferGeometry getGeometry();

    @JsProperty
    double getThresholdAngle();

    @JsProperty
    void setGeometry(TBufferGeometry geometry);

    @JsProperty
    void setThresholdAngle(double thresholdAngle);
  }

  public EdgesGeometry.ParametersFieldType<TBufferGeometry> parameters;
  public String type;

  public EdgesGeometry() {}

  public EdgesGeometry(TBufferGeometry geometry, double thresholdAngle) {}

  public EdgesGeometry(TBufferGeometry geometry) {}
}
