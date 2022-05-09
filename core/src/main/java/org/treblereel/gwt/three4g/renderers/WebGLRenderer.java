package org.treblereel.gwt.three4g.renderers;

import elemental2.core.JsArray;
import elemental2.core.JsObject;
import elemental2.dom.HTMLCanvasElement;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.*;
import org.treblereel.gwt.three4g.renderers.webgl.*;
import org.treblereel.gwt.three4g.renderers.webxr.WebXRManager;
import org.treblereel.gwt.three4g.scenes.Scene;
import org.treblereel.gwt.three4g.textures.DataTexture2DArray;
import org.treblereel.gwt.three4g.textures.DataTexture3D;
import org.treblereel.gwt.three4g.textures.Texture;

@JsType(isNative = true, name = "THREE.WebGLRenderer", namespace = JsPackage.GLOBAL)
public class WebGLRenderer implements Renderer {
  @JsFunction
  public interface AnimateCallbackFn {
    void onInvoke();
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface CopyTextureToTexture3DDstTextureUnionType {
    @JsOverlay
    static WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default DataTexture2DArray asDataTexture2DArray() {
      return Js.cast(this);
    }

    @JsOverlay
    default DataTexture3D asDataTexture3D() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isDataTexture2DArray() {
      return (Object) this instanceof DataTexture2DArray;
    }

    @JsOverlay
    default boolean isDataTexture3D() {
      return (Object) this instanceof DataTexture3D;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ReadRenderTargetPixelsRenderTargetUnionType {
    @JsOverlay
    static WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default WebGLMultipleRenderTargets asWebGLMultipleRenderTargets() {
      return Js.cast(this);
    }

    @JsOverlay
    default WebGLRenderTarget asWebGLRenderTarget() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isWebGLMultipleRenderTargets() {
      return (Object) this instanceof WebGLMultipleRenderTargets;
    }

    @JsOverlay
    default boolean isWebGLRenderTarget() {
      return (Object) this instanceof WebGLRenderTarget;
    }
  }

  @JsFunction
  public interface SetAnimationLoopCallbackFn {
    void onInvoke(double p0, Object p1);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetClearColorColorUnionType {
    @JsOverlay
    static WebGLRenderer.SetClearColorColorUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Color asColor() {
      return Js.cast(this);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default boolean isColor() {
      return (Object) this instanceof Color;
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  @JsFunction
  public interface SetOpaqueSortMethodFn {
    double onInvoke(JsObject p0, JsObject p1);

    @JsOverlay
    default double onInvoke(Object p0, Object p1) {
      return onInvoke(Js.<JsObject>uncheckedCast(p0), Js.<JsObject>uncheckedCast(p1));
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetRenderTargetRenderTargetUnionType {
    @JsOverlay
    static WebGLRenderer.SetRenderTargetRenderTargetUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default WebGLMultipleRenderTargets asWebGLMultipleRenderTargets() {
      return Js.cast(this);
    }

    @JsOverlay
    default WebGLRenderTarget asWebGLRenderTarget() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isWebGLMultipleRenderTargets() {
      return (Object) this instanceof WebGLMultipleRenderTargets;
    }

    @JsOverlay
    default boolean isWebGLRenderTarget() {
      return (Object) this instanceof WebGLRenderTarget;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetScissorXUnionType {
    @JsOverlay
    static WebGLRenderer.SetScissorXUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default Vector4 asVector4() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isVector4() {
      return (Object) this instanceof Vector4;
    }
  }

  @JsFunction
  public interface SetTransparentSortMethodFn {
    double onInvoke(JsObject p0, JsObject p1);

    @JsOverlay
    default double onInvoke(Object p0, Object p1) {
      return onInvoke(Js.<JsObject>uncheckedCast(p0), Js.<JsObject>uncheckedCast(p1));
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface SetViewportXUnionType {
    @JsOverlay
    static WebGLRenderer.SetViewportXUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default Vector4 asVector4() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isVector4() {
      return (Object) this instanceof Vector4;
    }
  }

  public boolean autoClear;
  public boolean autoClearColor;
  public boolean autoClearDepth;
  public boolean autoClearStencil;
  public WebGLCapabilities capabilities;
  public JsArray<JsObject> clippingPlanes;
  public WebGLRenderingContext context;
  public WebGLDebug debug;
  public HTMLCanvasElement domElement;
  public WebGLExtensions extensions;
  public double gammaFactor;
  public WebGLInfo info;
  public boolean localClippingEnabled;
  public double outputEncoding;
  public boolean physicallyCorrectLights;
  public double pixelRatio;
  public WebGLProperties properties;
  public WebGLRenderLists renderLists;
  public WebGLShadowMap shadowMap;
  public double shadowMapCullFace;
  public boolean shadowMapEnabled;
  public Object shadowMapType;
  public boolean sortObjects;
  public WebGLState state;
  public double toneMapping;
  public double toneMappingExposure;
  public boolean vr;
  public WebXRManager xr;

  public WebGLRenderer() {}

  public WebGLRenderer(WebGLRendererParameters parameters) {}

  @Deprecated
  public native void animate(WebGLRenderer.AnimateCallbackFn callback);

  public native void clear();

  public native void clear(boolean color, boolean depth, boolean stencil);

  public native void clear(boolean color, boolean depth);

  public native void clear(boolean color);

  public native void clearColor();

  public native void clearDepth();

  public native void clearStencil();

  public native void clearTarget(
      WebGLRenderTarget renderTarget, boolean color, boolean depth, boolean stencil);

  public native void compile(Object3D scene, Camera camera);

  public native void copyFramebufferToTexture(Vector2 position, Texture texture, double level);

  public native void copyFramebufferToTexture(Vector2 position, Texture texture);

  public native void copyTextureToTexture(
      Vector2 position, Texture srcTexture, Texture dstTexture, double level);

  public native void copyTextureToTexture(Vector2 position, Texture srcTexture, Texture dstTexture);

  public native void copyTextureToTexture3D(
      Box3 sourceBox,
      Vector3 position,
      Texture srcTexture,
      WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType dstTexture,
      double level);

  public native void copyTextureToTexture3D(
      Box3 sourceBox,
      Vector3 position,
      Texture srcTexture,
      WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType dstTexture);

  @JsOverlay
  public final void copyTextureToTexture3D(
      Box3 sourceBox,
      Vector3 position,
      Texture srcTexture,
      DataTexture2DArray dstTexture,
      double level) {
    copyTextureToTexture3D(
        sourceBox,
        position,
        srcTexture,
        Js.<WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType>uncheckedCast(dstTexture),
        level);
  }

  @JsOverlay
  public final void copyTextureToTexture3D(
      Box3 sourceBox, Vector3 position, Texture srcTexture, DataTexture2DArray dstTexture) {
    copyTextureToTexture3D(
        sourceBox,
        position,
        srcTexture,
        Js.<WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType>uncheckedCast(dstTexture));
  }

  @JsOverlay
  public final void copyTextureToTexture3D(
      Box3 sourceBox,
      Vector3 position,
      Texture srcTexture,
      DataTexture3D dstTexture,
      double level) {
    copyTextureToTexture3D(
        sourceBox,
        position,
        srcTexture,
        Js.<WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType>uncheckedCast(dstTexture),
        level);
  }

  @JsOverlay
  public final void copyTextureToTexture3D(
      Box3 sourceBox, Vector3 position, Texture srcTexture, DataTexture3D dstTexture) {
    copyTextureToTexture3D(
        sourceBox,
        position,
        srcTexture,
        Js.<WebGLRenderer.CopyTextureToTexture3DDstTextureUnionType>uncheckedCast(dstTexture));
  }

  public native void dispose();

  @Deprecated
  public native double enableScissorTest(double boolean_);

  public native void forceContextLoss();

  public native void forceContextRestore();

  public native double getActiveCubeFace();

  public native double getActiveMipmapLevel();

  public native double getClearAlpha();

  public native Color getClearColor(Color target);

  public native WebGLRenderingContext getContext();

  public native double getContextAttributes();

  @Deprecated
  public native WebGLRenderTarget getCurrentRenderTarget();

  public native Vector4 getCurrentViewport(Vector4 target);

  @JsProperty
  public native HTMLCanvasElement getDomElement();

  public native Vector2 getDrawingBufferSize(Vector2 target);

  @Deprecated
  public native double getMaxAnisotropy();

  public native double getPixelRatio();

  @Deprecated
  public native String getPrecision();

  public native WebGLRenderTarget getRenderTarget();

  public native Vector4 getScissor(Vector4 target);

  public native boolean getScissorTest();

  public native Vector2 getSize(Vector2 target);

  public native Vector4 getViewport(Vector4 target);

  public native void initTexture(Texture texture);

  public native void readRenderTargetPixels(
      WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType renderTarget,
      double x,
      double y,
      double width,
      double height,
      double buffer,
      double activeCubeFaceIndex);

  public native void readRenderTargetPixels(
      WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType renderTarget,
      double x,
      double y,
      double width,
      double height,
      double buffer);

  @JsOverlay
  public final void readRenderTargetPixels(
      WebGLMultipleRenderTargets renderTarget,
      double x,
      double y,
      double width,
      double height,
      double buffer,
      double activeCubeFaceIndex) {
    readRenderTargetPixels(
        Js.<WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType>uncheckedCast(renderTarget),
        x,
        y,
        width,
        height,
        buffer,
        activeCubeFaceIndex);
  }

  @JsOverlay
  public final void readRenderTargetPixels(
      WebGLMultipleRenderTargets renderTarget,
      double x,
      double y,
      double width,
      double height,
      double buffer) {
    readRenderTargetPixels(
        Js.<WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType>uncheckedCast(renderTarget),
        x,
        y,
        width,
        height,
        buffer);
  }

  @JsOverlay
  public final void readRenderTargetPixels(
      WebGLRenderTarget renderTarget,
      double x,
      double y,
      double width,
      double height,
      double buffer,
      double activeCubeFaceIndex) {
    readRenderTargetPixels(
        Js.<WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType>uncheckedCast(renderTarget),
        x,
        y,
        width,
        height,
        buffer,
        activeCubeFaceIndex);
  }

  @JsOverlay
  public final void readRenderTargetPixels(
      WebGLRenderTarget renderTarget,
      double x,
      double y,
      double width,
      double height,
      double buffer) {
    readRenderTargetPixels(
        Js.<WebGLRenderer.ReadRenderTargetPixelsRenderTargetUnionType>uncheckedCast(renderTarget),
        x,
        y,
        width,
        height,
        buffer);
  }

  public native void render(Object3D scene, Camera camera);

  public native void renderBufferDirect(
      Camera camera,
      Scene scene,
      BufferGeometry geometry,
      Material material,
      Object3D object,
      double geometryGroup);

  @Deprecated
  public native void resetGLState();

  public native void resetState();

  public native void setAnimationLoop(WebGLRenderer.SetAnimationLoopCallbackFn callback);

  public native void setClearAlpha(double alpha);

  @JsOverlay
  public final void setClearColor(Color color, double alpha) {
    setClearColor(Js.<WebGLRenderer.SetClearColorColorUnionType>uncheckedCast(color), alpha);
  }

  @JsOverlay
  public final void setClearColor(Color color) {
    setClearColor(Js.<WebGLRenderer.SetClearColorColorUnionType>uncheckedCast(color));
  }

  public native void setClearColor(WebGLRenderer.SetClearColorColorUnionType color, double alpha);

  public native void setClearColor(WebGLRenderer.SetClearColorColorUnionType color);

  @JsOverlay
  public final void setClearColor(String color, double alpha) {
    setClearColor(Js.<WebGLRenderer.SetClearColorColorUnionType>uncheckedCast(color), alpha);
  }

  @JsOverlay
  public final void setClearColor(String color) {
    setClearColor(Js.<WebGLRenderer.SetClearColorColorUnionType>uncheckedCast(color));
  }

  @JsOverlay
  public final void setClearColor(double color, double alpha) {
    setClearColor(Js.<WebGLRenderer.SetClearColorColorUnionType>uncheckedCast(color), alpha);
  }

  @JsOverlay
  public final void setClearColor(double color) {
    setClearColor(Js.<WebGLRenderer.SetClearColorColorUnionType>uncheckedCast(color));
  }

  @JsProperty
  public native void setDomElement(HTMLCanvasElement domElement);

  public native void setDrawingBufferSize(double width, double height, double pixelRatio);

  public native void setOpaqueSort(WebGLRenderer.SetOpaqueSortMethodFn method);

  public native void setPixelRatio(double value);

  public native void setRenderTarget(
      WebGLRenderer.SetRenderTargetRenderTargetUnionType renderTarget,
      double activeCubeFace,
      double activeMipmapLevel);

  public native void setRenderTarget(
      WebGLRenderer.SetRenderTargetRenderTargetUnionType renderTarget, double activeCubeFace);

  public native void setRenderTarget(
      WebGLRenderer.SetRenderTargetRenderTargetUnionType renderTarget);

  @JsOverlay
  public final void setRenderTarget(
      WebGLMultipleRenderTargets renderTarget, double activeCubeFace, double activeMipmapLevel) {
    setRenderTarget(
        Js.<WebGLRenderer.SetRenderTargetRenderTargetUnionType>uncheckedCast(renderTarget),
        activeCubeFace,
        activeMipmapLevel);
  }

  @JsOverlay
  public final void setRenderTarget(
      WebGLMultipleRenderTargets renderTarget, double activeCubeFace) {
    setRenderTarget(
        Js.<WebGLRenderer.SetRenderTargetRenderTargetUnionType>uncheckedCast(renderTarget),
        activeCubeFace);
  }

  @JsOverlay
  public final void setRenderTarget(WebGLMultipleRenderTargets renderTarget) {
    setRenderTarget(
        Js.<WebGLRenderer.SetRenderTargetRenderTargetUnionType>uncheckedCast(renderTarget));
  }

  @JsOverlay
  public final void setRenderTarget(
      WebGLRenderTarget renderTarget, double activeCubeFace, double activeMipmapLevel) {
    setRenderTarget(
        Js.<WebGLRenderer.SetRenderTargetRenderTargetUnionType>uncheckedCast(renderTarget),
        activeCubeFace,
        activeMipmapLevel);
  }

  @JsOverlay
  public final void setRenderTarget(WebGLRenderTarget renderTarget, double activeCubeFace) {
    setRenderTarget(
        Js.<WebGLRenderer.SetRenderTargetRenderTargetUnionType>uncheckedCast(renderTarget),
        activeCubeFace);
  }

  @JsOverlay
  public final void setRenderTarget(WebGLRenderTarget renderTarget) {
    setRenderTarget(
        Js.<WebGLRenderer.SetRenderTargetRenderTargetUnionType>uncheckedCast(renderTarget));
  }

  public native void setScissor(
      WebGLRenderer.SetScissorXUnionType x, double y, double width, double height);

  public native void setScissor(WebGLRenderer.SetScissorXUnionType x, double y, double width);

  public native void setScissor(WebGLRenderer.SetScissorXUnionType x, double y);

  public native void setScissor(WebGLRenderer.SetScissorXUnionType x);

  @JsOverlay
  public final void setScissor(Vector4 x, double y, double width, double height) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x), y, width, height);
  }

  @JsOverlay
  public final void setScissor(Vector4 x, double y, double width) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x), y, width);
  }

  @JsOverlay
  public final void setScissor(Vector4 x, double y) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x), y);
  }

  @JsOverlay
  public final void setScissor(Vector4 x) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x));
  }

