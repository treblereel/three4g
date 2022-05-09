package org.treblereel.gwt.three4g.core;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Quaternion;
import org.treblereel.gwt.three4g.math.Sphere;
import org.treblereel.gwt.three4g.math.Vector3;
import org.treblereel.gwt.three4g.math.Box3;
import org.treblereel.gwt.three4g.math.Matrix4;

@JsType(isNative = true, name = "THREE.BufferGeometry", namespace = JsPackage.GLOBAL)
public class BufferGeometry extends EventDispatcher {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface AddAttributeNameUnionType {
    @JsOverlay
    static BufferGeometry.AddAttributeNameUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface AttributesJsPropertyMapTypeParameterUnionType {
    @JsOverlay
    static BufferGeometry.AttributesJsPropertyMapTypeParameterUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default BufferAttribute asBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default InterleavedBufferAttribute asInterleavedBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isBufferAttribute() {
      return (Object) this instanceof BufferAttribute;
    }

    @JsOverlay
    default boolean isInterleavedBufferAttribute() {
      return (Object) this instanceof InterleavedBufferAttribute;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface DeleteAttributeNameUnionType {
    @JsOverlay
    static BufferGeometry.DeleteAttributeNameUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface DrawRangeFieldType {
    @JsOverlay
    static BufferGeometry.DrawRangeFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getCount();

    @JsProperty
    double getStart();

    @JsProperty
    void setCount(double count);

    @JsProperty
    void setStart(double start);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetAttributeNameUnionType {
    @JsOverlay
    static BufferGeometry.GetAttributeNameUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetAttributeUnionType {
    @JsOverlay
    static BufferGeometry.GetAttributeUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default BufferAttribute asBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default InterleavedBufferAttribute asInterleavedBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isBufferAttribute() {
      return (Object) this instanceof BufferAttribute;
    }

    @JsOverlay
    default boolean isInterleavedBufferAttribute() {
      return (Object) this instanceof InterleavedBufferAttribute;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GroupsFieldType {
    @JsOverlay
    static BufferGeometry.GroupsFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    double getCount();

    @JsProperty
    double getMaterialIndex();

    @JsProperty
    double getStart();

    @JsProperty
    void setCount(double count);

    @JsProperty
    void setMaterialIndex(double materialIndex);

    @JsProperty
    void setStart(double start);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface HasAttributeNameUnionType {
    @JsOverlay
    static BufferGeometry.HasAttributeNameUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface MorphAttributesJsPropertyMapTypeParameterArrayUnionType {
    @JsOverlay
    static BufferGeometry.MorphAttributesJsPropertyMapTypeParameterArrayUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default BufferAttribute asBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default InterleavedBufferAttribute asInterleavedBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isBufferAttribute() {
      return (Object) this instanceof BufferAttribute;
    }

    @JsOverlay
    default boolean isInterleavedBufferAttribute() {
      return (Object) this instanceof InterleavedBufferAttribute;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetAttributeAttributeUnionType {
    @JsOverlay
    static BufferGeometry.SetAttributeAttributeUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default BufferAttribute asBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default InterleavedBufferAttribute asInterleavedBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isBufferAttribute() {
      return (Object) this instanceof BufferAttribute;
    }

    @JsOverlay
    default boolean isInterleavedBufferAttribute() {
      return (Object) this instanceof InterleavedBufferAttribute;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetAttributeNameUnionType {
    @JsOverlay
    static BufferGeometry.SetAttributeNameUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetIndexIndexUnionType {
    @JsOverlay
    static BufferGeometry.SetIndexIndexUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default BufferAttribute asBufferAttribute() {
      return Js.cast(this);
    }

    @JsOverlay
    default JsArray<Double> asJsArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isBufferAttribute() {
      return (Object) this instanceof BufferAttribute;
    }

    @JsOverlay
    default boolean isJsArray() {
      return (Object) this instanceof JsArray;
    }
  }

  public static double MaxIndex;
  public JsPropertyMap<BufferGeometry.AttributesJsPropertyMapTypeParameterUnionType> attributes;
  public Box3 boundingBox;
  public Sphere boundingSphere;
  public BufferGeometry.DrawRangeFieldType drawRange;
  public double drawcalls;
  public JsArray<BufferGeometry.GroupsFieldType> groups;
  public double id;
  public BufferAttribute index;
  public boolean isBufferGeometry;
  public JsPropertyMap<
          JsArray<BufferGeometry.MorphAttributesJsPropertyMapTypeParameterArrayUnionType>>
      morphAttributes;
  public boolean morphTargetsRelative;
  public String name;
  public double offsets;
  public String type;
  public JsPropertyMap<JsObject> userData;
  public String uuid;

  @Deprecated
  public native JsObject addAttribute(
      BufferGeometry.AddAttributeNameUnionType name,
      JsObject attribute_or_array,
      JsObject itemSize);

  @Deprecated
  public native JsObject addAttribute(
      BufferGeometry.AddAttributeNameUnionType name, JsObject attribute_or_array);

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(
      BufferGeometry.AddAttributeNameUnionType name, Object attribute_or_array, Object itemSize) {
    return addAttribute(
        name, Js.<JsObject>uncheckedCast(attribute_or_array), Js.<JsObject>uncheckedCast(itemSize));
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(
      BufferGeometry.AddAttributeNameUnionType name, Object attribute_or_array) {
    return addAttribute(name, Js.<JsObject>uncheckedCast(attribute_or_array));
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(
      JsObject name, JsObject attribute_or_array, JsObject itemSize) {
    return addAttribute(
        Js.<BufferGeometry.AddAttributeNameUnionType>uncheckedCast(name),
        attribute_or_array,
        itemSize);
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(JsObject name, JsObject attribute_or_array) {
    return addAttribute(
        Js.<BufferGeometry.AddAttributeNameUnionType>uncheckedCast(name), attribute_or_array);
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(Object name, Object attribute_or_array, Object itemSize) {
    return addAttribute(
        Js.<JsObject>uncheckedCast(name),
        Js.<JsObject>uncheckedCast(attribute_or_array),
        Js.<JsObject>uncheckedCast(itemSize));
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(Object name, Object attribute_or_array) {
    return addAttribute(
        Js.<JsObject>uncheckedCast(name), Js.<JsObject>uncheckedCast(attribute_or_array));
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(String name, JsObject attribute_or_array, JsObject itemSize) {
    return addAttribute(
        Js.<BufferGeometry.AddAttributeNameUnionType>uncheckedCast(name),
        attribute_or_array,
        itemSize);
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(String name, JsObject attribute_or_array) {
    return addAttribute(
        Js.<BufferGeometry.AddAttributeNameUnionType>uncheckedCast(name), attribute_or_array);
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(String name, Object attribute_or_array, Object itemSize) {
    return addAttribute(
        name, Js.<JsObject>uncheckedCast(attribute_or_array), Js.<JsObject>uncheckedCast(itemSize));
  }

  @JsOverlay
  @Deprecated
  public final JsObject addAttribute(String name, Object attribute_or_array) {
    return addAttribute(name, Js.<JsObject>uncheckedCast(attribute_or_array));
  }

  @Deprecated
  public native void addDrawCall(double start, double count, JsObject indexOffset);

  @JsOverlay
  @Deprecated
  public final void addDrawCall(double start, double count, Object indexOffset) {
    addDrawCall(start, count, Js.<JsObject>uncheckedCast(indexOffset));
  }

  @Deprecated
  public native void addDrawCall(double start, double count);

  public native void addGroup(double start, double count, double materialIndex);

  public native void addGroup(double start, double count);

  @Deprecated
  public native void addIndex(double index);

  public native BufferGeometry applyMatrix4(Matrix4 matrix);

  public native BufferGeometry applyQuaternion(Quaternion q);

  public native BufferGeometry center();

  @Deprecated
  public native void clearDrawCalls();

  public native void clearGroups();

  @JsMethod(name = "clone")
  public native BufferGeometry clone_();

  public native void computeBoundingBox();

  public native void computeBoundingSphere();

  public native void computeTangents();

  public native void computeVertexNormals();

  public native BufferGeometry copy(BufferGeometry source);

  public native BufferGeometry deleteAttribute(BufferGeometry.DeleteAttributeNameUnionType name);

  @JsOverlay
  public final BufferGeometry deleteAttribute(JsObject name) {
    return deleteAttribute(Js.<BufferGeometry.DeleteAttributeNameUnionType>uncheckedCast(name));
  }

  @JsOverlay
  public final BufferGeometry deleteAttribute(Object name) {
    return deleteAttribute(Js.<JsObject>uncheckedCast(name));
  }

  @JsOverlay
  public final BufferGeometry deleteAttribute(String name) {
    return deleteAttribute(Js.<BufferGeometry.DeleteAttributeNameUnionType>uncheckedCast(name));
  }

  public native void dispose();

  public native BufferGeometry.GetAttributeUnionType getAttribute(
      BufferGeometry.GetAttributeNameUnionType name);

  @JsOverlay
  public final BufferGeometry.GetAttributeUnionType getAttribute(JsObject name) {
    return getAttribute(Js.<BufferGeometry.GetAttributeNameUnionType>uncheckedCast(name));
  }

  @JsOverlay
  public final BufferGeometry.GetAttributeUnionType getAttribute(Object name) {
    return getAttribute(Js.<JsObject>uncheckedCast(name));
  }

  @JsOverlay
  public final BufferGeometry.GetAttributeUnionType getAttribute(String name) {
    return getAttribute(Js.<BufferGeometry.GetAttributeNameUnionType>uncheckedCast(name));
  }

  public native BufferAttribute getIndex();

  public native boolean hasAttribute(BufferGeometry.HasAttributeNameUnionType name);

  @JsOverlay
  public final boolean hasAttribute(JsObject name) {
    return hasAttribute(Js.<BufferGeometry.HasAttributeNameUnionType>uncheckedCast(name));
  }

  @JsOverlay
  public final boolean hasAttribute(Object name) {
    return hasAttribute(Js.<JsObject>uncheckedCast(name));
  }

  @JsOverlay
  public final boolean hasAttribute(String name) {
    return hasAttribute(Js.<BufferGeometry.HasAttributeNameUnionType>uncheckedCast(name));
  }

  public native void lookAt(Vector3 v);

  public native BufferGeometry merge(BufferGeometry geometry, double offset);

  public native BufferGeometry merge(BufferGeometry geometry);

  public native void normalizeNormals();

  @Deprecated
  public native BufferGeometry removeAttribute(String name);

  public native BufferGeometry rotateX(double angle);

  public native BufferGeometry rotateY(double angle);

  public native BufferGeometry rotateZ(double angle);

  public native BufferGeometry scale(double x, double y, double z);

  @JsOverlay
  public final BufferGeometry setAttribute(JsObject name, BufferAttribute attribute) {
    return setAttribute(
        Js.<BufferGeometry.SetAttributeNameUnionType>uncheckedCast(name),
        Js.<BufferGeometry.SetAttributeAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final BufferGeometry setAttribute(JsObject name, InterleavedBufferAttribute attribute) {
    return setAttribute(
        Js.<BufferGeometry.SetAttributeNameUnionType>uncheckedCast(name),
        Js.<BufferGeometry.SetAttributeAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final BufferGeometry setAttribute(
      JsObject name, BufferGeometry.SetAttributeAttributeUnionType attribute) {
    return setAttribute(
        Js.<BufferGeometry.SetAttributeNameUnionType>uncheckedCast(name), attribute);
  }

  @JsOverlay
  public final BufferGeometry setAttribute(Object name, BufferAttribute attribute) {
    return setAttribute(Js.<JsObject>uncheckedCast(name), attribute);
  }

  @JsOverlay
  public final BufferGeometry setAttribute(Object name, InterleavedBufferAttribute attribute) {
    return setAttribute(Js.<JsObject>uncheckedCast(name), attribute);
  }

  @JsOverlay
  public final BufferGeometry setAttribute(
      Object name, BufferGeometry.SetAttributeAttributeUnionType attribute) {
    return setAttribute(Js.<JsObject>uncheckedCast(name), attribute);
  }

  @JsOverlay
  public final BufferGeometry setAttribute(
      BufferGeometry.SetAttributeNameUnionType name, BufferAttribute attribute) {
    return setAttribute(
        name, Js.<BufferGeometry.SetAttributeAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final BufferGeometry setAttribute(
      BufferGeometry.SetAttributeNameUnionType name, InterleavedBufferAttribute attribute) {
    return setAttribute(
        name, Js.<BufferGeometry.SetAttributeAttributeUnionType>uncheckedCast(attribute));
  }

  public native BufferGeometry setAttribute(
      BufferGeometry.SetAttributeNameUnionType name,
      BufferGeometry.SetAttributeAttributeUnionType attribute);

  @JsOverlay
  public final BufferGeometry setAttribute(String name, BufferAttribute attribute) {
    return setAttribute(
        Js.<BufferGeometry.SetAttributeNameUnionType>uncheckedCast(name),
        Js.<BufferGeometry.SetAttributeAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final BufferGeometry setAttribute(String name, InterleavedBufferAttribute attribute) {
    return setAttribute(
        Js.<BufferGeometry.SetAttributeNameUnionType>uncheckedCast(name),
        Js.<BufferGeometry.SetAttributeAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final BufferGeometry setAttribute(
      String name, BufferGeometry.SetAttributeAttributeUnionType attribute) {
    return setAttribute(
        Js.<BufferGeometry.SetAttributeNameUnionType>uncheckedCast(name), attribute);
  }

  public native void setDrawRange(double start, double count);

  public native BufferGeometry setFromPoints(JsArray<Object> points);

  @JsOverlay
  public final BufferGeometry setFromPoints(Object[] points) {
    return setFromPoints(Js.<JsArray<Object>>uncheckedCast(points));
  }

  @JsOverlay
  public final BufferGeometry setIndex(BufferAttribute index) {
    return setIndex(Js.<BufferGeometry.SetIndexIndexUnionType>uncheckedCast(index));
  }

  @JsOverlay
  public final BufferGeometry setIndex(JsArray<Double> index) {
    return setIndex(Js.<BufferGeometry.SetIndexIndexUnionType>uncheckedCast(index));
  }

  public native BufferGeometry setIndex(BufferGeometry.SetIndexIndexUnionType index);

  @JsOverlay
  public final BufferGeometry setIndex(double[] index) {
    return setIndex(Js.<JsArray<Double>>uncheckedCast(index));
  }

  public native Object toJSON();

  public native Object toJSON(String key);

  public native BufferGeometry toNonIndexed();

  public native BufferGeometry translate(double x, double y, double z);
}
