package org.treblereel.gwt.three4g.math;

import elemental2.core.JsArray;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.objects.Sprite;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.Frustum", namespace = JsPackage.GLOBAL)
public class Frustum {
  public JsArray<Plane> planes;

  public Frustum() {}

  public Frustum(Plane p0, Plane p1, Plane p2, Plane p3, Plane p4, Plane p5) {}

  public Frustum(Plane p0, Plane p1, Plane p2, Plane p3, Plane p4) {}

  public Frustum(Plane p0, Plane p1, Plane p2, Plane p3) {}

  public Frustum(Plane p0, Plane p1, Plane p2) {}

  public Frustum(Plane p0, Plane p1) {}

  public Frustum(Plane p0) {}

  @JsMethod(name = "clone")
  public native Frustum clone_();

  public native boolean containsPoint(Vector3 point);

  public native Frustum copy(Frustum frustum);

  public native boolean intersectsBox(Box3 box);

  public native boolean intersectsObject(Object3D object);

  public native boolean intersectsSphere(Sphere sphere);

  public native boolean intersectsSprite(Sprite sprite);

  public native Frustum set(Plane p0, Plane p1, Plane p2, Plane p3, Plane p4, Plane p5);

  public native Frustum setFromProjectionMatrix(Matrix4 m);
}
