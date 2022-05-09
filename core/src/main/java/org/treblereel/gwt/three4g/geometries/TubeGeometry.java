package org.treblereel.gwt.three4g.geometries;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.extras.core.Curve;
import org.treblereel.gwt.three4g.math.Vector3;

@JsType(isNative = true, name = "THREE.TubeGeometry", namespace = JsPackage.GLOBAL)
public class TubeGeometry extends BufferGeometry {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ParametersFieldType {
    @JsOverlay
    static TubeGeometry.ParametersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    Curve getPath();

    @JsProperty
    double getRadialSegments();

    @JsProperty
    double getRadius();

    @JsProperty
    double getTubularSegments();

    @JsProperty
    boolean isClosed();

    @JsProperty
    void setClosed(boolean closed);

    @JsProperty
    void setPath(Curve path);

    @JsProperty
    void setRadialSegments(double radialSegments);

    @JsProperty
    void setRadius(double radius);

    @JsProperty
    void setTubularSegments(double tubularSegments);
  }

  public static native TubeGeometry fromJSON(JsObject data);

  @JsOverlay
  public static final TubeGeometry fromJSON(Object data) {
    return fromJSON(Js.<JsObject>uncheckedCast(data));
  }

  public JsArray<Vector3> binormals;
  public JsArray<Vector3> normals;
  public TubeGeometry.ParametersFieldType parameters;
  public JsArray<Vector3> tangents;
  public String type;

  public TubeGeometry() {}

  public TubeGeometry(
      Curve path, double tubularSegments, double radius, double radiusSegments, boolean closed) {}

  public TubeGeometry(Curve path, double tubularSegments, double radius, double radiusSegments) {}

  public TubeGeometry(Curve path, double tubularSegments, double radius) {}

  public TubeGeometry(Curve path, double tubularSegments) {}

  public TubeGeometry(Curve path) {}
}
