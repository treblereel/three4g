package org.treblereel.gwt.three4g.extras.core;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Vector2;

@JsType(isNative = true, name = "THREE.Shape", namespace = JsPackage.GLOBAL)
public class Shape extends Path<Shape> {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ExtractPointsReturnType {
    @JsOverlay
    static Shape.ExtractPointsReturnType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    JsArray<JsArray<Vector2>> getHoles();

    @JsProperty
    JsArray<Vector2> getShape();

    @JsProperty
    void setHoles(JsArray<JsArray<Vector2>> holes);

    @JsOverlay
    default void setHoles(Vector2[][] holes) {
      setHoles(Js.<JsArray<JsArray<Vector2>>>uncheckedCast(holes));
    }

    @JsProperty
    void setShape(JsArray<Vector2> shape);

    @JsOverlay
    default void setShape(Vector2[] shape) {
      setShape(Js.<JsArray<Vector2>>uncheckedCast(shape));
    }
  }

  public JsArray<Path> holes;
  public String type;
  public String uuid;

  public Shape() {}

  public Shape(JsArray<Vector2> points) {}

  public Shape(Vector2[] points) {}

  public native Shape.ExtractPointsReturnType extractPoints(double divisions);

  public native JsArray<JsArray<Vector2>> getPointsHoles(double divisions);
}
