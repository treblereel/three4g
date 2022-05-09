package org.treblereel.gwt.three4g.geometries;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.renderers.webgl.WebGLAttributes;
import org.treblereel.gwt.three4g.renderers.webgl.WebGLInfo;

@JsType(isNative = true, name = "THREE.WebGLGeometries", namespace = JsPackage.GLOBAL)
public class WebGLGeometries {
  public WebGLGeometries(WebGLRenderingContext gl, WebGLAttributes attributes, WebGLInfo info) {}

  public native BufferGeometry get(Object3D object, BufferGeometry geometry);

  public native BufferAttribute getWireframeAttribute(BufferGeometry geometry);

  public native void update(BufferGeometry geometry);
}
