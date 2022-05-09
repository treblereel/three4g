package org.treblereel.gwt.three4g.extras.core;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Vector;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.Curve", namespace = JsPackage.GLOBAL)
public class Curve {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ComputeFrenetFramesReturnType {
    @JsOverlay
    static Curve.ComputeFrenetFramesReturnType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    JsArray<Vector3> getBinormals();

    @JsProperty
    JsArray<Vector3> getNormals();

    @JsProperty
    JsArray<Vector3> getTangents();

    @JsProperty
    void setBinormals(JsArray<Vector3> binormals);

    @JsOverlay
    default void setBinormals(Vector3[] binormals) {
      setBinormals(Js.<JsArray<Vector3>>uncheckedCast(binormals));
    }

    @JsProperty
    void setNormals(JsArray<Vector3> normals);

    @JsOverlay
    default void setNormals(Vector3[] normals) {
      setNormals(Js.<JsArray<Vector3>>uncheckedCast(normals));
    }

    @JsProperty
    void setTangents(JsArray<Vector3> tangents);

    @JsOverlay
    default void setTangents(Vector3[] tangents) {
      setTangents(Js.<JsArray<Vector3>>uncheckedCast(tangents));
    }
  }

  @JsFunction
  public interface CreateConstructorFuncFn {
    void onInvoke();
  }

  @JsFunction
  public interface CreateFn {
    void onInvoke();
  }

  @JsFunction
  public interface CreateGetPointFuncFn {
    void onInvoke();
  }

  @Deprecated
  public static native Curve.CreateFn create(
      Curve.CreateConstructorFuncFn constructorFunc, Curve.CreateGetPointFuncFn getPointFunc);

  public double arcLengthDivisions;
  public String type;

  @JsMethod(name = "clone")
  public native Curve clone_();

  public native Curve.ComputeFrenetFramesReturnType computeFrenetFrames(
      double segments, boolean closed);

  public native Curve.ComputeFrenetFramesReturnType computeFrenetFrames(double segments);

  public native Curve copy(Curve source);

  public native Curve fromJSON(JsObject json);

  @JsOverlay
  public final Curve fromJSON(Object json) {
    return fromJSON(Js.<JsObject>uncheckedCast(json));
  }

  public native double getLength();

  public native JsArray<Double> getLengths();

  public native JsArray<Double> getLengths(double divisions);

  public native Vector getPoint(double t, Vector optionalTarget);

  public native Vector getPoint(double t);

  public native Vector getPointAt(double u, Vector optionalTarget);

  public native Vector getPointAt(double u);

  public native JsArray<Vector> getPoints();

  public native JsArray<Vector> getPoints(double divisions);

  public native JsArray<Object> getSpacedPoints();

  public native JsArray<Object> getSpacedPoints(double divisions);

  public native Vector getTangent(double t, Vector optionalTarget);

  public native Vector getTangent(double t);

  public native Vector getTangentAt(double u, Vector optionalTarget);

  public native Vector getTangentAt(double u);

  public native double getUtoTmapping(double u, double distance);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native void updateArcLengths();
}
