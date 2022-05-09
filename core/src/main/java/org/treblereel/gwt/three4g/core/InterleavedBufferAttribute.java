package org.treblereel.gwt.three4g.core;

import elemental2.core.JsObject;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.math.Matrix3;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.InterleavedBufferAttribute", namespace = JsPackage.GLOBAL)
public class InterleavedBufferAttribute {
  public InterleavedBuffer data;
  public boolean isInterleavedBufferAttribute;
  public double itemSize;
  public String name;
  public boolean normalized;
  public double offset;

  public InterleavedBufferAttribute(
      InterleavedBuffer interleavedBuffer, double itemSize, double offset, boolean normalized) {}

  public InterleavedBufferAttribute(
      InterleavedBuffer interleavedBuffer, double itemSize, double offset) {}

  public native InterleavedBufferAttribute applyMatrix4(Matrix4 m);

  public native InterleavedBufferAttribute applyNormalMatrix(Matrix3 matrix);

  public native BufferAttribute clone(JsObject data);

  @JsOverlay
  public final BufferAttribute clone(Object data) {
    return clone(Js.<JsObject>uncheckedCast(data));
  }

  @JsMethod(name = "clone")
  public native BufferAttribute clone_();

  public native double getW(double index);

  public native double getX(double index);

  public native double getY(double index);

  public native double getZ(double index);

  public native InterleavedBufferAttribute setW(double index, double z);

  public native InterleavedBufferAttribute setX(double index, double x);

  public native InterleavedBufferAttribute setXY(double index, double x, double y);

  public native InterleavedBufferAttribute setXYZ(double index, double x, double y, double z);

  public native InterleavedBufferAttribute setXYZW(
      double index, double x, double y, double z, double w);

  public native InterleavedBufferAttribute setY(double index, double y);

  public native InterleavedBufferAttribute setZ(double index, double z);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native InterleavedBufferAttribute transformDirection(Matrix3 matrix);
}
