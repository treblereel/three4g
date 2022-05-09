package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Cylindrical", namespace = JsPackage.GLOBAL)
public class Cylindrical {
  public double radius;
  public double theta;
  public double y;

  public Cylindrical() {}

  public Cylindrical(double radius, double theta, double y) {}

  public Cylindrical(double radius, double theta) {}

  public Cylindrical(double radius) {}

  @JsMethod(name = "clone")
  public native Cylindrical clone_();

  public native Cylindrical copy(Cylindrical other);

  public native Cylindrical set(double radius, double theta, double y);

  public native Cylindrical setFromCartesianCoords(double x, double y, double z);

  public native Cylindrical setFromVector3(Vector3 vec3);
}
