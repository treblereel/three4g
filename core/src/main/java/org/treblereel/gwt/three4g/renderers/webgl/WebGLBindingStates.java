package org.treblereel.gwt.three4g.renderers.webgl;

import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.BufferAttribute;
import org.treblereel.gwt.three4g.core.BufferGeometry;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.materials.Material;

@JsType(isNative = true, name = "THREE.WebGLBindingStates", namespace = JsPackage.GLOBAL)
public class WebGLBindingStates {
  public WebGLBindingStates(
      WebGLRenderingContext gl,
      WebGLExtensions extensions,
      WebGLAttributes attributes,
      WebGLCapabilities capabilities) {}

  public native void disableUnusedAttributes();

  public native void dispose();

  public native void enableAttribute(double attribute);

  public native void initAttributes();

  public native void releaseStatesOfGeometry();

  public native void releaseStatesOfProgram();

  public native void reset();

  public native void resetDefaultState();

  public native void setup(
      Object3D object,
      Material material,
      WebGLProgram program,
      BufferGeometry geometry,
      BufferAttribute index);
}
