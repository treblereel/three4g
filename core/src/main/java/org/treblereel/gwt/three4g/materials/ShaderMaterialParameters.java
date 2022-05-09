package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.ShaderMaterialParameters", namespace = JsPackage.GLOBAL)
public interface ShaderMaterialParameters extends MaterialParameters {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ExtensionsFieldType {
    @JsOverlay
    static ShaderMaterialParameters.ExtensionsFieldType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    boolean isDerivatives();

    @JsProperty
    boolean isDrawBuffers();

    @JsProperty
    boolean isFragDepth();

    @JsProperty
    boolean isShaderTextureLOD();

    @JsProperty
    void setDerivatives(boolean derivatives);

    @JsProperty
    void setDrawBuffers(boolean drawBuffers);

    @JsProperty
    void setFragDepth(boolean fragDepth);

    @JsProperty
    void setShaderTextureLOD(boolean shaderTextureLOD);
  }

  @JsOverlay
  static ShaderMaterialParameters create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  ShaderMaterialParameters.ExtensionsFieldType getExtensions();

  @JsProperty
  String getFragmentShader();

  @JsProperty
  double getGlslVersion();

  @JsProperty
  double getLinewidth();

  @JsProperty
  JsPropertyMap<JsObject> getUniforms();

  @JsProperty
  String getVertexShader();

  @JsProperty
  double getWireframeLinewidth();

  @JsProperty
  boolean isClipping();

  @JsProperty
  boolean isLights();

  @JsProperty
  boolean isWireframe();

  @JsProperty
  void setClipping(boolean clipping);

  @JsProperty
  void setExtensions(ShaderMaterialParameters.ExtensionsFieldType extensions);

  @JsProperty
  void setFragmentShader(String fragmentShader);

  @JsProperty
  void setGlslVersion(double glslVersion);

  @JsProperty
  void setLights(boolean lights);

  @JsProperty
  void setLinewidth(double linewidth);

  @JsProperty
  void setUniforms(JsPropertyMap<JsObject> uniforms);

  @JsProperty
  void setVertexShader(String vertexShader);

  @JsProperty
  void setWireframe(boolean wireframe);

  @JsProperty
  void setWireframeLinewidth(double wireframeLinewidth);
}
