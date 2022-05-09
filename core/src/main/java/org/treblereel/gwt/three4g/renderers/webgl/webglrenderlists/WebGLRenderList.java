package org.treblereel.gwt.three4g.renderers.webgl.webglrenderlists;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.renderers.webgl.WebGLProperties;

@JsType(
    isNative = true,
    name = "THREE.WebGLRenderLists.WebGLRenderList",
    namespace = JsPackage.GLOBAL)
public class WebGLRenderList {
  @JsFunction
  public interface SortOpaqueSortFn {
    double onInvoke(JsObject p0, JsObject p1);

    @JsOverlay
    default double onInvoke(Object p0, Object p1) {
      return onInvoke(Js.<JsObject>uncheckedCast(p0), Js.<JsObject>uncheckedCast(p1));
    }
  }

  @JsFunction
  public interface SortTransparentSortFn {
    double onInvoke(JsObject p0, JsObject p1);

    @JsOverlay
    default double onInvoke(Object p0, Object p1) {
      return onInvoke(Js.<JsObject>uncheckedCast(p0), Js.<JsObject>uncheckedCast(p1));
    }
  }

  public JsArray<RenderItem> opaque;
  public JsArray<RenderItem> transmissive;
  public JsArray<RenderItem> transparent;

  public WebGLRenderList(WebGLProperties properties) {}

  public native void finish();

  public native void init();

  public native void push(
      Object3D object,
      BufferGeometry geometry,
      Material material,
      double groupOrder,
      double z,
      Group group);

  public native void sort(
      WebGLRenderList.SortOpaqueSortFn opaqueSort,
      WebGLRenderList.SortTransparentSortFn transparentSort);

  public native void unshift(
      Object3D object,
      BufferGeometry geometry,
      Material material,
      double groupOrder,
      double z,
      Group group);
}
