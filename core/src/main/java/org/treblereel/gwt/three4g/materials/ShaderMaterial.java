package org.treblereel.gwt.three4g.materials;

import elemental2.core.JsObject;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "THREE.ShaderMaterial", namespace = JsPackage.GLOBAL)
public class ShaderMaterial extends Material {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface ExtensionsFieldType {
    @JsOverlay
    static ShaderMaterial.ExtensionsFieldType create() {
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

  public boolean clipping;
  public double defaultAttributeValues;
  public JsPropertyMap<JsObject> defines;
  public double derivatives;
  public ShaderMaterial.ExtensionsFieldType extensions;
  public boolean fog;
  public String fragmentShader;
  public double glslVersion;
  public String index0AttributeName;
  public boolean isShaderMaterial;
  public boolean lights;
  public double linewidth;
  public String type;
  public JsPropertyMap<JsObject> uniforms;
  public boolean uniformsNeedUpdate;
  public String vertexShader;
  public boolean wireframe;
  public double wireframeLinewidth;

  public ShaderMaterial() {}

  public ShaderMaterial(ShaderMaterialParameters parameters) {}

  public native void setValues(ShaderMaterialParameters parameters);

  public native Object toJSON();

  public native Object toJSON(String key);
}
