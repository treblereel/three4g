package org.treblereel.gwt.three4g.core;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.InterleavedBuffer", namespace = JsPackage.GLOBAL)
public class InterleavedBuffer {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UpdateRangeFieldType {
    @JsOverlay
    static InterleavedBuffer.UpdateRangeFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getCount();

    @JsProperty
    double getOffset();

    @JsProperty
    void setCount(double count);

    @JsProperty
    void setOffset(double offset);
  }

  public Object array;
  public double count;
  public double length;
  public boolean needsUpdate;
  public double stride;
  public InterleavedBuffer.UpdateRangeFieldType updateRange;
  public double usage;
  public String uuid;
  public double version;

  public InterleavedBuffer(Object array, double stride) {}

  public native InterleavedBuffer clone(JsObject data);

  @JsOverlay
  public final InterleavedBuffer clone(Object data) {
    return clone(Js.<JsObject>uncheckedCast(data));
  }

  public native InterleavedBuffer copy(InterleavedBuffer source);

  public native InterleavedBuffer copyAt(
      double index1, InterleavedBufferAttribute attribute, double index2);

  public native InterleavedBuffer set(Object value, double index);

  public native InterleavedBuffer setUsage(double usage);

  public native Object toJSON();

  public native Object toJSON(String key);
}
