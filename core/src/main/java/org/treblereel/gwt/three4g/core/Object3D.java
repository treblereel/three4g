package org.treblereel.gwt.three4g.core;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.*;
import org.treblereel.gwt.three4g.animation.AnimationClip;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.*;
import org.treblereel.gwt.three4g.objects.Group;
import org.treblereel.gwt.three4g.raycaster.Intersection;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;
import org.treblereel.gwt.three4g.scenes.Scene;

@JsType(isNative = true, name = "THREE.Object3D", namespace = JsPackage.GLOBAL)
public class Object3D extends EventDispatcher<Object> {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface LookAtVectorUnionType {
    @JsOverlay
    static Object3D.LookAtVectorUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default Vector3 asVector3() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isVector3() {
      return (Object) this instanceof Vector3;
    }
  }

  @JsFunction
  public interface OnAfterRenderFn {
    void onInvoke(WebGLRenderer p0, Scene p1, Camera p2, BufferGeometry p3, Material p4, Group p5);
  }

  @JsFunction
  public interface OnBeforeRenderFn {
    void onInvoke(WebGLRenderer p0, Scene p1, Camera p2, BufferGeometry p3, Material p4, Group p5);
  }

  @JsFunction
  public interface TraverseAncestorsCallbackFn {
    JsObject onInvoke(Object3D p0);
  }

  @JsFunction
  public interface TraverseCallbackFn {
    JsObject onInvoke(Object3D p0);
  }

  @JsFunction
  public interface TraverseVisibleCallbackFn {
    JsObject onInvoke(Object3D p0);
  }

  public static boolean DefaultMatrixAutoUpdate;
  public static Vector3 DefaultUp;
  public JsArray<AnimationClip> animations;
  public boolean castShadow;
  public JsArray<Object3D> children;
  public Material customDepthMaterial;
  public Material customDistanceMaterial;
  public boolean frustumCulled;
  public double id;
  public boolean isObject3D;
  public Layers layers;
  public Matrix4 matrix;
  public boolean matrixAutoUpdate;
  public Matrix4 matrixWorld;
  public boolean matrixWorldNeedsUpdate;
  public Matrix4 modelViewMatrix;
  public String name;
  public Matrix3 normalMatrix;
  public Object3D.OnAfterRenderFn onAfterRender;
  public Object3D.OnBeforeRenderFn onBeforeRender;
  public Object3D parent;
  public Vector3 position;
  public Quaternion quaternion;
  public boolean receiveShadow;
  public double renderOrder;
  public Euler rotation;
  public Vector3 scale;
  public String type;
  public Vector3 up;
  public JsPropertyMap<JsObject> userData;
  public String uuid;
  public boolean visible;

  public native Object3D add(Object3D... object);

  public native void applyMatrix4(Matrix4 matrix);

  public native Object3D applyQuaternion(Quaternion quaternion);

  public native Object3D attach(Object3D object);

  public native Object3D clear();

  public native Object3D clone(boolean recursive);

  @JsMethod(name = "clone")
  public native Object3D clone_();

  public native Object3D copy(Object3D source, boolean recursive);

  public native Object3D copy(Object3D source);

  public native Object3D getObjectById(double id);

  public native Object3D getObjectByName(String name);

  public native Object3D getObjectByProperty(String name, String value);

  public native Vector3 getWorldDirection(Vector3 target);

  public native Vector3 getWorldPosition(Vector3 target);

  public native Quaternion getWorldQuaternion(Quaternion target);

  public native Vector3 getWorldScale(Vector3 target);

  public native Vector3 localToWorld(Vector3 vector);

  public native void lookAt(Object3D.LookAtVectorUnionType vector, double y, double z);

  public native void lookAt(Object3D.LookAtVectorUnionType vector, double y);

  public native void lookAt(Object3D.LookAtVectorUnionType vector);

  @JsOverlay
  public final void lookAt(Vector3 vector, double y, double z) {
    lookAt(Js.<Object3D.LookAtVectorUnionType>uncheckedCast(vector), y, z);
  }

  @JsOverlay
  public final void lookAt(Vector3 vector, double y) {
    lookAt(Js.<Object3D.LookAtVectorUnionType>uncheckedCast(vector), y);
  }

  @JsOverlay
  public final void lookAt(Vector3 vector) {
    lookAt(Js.<Object3D.LookAtVectorUnionType>uncheckedCast(vector));
  }

  @JsOverlay
  public final void lookAt(double vector, double y, double z) {
    lookAt(Js.<Object3D.LookAtVectorUnionType>uncheckedCast(vector), y, z);
  }

  @JsOverlay
  public final void lookAt(double vector, double y) {
    lookAt(Js.<Object3D.LookAtVectorUnionType>uncheckedCast(vector), y);
  }

  @JsOverlay
  public final void lookAt(double vector) {
    lookAt(Js.<Object3D.LookAtVectorUnionType>uncheckedCast(vector));
  }

  @JsOverlay
  public final void raycast(Raycaster raycaster, Intersection<Object3D>[] intersects) {
    raycast(raycaster, Js.<JsArray<Intersection<Object3D>>>uncheckedCast(intersects));
  }

  public native void raycast(Raycaster raycaster, JsArray<Intersection<Object3D>> intersects);

  public native Object3D remove(Object3D... object);

  public native Object3D removeFromParent();

  public native Object3D rotateOnAxis(Vector3 axis, double angle);

  public native Object3D rotateOnWorldAxis(Vector3 axis, double angle);

  public native Object3D rotateX(double angle);

  public native Object3D rotateY(double angle);

  public native Object3D rotateZ(double angle);

  public native void setRotationFromAxisAngle(Vector3 axis, double angle);

  public native void setRotationFromEuler(Euler euler);

  public native void setRotationFromMatrix(Matrix4 m);

  public native void setRotationFromQuaternion(Quaternion q);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native Object3D translateOnAxis(Vector3 axis, double distance);

  public native Object3D translateX(double distance);

  public native Object3D translateY(double distance);

  public native Object3D translateZ(double distance);

  public native void traverse(Object3D.TraverseCallbackFn callback);

  public native void traverseAncestors(Object3D.TraverseAncestorsCallbackFn callback);

  public native void traverseVisible(Object3D.TraverseVisibleCallbackFn callback);

  public native void updateMatrix();

  public native void updateMatrixWorld();

  public native void updateMatrixWorld(boolean force);

  public native void updateWorldMatrix(boolean updateParents, boolean updateChildren);

  public native Vector3 worldToLocal(Vector3 vector);
}
