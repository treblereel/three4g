package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsObject;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.events.EventDispatcher;
import org.treblereel.gwt.three4g.math.Plane;
import org.treblereel.gwt.three4g.renderers.WebGLRenderer;

@JsType(isNative = true, name = "THREE.Material", namespace = JsPackage.GLOBAL)
public class Material extends EventDispatcher {
  public double alphaTest;
  public boolean alphaToCoverage;
  public double blendDst;
  public double blendDstAlpha;
  public double blendEquation;
  public double blendEquationAlpha;
  public double blendSrc;
  public double blendSrcAlpha;
  public double blending;
  public boolean clipIntersection;
  public boolean clipShadows;
  public Plane[] clippingPlanes;
  public boolean colorWrite;
  public JsPropertyMap<JsObject> defines;
  public double depthFunc;
  public boolean depthTest;
  public boolean depthWrite;
  public boolean dithering;
  public boolean fog;
  public double format;
  public double id;
  public boolean isMaterial;
  public String name;
  public boolean needsUpdate;
  public double opacity;
  public boolean polygonOffset;
  public double polygonOffsetFactor;
  public double polygonOffsetUnits;
  public String precision;
  public boolean premultipliedAlpha;
  public double shadowSide;
  public double side;
  public double stencilFail;
  public double stencilFunc;
  public double stencilFuncMask;
  public double stencilRef;
  public boolean stencilWrite;
  public double stencilWriteMask;
  public double stencilZFail;
  public double stencilZPass;
  public boolean toneMapped;
  public boolean transparent;
  public String type;
  public double userData;
  public String uuid;
  public double version;
  public boolean vertexColors;
  public boolean visible;

  @JsMethod(name = "clone")
  public native <T extends Material> T clone_();

  public native <T extends Material> T copy(Material material);

  public native String customProgramCacheKey();

  public native void dispose();

  public native void onBeforeCompile(JsObject shader, WebGLRenderer renderer);

  @JsOverlay
  public final void onBeforeCompile(Object shader, WebGLRenderer renderer) {
    onBeforeCompile(Js.<JsObject>uncheckedCast(shader), renderer);
  }

  public native void setValues(MaterialParameters values);

  public native Object toJSON();

  public native Object toJSON(String key);
}
