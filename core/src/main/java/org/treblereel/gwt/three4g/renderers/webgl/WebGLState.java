package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.core.ArrayBufferView;
import elemental2.core.JsObject;
import elemental2.webgl.WebGLFramebuffer;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.materials.Material;
import org.treblereel.gwt.three4g.math.Vector4;
import org.treblereel.gwt.three4g.renderers.webgl.webglstate.WebGLColorBuffer;
import org.treblereel.gwt.three4g.renderers.webgl.webglstate.WebGLDepthBuffer;
import org.treblereel.gwt.three4g.renderers.webgl.webglstate.WebGLStencilBuffer;

@JsType(isNative = true, name = "THREE.WebGLState", namespace = JsPackage.GLOBAL)
public class WebGLState {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface BuffersFieldType {
    @JsOverlay
    static WebGLState.BuffersFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    WebGLColorBuffer getColor();

    @JsProperty
    WebGLDepthBuffer getDepth();

    @JsProperty
    WebGLStencilBuffer getStencil();

    @JsProperty
    void setColor(WebGLColorBuffer color);

    @JsProperty
    void setDepth(WebGLDepthBuffer depth);

    @JsProperty
    void setStencil(WebGLStencilBuffer stencil);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface TexImage2DBorder_or_sourceUnionType {
    @JsOverlay
    static WebGLState.TexImage2DBorder_or_sourceUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default double asDouble() {
      return Js.asDouble(this);
    }

    @JsOverlay
    default JsObject asJsObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isDouble() {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isJsObject() {
      return (Object) this instanceof JsObject;
    }
  }

  public WebGLState.BuffersFieldType buffers;

  public WebGLState(
      WebGLRenderingContext gl, WebGLExtensions extensions, WebGLCapabilities capabilities) {}

  public native void activeTexture(double webglSlot);

  public native void bindFramebuffer(double target, WebGLFramebuffer framebuffer);

  public native void bindTexture(double webglType, double webglTexture);

  public native void bindXRFramebuffer(WebGLFramebuffer framebuffer);

  public native void compressedTexImage2D(
      double target,
      double level,
      double internalformat,
      double width,
      double height,
      double border,
      ArrayBufferView data);

  public native void disable(double id);

  public native void disableUnusedAttributes();

  public native void enable(double id);

  public native void enableAttribute(double attribute);

  public native void enableAttributeAndDivisor(double attribute, double meshPerAttribute);

  public native void initAttributes();

  public native void reset();

  public native void scissor(Vector4 scissor);

  public native void setBlending(
      double blending,
      double blendEquation,
      double blendSrc,
      double blendDst,
      double blendEquationAlpha,
      double blendSrcAlpha,
      double blendDstAlpha,
      boolean premultiplyAlpha);

  public native void setBlending(
      double blending,
      double blendEquation,
      double blendSrc,
      double blendDst,
      double blendEquationAlpha,
      double blendSrcAlpha,
      double blendDstAlpha);

  public native void setBlending(
      double blending,
      double blendEquation,
      double blendSrc,
      double blendDst,
      double blendEquationAlpha,
      double blendSrcAlpha);

  public native void setBlending(
      double blending,
      double blendEquation,
      double blendSrc,
      double blendDst,
      double blendEquationAlpha);

  public native void setBlending(
      double blending, double blendEquation, double blendSrc, double blendDst);

  public native void setBlending(double blending, double blendEquation, double blendSrc);

  public native void setBlending(double blending, double blendEquation);

  public native void setBlending(double blending);

  public native void setCullFace(double cullFace);

  public native void setFlipSided(boolean flipSided);

  public native void setLineWidth(double width);

  public native void setMaterial(Material material, boolean frontFaceCW);

  public native void setPolygonOffset(boolean polygonoffset, double factor, double units);

  public native void setPolygonOffset(boolean polygonoffset, double factor);

  public native void setPolygonOffset(boolean polygonoffset);

  public native void setScissorTest(boolean scissorTest);

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      JsObject border_or_source,
      double format,
      double type,
      ArrayBufferView pixels) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source),
        format,
        type,
        pixels);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      JsObject border_or_source,
      double format,
      double type) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source),
        format,
        type);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      JsObject border_or_source,
      double format) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source),
        format);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      JsObject border_or_source) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source));
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      Object border_or_source,
      double format,
      double type,
      ArrayBufferView pixels) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<JsObject>uncheckedCast(border_or_source),
        format,
        type,
        pixels);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      Object border_or_source,
      double format,
      double type) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<JsObject>uncheckedCast(border_or_source),
        format,
        type);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      Object border_or_source,
      double format) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<JsObject>uncheckedCast(border_or_source),
        format);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      Object border_or_source) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<JsObject>uncheckedCast(border_or_source));
  }

  public native void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      WebGLState.TexImage2DBorder_or_sourceUnionType border_or_source,
      double format,
      double type,
      ArrayBufferView pixels);

  public native void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      WebGLState.TexImage2DBorder_or_sourceUnionType border_or_source,
      double format,
      double type);

  public native void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      WebGLState.TexImage2DBorder_or_sourceUnionType border_or_source,
      double format);

  public native void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      WebGLState.TexImage2DBorder_or_sourceUnionType border_or_source);

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      double border_or_source,
      double format,
      double type,
      ArrayBufferView pixels) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source),
        format,
        type,
        pixels);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      double border_or_source,
      double format,
      double type) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source),
        format,
        type);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      double border_or_source,
      double format) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source),
        format);
  }

  @JsOverlay
  public final void texImage2D(
      double target,
      double level,
      double internalformat,
      double width_or_format,
      double height_or_type,
      double border_or_source) {
    texImage2D(
        target,
        level,
        internalformat,
        width_or_format,
        height_or_type,
        Js.<WebGLState.TexImage2DBorder_or_sourceUnionType>uncheckedCast(border_or_source));
  }

  public native void texImage3D(
      double target,
      double level,
      double internalformat,
      double width,
      double height,
      double depth,
      double border,
      double format,
      double type,
      double pixels);

  public native void unbindTexture();

  public native boolean useProgram(double program);

  public native void vertexAttribPointer(
      double index, double size, double type, boolean normalized, double stride, double offset);

  public native void viewport(Vector4 viewport);
}
