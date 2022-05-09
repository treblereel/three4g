package org.treblereel.gwt.three4g.geometries;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.WireframeGeometry", namespace = JsPackage.GLOBAL)
public class WireframeGeometry<TBufferGeometry> extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType<TBufferGeometry> {
    @JsOverlay
    static WireframeGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    TBufferGeometry getGeometry();

    @JsProperty
    void setGeometry(TBufferGeometry geometry);
  }

  public WireframeGeometry.ParametersFieldType<TBufferGeometry> parameters;
  public String type;

  public WireframeGeometry() {}

  public WireframeGeometry(TBufferGeometry geometry) {}
}
