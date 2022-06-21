package org.treblereel.gwt.three4g.utils;

import elemental2.core.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.InterleavedBufferAttribute;
import org.treblereel.gwt.three4g.objects.Line;
import org.treblereel.gwt.three4g.objects.Mesh;
import org.treblereel.gwt.three4g.objects.Points;

@JsType(isNative = true, name = "THREE.BufferGeometryUtils", namespace = JsPackage.GLOBAL)
public class BufferGeometryUtils {
  @JsOverlay
  public static final BufferAttribute mergeBufferAttributes(BufferAttribute[] attributes) {
    return mergeBufferAttributes(Js.<JsArray<BufferAttribute>>uncheckedCast(attributes));
  }

  public static native BufferAttribute mergeBufferAttributes(JsArray<BufferAttribute> attributes);

  @JsOverlay
  public static final BufferGeometry mergeBufferGeometries(BufferGeometry[] geometries) {
    return mergeBufferGeometries(Js.<JsArray<BufferGeometry>>uncheckedCast(geometries));
  }

  public static native BufferGeometry mergeBufferGeometries(JsArray<BufferGeometry> geometries);

  @JsOverlay
  public static final BufferGeometry mergeBufferGeometries(BufferGeometry[] geometries, boolean useGroups ) {
    return mergeBufferGeometries(Js.<JsArray<BufferGeometry>>uncheckedCast(geometries), useGroups);
  }

  public static native BufferGeometry mergeBufferGeometries(JsArray<BufferGeometry> geometries, boolean useGroups );

  @JsOverlay
  public static final InterleavedBufferAttribute interleaveAttributes(BufferAttribute[] geometries) {
    return interleaveAttributes(Js.<JsArray<BufferAttribute>>uncheckedCast(geometries));
  }

  public static native InterleavedBufferAttribute interleaveAttributes(JsArray<BufferAttribute> geometries);

  public static native double estimateBytesUsed(BufferGeometry geometry);

  public static native BufferGeometry mergeVertices(BufferGeometry geometry);

  public static native BufferGeometry mergeVertices(BufferGeometry geometry, double tolerance);

  public static native BufferGeometry toTrianglesDrawMode(BufferGeometry geometry, int drawMode);

  public static native Object computeMorphedAttributes(Mesh object);

  public static native Object computeMorphedAttributes(Line object);

  public static native Object computeMorphedAttributes(Points object);

  public static native BufferGeometry computeMikkTSpaceTangents(BufferGeometry geometry, Object MikkTSpace);

  public static native BufferGeometry computeMikkTSpaceTangents(BufferGeometry geometry, Object MikkTSpace, boolean negateSign);

  public static native BufferGeometry mergeGroups(BufferGeometry geometry);

  public static native void deinterleaveAttribute(BufferGeometry geometry);

  public static native void deinterleaveGeometry(BufferGeometry geometry);

}
