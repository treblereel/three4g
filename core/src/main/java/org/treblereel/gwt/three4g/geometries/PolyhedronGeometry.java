package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.PolyhedronGeometry", namespace = JsPackage.GLOBAL)
public class PolyhedronGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static PolyhedronGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getDetail();

    @JsProperty
    JsArray<Double> getIndices();

    @JsProperty
    double getRadius();

    @JsProperty
    JsArray<Double> getVertices();

    @JsProperty
    void setDetail(double detail);

    @JsProperty
    void setIndices(JsArray<Double> indices);

    @JsOverlay
    default void setIndices(double[] indices) {
      setIndices(Js.<JsArray<Double>>uncheckedCast(indices));
    }

    @JsProperty
    void setRadius(double radius);

    @JsProperty
    void setVertices(JsArray<Double> vertices);

    @JsOverlay
    default void setVertices(double[] vertices) {
      setVertices(Js.<JsArray<Double>>uncheckedCast(vertices));
    }
  }

  public static native PolyhedronGeometry fromJSON(Object data);

  public PolyhedronGeometry.ParametersFieldType parameters;
  public String type;

  public PolyhedronGeometry() {}

  public PolyhedronGeometry(
      JsArray<Double> vertices, JsArray<Double> indices, double radius, double detail) {}

  public PolyhedronGeometry(JsArray<Double> vertices, JsArray<Double> indices, double radius) {}

  public PolyhedronGeometry(JsArray<Double> vertices, JsArray<Double> indices) {}

  public PolyhedronGeometry(JsArray<Double> vertices) {}

  public PolyhedronGeometry(double[] vertices, double[] indices, double radius, double detail) {}

  public PolyhedronGeometry(double[] vertices, double[] indices, double radius) {}

  public PolyhedronGeometry(double[] vertices, double[] indices) {}

  public PolyhedronGeometry(double[] vertices) {}
}
