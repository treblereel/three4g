package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLBuffer;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.InterleavedBufferAttribute;

@JsType(isNative = true, name = "THREE.WebGLAttributes", namespace = JsPackage.GLOBAL)
public class WebGLAttributes {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ConstructorGlUnionType {
    @JsOverlay
    static WebGLAttributes.ConstructorGlUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default Object asObject() {
      return Js.cast(this);
    }

    @JsOverlay
    default WebGLRenderingContext asWebGLRenderingContext() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isObject() {
      return (Object) this instanceof Object;
    }

    @JsOverlay
    default boolean isWebGLRenderingContext() {
      return (Object) this instanceof WebGLRenderingContext;
    }
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface GetAttributeUnionType {
    @JsOverlay
    static WebGLAttributes.GetAttributeUnionType of(Object o) {
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
  public interface GetReturnType {
    @JsOverlay
    static WebGLAttributes.GetReturnType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    WebGLBuffer getBuffer();

    @JsProperty
    double getBytesPerElement();

    @JsProperty
    double getType();

    @JsProperty
    double getVersion();

    @JsProperty
    void setBuffer(WebGLBuffer buffer);

    @JsProperty
    void setBytesPerElement(double bytesPerElement);

    @JsProperty
    void setType(double type);

    @JsProperty
    void setVersion(double version);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface RemoveAttributeUnionType {
    @JsOverlay
    static WebGLAttributes.RemoveAttributeUnionType of(Object o) {
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
  public interface UpdateAttributeUnionType {
    @JsOverlay
    static WebGLAttributes.UpdateAttributeUnionType of(Object o) {
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

  public WebGLAttributes(
      WebGLAttributes.ConstructorGlUnionType gl, WebGLCapabilities capabilities) {}

  public WebGLAttributes(Object gl, WebGLCapabilities capabilities) {}

  public WebGLAttributes(WebGLRenderingContext gl, WebGLCapabilities capabilities) {}

  @JsOverlay
  public final WebGLAttributes.GetReturnType get(BufferAttribute attribute) {
    return get(Js.<WebGLAttributes.GetAttributeUnionType>uncheckedCast(attribute));
  }

  public native WebGLAttributes.GetReturnType get(WebGLAttributes.GetAttributeUnionType attribute);

  @JsOverlay
  public final WebGLAttributes.GetReturnType get(InterleavedBufferAttribute attribute) {
    return get(Js.<WebGLAttributes.GetAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final void remove(BufferAttribute attribute) {
    remove(Js.<WebGLAttributes.RemoveAttributeUnionType>uncheckedCast(attribute));
  }

  @JsOverlay
  public final void remove(InterleavedBufferAttribute attribute) {
    remove(Js.<WebGLAttributes.RemoveAttributeUnionType>uncheckedCast(attribute));
  }

  public native void remove(WebGLAttributes.RemoveAttributeUnionType attribute);

  @JsOverlay
  public final void update(BufferAttribute attribute, double bufferType) {
    update(Js.<WebGLAttributes.UpdateAttributeUnionType>uncheckedCast(attribute), bufferType);
  }

  @JsOverlay
  public final void update(InterleavedBufferAttribute attribute, double bufferType) {
    update(Js.<WebGLAttributes.UpdateAttributeUnionType>uncheckedCast(attribute), bufferType);
  }

  public native void update(WebGLAttributes.UpdateAttributeUnionType attribute, double bufferType);
}
