package org.treblereel.gwt.three4g.raycaster;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.RaycasterParameters", namespace = JsPackage.GLOBAL)
public interface RaycasterParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface LineFieldType {
    @JsOverlay
    static RaycasterParameters.LineFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getThreshold();

    @JsProperty
    void setThreshold(double threshold);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface PointsFieldType {
    @JsOverlay
    static RaycasterParameters.PointsFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getThreshold();

    @JsProperty
    void setThreshold(double threshold);
  }

  @JsOverlay
  static RaycasterParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty(name = "LOD")
  JsObject getLOD();

  @JsProperty(name = "Line")
  RaycasterParameters.LineFieldType getLine();

  @JsProperty(name = "Mesh")
  JsObject getMesh();

  @JsProperty(name = "Points")
  RaycasterParameters.PointsFieldType getPoints();

  @JsProperty(name = "Sprite")
  JsObject getSprite();

  @JsProperty(name = "LOD")
  void setLOD(JsObject LOD);

  @JsOverlay
  default void setLOD(Object LOD) {
    setLOD(Js.<JsObject>uncheckedCast(LOD));
  }

  @JsProperty(name = "Line")
  void setLine(RaycasterParameters.LineFieldType Line);

  @JsProperty(name = "Mesh")
  void setMesh(JsObject Mesh);

  @JsOverlay
  default void setMesh(Object Mesh) {
    setMesh(Js.<JsObject>uncheckedCast(Mesh));
  }

  @JsProperty(name = "Points")
  void setPoints(RaycasterParameters.PointsFieldType Points);

  @JsProperty(name = "Sprite")
  void setSprite(JsObject Sprite);

  @JsOverlay
  default void setSprite(Object Sprite) {
    setSprite(Js.<JsObject>uncheckedCast(Sprite));
  }
}
