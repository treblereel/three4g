package org.treblereel.gwt.three4g.renderers.webxr;

import elemental2.promise.Promise;
import elemental2.webgl.WebGLRenderingContext;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.cameras.Camera;
import org.treblereel.gwt.three4g.objects.Group;

@JsType(isNative = true, name = "THREE.WebXRManager", namespace = JsPackage.GLOBAL)
public class WebXRManager {
  @JsFunction
  public interface SetAnimationLoopCallbackFn {
    void onInvoke(double p0, Object p1);
  }

  public boolean enabled;
  public boolean isPresenting;

  public WebXRManager(double renderer, WebGLRenderingContext gl) {}

  public native void dispose();

  public native Camera getCamera(Camera camera);

  public native Group getController(double index);

  public native Group getControllerGrip(double index);

  public native double getFoveation();

  public native Group getHand(double index);

  public native Object getReferenceSpace();

  public native Object getSession();

  public native void setAnimationLoop(WebXRManager.SetAnimationLoopCallbackFn callback);

  public native void setFoveation(double foveation);

  public native void setFramebufferScaleFactor(double value);

  public native void setReferenceSpaceType(String value);

  public native Promise<Void> setSession(Object value);
}