  @JsOverlay
  public final void setScissor(double x, double y, double width, double height) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x), y, width, height);
  }

  @JsOverlay
  public final void setScissor(double x, double y, double width) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x), y, width);
  }

  @JsOverlay
  public final void setScissor(double x, double y) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x), y);
  }

  @JsOverlay
  public final void setScissor(double x) {
    setScissor(Js.<WebGLRenderer.SetScissorXUnionType>uncheckedCast(x));
  }

  public native void setScissorTest(boolean enable);

  public native void setSize(double width, double height, boolean updateStyle);

  public native void setSize(double width, double height);

  public native void setTransparentSort(WebGLRenderer.SetTransparentSortMethodFn method);

  public native void setViewport(
      WebGLRenderer.SetViewportXUnionType x, double y, double width, double height);

  public native void setViewport(WebGLRenderer.SetViewportXUnionType x, double y, double width);

  public native void setViewport(WebGLRenderer.SetViewportXUnionType x, double y);

  public native void setViewport(WebGLRenderer.SetViewportXUnionType x);

  @JsOverlay
  public final void setViewport(Vector4 x, double y, double width, double height) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x), y, width, height);
  }

  @JsOverlay
  public final void setViewport(Vector4 x, double y, double width) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x), y, width);
  }

  @JsOverlay
  public final void setViewport(Vector4 x, double y) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x), y);
  }

  @JsOverlay
  public final void setViewport(Vector4 x) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x));
  }

  @JsOverlay
  public final void setViewport(double x, double y, double width, double height) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x), y, width, height);
  }

  @JsOverlay
  public final void setViewport(double x, double y, double width) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x), y, width);
  }

  @JsOverlay
  public final void setViewport(double x, double y) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x), y);
  }

  @JsOverlay
  public final void setViewport(double x) {
    setViewport(Js.<WebGLRenderer.SetViewportXUnionType>uncheckedCast(x));
  }

  @Deprecated
  public native double supportsBlendMinMax();

  @Deprecated
  public native double supportsCompressedTexturePVRTC();

  @Deprecated
  public native double supportsCompressedTextureS3TC();

  @Deprecated
  public native double supportsFloatTextures();

  @Deprecated
  public native double supportsHalfFloatTextures();

  @Deprecated
  public native double supportsInstancedArrays();

  @Deprecated
  public native double supportsStandardDerivatives();

  @Deprecated
  public native double supportsVertexTextures();
}
