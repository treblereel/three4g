package org.treblereel.gwt.three4g.renderers.webxr;


import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.treblereel.gwt.three4g.objects.Group;

@JsType(isNative = true, name = "THREE.WebXRController", namespace = JsPackage.GLOBAL)
public class WebXRController {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface DispatchEventEventType {
    @JsOverlay
    static WebXRController.DispatchEventEventType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    Object getData();

    @JsProperty
    String getType();

    @JsProperty
    void setData(Object data);

    @JsProperty
    void setType(String type);
  }

  public native WebXRController disconnect(Object inputSource);

  public native WebXRController dispatchEvent(WebXRController.DispatchEventEventType event);

  public native Group getGripSpace();

  public native Group getTargetRaySpace();

  public native WebXRController update(Object inputSource, Object frame, Object referenceSpace);
}
