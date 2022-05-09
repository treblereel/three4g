package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.extras.core.Shape;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.ExtrudeGeometry", namespace = JsPackage.GLOBAL)
public class ExtrudeGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorShapesUnionType {
    @JsOverlay
    static ExtrudeGeometry.ConstructorShapesUnionType of(Object o) {
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

  public static native ExtrudeGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final ExtrudeGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public String type;

  public ExtrudeGeometry() {}

  public ExtrudeGeometry(
      ExtrudeGeometry.ConstructorShapesUnionType shapes, ExtrudeGeometryOptions options) {}

  public ExtrudeGeometry(ExtrudeGeometry.ConstructorShapesUnionType shapes) {}

  public ExtrudeGeometry(JsArray<Shape> shapes, ExtrudeGeometryOptions options) {}

  public ExtrudeGeometry(JsArray<Shape> shapes) {}

  public ExtrudeGeometry(Shape shapes, ExtrudeGeometryOptions options) {}

  public ExtrudeGeometry(Shape[] shapes, ExtrudeGeometryOptions options) {}

  public ExtrudeGeometry(Shape shapes) {}

  public ExtrudeGeometry(Shape[] shapes) {}

  public native void addShape(Shape shape, JsObject options);

  @JsOverlay
  public final void addShape(Shape shape, Object options) {
    addShape(shape, Js.<JsObject>uncheckedCast(options));
  }

  public native void addShape(Shape shape);

  public native void addShapeList(JsArray<Shape> shapes, JsObject options);

  @JsOverlay
  public final void addShapeList(JsArray<Shape> shapes, Object options) {
    addShapeList(shapes, Js.<JsObject>uncheckedCast(options));
  }

  public native void addShapeList(JsArray<Shape> shapes);

  @JsOverlay
  public final void addShapeList(Shape[] shapes, JsObject options) {
    addShapeList(Js.<JsArray<Shape>>uncheckedCast(shapes), options);
  }

  @JsOverlay
  public final void addShapeList(Shape[] shapes, Object options) {
    addShapeList(shapes, Js.<JsObject>uncheckedCast(options));
  }

  @JsOverlay
  public final void addShapeList(Shape[] shapes) {
    addShapeList(Js.<JsArray<Shape>>uncheckedCast(shapes));
  }
}
