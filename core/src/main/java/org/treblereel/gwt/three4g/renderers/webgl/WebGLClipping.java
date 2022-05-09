package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.materials.Material;

@JsType(isNative = true, name = "THREE.WebGLClipping", namespace = JsPackage.GLOBAL)
public class WebGLClipping {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UniformFieldType {
    @JsOverlay
    static WebGLClipping.UniformFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    JsObject getValue();

    @JsProperty
    boolean isNeedsUpdate();

    @JsProperty
    void setNeedsUpdate(boolean needsUpdate);

    @JsProperty
    void setValue(JsObject value);

    @JsOverlay
    default void setValue(Object value) {
      setValue(Js.<JsObject>uncheckedCast(value));
    }
  }

  public double numIntersection;
  public double numPlanes;
  public WebGLClipping.UniformFieldType uniform;

  public WebGLClipping(WebGLProperties properties) {}

  public native void beginShadows();

  public native void endShadows();

  public native boolean init(JsArray<JsObject> planes, boolean enableLocalClipping, Camera camera);

  @JsOverlay
  public final boolean init(JsObject[] planes, boolean enableLocalClipping, Camera camera) {
    return init(Js.<JsArray<JsObject>>uncheckedCast(planes), enableLocalClipping, camera);
  }

  public native void setState(Material material, Camera camera, boolean useCache);
}
