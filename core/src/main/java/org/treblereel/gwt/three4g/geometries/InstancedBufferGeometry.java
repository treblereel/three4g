package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;

@JsType(isNative = true, name = "THREE.InstancedBufferGeometry", namespace = JsPackage.GLOBAL)
public class InstancedBufferGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GroupsFieldType {
    @JsOverlay
    static InstancedBufferGeometry.GroupsFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getCount();

    @JsProperty
    double getInstances();

    @JsProperty
    double getStart();

    @JsProperty
    void setCount(double count);

    @JsProperty
    void setInstances(double instances);

    @JsProperty
    void setStart(double start);
  }

  public JsArray<InstancedBufferGeometry.GroupsFieldType> groups;
  public double instanceCount;
  public boolean isInstancedBufferGeometry;
  public String type;

  public native void addGroup(double start, double count, double instances);
}
