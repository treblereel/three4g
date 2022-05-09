package org.treblereel.gwt.three4g.propertybinding;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(
    isNative = true,
    name = "THREE.PropertyBinding.ParseTrackNameResults",
    namespace = JsPackage.GLOBAL)
public interface ParseTrackNameResults {
  @JsOverlay
  static ParseTrackNameResults create() {
    return Js.uncheckedCast(JsPropertyMap.of());
  }

  @JsProperty
  String getNodeName();

  @JsProperty
  String getObjectIndex();

  @JsProperty
  String getObjectName();

  @JsProperty
  String getPropertyIndex();

  @JsProperty
  String getPropertyName();

  @JsProperty
  void setNodeName(String nodeName);

  @JsProperty
  void setObjectIndex(String objectIndex);

  @JsProperty
  void setObjectName(String objectName);

  @JsProperty
  void setPropertyIndex(String propertyIndex);

  @JsProperty
  void setPropertyName(String propertyName);
}
