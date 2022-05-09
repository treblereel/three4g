package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsArray;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.WebGLInfo", namespace = JsPackage.GLOBAL)
public class WebGLInfo {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface MemoryFieldType {
    @JsOverlay
    static WebGLInfo.MemoryFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getGeometries();

    @JsProperty
    double getTextures();

    @JsProperty
    void setGeometries(double geometries);

    @JsProperty
    void setTextures(double textures);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface RenderFieldType {
    @JsOverlay
    static WebGLInfo.RenderFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getCalls();

    @JsProperty
    double getFrame();

    @JsProperty
    double getLines();

    @JsProperty
    double getPoints();

    @JsProperty
    double getTriangles();

    @JsProperty
    void setCalls(double calls);

    @JsProperty
    void setFrame(double frame);

    @JsProperty
    void setLines(double lines);

    @JsProperty
    void setPoints(double points);

    @JsProperty
    void setTriangles(double triangles);
  }

  public boolean autoReset;
  public WebGLInfo.MemoryFieldType memory;
  public JsArray<WebGLProgram> programs;
  public WebGLInfo.RenderFieldType render;

  public WebGLInfo(WebGLRenderingContext gl) {}

  public native void reset();

  public native void update(double count, double mode, double instanceCount);
}
