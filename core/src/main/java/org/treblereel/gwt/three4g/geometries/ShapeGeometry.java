package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.extras.core.Shape;

@JsType(isNative = true, name = "THREE.ShapeGeometry", namespace = JsPackage.GLOBAL)
public class ShapeGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorShapesUnionType {
    @JsOverlay
    static ShapeGeometry.ConstructorShapesUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsArray<Shape> asJsArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default Shape asShape() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isJsArray() {
      return (Object) this instanceof JsArray;
    }

    @JsOverlay
    default boolean isShape() {
      return (Object) this instanceof Shape;
    }
  }

  public static native ShapeGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final ShapeGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public String type;

  public ShapeGeometry() {}

  public ShapeGeometry(ShapeGeometry.ConstructorShapesUnionType shapes, double curveSegments) {}

  public ShapeGeometry(ShapeGeometry.ConstructorShapesUnionType shapes) {}

  public ShapeGeometry(JsArray<Shape> shapes, double curveSegments) {}

  public ShapeGeometry(JsArray<Shape> shapes) {}

  public ShapeGeometry(Shape shapes, double curveSegments) {}

  public ShapeGeometry(Shape[] shapes, double curveSegments) {}

  public ShapeGeometry(Shape shapes) {}

  public ShapeGeometry(Shape[] shapes) {}
}
