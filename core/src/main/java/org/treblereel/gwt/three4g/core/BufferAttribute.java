package org.treblereel.gwt.three4g.core;

import elemental2.core.ArrayBufferView;
import elemental2.core.JsArray;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Matrix3;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.BufferAttribute", namespace = JsPackage.GLOBAL)
public class BufferAttribute {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface CopyColorsArrayColorsType {
    @JsOverlay
    static BufferAttribute.CopyColorsArrayColorsType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getB();

    @JsProperty
    double getG();

    @JsProperty
    double getR();

    @JsProperty
    void setB(double b);

    @JsProperty
    void setG(double g);

    @JsProperty
    void setR(double r);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface CopyVector2sArrayVectorsType {
    @JsOverlay
    static BufferAttribute.CopyVector2sArrayVectorsType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getX();

    @JsProperty
    double getY();

    @JsProperty
    void setX(double x);

    @JsProperty
    void setY(double y);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface CopyVector3sArrayVectorsType {
    @JsOverlay
    static BufferAttribute.CopyVector3sArrayVectorsType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getX();

    @JsProperty
    double getY();

    @JsProperty
    double getZ();

    @JsProperty
    void setX(double x);

    @JsProperty
    void setY(double y);

    @JsProperty
    void setZ(double z);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface CopyVector4sArrayVectorsType {
    @JsOverlay
    static BufferAttribute.CopyVector4sArrayVectorsType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getW();

    @JsProperty
    double getX();

    @JsProperty
    double getY();

    @JsProperty
    double getZ();

    @JsProperty
    void setW(double w);

    @JsProperty
    void setX(double x);

    @JsProperty
    void setY(double y);

    @JsProperty
    void setZ(double z);
  }

  @JsFunction
  public interface OnUploadCallbackFn {
    void onInvoke();
  }

  @JsFunction
  public interface OnUploadCallbackFn0 {
    void onInvoke();
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetValueUnionType {
    @JsOverlay
    static BufferAttribute.SetValueUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default ArrayBufferView asArrayBufferView() {
      return Js.cast(this);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isArrayBufferView() {
      return (Object) this instanceof ArrayBufferView;
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UpdateRangeFieldType {
    @JsOverlay
    static BufferAttribute.UpdateRangeFieldType create() {
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

  public JsArray<Double> array;
  public double count;
  public boolean isBufferAttribute;
  public double itemSize;
  public String name;
  public boolean normalized;
  public BufferAttribute.OnUploadCallbackFn0 onUploadCallback;
  public BufferAttribute.UpdateRangeFieldType updateRange;
  public double usage;
  public double version;
  public boolean needsUpdate;

  public BufferAttribute(JsArrayLike<Double> array, double itemSize, boolean normalized) {}

  public BufferAttribute(JsArrayLike<Double> array, double itemSize) {}

  public native BufferAttribute applyMatrix3(Matrix3 m);

  public native BufferAttribute applyMatrix4(Matrix4 m);

  public native BufferAttribute applyNormalMatrix(Matrix3 m);

  @JsMethod(name = "clone")
  public native BufferAttribute clone_();

  public native BufferAttribute copy(BufferAttribute source);

  public native BufferAttribute copyArray(Object array);

  public native BufferAttribute copyAt(double index1, BufferAttribute attribute, double index2);

  @JsOverlay
  public final BufferAttribute copyColorsArray(BufferAttribute.CopyColorsArrayColorsType[] colors) {
    return copyColorsArray(
        Js.<JsArray<BufferAttribute.CopyColorsArrayColorsType>>uncheckedCast(colors));
  }

  public native BufferAttribute copyColorsArray(
      JsArray<BufferAttribute.CopyColorsArrayColorsType> colors);

  @JsOverlay
  public final BufferAttribute copyVector2sArray(
      BufferAttribute.CopyVector2sArrayVectorsType[] vectors) {
    return copyVector2sArray(
        Js.<JsArray<BufferAttribute.CopyVector2sArrayVectorsType>>uncheckedCast(vectors));
  }

  public native BufferAttribute copyVector2sArray(
      JsArray<BufferAttribute.CopyVector2sArrayVectorsType> vectors);

  @JsOverlay
  public final BufferAttribute copyVector3sArray(
      BufferAttribute.CopyVector3sArrayVectorsType[] vectors) {
    return copyVector3sArray(
        Js.<JsArray<BufferAttribute.CopyVector3sArrayVectorsType>>uncheckedCast(vectors));
  }

  public native BufferAttribute copyVector3sArray(
      JsArray<BufferAttribute.CopyVector3sArrayVectorsType> vectors);

  @JsOverlay
  public final BufferAttribute copyVector4sArray(
      BufferAttribute.CopyVector4sArrayVectorsType[] vectors) {
    return copyVector4sArray(
        Js.<JsArray<BufferAttribute.CopyVector4sArrayVectorsType>>uncheckedCast(vectors));
  }

  public native BufferAttribute copyVector4sArray(
      JsArray<BufferAttribute.CopyVector4sArrayVectorsType> vectors);

  public native double getW(double index);

  public native double getX(double index);

  public native double getY(double index);

  public native double getZ(double index);

  public native BufferAttribute onUpload(BufferAttribute.OnUploadCallbackFn callback);

  @JsOverlay
  public final BufferAttribute set(ArrayBufferView value, double offset) {
    return set(Js.<BufferAttribute.SetValueUnionType>uncheckedCast(value), offset);
  }

  @JsOverlay
  public final BufferAttribute set(ArrayBufferView value) {
    return set(Js.<BufferAttribute.SetValueUnionType>uncheckedCast(value));
  }

  @JsOverlay
  public final BufferAttribute set(Object value, double offset) {
    return set(Js.<BufferAttribute.SetValueUnionType>uncheckedCast(value), offset);
  }

  @JsOverlay
  public final BufferAttribute set(Object value) {
    return set(Js.<BufferAttribute.SetValueUnionType>uncheckedCast(value));
  }

  public native BufferAttribute set(BufferAttribute.SetValueUnionType value, double offset);

  public native BufferAttribute set(BufferAttribute.SetValueUnionType value);

  public native BufferAttribute setUsage(double usage);

  public native BufferAttribute setW(double index, double z);

  public native BufferAttribute setX(double index, double x);

  public native BufferAttribute setXY(double index, double x, double y);

  public native BufferAttribute setXYZ(double index, double x, double y, double z);

  public native BufferAttribute setXYZW(double index, double x, double y, double z, double w);

  public native BufferAttribute setY(double index, double y);

  public native BufferAttribute setZ(double index, double z);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native BufferAttribute transformDirection(Matrix4 m);
}
