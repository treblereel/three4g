package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.Spherical", namespace = JsPackage.GLOBAL)
public class Spherical {
  public double phi;
  public double radius;
  public double theta;

  public Spherical() {}

  public Spherical(double radius, double phi, double theta) {}

  public Spherical(double radius, double phi) {}

  public Spherical(double radius) {}

  @JsMethod(name = "clone")
  public native Spherical clone_();

  public native Spherical copy(Spherical other);

  public native Spherical makeSafe();

  public native Spherical set(double radius, double phi, double theta);

  public native Spherical setFromCartesianCoords(double x, double y, double z);

  public native Spherical setFromVector3(Vector3 v);
}
