package org.treblereel.gwt.three4g.math;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "THREE.MathUtils", namespace = JsPackage.GLOBAL)
public class MathUtils {
  public static double DEG2RAD;
  public static double RAD2DEG;

  public static native double ceilPowerOfTwo(double value);

  public static native double clamp(double value, double min, double max);

  public static native double damp(double x, double y, double lambda, double dt);

  public static native double degToRad(double degrees);

  public static native double euclideanModulo(double n, double m);

  public static native double floorPowerOfTwo(double value);

  public static native String generateUUID();

  public static native double inverseLerp(double x, double y, double t);

  public static native boolean isPowerOfTwo(double value);

  public static native double lerp(double x, double y, double t);

  public static native double mapLinear(double x, double a1, double a2, double b1, double b2);

  @Deprecated
  public static native double nearestPowerOfTwo(double value);

  @Deprecated
  public static native double nextPowerOfTwo(double value);

  public static native double pingpong(double x, double length);

  public static native double pingpong(double x);

  public static native double radToDeg(double radians);

  public static native double randFloat(double low, double high);

  public static native double randFloatSpread(double range);

  public static native double randInt(double low, double high);

  @Deprecated
  public static native double random16();

  public static native double seededRandom();

  public static native double seededRandom(double seed);

  public static native void setQuaternionFromProperEuler(
          Quaternion q, double a, double b, double c, String order);

  public static native double smootherstep(double x, double min, double max);

  public static native double smoothstep(double x, double min, double max);
}
