package org.treblereel.gwt.three4g.core;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.raycaster.Intersection;
import org.treblereel.gwt.three4g.raycaster.RaycasterParameters;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Ray;

@JsType(isNative = true, name = "THREE.Raycaster", namespace = JsPackage.GLOBAL)
public class Raycaster {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetFromCameraCoordsType {
    @JsOverlay
    static Raycaster.SetFromCameraCoordsType create() {
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

  public Camera camera;
  public double far;
  public Layers layers;
  public double near;
  public RaycasterParameters params;
  public Ray ray;

  public Raycaster() {}

  public Raycaster(Vector3 origin, Vector3 direction, double near, double far) {}

  public Raycaster(Vector3 origin, Vector3 direction, double near) {}

  public Raycaster(Vector3 origin, Vector3 direction) {}

  public Raycaster(Vector3 origin) {}

  @JsOverlay
  public final <TIntersected> JsArray<Intersection<TIntersected>> intersectObject(
      Object3D object, boolean recursive, Intersection<TIntersected>[] optionalTarget) {
    return intersectObject(
        object, recursive, Js.<JsArray<Intersection<TIntersected>>>uncheckedCast(optionalTarget));
  }

  public native <TIntersected> JsArray<Intersection<TIntersected>> intersectObject(
      Object3D object, boolean recursive, JsArray<Intersection<TIntersected>> optionalTarget);

  public native <TIntersected> JsArray<Intersection<TIntersected>> intersectObject(
      Object3D object, boolean recursive);

  public native <TIntersected> JsArray<Intersection<TIntersected>> intersectObject(Object3D object);

  public native <TIntersected> JsArray<Intersection<TIntersected>> intersectObjects(
      JsArray<Object3D> objects,
      boolean recursive,
      JsArray<Intersection<TIntersected>> optionalTarget);

  public native <TIntersected> JsArray<Intersection<TIntersected>> intersectObjects(
      JsArray<Object3D> objects, boolean recursive);

  public native <TIntersected> JsArray<Intersection<TIntersected>> intersectObjects(
      JsArray<Object3D> objects);

  @JsOverlay
  public final <TIntersected> JsArray<Intersection<TIntersected>> intersectObjects(
      Object3D[] objects, boolean recursive, Intersection<TIntersected>[] optionalTarget) {
    return intersectObjects(
        Js.<JsArray<Object3D>>uncheckedCast(objects),
        recursive,
        Js.<JsArray<Intersection<TIntersected>>>uncheckedCast(optionalTarget));
  }

  @JsOverlay
  public final <TIntersected> JsArray<Intersection<TIntersected>> intersectObjects(
      Object3D[] objects, boolean recursive) {
    return intersectObjects(Js.<JsArray<Object3D>>uncheckedCast(objects), recursive);
  }

  @JsOverlay
  public final <TIntersected> JsArray<Intersection<TIntersected>> intersectObjects(
      Object3D[] objects) {
    return intersectObjects(Js.<JsArray<Object3D>>uncheckedCast(objects));
  }

  public native void set(Vector3 origin, Vector3 direction);

  public native void setFromCamera(Raycaster.SetFromCameraCoordsType coords, Camera camera);
}
