package org.treblereel.gwt.three4g.objects;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.Object3D;

@JsType(isNative = true, name = "THREE.LOD", namespace = JsPackage.GLOBAL)
public class LOD extends Object3D {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface LevelsFieldType {
    @JsOverlay
    static LOD.LevelsFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getDistance();

    @JsProperty
    Object3D getObject();

    @JsProperty
    void setDistance(double distance);

    @JsProperty
    void setObject(Object3D object);
  }

  public boolean autoUpdate;
  public boolean isLOD;
  public JsArray<LOD.LevelsFieldType> levels;
  public JsArray<JsObject> objects;
  public String type;

  public native LOD addLevel(Object3D object, double distance);

  public native LOD addLevel(Object3D object);

  public native double getCurrentLevel();

  public native Object3D getObjectForDistance(double distance);

  public native Object toJSON();

  public native Object toJSON(String key);

  public native void update(Camera camera);
}
