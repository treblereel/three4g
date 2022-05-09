package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(isNative = true, name = "THREE.Euler", namespace = JsPackage.GLOBAL)
public class Euler {
  @JsFunction
  public interface _onChangeCallbackFn {
    void onInvoke();
  }

  @JsFunction
  public interface _onChangeCallbackFn0 {
    void onInvoke();
  }

  public static String DefaultOrder;
  public static JsArray<String> RotationOrders;
  public Euler._onChangeCallbackFn0 _onChangeCallback;
  public boolean isEuler;
  public String order;
  public double x;
  public double y;
  public double z;

  public Euler() {}

  public Euler(double x, double y, double z, String order) {}

  public Euler(double x, double y, double z) {}

  public Euler(double x, double y) {}

  public Euler(double x) {}

  public native Euler _onChange(Euler._onChangeCallbackFn callback);

  @JsMethod(name = "clone")
  public native Euler clone_();

  public native Euler copy(Euler euler);

  public native boolean equals(Euler euler);

  public native Euler fromArray(JsArray<JsObject> xyzo);

  @JsOverlay
  public final Euler fromArray(JsObject[] xyzo) {
    return fromArray(Js.<JsArray<JsObject>>uncheckedCast(xyzo));
  }

  public native Euler reorder(String newOrder);

  public native Euler set(double x, double y, double z, String order);

  public native Euler set(double x, double y, double z);

  public native Euler setFromQuaternion(Quaternion q, String order, boolean update);

  public native Euler setFromQuaternion(Quaternion q, String order);

  public native Euler setFromQuaternion(Quaternion q);

  public native Euler setFromRotationMatrix(Matrix4 m, String order, boolean update);

  public native Euler setFromRotationMatrix(Matrix4 m, String order);

  public native Euler setFromRotationMatrix(Matrix4 m);

  public native Euler setFromVector3(Vector3 v, String order);

  public native Euler setFromVector3(Vector3 v);

  public native JsArray<Double> toArray();

  public native JsArray<Double> toArray(JsArray<Double> array, double offset);

  public native JsArray<Double> toArray(JsArray<Double> array);

  @JsOverlay
  public final JsArray<Double> toArray(double[] array, double offset) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array), offset);
  }

  @JsOverlay
  public final JsArray<Double> toArray(double[] array) {
    return toArray(Js.<JsArray<Double>>uncheckedCast(array));
  }

  public native Vector3 toVector3();

  public native Vector3 toVector3(Vector3 optionalResult);
}
