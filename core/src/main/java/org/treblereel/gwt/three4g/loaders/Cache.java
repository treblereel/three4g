package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Cache", namespace = JsPackage.GLOBAL)
public class Cache {
  public static boolean enabled;
  public static double files;

  public static native void add(String key, double file);

  public static native void clear();

  public static native double get(String key);

  public static native void remove(String key);
}
