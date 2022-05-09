package org.treblereel.gwt.three4g.core;

import elemental2.webgl.WebGLBuffer;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.GLBufferAttribute", namespace = JsPackage.GLOBAL)
public class GLBufferAttribute {
  public WebGLBuffer buffer;
  public double count;
  public double elementSize;
  public boolean isGLBufferAttribute;
  public double itemSize;
  public double type;
  public double version;

  public GLBufferAttribute(
      WebGLBuffer buffer, double type, double itemSize, double elementSize, double count) {}

  public native GLBufferAttribute setBuffer(WebGLBuffer buffer);

  public native GLBufferAttribute setCount(double count);

  public native GLBufferAttribute setItemSize(double itemSize);

  public native GLBufferAttribute setType(double type, double elementSize);
}
