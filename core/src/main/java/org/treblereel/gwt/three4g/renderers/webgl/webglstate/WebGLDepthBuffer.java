package org.treblereel.gwt.three4g.renderers.webgl.webglstate;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.WebGLState.WebGLDepthBuffer", namespace = JsPackage.GLOBAL)
public class WebGLDepthBuffer {
  public native void reset();

  public native void setClear(double depth);

  public native void setFunc(double depthFunc);

  public native void setLocked(boolean lock);

  public native void setMask(boolean depthMask);

  public native void setTest(boolean depthTest);
}
