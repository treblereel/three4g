package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.WebGLLights", namespace = JsPackage.GLOBAL)
public class WebGLLights {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface StateFieldType {
    @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
    public interface HashFieldType {
      @JsOverlay
      static WebGLLights.StateFieldType.HashFieldType create() {
        return Js.uncheckedCast(JsPropertyMap.of());
      }

      @JsProperty
      double getDirectionalLength();

      @JsProperty
      double getHemiLength();

      @JsProperty
      double getNumDirectionalShadows();

      @JsProperty
      double getNumPointShadows();

      @JsProperty
      double getNumSpotShadows();

      @JsProperty
      double getPointLength();

      @JsProperty
      double getRectAreaLength();

      @JsProperty
      double getSpotLength();

      @JsProperty
      void setDirectionalLength(double directionalLength);

      @JsProperty
      void setHemiLength(double hemiLength);

      @JsProperty
      void setNumDirectionalShadows(double numDirectionalShadows);

      @JsProperty
      void setNumPointShadows(double numPointShadows);

      @JsProperty
      void setNumSpotShadows(double numSpotShadows);

      @JsProperty
      void setPointLength(double pointLength);

      @JsProperty
      void setRectAreaLength(double rectAreaLength);

      @JsProperty
      void setSpotLength(double spotLength);
    }

    @JsOverlay
    static WebGLLights.StateFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    JsArray<Double> getAmbient();

    @JsProperty
    JsArray<JsObject> getDirectional();

    @JsProperty
    JsArray<JsObject> getDirectionalShadow();

    @JsProperty
    JsArray<JsObject> getDirectionalShadowMap();

    @JsProperty
    JsArray<JsObject> getDirectionalShadowMatrix();

    @JsProperty
    WebGLLights.StateFieldType.HashFieldType getHash();

    @JsProperty
    JsArray<JsObject> getHemi();

    @JsProperty
    JsArray<JsObject> getPoint();

    @JsProperty
    JsArray<JsObject> getPointShadow();

    @JsProperty
    JsArray<JsObject> getPointShadowMap();

    @JsProperty
    JsArray<JsObject> getPointShadowMatrix();

    @JsProperty
    JsArray<JsObject> getProbe();

    @JsProperty
    JsArray<JsObject> getRectArea();

    @JsProperty
    JsArray<JsObject> getSpot();

    @JsProperty
    JsArray<JsObject> getSpotShadow();

    @JsProperty
    JsArray<JsObject> getSpotShadowMap();

    @JsProperty
    JsArray<JsObject> getSpotShadowMatrix();

    @JsProperty
    double getVersion();

    @JsProperty
    void setAmbient(JsArray<Double> ambient);

    @JsOverlay
    default void setAmbient(double[] ambient) {
      setAmbient(Js.<JsArray<Double>>uncheckedCast(ambient));
    }

    @JsProperty
    void setDirectional(JsArray<JsObject> directional);

    @JsOverlay
    default void setDirectional(JsObject[] directional) {
      setDirectional(Js.<JsArray<JsObject>>uncheckedCast(directional));
    }

    @JsProperty
    void setDirectionalShadow(JsArray<JsObject> directionalShadow);

    @JsOverlay
    default void setDirectionalShadow(JsObject[] directionalShadow) {
      setDirectionalShadow(Js.<JsArray<JsObject>>uncheckedCast(directionalShadow));
    }

    @JsProperty
    void setDirectionalShadowMap(JsArray<JsObject> directionalShadowMap);

    @JsOverlay
    default void setDirectionalShadowMap(JsObject[] directionalShadowMap) {
      setDirectionalShadowMap(Js.<JsArray<JsObject>>uncheckedCast(directionalShadowMap));
    }

    @JsProperty
    void setDirectionalShadowMatrix(JsArray<JsObject> directionalShadowMatrix);

    @JsOverlay
    default void setDirectionalShadowMatrix(JsObject[] directionalShadowMatrix) {
      setDirectionalShadowMatrix(Js.<JsArray<JsObject>>uncheckedCast(directionalShadowMatrix));
    }

    @JsProperty
    void setHash(WebGLLights.StateFieldType.HashFieldType hash);

    @JsProperty
    void setHemi(JsArray<JsObject> hemi);

    @JsOverlay
    default void setHemi(JsObject[] hemi) {
      setHemi(Js.<JsArray<JsObject>>uncheckedCast(hemi));
    }

    @JsProperty
    void setPoint(JsArray<JsObject> point);

    @JsOverlay
    default void setPoint(JsObject[] point) {
      setPoint(Js.<JsArray<JsObject>>uncheckedCast(point));
    }

    @JsProperty
    void setPointShadow(JsArray<JsObject> pointShadow);

    @JsOverlay
    default void setPointShadow(JsObject[] pointShadow) {
      setPointShadow(Js.<JsArray<JsObject>>uncheckedCast(pointShadow));
    }

    @JsProperty
    void setPointShadowMap(JsArray<JsObject> pointShadowMap);

    @JsOverlay
    default void setPointShadowMap(JsObject[] pointShadowMap) {
      setPointShadowMap(Js.<JsArray<JsObject>>uncheckedCast(pointShadowMap));
    }

    @JsProperty
    void setPointShadowMatrix(JsArray<JsObject> pointShadowMatrix);

    @JsOverlay
    default void setPointShadowMatrix(JsObject[] pointShadowMatrix) {
      setPointShadowMatrix(Js.<JsArray<JsObject>>uncheckedCast(pointShadowMatrix));
    }

    @JsProperty
    void setProbe(JsArray<JsObject> probe);

    @JsOverlay
    default void setProbe(JsObject[] probe) {
      setProbe(Js.<JsArray<JsObject>>uncheckedCast(probe));
    }

    @JsProperty
    void setRectArea(JsArray<JsObject> rectArea);

    @JsOverlay
    default void setRectArea(JsObject[] rectArea) {
      setRectArea(Js.<JsArray<JsObject>>uncheckedCast(rectArea));
    }

    @JsProperty
    void setSpot(JsArray<JsObject> spot);

    @JsOverlay
    default void setSpot(JsObject[] spot) {
      setSpot(Js.<JsArray<JsObject>>uncheckedCast(spot));
    }

    @JsProperty
    void setSpotShadow(JsArray<JsObject> spotShadow);

    @JsOverlay
    default void setSpotShadow(JsObject[] spotShadow) {
      setSpotShadow(Js.<JsArray<JsObject>>uncheckedCast(spotShadow));
    }

    @JsProperty
    void setSpotShadowMap(JsArray<JsObject> spotShadowMap);

    @JsOverlay
    default void setSpotShadowMap(JsObject[] spotShadowMap) {
      setSpotShadowMap(Js.<JsArray<JsObject>>uncheckedCast(spotShadowMap));
    }

    @JsProperty
    void setSpotShadowMatrix(JsArray<JsObject> spotShadowMatrix);

    @JsOverlay
    default void setSpotShadowMatrix(JsObject[] spotShadowMatrix) {
      setSpotShadowMatrix(Js.<JsArray<JsObject>>uncheckedCast(spotShadowMatrix));
    }

    @JsProperty
    void setVersion(double version);
  }

  public WebGLLights.StateFieldType state;

  public WebGLLights(WebGLExtensions extensions, WebGLCapabilities capabilities) {}

  public native double get(double light);

  public native void setup(double lights);

  public native void setupView(double lights, double camera);
}
