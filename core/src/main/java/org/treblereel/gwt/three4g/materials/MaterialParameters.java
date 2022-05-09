package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.math.Plane;

@JsType(isNative = true, name = "THREE.MaterialParameters", namespace = JsPackage.GLOBAL)
public interface MaterialParameters {
  @JsOverlay
  static MaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  double getAlphaTest();

  @JsProperty
  double getBlendDst();

  @JsProperty
  double getBlendDstAlpha();

  @JsProperty
  double getBlendEquation();

  @JsProperty
  double getBlendEquationAlpha();

  @JsProperty
  double getBlendSrc();

  @JsProperty
  double getBlendSrcAlpha();

  @JsProperty
  double getBlending();

  @JsProperty
  JsArray<Plane> getClippingPlanes();

  @JsProperty
  JsObject getDefines();

  @JsProperty
  double getDepthFunc();

  @JsProperty
  double getFormat();

  @JsProperty
  String getName();

  @JsProperty
  double getOpacity();

  @JsProperty
  double getPolygonOffsetFactor();

  @JsProperty
  double getPolygonOffsetUnits();

  @JsProperty
  String getPrecision();

  @JsProperty
  double getShadowSide();

  @JsProperty
  double getSide();

  @JsProperty
  double getStencilFail();

  @JsProperty
  double getStencilFunc();

  @JsProperty
  double getStencilFuncMask();

  @JsProperty
  double getStencilRef();

  @JsProperty
  double getStencilWriteMask();

  @JsProperty
  double getStencilZFail();

  @JsProperty
  double getStencilZPass();

  @JsProperty
  JsObject getUserData();

  @JsProperty
  boolean isAlphaToCoverage();

  @JsProperty
  boolean isClipIntersection();

  @JsProperty
  boolean isClipShadows();

  @JsProperty
  boolean isColorWrite();

  @JsProperty
  boolean isDepthTest();

  @JsProperty
  boolean isDepthWrite();

  @JsProperty
  boolean isDithering();

  @JsProperty
  boolean isFog();

  @JsProperty
  boolean isPolygonOffset();

  @JsProperty
  boolean isPremultipliedAlpha();

  @JsProperty
  boolean isStencilWrite();

  @JsProperty
  boolean isToneMapped();

  @JsProperty
  boolean isTransparent();

  @JsProperty
  boolean isVertexColors();

  @JsProperty
  boolean isVisible();

  @JsProperty
  void setAlphaTest(double alphaTest);

  @JsProperty
  void setAlphaToCoverage(boolean alphaToCoverage);

  @JsProperty
  void setBlendDst(double blendDst);

  @JsProperty
  void setBlendDstAlpha(double blendDstAlpha);

  @JsProperty
  void setBlendEquation(double blendEquation);

  @JsProperty
  void setBlendEquationAlpha(double blendEquationAlpha);

  @JsProperty
  void setBlendSrc(double blendSrc);

  @JsProperty
  void setBlendSrcAlpha(double blendSrcAlpha);

  @JsProperty
  void setBlending(double blending);

  @JsProperty
  void setClipIntersection(boolean clipIntersection);

  @JsProperty
  void setClipShadows(boolean clipShadows);

  @JsProperty
  void setClippingPlanes(JsArray<Plane> clippingPlanes);

  @JsOverlay
  default void setClippingPlanes(Plane[] clippingPlanes) {
    setClippingPlanes(Js.<JsArray<Plane>>uncheckedCast(clippingPlanes));
  }

  @JsProperty
  void setColorWrite(boolean colorWrite);

  @JsProperty
  void setDefines(JsObject defines);

  @JsOverlay
  default void setDefines(Object defines) {
    setDefines(Js.<JsObject>uncheckedCast(defines));
  }

  @JsProperty
  void setDepthFunc(double depthFunc);

  @JsProperty
  void setDepthTest(boolean depthTest);

  @JsProperty
  void setDepthWrite(boolean depthWrite);

  @JsProperty
  void setDithering(boolean dithering);

  @JsProperty
  void setFog(boolean fog);

  @JsProperty
  void setFormat(double format);

  @JsProperty
  void setName(String name);

  @JsProperty
  void setOpacity(double opacity);

  @JsProperty
  void setPolygonOffset(boolean polygonOffset);

  @JsProperty
  void setPolygonOffsetFactor(double polygonOffsetFactor);

  @JsProperty
  void setPolygonOffsetUnits(double polygonOffsetUnits);

  @JsProperty
  void setPrecision(String precision);

  @JsProperty
  void setPremultipliedAlpha(boolean premultipliedAlpha);

  @JsProperty
  void setShadowSide(double shadowSide);

  @JsProperty
  void setSide(double side);

  @JsProperty
  void setStencilFail(double stencilFail);

  @JsProperty
  void setStencilFunc(double stencilFunc);

  @JsProperty
  void setStencilFuncMask(double stencilFuncMask);

  @JsProperty
  void setStencilRef(double stencilRef);

  @JsProperty
  void setStencilWrite(boolean stencilWrite);

  @JsProperty
  void setStencilWriteMask(double stencilWriteMask);

  @JsProperty
  void setStencilZFail(double stencilZFail);

  @JsProperty
  void setStencilZPass(double stencilZPass);

  @JsProperty
  void setToneMapped(boolean toneMapped);

  @JsProperty
  void setTransparent(boolean transparent);

  @JsProperty
  void setUserData(JsObject userData);

  @JsOverlay
  default void setUserData(Object userData) {
    setUserData(Js.<JsObject>uncheckedCast(userData));
  }

  @JsProperty
  void setVertexColors(boolean vertexColors);

  @JsProperty
  void setVisible(boolean visible);
}
